package ex;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Reflector {


	static Map<String, String> primitiveMap = new HashMap<String, String>();
	static Map<String, Class> primitiveClassMap = new HashMap<String, Class>();
	static{
		primitiveMap.put("byte", "java.lang.Byte");
		primitiveMap.put("short", "java.lang.Short");
		primitiveMap.put("int", "java.lang.Integer");
		primitiveMap.put("long", "java.lang.Long");
		primitiveMap.put("float", "java.lang.Float");
		primitiveMap.put("double", "java.lang.Doublle");
		primitiveMap.put("char", "java.lang.Character");
		primitiveMap.put("boolean", "java.lang.Boolean");

		primitiveClassMap.put("byte", byte.class);
		primitiveClassMap.put("short", short.class);
		primitiveClassMap.put("int", int.class);
		primitiveClassMap.put("long", long.class);
		primitiveClassMap.put("float", float.class);
		primitiveClassMap.put("double", double.class);
		primitiveClassMap.put("char", char.class);
		primitiveClassMap.put("boolean", boolean.class);
	}

	/**
	 * オブジェクト生成(コンストラクタ引数なし)
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("deprecation")
	public static Object createObject(final String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException{
		Class  clazz = Class.forName(className);
		return  clazz.newInstance();
	}

	/**
	 * オブジェクト生成(コンストラクタ引数あり)
	 * @param paramTypes
	 * @param paramValues
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("unchecked")
	public static Object createObject(final String className, Type[] paramTypes, String[] paramValues) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		if(className == null || paramTypes == null || paramValues == null ) {
			return null;
		}
		if (paramTypes.length != paramValues.length ) {
			throw new IllegalArgumentException("list size is unmatch.");
		}
		Object ret  = null;
		Class  clazz = Class.forName(className);
		Class[] paramClassList = new Class[paramTypes.length];
		Object[] values = new Object[paramValues.length];
		//Type→Class
		for (int i = 0; i < paramClassList.length; i++) {
			paramClassList[i] = paramTypes[i].getClass();
//			String param = paramTypes[i].getClass().toString();
			String param =paramTypes[i].getTypeName();
			//TODO if-else NULLcheck
			if(primitiveMap.get(param) != null){
				paramClassList[i] = primitiveClassMap.get(param);
				// int -> Integer
				Class wrapperClass = Class.forName( primitiveMap.get(param));
				//Integer x = new Integer("10");
				Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(paramValues[i]);
				//Integer.intValue();
				values[i] =wrapperObj.getClass().getMethod(param + "Value", null ).invoke(wrapperObj, null);
			}else{
				//TODO 排列に対応する
				paramClassList[i] = Class.forName(paramTypes[i].getTypeName());
				Constructor constructor = paramClassList[i].getConstructor(String.class);
				constructor.setAccessible(true);
				values[i] = constructor.newInstance(paramValues[i]);
			}
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		Constructor constructor = clazz.getConstructor(paramClassList);
		constructor.setAccessible(true);
		ret = constructor.newInstance(values);
		return ret;
	}

	public static String[] getMethodList(String className)throws ClassNotFoundException{
		Class  clazz = Class.forName(className);
		Method[] methodList = clazz.getMethods();
		if(methodList == null || methodList.length == 0){
			return null;
		}
		String[] list = new String[methodList.length];
		for(int i = 0; i < methodList.length; i++){
			Method m = methodList[i];
				list[i] = Modifier.toString(m.getModifiers()) + " "	//修飾子
						+ m.getGenericReturnType().getTypeName()+ " "		//戻り値
						+ m.getName() 									//メソッド名
						+ "(";											//パラメータ
				Class[] params = m.getParameterTypes();
				if(params == null || params.length == 0){

				}else{
					for(int j = 0 ; j < params.length; j++){
						if(j != 0)list[i]+= ",";
						list[i] += params[j].getCanonicalName();
					}
				}
				list[i] += ")";
			}
		return list;
	}

	public static Method[] getMethods(String className)throws ClassNotFoundException{
		Class  clazz = Class.forName(className);
		Method[] methodList = clazz.getMethods();
		if(methodList == null || methodList.length == 0){
			return null;
		}
		return methodList;
	}

//	/**
//	 *
//	 * @param object 		メソッド実行対象のクラス
//	 * @param methodName
//	 * @param params
//	 * @param paramValues
//	 * @return
//	 * @throws ClassNotFoundException
//	 * @throws IllegalAccessException
//	 * @throws InstantiationException
//	 * @throws NoSuchMethodException
//	 * @throws InvocationTargetException
//	 */
//	@SuppressWarnings("unchecked")
//	public static Object oldExecuteMethod(Object object , String methodName, String[] params, String[] paramValues)throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException{
//		Object obj = null;
//		if(params == null ) {
//			return null;
//		}
//		Class[] paramClasses = new Class[params.length];
//		Object[] values  = new Object[params.length];
//		for(int i = 0; i < params.length; i ++){
//			//TODO if-else NULLcheck
//			if(primitiveMap.get(params[i]) != null){
//				paramClasses[i] = primitiveClassMap.get(params[i]);
//				Class wrapperClass = Class.forName( primitiveMap.get(params[i]));
//				Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(paramValues[i]);
//				Method method  = wrapperObj.getClass().getMethod(params[i] + "Value", null );
//				method.setAccessible(true);
//				values[i]  = method.invoke(wrapperObj, null);;
//			}else{
//				paramClasses[i] = Class.forName(params[i]);
//				Constructor constructor = paramClasses[i].getConstructor(String.class);
//				constructor.setAccessible(true);
//				values[i] = constructor.newInstance(paramValues[i]);
//			}
//		}
//		Method method = object.getClass().getMethod(methodName, paramClasses);
//		method.setAccessible(true);
//		if(Modifier.isStatic(method.getModifiers()))
//			obj = method.invoke(null, values);
//		else
//			obj = method.invoke(object, values);
//		return obj;
//	}

	/**
	 *
	 * @param object 		メソッド実行対象のクラス
	 * @param methodName
	 * @param params
	 * @param paramValues
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 */
	//TODO 残：メソッドに指定するパラメータの配列対応
	@SuppressWarnings("unchecked")
	public static Object executeMethod(Object object , String methodName, Type[] paramTypes, String[] paramValues)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, Exception{
		Object obj = null;
		if(paramTypes == null ) {
			return null;
		}
		Class[] paramClassList = new Class[paramTypes.length];
		Object[] values = new Object[paramValues.length];
		//Type→Class
		for (int i = 0; i < paramClassList.length; i++) {
			paramClassList[i] = paramTypes[i].getClass();
			String param =paramTypes[i].getTypeName();
			//TODO if-else NULLcheck
			if(primitiveMap.get(param) != null){
				paramClassList[i] = primitiveClassMap.get(param);
				// int -> Integer
				Class wrapperClass = Class.forName( primitiveMap.get(param));
				//Integer x = new Integer("10");
				Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(paramValues[i]);
				//Integer.intValue();
				values[i] =wrapperObj.getClass().getMethod(param + "Value", null ).invoke(wrapperObj, null);
			}else{
				//TODO 排列に対応する
				paramClassList[i] = Class.forName(paramTypes[i].getTypeName());
				Constructor constructor = paramClassList[i].getConstructor(String.class);
				constructor.setAccessible(true);
				values[i] = constructor.newInstance(paramValues[i]);
			}
		}

		Method method = object.getClass().getMethod(methodName, paramClassList);
		method.setAccessible(true);
		if(Modifier.isStatic(method.getModifiers()))
			obj = method.invoke(null, values);
		else
			obj = method.invoke(object, values);
		return obj;
	}


//	//private fieldも表示する
//	public static String[] getFieldList(Object object_) throws ClassNotFoundException {
//		Class  clazz = Class.forName(object_);
//		Field[] fieldList = clazz.getDeclaredFields();
////		Field[] fieldList = clazz.getFields();
//		if(fieldList == null || fieldList.length == 0){
//			return null;
//		}
//		String[] list = new String[fieldList.length];
//		for(int i = 0; i < fieldList.length; i++){
//			Field f = fieldList[i];
//				list[i] = f.getName();			}
//		return list;
//	}


//	public static String[][] getFieldList(Object object , String className)throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException{
//		Class  clazz = Class.forName(className);
//		Field[] fieldList = clazz.getDeclaredFields();
//		if(fieldList == null || fieldList.length == 0){
//			return null;
//		}
//		String[][] list = new String[fieldList.length][3];
//		String[] typeList = new String[fieldList.length]; 	//型
//		String[] nameList = new String[fieldList.length];		//名称
//		String[] valueList = new String[fieldList.length];	//値
//		for(int i = 0; i < fieldList.length; i++){
//			Field f = fieldList[i];
//			System.out.println("■■■■■■■■■"+ f.getType());
//			System.out.println("■■■■■■■■■"+ f.getType().getComponentType());
//			System.out.println("■■■■■■■■■"+ f.getType().getComponentType().isArray());
//			f.setAccessible(true);
//			nameList[i] = f.getName();
//			Class fieldType = f.getType();
//			typeList[i] =  fieldType.getCanonicalName();
//			Object value = f.get(object);
//			if(value != null){
//				valueList[i] = value.toString();
//			}
//		}
////		String[] sorted = Util.sort(nameList);
////		int[] indexMap = Util.sortIndex(nameList);
////		String[] sortedTypeList = Util.sortObject(typeList, indexMap);
////		String[] sortedValueList = Util.sortObject(valueList, indexMap);
////		for(int i = 0 ; i < sorted.length; i++){
////			list[i][0] = sortedTypeList[i];
////			list[i][1] = sorted[i];
////			list[i][2] = sortedValueList[i];
////		}
//		return list;
//	}

	//copy
	public static String[][] getFieldList(Object object, String className)throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException{

		Class clazz;
		String[][] list;

		clazz = Class.forName(className);

		Field[] fieldList = clazz.getDeclaredFields();
		if(fieldList == null || fieldList.length == 0){
			return null;
		}
		list = new String[fieldList.length][3]; //[i][0]=型,[i][0]=名前, [i][0]=値,

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
				fieldValue = field.get(object);
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
				fieldValue = field.get(object);
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

		return list;
	}


	public static boolean updateField(Object object ,String className, String paramType, String paramName, String paramValue)throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, SecurityException, NoSuchFieldException{

		if(paramValue == null || paramValue.equals("") || paramValue.length() == 0 || paramValue == null)return false;

			Object  value;
			Class objClass = Class.forName(className);
			Class paramClass;
			//mapにオブジェクトがあるか確認

			if(primitiveMap.get(paramType) != null){
				paramClass = primitiveClassMap.get(paramType);
				// int -> Integer
				Class wrapperClass = Class.forName( primitiveMap.get(paramType));
				//Integer x = new Integer("10");
				Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(paramValue);
				//Integer.intValue();
				Method m  = wrapperObj.getClass().getMethod(paramType + "Value", null );
				m.setAccessible(true);
				value =	m.invoke(wrapperObj, null);
			}else{
				paramClass = Class.forName(paramType);
				Constructor constructor = paramClass.getConstructor(String.class);
				constructor.setAccessible(true);
				value = constructor.newInstance(paramValue);
			}

			Field f = object.getClass().getDeclaredField(paramName);
			f.setAccessible(true);
			f.set(object, value);
			return true;
	}

	static void dump(final String str ) {
		System.out.println(">>>>> debug log >>>>>>>\t" + str);
	}


}
