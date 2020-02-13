package ex;

import java.awt.Button;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;

import exhoge.StringCounter;

/*
2.4 『プログラミング言語Java 第4 版』| Interpret 課題
練習問題16.6、16.7、16.8、16.10 をそれぞれ作成する代わりに、Interpret プログラムを１つ作成してもらいます。
練習問題で指定された操作ができることに加えて、以下のことも行ってもらいます。
• GUI で作成する（AWT/Swing のどちらでも良い）
• java.awt.Frame のsetVisible()、setTitle()、setSize()、setBackground() を呼び出すデモができること
• コンストラクタやメソッドの呼び出しで発生した例外も正しく表示されること
• 参照型の配列を生成して、各要素に個別に参照を代入できること
• private final のインスタンスフィールドの書き換えもできること
• 自分自身を起動できること


ex16.6	要求された型のオブジェクトを生成し、ユーザがそのオブジェクトフィールドを調べて、
		フィールドを修正できるInterpretプログラムを作成すること

ex16.7	オブジェクトに対してメソッドを呼び出すようにInterpretプログラムを修正しなさい、
	   	戻り値やスローされた例外を適切に表示するようにしなさい

ex16.8 	Interpretプログラムをさらに修正して、任意のクラスのコンストラクタをユーザが呼び出せるようにする
	   	その際にどんな例外も表示すること
	   	またオブジェクトの生成が成功したら、そのオブジェクトのメソッドをユーザーが呼び出せるようにしなさい

ex16.10 Interpretプログラムをさらに修正して、ユーザが生成する配列の方とサイズを指定できて
		その配列の要素を呼び出したり設定したりできて、また配列の要素として含まれているオブジェクトを指定して
		そのオブジェクトのフィールドにアクセスしたりメソッドを呼び出したりできるようにしなさい

 */
public class InterpretFrame extends JFrame {

	private int defaultXPoint = 10;
	private int windowWidth = 1000;
	private int windowHeight = 1000;
	private Class<?> type_ ;					//ユーザが入力したクラス名
	private Constructor<?>[] contructorList_;	//ユーザが入力したクラス名から取得したコンストラクタ
	private Object object_;					//ユーザーが選択したコンストラクタから生成したインスタンスオブジェクト
	private String[] methodList_;

	private TextArea textOutput_;				//結果出力 ※showMessage(String)を利用すること

