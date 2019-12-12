package ch13.ex06;


public class CommaInsertString2 {

    public static String insertComma(String source, char separate, int commaSize) {
        if (source == null)
            throw new NullPointerException();
        if (commaSize < 1)
        	throw new IllegalArgumentException();


    	String ret = null;
		int index = source.length()%commaSize;
		if(index == 0)index=commaSize;
		ret = source.substring(0,  index);
		//1,234 index = 1
		for(int i = 0; index < source.length(); i++ ){
			ret += separate;
			ret += source.substring(index, index + commaSize);
			index += commaSize;
		}
		return ret;

    }


}
