package ch14.ex02;

/**
 * ex14.2
 * 最初のバージョンのPrintServerを修正して
 * スレッドの識別によりコンストラクタで生成されたスレッドだけがrunを実行できるようにしなさい
 */
public class PrintServer implements Runnable {

	private final PrintQueue requests = new PrintQueue();
	private final String TAG_CONST = "TAG_CONST"; // コンストラクタで生成したときに付与するタグ

	public PrintServer() {
		new Thread(this, TAG_CONST).start();
	}

	public void print(PrintJob job) {
		this.requests.add(job);
	}

	@Override
	public void run() {
		if(!TAG_CONST.equals(Thread.currentThread().getName())) {
			System.out.println("[ERROR]illegal thead:" + Thread.currentThread().getName());
			return;
		}
		for(;;) {
			try {
				PrintJob job = requests.remove();
				realPrint(job);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void realPrint(PrintJob job) {
		job.print();
	}


	public static void main(String[] args) {
		PrintServer server = new PrintServer();
		server.print(new PrintJob()); //job追加

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println("---------------------");
		server.run();

	}
}
