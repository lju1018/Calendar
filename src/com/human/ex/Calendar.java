package com.human.ex;

import java.util.Scanner;

public class Calendar {

	private final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

//	public int getMaxDaysOfMonth(int month) {
//			return MAX_DAYS[month - 1];
//	}

	public void printSampleCalendar(int month) {
		
		System.out.println(" 월   화   수    목    금    토   일");
		System.out.println("--------------------");
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
		
		for(int i=1;i<=MAX_DAYS[month];i++) {
			if(i%7==0) {
				System.out.print(" "+(i));
				System.out.println();
			}else {
			System.out.print(" "+(i));
			
		}
		}
	}

	public static void main(String[] args) {

		// 숫자를 입력받아 해당하는 달의 최대일수를 출력하는 프로그램
		String PROMPT="cal> ";
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int month=1;
	
		while (true) {
			System.out.println("달을 입력>> ");
			System.out.print(PROMPT);
			month= sc.nextInt();
			if(month==-1) {
				break;
			}
			if(month>12) {
				continue;
			}
			cal.printSampleCalendar(month);
//			System.out.printf("%d월 %d일 까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));
		}
		
//		cal.printSampleCalendar();
		sc.close();
	}

}
