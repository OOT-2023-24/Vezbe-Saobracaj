package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame(); // Objekat koji ce predstavljati okvir-prozor
		Drawing drawing = new Drawing(); // Objekat koji predstavlja radnu povrsinu
		frame.setContentPane(drawing); // Prozoru dodeljujemo radnu povrsinu
		frame.setSize(800, 600); // Dimenzije prozora
		frame.setLocationRelativeTo(null); // Prozor ce biti centriran na ekranu
		frame.setVisible(true); // Prozor ce biti vidljiv - obavezno
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		Point p1 = new Point(400,400);
		//p1.draw(g);
		Line l1 = new Line(new Point (200,200), new Point(400,200));
		//l1.draw(g);
		Rectangle r1 = new Rectangle(new Point(500,500),100,100);
		//r1.draw(g);
		Circle c1 = new Circle(new Point(400,200), 70);
		//c1.draw(g);
		Donut d1 = new Donut(new Point(100,100),80,20);
		
		//Zadatak 5 - Opisana kruznica
		int innerRadius = (int) (r1.getWidth()*Math.sqrt(2))/2;
		Point center = new Point(r1.getUpperLeft().getX() + r1.getWidth()/2,  
				r1.getUpperLeft().getY() + r1.getHeigth()/2);
		d1.setCenter(center);
		d1.setInnerRadius(innerRadius);		
		//d1.draw(g);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		
		shapes.add(p1);
		shapes.add(l1);
		shapes.add(r1);
		shapes.add(c1);
		shapes.add(d1);
		
//		for(Shape s: shapes) {
//			g.setColor(Color.BLUE);
//			s.draw(g);
//			g.setColor(Color.RED);
//			s.moveBy(10, 0);
//			s.draw(g);	
//		}
		
//		shapes.get(2).draw(g);
//		shapes.get(shapes.size()-1).draw(g);
//		shapes.remove(1);
//		shapes.get(1).draw(g);
//		shapes.get(3).draw(g);
//		shapes.add(3, l1);
		
//		for(Shape s: shapes) {
//			if(s instanceof Circle) {
//				if(! (s instanceof Donut)) {
//					s.draw(g);
//				}
//			}
//		}
		
//		for(Shape s: shapes) {
//			if(s instanceof Circle
//			|| s instanceof Rectangle) {
//				s.draw(g);
//			}
//		}
		
		Line l2 = new Line(new Point(0,0), new Point(0,0));
		shapes.add(l2);
		
		HashMap<String,Shape> hmShapes = new HashMap<String,Shape>();
		for(Shape s: shapes) {
			if(s instanceof Point) {
				hmShapes.put("Point", s);
			}
			else if(s instanceof Line) {
				hmShapes.put("Line", s);
			}
			else if(s instanceof Rectangle) {
				hmShapes.put("Rectangle", s);
			}
			else if(s instanceof Donut) {
				hmShapes.put("Donut", s);
			}
			else if(s instanceof Circle) {
				hmShapes.put("Circle", s);
			}else {
				hmShapes.put("Nepoznati oblik", s);
			}			
		}
		
		for(Map.Entry<String, Shape> es: hmShapes.entrySet()) {
			System.out.println(es);
			es.getValue().draw(g);
		}
		
	}

}
