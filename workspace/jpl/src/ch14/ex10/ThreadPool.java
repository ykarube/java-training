/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 * Copyright (C) 2019 Yoshiki Shibata. All rights reserved.
 */
package ch14.ex10;

import java.util.LinkedList;

/**
	1.2.4 JPL 追加練習問題
		第14 章の追加問題として練習問題10 を解いてもらいます。練習問題は、以下のリポジトリの
		ThreadPool.java とThreadPoolTest.java の二つのソースファイルです。
			https://github.com/YoshikiShibata/jpltest/tree/master/jpl/ch14/ex10
		ファイル内のpackage 宣言をjpl.ch14.ex10 からch14.ex10 へ修正して、
		各人の		jpl/src/ch14/ex10 とjpl/test/ch14/ex10 ディレクトリの下に、ThreadPool.java とThreadPoolTest.java を配置してださい。
		練習問題の内容は以下の通りです。
		• ThreadPoolTest.java は完成したテストコードであり修正しない
		• ThreadPoolTest.java 内のテストがすべて合格するようにThreadPool.java を完成させる
 */

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to
 * be exectued by a thread.<br><br>
 *
 * [Instruction]
 * <ul>
 *  <li> Implement one constructor and three methods. </li>
 *  <li> Don't forget to write a Test program to test this class. </li>
 *  <li> Pay attention to @throws tags in the javadoc. </li>
 *  <li> If needed, you can put "synchronized" keyword to methods. </li>
 *  <li> All classes for implementation must be private inside this class. </li>
 *  <li> Don't use java.util.concurrent package. </li>
 *  <li> Don't use {@link java.lang.Thread#interrupt}  method to stop a thread</li>
 *  </ul>
 *
 *  @author Yoshiki Shibata
 */
public class ThreadPool {

    private ThreadPoolQueue<Runnable> queue;
    private boolean isStarted_;

    //workerThreadパタンを利用：
	//http://www.hyuki.com/dp/dp2_ch08.pdf
    private WorkerThread[] workerThreads;

    /**
     * Constructs ThreadPool.
     *
     * @param queueSize the max size of queue
     * @param numberOfThreads the number of threads in this pool.
     * @throws IllegalArgumentException if either queueSize or numberOfThreads
     *             is less than 1
     */
    public ThreadPool(final int queueSize, final int numberOfThreads) {
    	if ( queueSize < 1 || numberOfThreads < 1 ) {
    		throw new IllegalArgumentException();
    	}
        workerThreads = new WorkerThread[numberOfThreads];
        queue = new ThreadPoolQueue<Runnable>(queueSize);
        for (int i = 0; i < workerThreads.length; i++)
            workerThreads[i] = new WorkerThread("thread-["+i+"]");
    }

    /**
     * Starts threads.
     *
     * @throws IllegalStateException if threads has been already started.
     */
    public void start() {
        if (isStarted_)
            throw new IllegalStateException("Already started.");
        for (int i = 0; i < workerThreads.length; i++) {
            try {
                workerThreads[i].start();
            } catch (IllegalThreadStateException e) {
                throw new IllegalStateException(e);
            }
        }
        isStarted_ = true;
    }

    /**
     * Stop all threads and wait for their terminations.
     *
     * @throws IllegalStateException if threads has not been started.
     */
    public void stop() {
    	for (int i = 0; i < workerThreads.length; i++) {
            if (workerThreads[i].isAlive()) {
            	workerThreads[i].stopRequest();
                try {
                	System.out.println("[log] stop & join start:" + workerThreads[i].getName());
                	workerThreads[i].join();
                    System.out.println("[log] stop & join end:" + workerThreads[i].getName());
                } catch (InterruptedException e) {
                    System.err.println("err");
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /**
     * Executes the specified Runnable object, using a thread in the pool. run()
     * method will be invoked in the thread. If the queue is full, then this
     * method invocation will be blocked until the queue is not full.
     *
     * @param runnable Runnable object whose run() method will be invoked.
     * @throws NullPointerException if runnable is null.
     * @throws IllegalStateException if this pool has not been started yet.
     */
    public synchronized void dispatch(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        if (!isStarted_) {
            throw new IllegalStateException("Not statrted.");
        }
        queue.add(runnable);
        System.out.println("[log] dispatch: queue size" + queue.size);
    }

    class WorkerThread extends Thread {

        private boolean stopped;

        public WorkerThread(String name) {
			super(name);
			stopped = false;
		}

        @Override
        public void run() {
            Runnable runnable = null;
            while (!stopped) {
                runnable = queue.poll();
                if (runnable != null)
                    runnable.run();
            }
        }

        private void stopRequest() {
            stopped = true;
            queue.stop();
        }
    }

    class ThreadPoolQueue<Runnable> {

        private final int size;
        private LinkedList<Runnable> list;

        public ThreadPoolQueue(int size) {
            if (size < 1) {
                throw new IllegalArgumentException("Illegal size of queue.");
            }
            this.size = size;
            list = new LinkedList<Runnable>();
        }

        /**
         * Appends the specified element to the end of this list.
         *
         * @param e element to be appended to this list
         * @return true, or false if interrupted on waiting for polling
         */
        public synchronized boolean add(Runnable runnable) {
            while (list.size() >= size)
                try {
                    wait();
                } catch (InterruptedException e1) {
                    return false;
                }
            boolean result = list.add(runnable);
            notifyAll();
            System.out.println("[log] queue add: size" + list.size());
            return result;
        }

        /**
         * Retrieves and removes the head of this list.
         *
         * @return the head of this list, or null if interrupted on waiting for adding
         */
        public synchronized Runnable poll() {
            if (list.isEmpty())
                try {
                    wait();
                } catch (InterruptedException e1) {
                    return null;
                }
            Runnable e = list.poll();
            notifyAll();
            System.out.println("[log] poll: list size" + list.size());
            return e;
        }

        public synchronized void stop() {
            notifyAll();
            System.out.println("[log] stop;");
        }
    }
}