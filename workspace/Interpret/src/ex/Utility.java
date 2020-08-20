package ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Utility {
public static String[] sort(String[] list){
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
public static int[] sortIndex(String[] list){
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
public static int[] deSortIndex(String[] list){
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

public static String[] sortObject(String[] list,  int[] sortIndex){
	if(list == null || list.length == 0)return null;
	String[] result = new String[list.length];
	for(int i = 0; i < list.length; i++){
		result[sortIndex[i]] = list[i];
	}
	return result;
}

public static void main(String[] args){
		String[] list = {"a", "d", "f", "Z", "z", "p"};
		String[]  newlist = sort(list);


		for (String string : list) {
			System.out.print(string + ",");
		}
		System.out.println("\n------------------");

		for (String string : newlist) {
			System.out.print(string + ",");
		}
		System.out.println("\n------------------");

		int[] sortI = sortIndex(list);
		for (int i : sortI) {
			System.out.print(i + ",");
		}
		System.out.println("\n------------------");

		int[] deSortI = deSortIndex(list);
		for (int i : deSortI) {
			System.out.print(i + ",");
		}

		System.out.println("sort開始");

		String[] l = sort(list);
		int[] desortNum = deSortIndex(list);
		for (int i = 0; i < desortNum.length; i++) {
			System.out.print("[" + desortNum[i] + "=" + l[i] + "],");

		}
	}

}

