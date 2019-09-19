package ch01.ex10;

/*
 * 練習問題1.10
 * ImprovedFibonacciアプリケーションを修正して、数列を配列に保存する
 * その際に数列の値とその値が偶数かを示すプール値を保持するクラスを作成してそのクラスの
 * オブジェクトへの参照を配列をして持つようにしなさい
 *
 */
public class Exercise10 {

	public static void main(String[] args) {
		Exercise10 ex = new Exercise10();
		ReImprovedFibonacchi fibonacchi = ex.new ReImprovedFibonacchi();
		fibonacchi.function();
		fibonacchi.out();
	}

	/**
	 *
	 * 数値と数値が偶数かを示すboolean値を保持するクラス
	 *
	 */
	class DataHolder{
		private final int number_;
		private final boolean even_; //even：偶数

		/**
		 * コンストラクタ　初期化
		 */
		public DataHolder() {
			this.number_ = 0;
			this.even_ = true;

		}

		/**
		 * コンストラクタ　初期化
		 * @param num 保持する値
		 */
		public DataHolder( final int num ) {
			this.number_ = num;
			if ( this.number_ % 2 == 0 )
				this.even_= true;
			else
				this.even_ = false;
		}

		/**
		 * DataHolderが保持する数値を返却する
		 * @return int 保持する数値
		 */
		public int getNumber() {
			return this.number_;
		}

		/**
		 * DataHolderが保持する偶数か否かを示すboolean値を返却する
		 * @return boolean 偶数か否か
		 */
		public boolean getEven() {
			return this.even_;
		}
	}


	class ReImprovedFibonacchi{
		static final int MAX_INDEX = 9;
		DataHolder[] fibonacchi_ = new DataHolder[MAX_INDEX];

		/**
		 * Fibonacchi数列をDataHolderの配列で保持する
		 */
		public void function() {
			int lo = 1;
			int hi = 1;
			this.fibonacchi_[0] = new DataHolder(lo);
			for ( int i = 2; i <= MAX_INDEX; i++ ) {
				this.fibonacchi_[i-1] = new DataHolder(hi);
				hi = lo + hi;
				lo = hi - lo;
			}
		}

		/**
		 * 結果を出力する
		 */
		public void out() {
			for (int i = 0; i < fibonacchi_.length; i++) {
				DataHolder dataHolder = fibonacchi_[i];
				System.out.println(dataHolder.getNumber() + ":" + dataHolder.getEven());
			}
		}

//P8より
//	class ImprovedFibonacchi{
//
//		static final int MAX_INDEX = 9;
//
//		public void function() {
//			int lo = 1;
//			int hi = 1;
//			String mark;
//			System.out.println("1: " + lo );
//			for ( int i = 2; i <= MAX_INDEX; i++ ) {
//				if ( hi % 2 == 0 ) {
//					mark = " *";
//				}else {
//					mark = "";
//				}
//				System.out.println( i + ": " + hi + mark );
//				hi = lo + hi;
//				lo = hi - lo;
//			}
//		}
	}

}
