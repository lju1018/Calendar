package com.human.ex;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록" );         
		System.out.println("| 2. 일정 검색");        
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 메뉴 q. 종료");
		System.out.println("+----------------------+");
	}
	
	/**
	 * 1.스위치 케이스 -스트링 적용
	 * 2. 플랜 클래스 생성 - 리팩토링?
	 */
	
	/**
	 * 
	 * @param week 요일명
	 * @return	0~6 
	 */
	public int parseDay(String week) {
		switch(week) {
		case "su":
			return 0;
		case "tu":
			return 1;
		case "we":
			return 2;
		case "th":
			return 3;
		case "fr":
			return 4;
		case "sa":
			return 5;
		default:
			return 0;
		}
	}
		
	
	
	
	public void runPrompt() throws ParseException {
		// 숫자를 입력받아 해당하는 달의 최대일수를 출력하는 프로그램
		printMenu();
				Scanner sc = new Scanner(System.in);
				Calendar cal = new Calendar();

				boolean isLoop=true;
				while(isLoop) {
					System.out.println("명령(1, 2, 3, m, q)");
				String cmd=sc.nextLine();
				
				switch(cmd) {
				case "1":
					cmdRegister(sc, cal);
					break;
				case "2":
					cmdSearch(sc, cal);
					break;
				case "3":
					cmdCal(sc, cal);
					break;
				case "m":
					printMenu();
					break;
				case "q":
					isLoop=false;
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
		PlanItem plan;
		
		plan = c.searchPlan(date);
		if(plan !=null) {
			System.out.println(plan.detail);
		}else {
			System.out.println("일정이 없음");
		}
	}


	private void cmdRegister(Scanner sc, Calendar c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.print("날짜 입력 >> (yyyy-MM-dd)");
		String date=sc.next();
		String text="";
		System.out.print("일정 입력>> (끝에 ; 입력)");
		String word;
		while(!(word=sc.next()).endsWith(";")) {
			text+=word+" ";
		}
		word=word.replace(";", "");
		text+=word;
		c.registerPlan(date, text);
	}
	public static void main(String[] args) throws ParseException {
		//셀 실행
		Prompt p=new Prompt();
		p.runPrompt();
	}

}
