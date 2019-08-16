package com.human.ex;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록" );         
		System.out.println("| 2. 일정 검색");        
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}
	
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
	
	
	
	public void runPrompt() throws ParseException {
		// 숫자를 입력받아 해당하는 달의 최대일수를 출력하는 프로그램
		printMenu();
				Scanner sc = new Scanner(System.in);
				Calendar cal = new Calendar();


				while(true) {
					System.out.println("명령(1, 2, 3, h, q)");
				String cmd=sc.nextLine();
				if(cmd.equals("1")) {
					cmdRegister(sc, cal);
				}else if(cmd.equals("2")) {
					cmdSearch(sc, cal);
				}else if(cmd.equals("3")) {
					cmdCal(sc, cal);
				}else if(cmd.equals("h")) {
					printMenu();
				}else if(cmd.equals("q")) {
					break;
				}
				}
				System.out.println("Thank you. Bye~");
				sc.close();
				}
	

	private void cmdCal(Scanner s,Calendar c) {
			int month = 1;
			int year=2017;
			System.out.println("년도 입력>>  ");
			System.out.print("Year>> ");
			year=s.nextInt();
	
			System.out.println("달을 입력>> ");
			System.out.print("Month>> ");
			month = s.nextInt();
			
			if (month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다.");
				return;
			}

			c.printCalendar(year,month);
		}


		
	



	private void cmdSearch(Scanner sc, Calendar c) {
		System.out.println("일정 검색");
		System.out.print("날짜 입력 >> (yyyy-MM-dd)");
		String date=sc.next();
		String plan="";
		try {
			plan = c.searchPlan(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("일정 검색 중 오류발생");
		}
		System.out.println(plan);
	}


	private void cmdRegister(Scanner sc, Calendar c) throws ParseException {
		System.out.println("새 일정 등록");
		System.out.print("날짜 입력 >> (yyyy-MM-dd)");
		String date=sc.next();
		String text="";
		System.out.print("일정 입력>> (문장 끝에 ; 입력)");
		while(true) {
		String word=sc.next();
		text+=word+" ";
		if(word.endsWith(";")) {
			break;
		}
		}
		c.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException {
		//셀 실행
		Prompt p=new Prompt();
		p.runPrompt();
	}

}
