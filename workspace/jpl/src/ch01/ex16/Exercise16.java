package ch01.ex16;

/*
 * 練習問題1.15

 */
public class Exercise16 {

	public static void main(String[] args) {
		Exercise16 ex = new Exercise16();
		System.out.println("=============success============");
		ex.executeSuccess();
		System.out.println("=============error==============");
		ex.executeError();
	}

	/**
	 * 練習問題の実行
	 */
	public static void executeSuccess() {
		MyUtilities utilities = new MyUtilities();
		try {
			utilities.getDataSet( "C:\\work\\workspace_repos\\java-training\\workspace\\jpl\\src\\ch01\\ex16\\exercise16" );
		} catch (BadDataSetException e) {
			e.printStackTrace();
		}

	}

	public static void executeError() {
		MyUtilities utilities = new MyUtilities();
		try {
			utilities.getDataSet( "unknownName" );
		} catch (BadDataSetException e) {
			System.out.println(e.getName());
			System.out.println(e.getCause());
		}
	}


}
