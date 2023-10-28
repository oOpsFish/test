package passwordsystem;
import java.io.*;
public class Demo {
	public static void encryption() {
		System.out.println("================================");
		System.out.print("请输入要加密的数字密码：");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try{
			str = bf.readLine();//用户输入一个字符串
		} catch (IOException e) {
			e.printStackTrace();
		}
		char[] charArray = str.toCharArray();
		for(int i=0;i<charArray.length;i++)
			charArray[i]+=1+i+3;//将每个字符的ASCII码加上它在字符串中的位置(1开始)和偏移值3
		char temp =charArray[0];
		charArray[0] = charArray[charArray.length-1];
		charArray[charArray.length-1] = temp;//将字符串的第一位和最后一位调换顺序
		for (int i = 0; i < charArray.length / 2; i++) {
		      temp = charArray[i];
		      charArray[i] = charArray[charArray.length - 1 -i];
		      charArray[charArray.length - 1 - i] = temp;
		    }//将字符串反转
		System.out.println("加密后的结果是："+String.valueOf(charArray));
	}
	public static void cryption() {
		System.out.println("================================");
		System.out.print("请输入要解密的数字密码：");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try{
			str = bf.readLine();//用户输入一个字符串
		} catch (IOException e) {
			e.printStackTrace();
		}
		char[] charArray = str.toCharArray(); 
		char temp =charArray[0];
		charArray[0] = charArray[charArray.length-1];
		charArray[charArray.length-1] = temp;//将字符串的第一位和最后一位调换顺序
		for (int i = 0; i < charArray.length / 2; i++) {
		      temp = charArray[i];
		      charArray[i] = charArray[charArray.length - 1 -i];
		      charArray[charArray.length - 1 - i] = temp;
		    }//将字符串反转
		for(int i=0;i<charArray.length;i++)
			charArray[i]-=1+i+3;//将每个字符的ASCII码加减去在字符串中的位置(1开始)和偏移值3
		System.out.println("解密后的结果是："+String.valueOf(charArray));
	}
	public static void main(String arc[]) {
		int choice = 0;
		do {//功能菜单
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
