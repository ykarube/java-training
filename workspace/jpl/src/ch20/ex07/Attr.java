package ch20.ex07;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * 第3章のAttrクラスヘ、DataOutputStreamにオブジェクトの内容を書き込むメソッドを
 * 追加しなさい。また、DatalnputStreamから状態を読み込むコンストラクタを追加しなさい。
 */
class Attr {

	private final String name;
	private Object value = null;

	public Attr(String name){
		this.name = name;
	}

	public Attr(String name, Object value){
		this.name = name;
		this.value = value;
	}

	public Attr(String name, DataInputStream in)throws IOException{
		this.name = name;
        DataInputStream input = new DataInputStream(in);
        this.value = input.readUTF();
        input.close();

	}

	public String getName(){
		return name;
	}

	public Object getValue(){
		return value;
	}

	public Object setValue(Object newValue){
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}

	public String toString(){
		return name + "='" + value + "'";
	}


	public void writeData(DataOutputStream dos)	throws IOException{
				dos.writeUTF(name);
				dos.writeUTF(value.toString());
	}

	public static void main(String[] args){
		try{
			Attr attr = new Attr("testName" , "testVal");
			String path = System.getProperty("user.dir");
			attr.writeData(new DataOutputStream(new FileOutputStream(new File(path+"\\src\\ch20\\ex07\\hoge.txt"))));


			attr.dump(new File(path+"\\src\\ch20\\ex07\\hoge.txt"));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private void dump( File file ) {
		StringBuilder s = new StringBuilder();
		try{
			BufferedReader  br = new BufferedReader(new FileReader(file));
			for(int i = 0; ; i++){
				String line = br.readLine();
				if(line == null)break;
				s.append(line + "\n");
			}
			System.out.println( s.toString());
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}