package passwordsystem;//随意添加一行注释
import java.io.*;
public class Demo {
	public static void encryption() {
		System.out.println("================================");
		System.out.print("请输入要加密的数字密码：");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try{
			str = bf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		char[] charArray = str.toCharArray();
		for(int i=0;i<charArray.length;i++)
			charArray[i]+=1+i+3;
		char temp =charArray[0];
		charArray[0] = charArray[charArray.length-1];
		charArray[charArray.length-1] = temp;
		for (int i = 0; i < charArray.length / 2; i++) {
		      temp = charArray[i];
		      charArray[i] = charArray[charArray.length - 1 -i];
		      charArray[charArray.length - 1 - i] = temp;
		    }
		System.out.println("加密后的结果是："+String.valueOf(charArray));
	}
	public static void cryption() {
		System.out.println("================================");
		System.out.print("请输入要解密的数字密码：");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try{
			str = bf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		char[] charArray = str.toCharArray(); 
		char temp =charArray[0];
		charArray[0] = charArray[charArray.length-1];
		charArray[charArray.length-1] = temp;
		for (int i = 0; i < charArray.length / 2; i++) {
		      temp = charArray[i];
		      charArray[i] = charArray[charArray.length - 1 -i];
		      charArray[charArray.length - 1 - i] = temp;
		    }
		for(int i=0;i<charArray.length;i++)
			charArray[i]-=1+i+3;
		System.out.println("解密后的结果是："+String.valueOf(charArray));
	}
	public static void main(String arc[]) {
		int choice = 0;
		do {
		System.out.println("================================");
		System.out.println("\t欢迎使用密码管理系统");
		System.out.println("================================");
		System.out.println("\t请选择操作：");
		System.out.println("1. 加密\n2. 解密");
		System.out.print("请输入选项序号：");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		try {
			choice = Integer.parseInt(bf.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		switch(choice) {
		case 1:encryption();break;
		case 2:cryption();break;
		default:break;
		}}while(choice!=5);
	}
}
