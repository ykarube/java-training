package ch01.ex06;

public class UncheckRunnable {

	public static void main(String[] args) {
	    new Thread(uncheck(()->{
	      System.out.println("Zzz");
	      Thread.sleep(1000);
	      System.out.println("zzzzz....");
	    })).start();
	    System.out.println("hoge");
	}

    @FunctionalInterface
    public interface RunnableEx {
        void run() throws Exception;
    }

    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}