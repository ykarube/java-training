package ch06.ex03;

/**
 * 練習問題6.3 104項4.2.1節のVerboseインターフェース
 * 整数定数の代わりにメッセージレベルのenumを使用して再定義しなさい
 */
public interface Verbose {

	enum Verbosity{
		SILENT, TERSE, NORMAL, VERBOSE,
	}

	void setVerbosity(Verbosity level);

	int getVerbosity();
}