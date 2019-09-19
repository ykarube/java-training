package ch01.ex16;

import java.io.IOException;

/**
 * 練習問題1.16
 * フィールドを追加して
 * データの集まりの名前と
 * 問題を通知しているI/O例外を保持できるようにする
 *
 * それによりその例外をキャッ氏してエラーの詳細を知ることができる
 *
 */
//dataの集まりの名前？
public class BadDataSetException extends Exception {

	private final Throwable cause_;
	private final String name_;

	public BadDataSetException( final String dataSetName, final IOException e) {
		this.cause_ = e;
		this.name_ = dataSetName;
	}

	public Throwable getCause() {
		return this.cause_;
	}

	public String getName() {
		return this.name_;
	}
}
