package passwordsystem;

import java.util.Random;
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
	public static void testpw() {
		System.out.println("============================");
		System.out.println("\t判断密码强度");
		System.out.println("============================");
		System.out.print("请输入数字密码：");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try{
			str = bf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean len,captial,lowercase,num;
		len=captial=lowercase=num=false;
		len=(str.length()>=8)?true:false;
		for(int i=0;i<str.length()&&len;i++) {
			char code=str.charAt(i);
			if(!lowercase&&code>='a'&&'z'>=code) lowercase=true;
			else if(!captial&&code>='A'&&'Z'>=code) captial=true;
			else if(!num&&code>='1'&&'9'>=code) num=true;
			if(lowercase&&captial&&num) break;
		}
		if(!len||len&&num&&!captial&&!lowercase||len&&!num)
			System.out.println("该密码强度为：弱");
		else if(len&&num) {
			if(captial&&lowercase) System.out.println("该密码强度为：强");
			else System.out.println("该密码强度为：中");
		}
	}
	public static void creatpw() {
		System.out.println("============================");
		System.out.println("\t密码生成器");
		System.out.println("============================");
		System.out.print("请输入您想要生成密码的长度(8及以上)：");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str,password;str = password = "";
		int len = 0;
		try{
			str = bf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try{
			len = Integer.parseInt(str);
		} catch (NumberFormatException e){
		
			e.printStackTrace();
		}
		if(len>7) {
			String ss="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			Random random=new Random();
			StringBuffer stb=new StringBuffer();
				for(int i=0;i<len;i++) {
					int randomnum = random.nextInt(62);
					stb.append(ss.charAt(randomnum));
				}
				password = stb.toString();
				
			System.out.println("已为您生成强密码："+password);
		}
		else System.out.println("请输入8及以上的数!!");
				
	}
	public static void main(String arc[]) {
		int choice;
		do {
		choice = 0;
		System.out.println("================================");
		System.out.println("\t欢迎使用密码管理系统");
		System.out.println("================================");
		System.out.println("\t请选择操作：");
		System.out.println("1. 加密\n2. 解密\n3.判断密码强度\n4.密码生成\n5.退出");
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
		case 3:testpw();break;
		case 4:creatpw();break;
		default:break;
		}}while(choice!=5);
	}
}