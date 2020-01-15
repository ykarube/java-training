package ch16.ex09;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;
/**
 * ex.16.9
 * 指定されたクラスの完全な宣言を表示するプログラムをリフレクションを使用して作成
 * ただし、インポート文、コメント、それに、初期化子、コンストラクタ、メソッドのコードは除外します。
 * メンバー宣言は、ソースコードに書かれたように表示すべきです。今まで説明してきたすべてのリフレクションクラスを
 * 使用する必要があるでしょう。多くのリフレクションオブジェクトのtoStringメソッドは、
 * 欲しい情報を正しい形式で提供しませんので、個々の情報を集めてまとめる必要があります
 */
//P358から流用
public class ClassContents {

	private static Set<String> members = new HashSet<String>();

	public static void main(String[] args) {
		String[] argments = { "java.lang.String" };
		try{
			Class<?> c = Class.forName(argments [0]);
			System.out.println(c);

 			/*from P358
			printMembers(c.getFields(),c);
			printMembers(c.getConstructors(),c);
			printMembers(c.getMethods(),c);
			*/

			int mod = c.getModifiers();
			if(Modifier.isPublic(mod))
				System.out.print("public ");
			else if(Modifier.isPrivate(mod))
				System.out.print("private ");
			else if(Modifier.isProtected(mod))
				System.out.print("protected ");
			if(Modifier.isStatic(mod))
				System.out.print("static ");
			if(Modifier.isFinal(mod))
				System.out.print("final ");

			System.out.println(strip(c.toString(), c.getPackage().getName() + "." ));

			addConstMembers(c.getConstructors());
	   	    addFiledMembers(c.getFields());
	        addMethodMembers(c.getMethods());
	   	    printMembers(c.getPackage().getName() + "." ,  c.getSimpleName() + ".");


		} catch (ClassNotFoundException e){
			System.out.println("unknown class" + argments[0]);
		}
	}

// from P358
//    private static void printMembers(Member[] mems, Class<?> c) {
//        for (Member m : mems) {
//            if (m.getDeclaringClass() == Object.class)
//                return;
//            if (m.getDeclaringClass() == c.getClass())
//                return;
//            String decl = m.toString();
//            System.out.println("  > " +strip(decl, "java.lang."));
//        }
//    }

	private static void addConstMembers(Constructor[] consts) {
		for (Constructor m : consts) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl  = "";
			Annotation[] annotations = m.getAnnotations();
			if(annotations == null || annotations.length ==0){
				//nop
			}
			else{
				for(int i = 0; i < annotations.length; i++){
					decl += annotations[i] + " ";
				}
			}
			decl += m.toString();
			members.add(decl);
		}
	}

	private static void addFiledMembers(Field[] fields) {
		for (Field m : fields) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = "";
			Annotation[] annotations = m.getAnnotations();
			if(annotations == null || annotations.length ==0){
				//nop
			}
			else{
				for(int i = 0; i < annotations.length; i++){
					decl += annotations[i] + " ";
				}
			}
			decl += m.toString();
			members.add(decl);
		}
	}

	private static void addMethodMembers(Method[] methods) {
		for (Method m : methods) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = "";
			Annotation[] annotations = m.getAnnotations();
			if(annotations == null || annotations.length ==0){
				//nop
			}
			else{
				for(int i = 0; i < annotations.length; i++){
					decl += annotations[i] + " ";
				}
			}
			decl += m.toString();
			members.add(decl);
		}
	}

	private static void printMembers(String packageName, String className){
		for (String s : members) {
			System.out.print(" ");
			System.out.println(strip(strip(s, packageName), className));
		}
	}

	//.… stripの定義.…
	public static String strip(String a, String b){
		String str = a.replace(b, "");
		return str;
	}

}
