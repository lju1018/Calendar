package com.human.ex;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		int a,b;
		Scanner sc=new Scanner(System.in);
		String s1, s2;
		System.out.print("두수 입력 >> ");
		s1=sc.next();
		s2=sc.next();
		System.out.println(s1 + ","+s2);
		
		a=Integer.parseInt(s1);
		b=Integer.parseInt(s2);
//		System.out.println(a+","+b);
		
//		int c=a+b;
//		System.out.println();
		
		System.out.printf("%d와 %d는 두수의 합은 %d입니다.",a,b,a+b);
		sc.close();
	}

}