	public InterpretFrame(){
		super("Interpret");
		setBounds(10, 10, windowWidth, windowHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(null);

		//window close処理
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);// 閉じる
			}
		});

		//-------- 結果出力( label + testFiled ) ----------------------------------------------
		Label labelOutput = new Label("■結果出力");
		labelOutput.setBounds(defaultXPoint, windowHeight-200, 300, 20);
		add(labelOutput);
		this.textOutput_ = new TextArea("", 50, 50, TextArea.SCROLLBARS_BOTH);
		this.textOutput_.setBounds(defaultXPoint, labelOutput.getY()+20, 800, 100);
		add(this.textOutput_);

		//-------- クラス名の入力( label +  textFiled ) ---------------------------------------
		Label labelClassName = new Label("■取得対象クラス");
		labelClassName.setBounds(defaultXPoint, 40, 300, 20);
		add(labelClassName);
		TextField classNameField = new TextField("(input class name. ex:java.lang.String)");
		classNameField.setBounds(defaultXPoint, labelClassName.getY()+20, 300, 30);
		add(classNameField);

		//-------- コンストラクタのリスト表示 ( label +  List ) --------------------------------
		Label labelConstruct = new Label("■コンストラクタ一覧");
		labelConstruct.setBounds(defaultXPoint, 120, 150, 20);
		add(labelConstruct);
		List ListConstructor = new List();
		ListConstructor.setBounds(defaultXPoint, labelConstruct.getY()+20, 300, 200);
		add(ListConstructor);

		//-------- 型からコンストラクタ一覧を取得 (botton) ----------------------------------------
		Button buttonGetConstructor = new Button("取得");
		buttonGetConstructor.setBounds(300+10, 60, 80,30 );
		add(buttonGetConstructor);
		buttonGetConstructor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListConstructor.removeAll();
				type_ = null;
				String name = classNameField.getText();
				try {
					type_ = Class.forName(name);
					if ( type_ == null ) {
						showErrorMessage("class not found.");
						return;
					}
					contructorList_= type_.getDeclaredConstructors();
					for (Constructor<?> c : contructorList_) {
						ListConstructor.add(c.toString());
					}
					showMessage("コンストラクタの一覧を取得しました.");
				} catch (ClassNotFoundException exception) {
					exception.printStackTrace();
					showErrorMessage("class not found.");
				}
			}
		});

		// -------- 選択したコンストラクタのパラメタ出力＆入力  ----------------------------------------
		Label labelConstructParam = new Label("■コンストラクタ生成パラメタ");
		labelConstructParam.setBounds(defaultXPoint, ListConstructor.getY()+ListConstructor.getHeight()+20, 230, 20);
		add(labelConstructParam);

		TextField textParameterFiled = new TextField("(input parameter)");
		textParameterFiled.setBounds(defaultXPoint, labelConstructParam.getY()+20, 500, 30);
		add(textParameterFiled);

		// -------- 選択したコンストラクタからインスタンスを生成 (botton) ----------------------------------------
		Button buttonCreateInstance = new Button("生成");
		buttonCreateInstance.setBounds(defaultXPoint+ textParameterFiled.getWidth(), textParameterFiled .getY(), 80,30 );
		add(buttonCreateInstance);
		buttonCreateInstance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = ListConstructor.getSelectedIndex();// 選択されている項目のIndex取得
				if (selectedIndex == -1) {
					showErrorMessage(" オブジェクト生成対象のコンストラクタを選択してください");
				} else {
					// コンストラクタの引数の型取得して、配列Object[]に保存
					java.lang.reflect.Type[] paramTypes = contructorList_[selectedIndex].getGenericParameterTypes();
					Object[] params = new Object[paramTypes.length];
					String sorce = textParameterFiled.getText();

					//選択したコンストラクタが引数なしの場合
					if(paramTypes.length == 0) {
						if (!sorce.equals("")) {
							showErrorMessage("選択したコンストラクタの引数と一致しません");
							return;
						} else {
							try {
								object_ = Util.createObject(type_.getName());
								showMessage("オブジェクトを生成しました." + object_.getClass().toString());
							} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e1) {
								e1.printStackTrace();
								showErrorMessage(e1.toString());
							}  catch (Exception e1) {
								e1.printStackTrace();
								showErrorMessage(e1.toString());
							}
						}

					}
					//選択したコンストラクタが引数ありの場合
					else {
						String[] paramValues = convertParams(sorce);
						if(paramValues.length != paramTypes.length) {
							showErrorMessage("選択したコンストラクタの引数と一致しません");
							return;
						}
						try {
							object_ = Util.createObject(type_.getName(), paramTypes, paramValues);
							showMessage("オブジェクトを生成しました." + object_.getClass().toString());
						} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
							e1.printStackTrace();
							showErrorMessage(e1.toString());
						}
					}
				}

			}
		});

		//-------- インスタンスのメソッド一覧を表示　( label +  List ) --------------------------------
		Label labelMethod = new Label("■生成したオブジェクトのメソッド一覧");
		labelMethod.setBounds(defaultXPoint, textParameterFiled.getY()+50, 300, 20);
		add(labelMethod);
		List listMethod = new List();
		listMethod.setBounds(defaultXPoint, labelMethod.getY()+20, 300, 200);
		add(listMethod);

		//-------- 型からメソッド一覧を取得 (botton) ----------------------------------------
		Button buttonGetMethod = new Button("取得");
		buttonGetMethod.setBounds(300+10, listMethod.getY(), 80,30 );
		add(buttonGetMethod);
		buttonGetMethod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listMethod.removeAll();
				String name = classNameField.getText();
				try {
					type_ = Class.forName(name);
					if ( type_ == null ) {
						showErrorMessage("class not found hogehoge.");
						return;
					}
					methodList_ = Util.getMethodList(type_.getName());
					for (String method : methodList_) {
						listMethod.add(method);
					}
					showMessage("メソッドの一覧を取得しました.");
				} catch (ClassNotFoundException exception) {
					exception.printStackTrace();
					showErrorMessage("class not found.");
				}
			}
		});


		// -------- 選択したメソッドのパラメタ入力＆実行  ----------------------------------------
		Label labelMethodExecParam = new Label("■メソッド実行パラメタ");
		labelMethodExecParam.setBounds(defaultXPoint, listMethod.getY()+listMethod.getHeight()+20, 230, 20);
		add(labelMethodExecParam);

		TextField textMethodParameterFiled = new TextField("(input parameter. ex: hoge,1)");
		textMethodParameterFiled.setBounds(defaultXPoint, labelMethodExecParam.getY()+20, 500, 30);
		add(textMethodParameterFiled);

		//-------- 型からメソッド一覧を取得 (botton) ----------------------------------------
		Button buttonExecMethod = new Button("実行(実装中..)");
		buttonExecMethod.setBounds(defaultXPoint + textMethodParameterFiled.getWidth(), textMethodParameterFiled.getY(), 150, 30 );
		//efaultXPoint+ textParameterFiled.getX()+500, textParameterFiled .getY(), 80,30 );
		add(buttonExecMethod);
		buttonExecMethod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO 実装
				showErrorMessage("実装中.....");
			}
		});
	}


	/**
	 * カンマで区切られたパラメータをObjectの配列に変換する
	 * sorceが空("")の場合はnullを返却
	 *
	 * @param sorce ユーザがコンストラクタ引数に指定した文字列
	 * @return
	 */
	private String[] convertParams(String sorce) {
		String[] ret = null;
		if (sorce.equals("")) {
			return ret;
		}

		//String(sorce) → String[]に変換
		StringCounter strCounter = new StringCounter();
		int paramElements = strCounter.countString(sorce, ",") + 1;
		String[] paramsList = new String[paramElements];
		int startIndex = 0;
		int endIndex = sorce.indexOf(',');
		for (int i = 0; i < paramElements; i++) {
			if (endIndex == -1) {// 最後の要素
				paramsList[i] = sorce.substring(startIndex, sorce.length());
				return paramsList;
			}
			paramsList[i] = sorce.substring(startIndex, endIndex);
			startIndex = endIndex + 1;
			endIndex = sorce.indexOf(',', startIndex);
		}

		return ret;
	}

	private void showMessage(final String message) {
		textOutput_.setText(message);
	}

	private void showErrorMessage(final String message) {
		textOutput_.setText("■■ERROR■■"+message);
	}

}
