package ch16.ex04;


import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * P363
 * ex.16.4
 * 指定された型に適用されていて得られる全てのアノテーションを表示する
 * プログラムを書きなさい
 * リテンションポリシーがRUNTIMEを持つアノテーションだけが得られる
 */
public class ShowAnnotation {

	public static void main(String[] args) {
		String[] argments = { "ch16.ex04.Sample" };
//		String[] argments = { "ch16.ex04.HogeAnnotation" };
		try{
			Class<?> clazz = Class.forName(argments[0]);
			System.out.println(clazz);


			Constructor[] cs = clazz.getConstructors();
			if(cs == null || cs.length ==0){
				//nop
			}
			else{
				for(int i = 0; i < cs.length; i++)
				print(clazz.toString(),  cs[i].getDeclaredAnnotations());
			}

			Field[] field = clazz.getDeclaredFields();
			if(field == null || field.length ==0){
				//nop
			}
			else{
				for(int i = 0; i < field.length; i++)
					print(field[i].getName(), field[i].getDeclaredAnnotations());
			}

			Method[] ms = clazz.getDeclaredMethods();
			if(ms == null || ms.length ==0){
				//nop
			}
			else{
				for(int i = 0; i < ms.length; i++){
					print(ms[i].getName(), ms[i].getDeclaredAnnotations());
					Annotation[][] ma = ms[i].getParameterAnnotations();
					if(ma == null ||ma.length == 0 || ma[0] == null ){}
					else{
						for(int j = 0 ; j < ma.length; j++)
						print("param" + j, ma[j]);
					}
				}
			}

		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public static void print(String name, Annotation[] as) {
		System.out.println(name + " : " +  as.toString());
	}
}
