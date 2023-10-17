package vezbe;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {

		//Zadatak 1
//		System.out.println("Unesite simbol operacije");
//		Scanner sc = new Scanner(System.in);
//		String operacija = sc.next();
//		int prviBroj = 24;
//		
//		if(operacija.equals("+")) {
//			System.out.println(24+12);
//		}
//		else if(operacija.equals("-")) {
//			System.out.println(24-12);
//		}
//		else if(operacija.equals("*")) {
//			System.out.println(24*12);
//		}
//		else if(operacija.equals("/")) {
//			System.out.println(24/12);
//		}
//		else {
//			System.out.println("Nedozvoljena operacija");
//		}
		
		//FOR PETLJA
//		int i = 0;
//		for(; i<=10; i=i+1 ) {
//			System.out.println(i);
//		}
		
		//WHILE PETLJA
//		int k = 0;
//		while(k<=10) {
//			System.out.println(k);
//			k++;
//		}
		
		//DO-WHILE PETLJA
//		int l = 0;
//		do {
//			System.out.println(l);
//			l++;
//		}while(l<0);
		
		//ZADATAK 2 - Zbir parnih brojeva od 0 do unetog broja
//		System.out.println("Unesite simbol operacije");
//		Scanner sc = new Scanner(System.in);
//		int broj = sc.nextInt();
//		int rezultat = 0;
//		if(broj>200) {
//			System.out.println("Broj ne sme biti veci od 200");
//		}else {
//			for(int brojac = 0; brojac<=broj; brojac=brojac+2) {
//				rezultat += brojac;
//			}
//			System.out.println(rezultat);
//		}
		
		//ZADATAK 3 - Prestupne godine
		int godina = 2023;
		for(; godina<=2100; godina+=4) {
			if(godina == 2023) {
				godina++;
				System.out.println(godina);
				continue;
			}else if(godina%100==0) {
				if(godina%400==0) {
					System.out.println(godina);
				}else {
					continue;
				}
			}
			else {
				System.out.println(godina);
			}
		}
		
		
	}

}
