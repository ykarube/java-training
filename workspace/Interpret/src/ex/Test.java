package ex;

import java.lang.reflect.Field;

public class Test {


	public static void main(String[] args) {
		exec();
	}

	static void exec() {
		try {
			reflectField();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	static void reflectField() throws IllegalArgumentException, IllegalAccessException {

		Class clazz;
		try {
			clazz = Class.forName("java.lang.String");
			String object_ = new String("hoge");

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
//					fieldType = field.getType().getCanonicalName();
					fieldName = field.getName();
					//TODO value
				} else {
					fieldType = field.getType();
					fieldName = field.getName();
					field.setAccessible(true);
					fieldValue = field.get(object_);
					fieldValueString = fieldValueString.toString();
				}

				//Object val = Modifier.isStatic(field.getModifiers()) ? field.get(null): field.get(object_);

				System.out.println("■■	type	■■"+ fieldType);
				System.out.println("■■	name	■■"+ fieldName);
				System.out.println("■■	value	■■"+ fieldValueString);




				//byte[] ba = (byte[]) Array.newInstance(f.getType(), 100);
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

			for (int i = 0; i < list.length; i++) {
				System.out.println("●"+list[i][0]);
				System.out.println("●"+list[i][1]);
				System.out.println("●"+list[i][2]);
			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}
}
