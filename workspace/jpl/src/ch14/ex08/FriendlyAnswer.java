package ch14.ex08;

/**
 * 以下デッドロックの可能性を除去したプログラム
 *
 * ex14-8
 * Friendlyプログラムを試しなさい。使用しているシステムでどの程度の頻度で実際にデッド
 * ロックが発生しますか。＞ANS1.
 * yield呼び出しを追加したら、デッドロックの頻度を変更できますか >Ans2.
 * もし可能なら、この練習問題を1種類以上のシステムで試しなさい。同期を削除することなくデッドロックの可能性を取り除いてみなさい
 */


public class FriendlyAnswer {
    private FriendlyAnswer partner;
    private String name;
    private static final Object lockObject = new Object();//add

    public FriendlyAnswer(String name) {
        this.name = name;
    }

    public synchronized void hug() {
    	synchronized (lockObject) { //add
    		System.out.println(Thread.currentThread().getName() + " in " + name
                    + ".hug() trying to invoke " + partner.name + ".hugBack()");
            partner.hugBack();
		}
    }

    private synchronized void hugBack() {
    	synchronized (lockObject) {
    		System.out.println(Thread.currentThread().getName() + " in " + name
                    + ".hugBack()");	
		}
    }

    public void becomeFriend(FriendlyAnswer partner) {
        this.partner = partner;
    }

    public static void main(String[] args) {
        final FriendlyAnswer jareth = new FriendlyAnswer("jareth");
        final FriendlyAnswer cory = new FriendlyAnswer("cory");

        jareth.becomeFriend(cory);
        cory.becomeFriend(jareth);

        new Thread(new Runnable() {
            public void run() {
                jareth.hug();
            }
        }, "Thread1").start();

        new Thread(new Runnable() {
            public void run() {
                cory.hug();
            }
        }, "Thread2").start();
    }
}
