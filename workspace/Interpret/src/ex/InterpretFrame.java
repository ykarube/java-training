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
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JFrame;

import test.StringCounter;
//TODO パラメータが排列のインスタンス生成
/*
######〇 staticメソッドの呼び出し   ★対応中 8/5～
######〇 waitの呼び出しで正しく表示されない >java.lang.IllegalMonitorStateException
######〇 setVisibleがうまく表示されなかた
(want)〇   sort
######× setBackGroud  (setClororは未確認)
######× bottunAdd
######× 配列は確認していない
######△ 自分自身も確認していない  ←main(string[] args)実行するためinvokeのパラメータに配列をセットする実装必要。。ただしexecute()を実行すればできるようにした△

######他の人
######・コンストラクタ/メソッドからの例外が表示されない。
######・配列の要素としてFrameが作成できなかった
######・Frameが作れなかった
######・setBackgroundで色指定ができない
######・自分自身が作れない"
######・配列はまだ作れない（java.awt.Frameの配列など）
######・メソッド（wait）の例外を表示しない
######・ボタンもaddできない
######・自分自身は呼べた（呼べなくなった）"
 */
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
	private int windowWidth = 800;
	private int windowHeight = 1000;
	private Class<?> type_ ;					//ユーザが入力したクラス名
	private Constructor<?>[] contructorList_;	//ユーザが入力したクラス名から取得したコンストラクタ
	private Object object_;					//ユーザーが選択したコンストラクタから生成したインスタンスオブジェクト
	private String[] methodStringList_;		//ユーザーが選択したクラスのメソッド一覧（文字列）
	private Method[] methodList_;				//ユーザーが選択したクラスのメソッド一覧
	private String[] fieldStringList_;			//ユーザーが選択したクラスのフィールド一覧（文字列）
	private Field[]  fieldList_;				//ユーザーが選択したクラスのフィールド一覧

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
		labelOutput.setBounds(defaultXPoint, windowHeight-180, 200, 20);
		add(labelOutput);
		this.textOutput_ = new TextArea("", 50, 50, TextArea.SCROLLBARS_BOTH);
		this.textOutput_.setBounds(defaultXPoint, labelOutput.getY()+20, 500, 100);
		add(this.textOutput_);

		//-------- クラス名の入力( label +  textFiled ) ---------------------------------------
		Label labelClassName = new Label("■取得対象クラス");
		labelClassName.setBounds(defaultXPoint, 20, 300, 20);
		add(labelClassName);
		TextField textClassName = new TextField("java.lang.Integer");
		textClassName.setBounds(defaultXPoint, labelClassName.getY()+20, 300, 20);
		add(textClassName);

		//-------- コンストラクタのリスト表示 ( label +  List ) --------------------------------
		Label labelConstruct = new Label("■コンストラクタ一覧");
		labelConstruct.setBounds(defaultXPoint, textClassName.getY()+40,300, 20);
		add(labelConstruct);
		List ListConstructor = new List();
		ListConstructor.setBounds(defaultXPoint, labelConstruct.getY()+20, 500, 80);
		add(ListConstructor);


		/*
		 * ex16.8
		 * Interpretプログラムをさらに修正して、任意のクラスのコンストラクタをユーザが呼び出せるようにする。その際にどんな例外も表示すること。
		 * またオブジェクトの生成が成功したら、そのオブジェクトのメソッドをユーザーが呼び出せるようにしなさい。
		 */
		/** 入力されたtextClassNameからClassオブジェクトを取得
		 *  Classオブジェクトから全てのConstructorを取得し、contructorList_へセットする*/
		//-------- 型からコンストラクタ一覧を取得 (botton) ----------------------------------------
		Button buttonGetConstructor = new Button("取得");
		buttonGetConstructor.setBounds(300+10, 40, 80, 20 );
		add(buttonGetConstructor);
		buttonGetConstructor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListConstructor.removeAll();
				type_ = null;
				String name = textClassName.getText();
				try {
					type_ = Class.forName(name);						//指定された文字列名を持つクラスまたはインタフェースに関連付けられたClassオブジェクトを返します
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
					showErrorMessage(exception.toString());
					showErrorMessage("class not found.");
				} catch (Exception exception) {
					exception.printStackTrace();
					showErrorMessage(exception.getCause().toString());
				}
			}
		});

		// -------- 選択したコンストラクタのパラメタ出力＆入力  ----------------------------------------
		Label labelConstructParam = new Label("■コンストラクタ生成パラメタ");
		labelConstructParam.setBounds(defaultXPoint, ListConstructor.getY()+ListConstructor.getHeight()+20, 230, 20);
		add(labelConstructParam);

		TextField textParameterFiled = new TextField("(input parameter)");
		textParameterFiled.setBounds(defaultXPoint, labelConstructParam.getY()+20, 500, 20);
		add(textParameterFiled);

		/*
		 * ex16.8
		 * Interpretプログラムをさらに修正して、任意のクラスのコンストラクタをユーザが呼び出せるようにする。その際にどんな例外も表示すること。
		 * またオブジェクトの生成が成功したら、そのオブジェクトのメソッドをユーザーが呼び出せるようにしなさい。
		 */
		// -------- 選択したコンストラクタからインスタンスを生成 (botton) ----------------------------------------
		Button buttonCreateInstance = new Button("生成");
		buttonCreateInstance.setBounds(defaultXPoint+ textParameterFiled.getWidth(), textParameterFiled.getY(), 80, 20 );
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
								object_ = Reflector.createObject(type_.getName());
								showMessage("オブジェクトを生成しました."  + "\n ->result: \"" + object_.getClass().toString()  + " \"");
							} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e1) {
								e1.printStackTrace();
								showErrorMessage(e1.getCause().toString());
							}  catch (Exception e1) {
								e1.printStackTrace();
								showErrorMessage(e1.getCause().toString());
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
							object_ = Reflector.createObject(type_.getName(), paramTypes, paramValues);
							showMessage("オブジェクトを生成しました."  + "\n ->result: \"" + object_.getClass().toString()  + " \"");
						} catch (ClassNotFoundException | NoSuchMethodException | SecurityException |
								InstantiationException | IllegalAccessException | IllegalArgumentException |
								InvocationTargetException e1) {
							showErrorMessage(e1.getCause().toString());
						}
					}
				}

			}
		});

		//-------- インスタンスのメソッド一覧を表示 ( label +  List ) --------------------------------
		Label labelMethod = new Label("■生成したオブジェクトのメソッド一覧");
		labelMethod.setBounds(defaultXPoint, textParameterFiled.getY()+50, 300, 20);
		add(labelMethod);
		List listMethod = new List();
		listMethod.setBounds(defaultXPoint, labelMethod.getY()+20, 500, 200);
		add(listMethod);

		//-------- 型からメソッド一覧を取得 (botton) ----------------------------------------
		Button buttonGetMethod = new Button("取得");
		buttonGetMethod.setBounds(500+10, listMethod.getY(), 80,20 );
		add(buttonGetMethod);
