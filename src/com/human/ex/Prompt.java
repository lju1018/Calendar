package com.human.ex;

import java.util.Scanner;

public class Prompt {
	/**
	 * 
	 * @param week 요일명
	 * @return	0~6 
	 */
	public int parseDay(String week) {
		if (week.equals("su"))  return 0;
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
				

				while (true) {
					System.out.println("년도 입력>> exit:-1 ");
					System.out.print("Year>> ");
					year=sc.nextInt();
					if(year==-1)
						break;
					System.out.println("달을 입력>> ");
					System.out.print("Month>> ");
					month = sc.nextInt();
					
					if (month > 12 || month < 1) {
						System.out.println("잘못된 입력입니다.");
						continue;
					}

					cal.printCalendar(year,month);
				}

//				cal.printSampleCalendar();
				sc.close();
	}

	public static void main(String[] args) {
		//셀 실행
		Prompt p=new Prompt();
		p.runPrompt();
		System.out.println("bye~!");
	}

}
