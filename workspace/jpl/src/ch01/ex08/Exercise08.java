package ch01.ex08;

/*
 * 練習問題1.8
 * pointクラスにメソッドを追加して、引数として渡されたオブジェクトの座標を自分の座標に設定するメソッドを定義しろ.
 *
 * memo
 * staticメソッドはクラスに関連した処理
 * 非staticメソッドはオブジェクトに関連した処理
 *
 */
public class Exercise08 {


	public static void main(String[] args) {

		Exercise08 e = new Exercise08();

		Point p1 = e.new Point();
		System.out.println( "original:" + "x = " + p1.x + "\t, y =  " + p1.y );
		Point p2 = e.new Point();

		p2.move(100, 200);
		p1.setPoint(p2);

		System.out.println( "after   :" + "x = " + p1.x + "\t, y =  " + p1.y );
	}

	/**
	 * x, y座標を持つ点クラス
	 *
	 */
	class Point {

		/**
		 * x座標
		 */
		public double x;

		/**
		 * y座標
		 */
		public double y;


		/**
		 * x,y座標の初期化
		 */
		public void clear() {
			this.x = 0.0;
			this.y = 0.0;
		}

		/**
		 * Pointクラスが保持するx,y座標の距離
		 * @param Point that point insatance
		 */
		public double distance( final Point that ) {
			double xdiff = x - that.x;
			double ydiff = y - that.y;
			return Math.sqrt( xdiff * xdiff + ydiff * ydiff);		//sqrt 平方根
		}

		/**
		 * Pointクラスが保持するx,y座標を置換する(座標を動かす)
		 * @param x 置換するx座標
		 * @param y 置換するy座標
		 */
		public void move( double x, double y ) {
			this.x = x;
			this.y = y;
		}


		/**
		 * 指定したPointクラスが保持するx,y座標を自身のx.y座標と置換する
		 * @param src 置換するPoint
		 */
		public void setPoint( final Point src ) {
			this.x = src.x;
			this.y = src.y;
		}
	}

}