//==========================ソートいじる前↓==========================
//		buttonGetMethod.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				listMethod.removeAll();
//				String name = textClassName.getText();
//				try {
//					type_ = Class.forName(name);
//					if ( type_ == null ) {
//						showErrorMessage("class not found.");
//						return;
//					}
//					methodStringList_ = Reflector.getMethodList(type_.getName());
//					methodList_ = Reflector.getMethods(type_.getName());
//					for (String method : methodStringList_) {
//						listMethod.add(method);
//					}
//					showMessage("メソッドの一覧を取得しました.");
//				} catch (ClassNotFoundException exception) {
//					exception.printStackTrace();
//					showErrorMessage("class not found.");
//				}
//			}
//		});
//==========================ソートいじる前↑==========================

		buttonGetMethod.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			listMethod.removeAll();
			String name = textClassName.getText();
			try {
				type_ = Class.forName(name);
				if ( type_ == null ) {
					showErrorMessage("class not found.");
					return;
				}
				methodStringList_ = Reflector.getMethodList(type_.getName());
				Method[] list = Reflector.getMethods(type_.getName());

				//ソートする
				int[] sortedMethodNumber = new int[methodStringList_.length];
				methodList_ = new Method[methodStringList_.length];
				sortedMethodNumber = Utility.deSortIndex(methodStringList_);	//methodStingList_をソートしたときの配列番号を取得
				for (int j = 0; j < sortedMethodNumber.length; j++) {
					listMethod.add(methodStringList_[sortedMethodNumber[j]]);	//UIへの一覧(listMethod)へはmethodStingList_[ソートしたときの配列番号]を指定しソートする
					methodList_[j] = list[sortedMethodNumber[j]];
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
		textMethodParameterFiled.setBounds(defaultXPoint, labelMethodExecParam.getY()+20, 500, 20);
		add(textMethodParameterFiled);

		//-------- メソッド実行 (botton) ----------------------------------------
		Button buttonExecMethod = new Button("実行");
		buttonExecMethod.setBounds(defaultXPoint + textMethodParameterFiled.getWidth(), textMethodParameterFiled.getY(), 80, 20 );
		add(buttonExecMethod);
		buttonExecMethod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = listMethod.getSelectedIndex();// 選択されている項目のIndex取得
				if (selectedIndex == -1) {
					showErrorMessage(" 実行対象のメソッドを選択してください");
				} else {
					// メソッド引数の型
					java.lang.reflect.Type[] paramTypes = methodList_[selectedIndex].getGenericParameterTypes();
					String methodName = methodList_[selectedIndex].getName();
					Object[] params = new Object[paramTypes.length];
					String sorce = textMethodParameterFiled.getText();
					String[] paramValues = convertParams(sorce);

					if(paramValues!=null && paramValues.length != paramTypes.length) {
						showErrorMessage("選択したメソッドの引数と一致しません");
						return;
					}
					if(paramValues == null) {
						paramValues = new String[0];
					}
					Object obj = null;
					try {
						obj = Reflector.executeMethod(object_, methodName, paramTypes, paramValues);
					} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException e1) {
						String msg = "execute method: \"" + methodName + " \"" + "\n ->result: \"" + obj  + " \"";
						Throwable cause = e1.getCause();
						if(cause == null) {
							showErrorMessage( msg + "\n" + "Exception is \"" + e1.toString() + "\"");
						}else {
							showErrorMessage( msg + "\n" + "Exception is \"" + e1.getCause().toString() + "\"");
						}

					} catch (InvocationTargetException e2) {
						String msg = "execute method: \"" + methodName + " \"" + "\n ->result: \"" + obj  + " \"";
						Throwable cause = e2.getCause();
						if(cause == null) {
							showErrorMessage( msg + "\n" + "Exception is \"" + e2.toString() + "\"");
						}else {
							showErrorMessage( msg + "\n" + "Exception is \"" + e2.getCause().toString() + "\"");
						}
					} catch (Exception e3) {
						String msg = "execute method: \"" + methodName + " \"" + "\n ->result: \"" + obj  + " \"";
						Throwable cause = e3.getCause();
						if(cause == null) {
							showErrorMessage( msg + "\n" + "Exception is \"" + e3.toString() + "\"");
						}else {
							showErrorMessage( msg + "\n" + "Exception is \"" + e3.getCause().toString() + "\"");
						}
					}
					if(obj != null) {
						showMessage("execute method: \"" + methodName + " \"" + "\n ->result: \"" + obj.toString()  + " \"");
					}else {
						showMessage("execute method: \"" + methodName + " \"");
					}
				}
			}
		});


		// -------- 生成したオブジェクトのフィールド一覧  ----------------------------------------
		Label labelField = new Label("■生成したオブジェクトのフィールド一覧");
		labelField.setBounds(defaultXPoint, textMethodParameterFiled.getY()+textMethodParameterFiled.getHeight()+20, 250, 20);
		add(labelField);
		List listField = new List();
		listField.setBounds(defaultXPoint, labelField.getY()+20, 500, 80);
		add(listField);



		//-------- フィールド取得 (botton) ----------------------------------------
		Button buttonGetField = new Button("取得");
		buttonGetField.setBounds(500+10, listField.getY(), 80,20 );
		add(buttonGetField);
		buttonGetField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				listField.removeAll(); //表示するためlistFieldにつっこむ。
				String className = textClassName.getText();
				try {
					type_ = Class.forName(className);
					if ( type_ == null ) {
						showErrorMessage("class not found hogehoge.");
						return;
					}

					String[][] list = Reflector .getFieldList(object_,type_.getName() );
					for (int j = 0; j < list.length; j++) {
						listField.add(list[j][0]+ " "+ list[j][1] + " = " + list[j][2] );

					}
					showMessage("フィールドの一覧を取得しました.");
				} catch (ClassNotFoundException exception) {
					exception.printStackTrace();
					showErrorMessage("class not found.");
				} catch (IllegalArgumentException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
					showErrorMessage("IllegalArgumentException.");
				} catch (IllegalAccessException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
					showErrorMessage("IllegalAccessException.");
				}
			}
		});

		// -------- 選択したフィールドの更新パラメタ入力＆更新  ----------------------------------------
		Label labelFieldUpdate = new Label("■フィールドの更新値");
		labelFieldUpdate.setBounds(defaultXPoint, listField.getY()+listField.getHeight()+20, 230, 20);
		add(labelFieldUpdate);

		TextField textFieldValue = new TextField("(input field value. ex: 1234)");
		textFieldValue.setBounds(defaultXPoint, labelFieldUpdate.getY()+20, 500, 20);
		add(textFieldValue);

		//-------- フィールド更新 (botton) ----------------------------------------
		Button buttonUpdateField = new Button("更新");
		buttonUpdateField.setBounds(defaultXPoint + textFieldValue.getWidth(), textFieldValue.getY(), 80,20 );
		add(buttonUpdateField);
		buttonUpdateField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = listField.getSelectedIndex();// 選択されている項目のIndex取得
				if (selectedIndex == -1) {
					showErrorMessage(" 更新対象のフィールドを選択してください");
				} else {
					try {
						String[][] list = Reflector .getFieldList(object_,type_.getName() );
						String className = type_.getName();
						String paramType = list[selectedIndex][0];
						String paramName = list[selectedIndex][1];
						String paramValue = textFieldValue.getText();
						Reflector.updateField(object_, className, paramType, paramName, paramValue);

						showMessage("フィールドを更新しました.\n" + "before :" + list[selectedIndex][2] + "\n after  :" + paramValue);
					} catch (ClassNotFoundException e1) {
						showErrorMessage(e1.getCause().toString());
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO 自動生成された catch ブロック
						showErrorMessage(e1.getCause().toString()+ "フィールドにアクセスできません");
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						showErrorMessage(e1.getCause().toString());
						e1.printStackTrace();
					} catch (NoSuchMethodException e1) {
						showErrorMessage(e1.getCause().toString());
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						showErrorMessage(e1.getCause().toString());
						e1.printStackTrace();
					} catch (SecurityException e1) {
						showErrorMessage(e1.getCause().toString());
						e1.printStackTrace();
					} catch (NoSuchFieldException e1) {
						showErrorMessage(e1.getCause().toString());
						e1.printStackTrace();
					}

				}

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
		textOutput_.setText("■ ■ ■ ■ ■ERROR■■ ■ ■ ■ ■\n"+message);
	}


}
