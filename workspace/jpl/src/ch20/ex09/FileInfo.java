package ch20.ex09;

import java.io.File;
import java.io.IOException;

/**
 *  1つかそれ以上のパス名を渡されて、それが表すフアイルについて得られるすべての情報を
 *  表示するメソッドを書きなさい。
 */
class FileInfo {

	   public static void main(String[] args) {
		   String path = System.getProperty("user.dir") + "\\src\\ch20\\ex09\\hoge.txt";
		   FileInfo fi = new FileInfo();
		   fi.showFileinfo(path);
	   }

		static void showFileinfo(String... filePath){
		   for (String name : filePath) {
		        File file = new File(name);
		        if (!file.exists()) {
		            System.err.println("ファイルが存在しません" + name);
		        break;
		    }
		    try {
		    	System.out.println("================");
		    	System.out.println("name: " + name);
		        System.out.println("getAbsolutePath(): " + file.getAbsolutePath());
		        System.out.println("CanonicalPath(): " + file.getCanonicalPath());
		        System.out.println("getFreeSpace(): " + file.getFreeSpace());
		        System.out.println("getName(): " + file.getName());
		        System.out.println("getParent(): " + file.getParent());
		        System.out.println("getPath(): " + file.getPath());
		        System.out.println("getTotalSpace(): " + file.getTotalSpace());
		        System.out.println("getUsableSpace(): " + file.getUsableSpace());
		        System.out.println("getAbsoluteFile(): " + file.getAbsoluteFile());
		        System.out.println("getCanonicalFile(): " + file.getCanonicalFile());
		        System.out.println("getParentFile(): " + file.getParentFile());
		        System.out.println("isAbsolute(): " + file.isAbsolute());
		        System.out.println("isDirectory(): " + file.isDirectory());
		        System.out.println("isFile(): " + file.isFile());
		        System.out.println("isHidden(): " + file.isHidden());
		        System.out.println("exists(): " + file.exists());
		        System.out.println("lastModified(): " + file.lastModified());
		        System.out.println("hashCode(): " + file.hashCode());
		        System.out.println("length(): " + file.length());
		        System.out.println("toString(): " + file.toString());
		        System.out.println("canExecute(): " + file.canExecute());
		        System.out.println("canRead(): " + file.canRead());
		        System.out.println("canWrite(): " + file.canWrite());
		        System.out.println("toURI(): " + file.toURI());
		        System.out.println("toPath(): " + file.toPath());
		        System.out.println("================");

		    } catch (IOException e) {
		        e.printStackTrace();
		        }
		    }
		}
}