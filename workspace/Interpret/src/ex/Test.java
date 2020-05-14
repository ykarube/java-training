package ex;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
public class Test {

	static Map<String, String> primitiveWrapperMap = new HashMap<String, String>();
	static Map<String, Class> primitiveClassMap = new HashMap<String, Class>();
	static{
		primitiveWrapperMap.put("byte", "java.lang.Byte");
		primitiveWrapperMap.put("short", "java.lang.Short");
		primitiveWrapperMap.put("int", "java.lang.Integer");
		primitiveWrapperMap.put("long", "java.lang.Long");
		primitiveWrapperMap.put("float", "java.lang.Float");
		primitiveWrapperMap.put("double", "java.lang.Doublle");
		primitiveWrapperMap.put("char", "java.lang.Character");
		primitiveWrapperMap.put("boolean", "java.lang.Boolean");

		primitiveClassMap.put("byte", byte.class);
		primitiveClassMap.put("short", short.class);
		primitiveClassMap.put("int", int.class);
		primitiveClassMap.put("long", long.class);
		primitiveClassMap.put("float", float.class);
		primitiveClassMap.put("double", double.class);
		primitiveClassMap.put("char", char.class);
		primitiveClassMap.put("boolean", boolean.class);
	}

	public static void main(String[] args) {
		exec();
	}

