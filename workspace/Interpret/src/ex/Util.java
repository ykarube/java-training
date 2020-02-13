package ex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
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
			String param = paramTypes[i].getClass().toString();

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
				paramClassList[i] = Class.forName(param);
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

}
