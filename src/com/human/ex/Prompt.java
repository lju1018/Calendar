package com.human.ex;

import java.util.Scanner;

public class Prompt {
	
	public int parseDay(String week) {
		if (week.equals("su")) return 0;
		else if(week.equals("mo")) return 1;
		else if(week.equals("tu")) return 2;
		else if(week.equals("we")) return 3;
		else if(week.equals("th")) return 4;
		else if(week.equals("fr")) return 5;
		else if(week.equals("sa")) return 6;
		else
			return 0;
	}
	
	public void runPrompt() {
		// 숫자를 입력받아 해당하는 달의 최대일수를 출력하는 프로그램
				Scanner sc = new Scanner(System.in);
				Calendar cal = new Calendar();

				int month = 1;
				int year=2017;
				int weekday=0;

				while (true) {
					System.out.println("년도 입력>> ");
					System.out.print("Year>> ");
					year=sc.nextInt();
					System.out.println("달을 입력>> ");
					System.out.print("Month>> ");
					month = sc.nextInt();
					if (month == -1) {
						break;
					}
					if (month > 12) {
						continue;
					}

					System.out.println("첫번째 요일(SU, MO, WE, TH, FR, SA)");
					System.out.println("WeekDay>> ");
					String str_weekday=sc.next();
					weekday=parseDay(str_weekday);

					cal.printCalendar(year,month,weekday);
				}

//				cal.printSampleCalendar();
				sc.close();
	}

	public static void main(String[] args) {
		//셀 실행
		Prompt p=new Prompt();
		p.runPrompt();
		
	}

}
