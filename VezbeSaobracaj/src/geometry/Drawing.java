package geometry;

import java.awt.Color;
import java.awt.Graphics;

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
		p1.draw(g);
		Line l1 = new Line(new Point (200,200), new Point(400,200));
		l1.draw(g);
		Rectangle r1 = new Rectangle(p1,100,100);
		r1.draw(g);
		Circle c1 = new Circle(new Point(400,200), 70);
		c1.draw(g);
		Donut d1 = new Donut(new Point(100,100),80,20);
		
		//Zadatak 5 - Opisana kruznica
		int innerRadius = (int) (r1.getWidth()*Math.sqrt(2))/2;
		Point center = new Point(r1.getUpperLeft().getX() + r1.getWidth()/2,  
				r1.getUpperLeft().getY() + r1.getHeigth()/2);
		d1.setCenter(center);
		d1.setInnerRadius(innerRadius);		
		d1.draw(g);
	}

}