	static void exec() {
		try {
			getReflectField();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	static void getReflectField() throws IllegalArgumentException, IllegalAccessException {

		Class clazz;
		try {
//			clazz = Class.forName("java.lang.Integer");
//			Integer object_ = new Integer(10);
			clazz = Class.forName("java.lang.String");
			String object_ = new String("hoge");

			Field[] fieldList = clazz.getDeclaredFields();
			if(fieldList == null || fieldList.length == 0){
				return;
			}
			String[][] list = new String[fieldList.length][3]; //[i][0]=型,[i][0]=名前, [i][0]=値,

			for(int i = 0; i < fieldList.length; i++){
				System.out.println("-----------------------"+i+"-----------------------");
				Field	field		 = fieldList[i];
				Class	fieldType	 = null;     //fieldの型
				String	fieldName	 = null;
				Object	fieldValue	 = null;
				String	fieldValueString = "";

				System.out.println(">>>>"+ field);
				System.out.println(">>>>"+ "isPrimitive = "+ field.getType().isPrimitive()  );
				System.out.println(">>>>"+ "isArray = "+ field.getType().isArray()  );

				int err = 0;
				//Fieldが配列か否か
				if(field.getType().isArray()) {
					//配列の型(クラス)を取得する
					fieldType = field.getType().getComponentType();
					fieldName = field.getName();
					field.setAccessible(true);
					fieldValue = field.get(object_);
					int length = Array.getLength(fieldValue);
					//primitive型のときは要素表示

					for (int j = 0; j < length; j++) {
						Class paramClass = primitiveClassMap.get(fieldType.getSimpleName());
						if(char.class.equals(paramClass)) {
							char c = Array.getChar(fieldValue, j);
							fieldValueString += String.valueOf(c) + ",";
						} else if(byte.class.equals(paramClass)) {
							byte b = Array.getByte(fieldValue, j);
							fieldValueString += String.valueOf(b) + ",";
						} else if(int.class.equals(paramClass)) {
							int num = Array.getInt(fieldValue, j);
							fieldValueString += String.valueOf(num) + ",";
						} else if(short.class.equals(paramClass)) {
							short s = Array.getShort(fieldValue, j);
							fieldValueString += String.valueOf(s) + ",";
						} else if(long.class.equals(paramClass)) {
							long l = Array.getShort(fieldValue, j);
							fieldValueString += String.valueOf(l) + ",";
						} else if(float.class.equals(paramClass)) {
							float f = Array.getShort(fieldValue, j);
							fieldValueString += String.valueOf(f) + ",";
						} else if(double.class.equals(paramClass)) {
							double d = Array.getShort(fieldValue, j);
							fieldValueString += String.valueOf(d) + ",";
						} else if(boolean.class.equals(paramClass)) {
							boolean b = Array.getBoolean(fieldValue, j);
							fieldValueString += String.valueOf(b) + ",";
						} else {
							fieldValueString += Array.get(fieldValue, j).toString();
						}
					}
				} else {
					fieldType = field.getType();
					fieldName = field.getName();
					field.setAccessible(true);
					fieldValue = field.get(object_);
					fieldValueString = fieldValue.toString();
				}

				String simpleName = fieldType.getSimpleName();
				String type =  field.getType().isArray() ? simpleName+"[]" : simpleName;
				list[i][0]=  type;
				list[i][1] = fieldName;
				list[i][2] = fieldValueString;

				System.out.println("■■type■■	= "+ list[i][0]);
				System.out.println("■■name■■	= "+ list[i][1]);
				System.out.println("■■value■■	= "+ list[i][2]);

			}


			int size = list.length;
			for (int j = 0; j < list.length; j++) {
				System.err.println("=====");

				System.err.println(list[j][0]+ " "+ list[j][1] + " = " + list[j][2] );
				System.err.println("=====");
			}


		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}


		static void reflectFieldTest() throws IllegalArgumentException, IllegalAccessException {

			Class clazz;
			try {
				clazz = Class.forName("ex.TestClass");
				TestClass object_ = new TestClass();

				Field[] fieldList = clazz.getDeclaredFields();
				if(fieldList == null || fieldList.length == 0){
					return;
				}
				for (Field field : fieldList) {
					System.out.println(field);
				}
				String[][] list = new String[fieldList.length][3];
				String[] typeList = new String[fieldList.length]; 	//型
				String[] nameList = new String[fieldList.length];		//名称
				String[] valueList = new String[fieldList.length];	//値


				for(int i = 0; i < fieldList.length; i++){
					System.out.println("-----------------------"+i+"-----------------------");

					Field	field		 = fieldList[i];
					Class	fieldType	 = null;     //fieldの型
					String	fieldName	 = null;
					Object	fieldValue	 = null;
					String	fieldValueString = null;

					//Fieldが配列か否か
					if(field.getType().isArray()) {
						//配列の型(クラス)を取得する
						fieldType = field.getType().getComponentType();
//						fieldType = field.getType().getCanonicalName();
						fieldName = field.getName();
						//TODO value
					} else {
						fieldType = field.getType();
						fieldName = field.getName();
						field.setAccessible(true);
						fieldValue = field.get(object_);
						fieldValueString = fieldValue.toString();
					}

					//Object val = Modifier.isStatic(field.getModifiers()) ? field.get(null): field.get(object_);

					System.out.println("■■type■■	= "+ fieldType);
					System.out.println("■■name■■	= "+ fieldName);
					System.out.println("■■value■■	= "+ fieldValueString);
					System.out.println("----------------------------------------------");
				}

//				for (int i = 0; i < list.length; i++) {
//					System.out.println("●"+list[i][0]);
//					System.out.println("●"+list[i][1]);
//					System.out.println("●"+list[i][2]);
//				}
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	}

		/*
		 *				//byte[] ba = (byte[]) Array.newInstance(f.getType(), 100);
				//System.out.println(ba);




//				byte[] baa = (byte[]) Array.newInstance(field.getType().getComponentType(), 100);	//getCompontn
//				System.out.println(baa);
//				System.out.println("■■■■■■■■■"+ field.getType());
//				System.out.println("■■■■■■■■■"+ field.getType().getComponentType());
//				System.out.println("■■■■■■■■■"+ field.getType().getComponentType().isArray());
////				f.setAccessible(true);
//				nameList[i] = field.getName();
//				System.out.println("●●"+nameList[i]);
//				Class fieldType = field.getType();
//				typeList[i] =  fieldType.getCanonicalName();
//				System.out.println("●●"+typeList[i]);
//				Object value;
//				try {
//					value = f.get(object);
//					if(value != null){
//						valueList[i] = value.toString();
//					}
//				} catch (IllegalArgumentException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				}
				System.out.println("----------------------------------------------");
			}

//			for (int i = 0; i < list.length; i++) {
//				System.out.println("●"+list[i][0]);
//				System.out.println("●"+list[i][1]);
//				System.out.println("●"+list[i][2]);
//			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}


		static void reflectFieldTest() throws IllegalArgumentException, IllegalAccessException {

			Class clazz;
			try {
				clazz = Class.forName("ex.TestClass");
				TestClass object_ = new TestClass();

				Field[] fieldList = clazz.getDeclaredFields();
				if(fieldList == null || fieldList.length == 0){
					return;
				}
				for (Field field : fieldList) {
					System.out.println(field);
				}
				String[][] list = new String[fieldList.length][3];
				String[] typeList = new String[fieldList.length]; 	//型
				String[] nameList = new String[fieldList.length];		//名称
				String[] valueList = new String[fieldList.length];	//値


				for(int i = 0; i < fieldList.length; i++){
					System.out.println("-----------------------"+i+"-----------------------");

					Field	field		 = fieldList[i];
					Class	fieldType	 = null;     //fieldの型
					String	fieldName	 = null;
					Object	fieldValue	 = null;
					String	fieldValueString = null;

					//Fieldが配列か否か
					if(field.getType().isArray()) {
						//配列の型(クラス)を取得する
						fieldType = field.getType().getComponentType();
//						fieldType = field.getType().getCanonicalName();
						fieldName = field.getName();
						//TODO value
					} else {
						fieldType = field.getType();
						fieldName = field.getName();
						field.setAccessible(true);
						fieldValue = field.get(object_);
						fieldValueString = fieldValue.toString();
					}

					//Object val = Modifier.isStatic(field.getModifiers()) ? field.get(null): field.get(object_);

					System.out.println("■■type■■	= "+ fieldType);
					System.out.println("■■name■■	= "+ fieldName);
					System.out.println("■■value■■	= "+ fieldValueString);
					System.out.println("----------------------------------------------");
				}

//				for (int i = 0; i < list.length; i++) {
//					System.out.println("●"+list[i][0]);
//					System.out.println("●"+list[i][1]);
//					System.out.println("●"+list[i][2]);
//				}
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	}

		 */
	/*

Exception in thread "main" java.lang.reflect.InaccessibleObjectException: Unable to make field private final byte java.lang.String.coder accessible: module java.base does not "opens java.lang" to module Interpret
	at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:340)
	at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:280)
	at java.base/java.lang.reflect.Field.checkCanSetAccessible(Field.java:176)
	at java.base/java.lang.reflect.Field.setAccessible(Field.java:170)
	at Interpret/ex.Test.reflectField(Test.java:61)
	at Interpret/ex.Test.exec(Test.java:13)
	at Interpret/ex.Test.main(Test.java:8)
	 */

}
