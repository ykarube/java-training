package ex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {


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
				list[i] = m.getName() + "(";
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
	@SuppressWarnings("unchecked")
	public static Object executeMethod(Object object , String methodName, String[] params, String[] paramValues)throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException{
		if(params == null ) {
			return null;
		}
		Class[] paramClasses = new Class[params.length];
		Object[] values  = new Object[params.length];
		for(int i = 0; i < params.length; i ++){
			//TODO if-else NULLcheck
			if(primitiveMap.get(params[i]) != null){
				paramClasses[i] = primitiveClassMap.get(params[i]);
				Class wrapperClass = Class.forName( primitiveMap.get(params[i]));
				Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(paramValues[i]);
				Method method  = wrapperObj.getClass().getMethod(params[i] + "Value", null );
				method.setAccessible(true);
				values[i]  = method.invoke(wrapperObj, null);;
				}else{
				paramClasses[i] = Class.forName(params[i]);
				Constructor constructor = paramClasses[i].getConstructor(String.class);
				constructor.setAccessible(true);
				values[i] = constructor.newInstance(paramValues[i]);
			}
		}
		Method method = object.getClass().getMethod(methodName, paramClasses);
		method.setAccessible(true);
		return method.invoke(object, values);
	}

	//private fieldも表示する
	public static String[] getFieldList(String className) throws ClassNotFoundException {
		Class  clazz = Class.forName(className);
		Field[] fieldList = clazz.getDeclaredFields();
//		Field[] fieldList = clazz.getFields();
		if(fieldList == null || fieldList.length == 0){
			return null;
		}
		String[] list = new String[fieldList.length];
		for(int i = 0; i < fieldList.length; i++){
			Field f = fieldList[i];
				list[i] = f.getName();			}
		return list;
	}


	public static String[][] getFieldList(Object object , String className)throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException{
		Class  clazz = Class.forName(className);
		Field[] fieldList = clazz.getDeclaredFields();
		if(fieldList == null || fieldList.length == 0){
			return null;
		}
		String[][] list = new String[fieldList.length][3];
		String[] typeList = new String[fieldList.length]; 	//型
		String[] nameList = new String[fieldList.length];		//名称
		String[] valueList = new String[fieldList.length];	//値
		for(int i = 0; i < fieldList.length; i++){
			Field f = fieldList[i];
			System.out.println("■■■■■■■■■"+ f.getType());
			System.out.println("■■■■■■■■■"+ f.getType().getComponentType());
			System.out.println("■■■■■■■■■"+ f.getType().getComponentType().isArray());
			f.setAccessible(true);
			nameList[i] = f.getName();
			Class fieldType = f.getType();
			typeList[i] =  fieldType.getCanonicalName();
			Object value = f.get(object);
			if(value != null){
				valueList[i] = value.toString();
			}
		}
//		String[] sorted = Util.sort(nameList);
//		int[] indexMap = Util.sortIndex(nameList);
//		String[] sortedTypeList = Util.sortObject(typeList, indexMap);
//		String[] sortedValueList = Util.sortObject(valueList, indexMap);
//		for(int i = 0 ; i < sorted.length; i++){
//			list[i][0] = sortedTypeList[i];
//			list[i][1] = sorted[i];
//			list[i][2] = sortedValueList[i];
//		}
		return list;
	}

	//copy
//	public static String[][] getFieldList(Object object , String className)throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException{
//		Class  clazz = Class.forName(className);
//		Field[] fields = clazz.getDeclaredFields();
//		if(fields == null || fields.length == 0){
//			return null;
//		}
//		String[][] list = new String[fields.length][3];
//		String[] nameList = new String[fields.length];
//		String[] typeList = new String[fields.length];
//		String[] valueList = new String[fields.length];
//		for(int i = 0; i < fields.length; i++){
//			Field f = fields[i];
//			f.setAccessible(true);
//				nameList[i] = f.getName();
//				Class fieldType = f.getType();
//				typeList[i] =  fieldType.getCanonicalName();
//				Object value = f.get(object);
//				if(value != null){
//					valueList[i] = value.toString();
//				}
//		}
//		String[] sorted = Util.sort(nameList);
//		int[] indexMap = Util.sortIndex(nameList);
//		String[] sortedTypeList = Util.sortObject(typeList, indexMap);
//		String[] sortedValueList = Util.sortObject(valueList, indexMap);
//		for(int i = 0 ; i < sorted.length; i++){
//			list[i][0] = sortedTypeList[i];
//			list[i][1] = sorted[i];
//			list[i][2] = sortedValueList[i];
//		}
//		return list;
//	}

	private static String[] sort(String[] list){
		if(list == null || list.length == 0)return list;
		String[] sorted  = new String[list.length];
		List<String> array = new ArrayList<String>();
		for(int i = 0; i < list.length; i++){
			array.add(list[i]);
		}
		Collections.sort(array);
		int i= 0;
		for (String string : array) {
			sorted[i] = string;
			i++;
		  //System.out.println(string);
		}
		return sorted;
	}
	/**
	 * sort前のindex -> sort後のindexの配列
	 * @param list
	 * @return
	 */
	private static int[] sortIndex(String[] list){
				if(list == null || list.length == 0)return null;
				int[] sortIndex = new int[list.length];
				String[] sorted  = new String[list.length];
				List<String> array = new ArrayList<String>();
				for(int i = 0; i < list.length; i++){
					array.add(list[i]);
				}
			Collections.sort(array);
			int i= 0;
			for (String string : array) {
				sorted[i] = string;
				i++;
			  //System.out.println(string);
			}
			for(i = 0; i < list.length; i++){
				for(int j = 0 ; j < list.length; j ++){
					if(sorted[i].equals(list[j]))sortIndex[j] = i;
				}
			}
			return sortIndex;
		}
	/**
	 * sort後のindex -> sort前のindexの配列
	 * @param list
	 * @return
	 */
	private static int[] deSortIndex(String[] list){
				if(list == null || list.length == 0)return null;
				int[] sortIndex = new int[list.length];
				String[] sorted  = new String[list.length];
				List<String> array = new ArrayList<String>();
				for(int i = 0; i < list.length; i++){
					array.add(list[i]);
				}
			Collections.sort(array);
			int i= 0;
			for (String string : array) {
				sorted[i] = string;
				i++;
			  //System.out.println(string);
			}
			for(i = 0; i < list.length; i++){
				for(int j = 0 ; j < list.length; j ++){
					if(sorted[i].equals(list[j]))sortIndex[i] = j;
				}
			}
			return sortIndex;
		}

	private static String[] sortObject(String[] list,  int[] sortIndex){
		if(list == null || list.length == 0)return null;
		String[] result = new String[list.length];
		for(int i = 0; i < list.length; i++){
			result[sortIndex[i]] = list[i];
		}
		return result;
	}

}
