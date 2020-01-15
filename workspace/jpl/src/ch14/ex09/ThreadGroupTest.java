package ch14.ex09;

/**
 * ex14-8
 * スレッドグループを引数に取り、そのグループ内のスレッドとスレッドグループの階層を定期
 * 的に表示するスレッドを開始するメソッドを書きなさい。
 * そのメソッドを、様々なグループ内でいくつかの短命なスレッドを生成するプログラムでテストしなさい。
 */
public class ThreadGroupTest {

	public static void main(String[] args) {
		ThreadGroupTest t = new ThreadGroupTest();
		ThreadGroup parentGroup = new ThreadGroup("PARANT_GROUP");
		Thread th1 = t.new TestThread( parentGroup, "thread1" );
		Thread th2 = t.new TestThread( parentGroup, "thread2" );
		th1.start();
		th2.start();

		ThreadGroup childGroup = new ThreadGroup(parentGroup,"child");
		Thread th3 = t.new TestThread( childGroup, "thread3" );
		th3.start();
	}

	private void showThreadGroup( final ThreadGroup group) {
		System.out.println("group parent name:" + group.getParent().getName());
		System.out.println("group name:" + group.getName());

		ThreadGroup[] groups = new ThreadGroup[group.activeGroupCount()];
		int length = group.enumerate(groups,false);
		for (int i = 0; i < length; i++) {
			showThreadGroup(groups[i]);

		}
	}

	public class TestThread extends Thread {


		public TestThread(ThreadGroup group, String name) {
			super(group, name);
		}

		@Override
		public void run() {
			try {
				System.out.println("threadName:" + this.getName() );
				Thread.sleep(1000);
				showThreadGroup(this.getThreadGroup());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
