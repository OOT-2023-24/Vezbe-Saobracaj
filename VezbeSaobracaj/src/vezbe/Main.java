package vezbe;

import geometry.Circle;
import geometry.Donut;
import geometry.Drawing;
import geometry.Line;
import geometry.Moveable;
import geometry.Point;
import geometry.Rectangle;

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
//		int godina = 2023;
//		for(; godina<=2100; godina+=4) {
//			if(godina == 2023) {
//				godina++;
//				System.out.println(godina);
//				continue;
//			}else if(godina%100==0) {
//				if(godina%400==0) {
//					System.out.println(godina);
//				}else {
//					continue;
//				}
//			}
//			else {
//				System.out.println(godina);
//			}
//		}
		
		//VEZBE 3
//		Point p1 = new Point();
//		System.out.println(p1);
//		System.out.println(p1.x);
		
//		p1.setX(20);
//		p1.setY(10);
//		
//		Point p2 = new Point();
//		p2.setX(10);
//		p2.setY(10);
		
//		System.out.println(p1.distance(p2));
//		System.out.println(p1.distance(p1));
//		Line l1 = new Line();
//		System.out.println("Memorijska lokacija: " + l1);
//		System.out.println(l1.getStartPoint());
//		//System.out.println(l1.getStartPoint().getX());
//		
//		l1.setStartPoint(p1);
//		p1 = p2;
//		System.out.println(l1.getStartPoint().getX());
//		l1.setEndPoint(p2);
//		System.out.println(l1.length());
		
		//VEZBE 4
		Point p1 = new Point(10,10,true);
		//System.out.println("x: " + p1.getX() + ", y: " + p1.getY() +
				//", selected: " + p1.isSelected());
		Point p2 = new Point(20,20,false);
		Line l1 = new Line(p1,p2,false);
		//System.out.println(l1.getEndPoint().getX());
		Rectangle r1 = new Rectangle(new Point(50,50), 30, 30);
		Circle c1 = new Circle(new Point(25,25),40);
		
		//System.out.println(p1.toString());
		//System.out.println(p1);
		// 13-10 = 3 && 7-10=-3
		System.out.println(p1.contains(14, 7));
		
		Donut d1 = new Donut(new Point(50,50),50,30);
		System.out.println(d1.toString());
		
	}

}
