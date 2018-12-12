package test;
import java.io.*;
public class ReadTest {

	public static void main(String[] args) {
	try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		String str1= br.readLine();
		String Str2=br.readLine();
		System.out.println(str);
		System.out.println(Str2);
		if(str1.equals("end")){
			
		System.out.println(str1);

	}
		else {System.out.println("fault");}


}catch(Exception ex) {};
}
}