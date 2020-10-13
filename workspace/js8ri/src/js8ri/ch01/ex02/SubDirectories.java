package js8ri.ch01.ex02;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SubDirectories {

	  public static void main(String[] args) {
	    Path currentPath = Paths.get("./", "src");
	    File dir = currentPath.toFile();
	    List<File> resultFileList = new ArrayList<>();

	    listAll(dir, resultFileList);
	    for (File file : resultFileList)
	      System.out.println(file.getAbsolutePath());

	    listAllbyRefMethod(dir, resultFileList);
	    for (File file : resultFileList)
	      System.out.println(file.getAbsolutePath());
	  }

	  public static void listAll(File f,List<File> resultList) {
		    File[] fileArray = f.listFiles(file -> file.isDirectory());
		    for(File file : fileArray){
		      resultList.add(file);
		      listAll(file, resultList);
		    }
		  }

	  public static void listAllbyRefMethod(File f,List<File> resultList) {
	    File[] fileArray = f.listFiles(File::isDirectory);
	    for(File file : fileArray){
	      resultList.add(file);
	      listAllbyRefMethod(file, resultList);
	    }
	  }
}