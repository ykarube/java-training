package ch16.ex05;


import java.lang.reflect.Member;

/**
 * ex.16.5
 * 個々のメンバーに対して得られるアノテーション情報を含むようにClassContentsを拡張
 */
//P358から流用
public class ClassContents {

	public static void main(String[] args) {
		String[] argments = { "java.lang.String" };
		try{
			Class<?> c = Class.forName(argments [0]);
			System.out.println(c);

			printMembers(c.getFields(),c);
			printMembers(c.getConstructors(),c);
			printMembers(c.getMethods(),c);
		} catch (ClassNotFoundException e){
			System.out.println("unknown class" + argments[0]);
		}
	}

    private static void printMembers(Member[] mems, Class<?> c) {
        for (Member m : mems) {
            if (m.getDeclaringClass() == Object.class)
                return;
            if (m.getDeclaringClass() == c.getClass())
                return;
            String decl = m.toString();
            System.out.println("  > " +strip(decl, "java.lang."));
        }
    }

	public static String strip(String a, String b){
		String str = a.replace(b, "");
		return str;
	}
}
