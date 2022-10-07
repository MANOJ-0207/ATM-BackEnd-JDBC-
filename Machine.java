package ATM;
import java.io.*;
public class Machine
{
	public static int[] getCountArray() throws IOException
	{
		FileReader fr=new FileReader("Currency 2k 500 100.txt");
		String s="";
		int data;
		while((data=fr.read())!=-1)
			s+=(char)data;
		String arr[]=s.split(" ");
		int c1=Integer.parseInt(arr[0]);
		int c2=Integer.parseInt(arr[1]);
		int c3=Integer.parseInt(arr[2]);
		fr.close();
		return new int[]{c1,c2,c3};
	}
	public static void reduceATM(int amount) throws ClassNotFoundException, IOException
	{
		int arr[]=getCountArray();
	    int c1=arr[0];
	    int c2=arr[1];
	    int c3=arr[2];       
		int a1=0,a2=0,a3=0;
		if(amount/2000>0)
		{
			a1=amount/2000;
			if(a1>c1)
			   a1=c1;  
			amount=amount-(2000*a1);   
		}
		if(amount/500>0)
		{
			a2=amount/500;
			if(a2>c2) 
				a2=c2;
		    amount=amount-(500*a2);
		}
		if(amount/100>0)
		{
			a3=amount/100;
			if(a3>c3) 
				a3=c3;
			amount=amount-(100*a3);
		}
		FileWriter fw=new FileWriter("Currency 2k 500 100.txt");
		String s1=String.valueOf(c1-a1);
		String s2=String.valueOf(c2-a2);
		String s3=String.valueOf(c3-a3);
		String s=s1+" "+s2+" "+s3;
		int l=s.length();
		for(int i=0;i<l;i++)
		{
			fw.write(s.charAt(i));
		}
		fw.close();
	}
	public static void loadATM() throws IOException
	{
		int arr[]=getCountArray();
	    int c1=arr[0];
	    int c2=arr[1];
	    int c3=arr[2];
	    FileWriter fw=new FileWriter("Currency 2k 500 100.txt");
		String s1=String.valueOf(c1+20);
		String s2=String.valueOf(c2+100);
		String s3=String.valueOf(c3+100);
		String s=s1+" "+s2+" "+s3;
		int l=s.length();
		for(int i=0;i<l;i++)
		{
			fw.write(s.charAt(i));
		}
		fw.close();
	}
	public static void displayBalance() throws IOException 
	{
		FileReader fr=new FileReader("Currency 2k 500 100.txt");
		String s="";
		int data;
		while((data=fr.read())!=-1)
			s+=(char)data;
		String arr[]=s.split(" ");
		int c1=Integer.parseInt(arr[0]);
		int c2=Integer.parseInt(arr[1]);
		int c3=Integer.parseInt(arr[2]);
		int total1=c1*2000;
		int total2=c2*500;
		int total3=c3*100;
		System.out.println("Denomination   Number             Value ");
//		System.out.println("2000          "+c1+"   "+total1);
//		System.out.println("500           "+c2+"   "+total2);
//		System.out.println("100           "+c3+"   "+total3);
		System.out.format("%8s   %8s   %17s", "2000", c1, total1);
		System.out.println();
		System.out.format("%8s   %8s   %17s", "500", c2, total2);
		System.out.println();
		System.out.format("%8s   %8s   %17s", "100", c3, total3);
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("Total Amount available in the ATM:"+(total1+total2+total3));
		fr.close();
	}
	public static int getATMBalance() throws IOException 
	{
		FileReader fr=new FileReader("Currency 2k 500 100.txt");
		String s="";
		int data;
		while((data=fr.read())!=-1)
			s+=(char)data;
		String arr[]=s.split(" ");
		int c1=Integer.parseInt(arr[0]);
		int c2=Integer.parseInt(arr[1]);
		int c3=Integer.parseInt(arr[2]);
		int total1=c1*2000;
		int total2=c2*500;
		int total3=c3*100;
		fr.close();
		return total1+total2+total3;
	}
}
