package geometry;

import java.awt.Graphics;

public class Point extends Shape {
	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);
		this.selected = selected;
	}
	
	@Override
	public void draw(Graphics g) {
		// Point cemo predstavljati u vidu znaka +
		g.drawLine(x-2, y, x+2, y); // Horizontalna linija
		g.drawLine(x, y-2, x, y+2); // Vertikalna linija
		
	}
	
	public double distance(Point p1) {
		int dx = x - p1.x;
		int dy = y - p1.y;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	//Kada se metode zovu identicno a imaju razlicite parametre 
	// tada se radi o mehanizmu overloading-a
	//Kada metode imaju identican potpis a drugaciju logiku tada se radi
	// o mehanizmu overridinga
	
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Point) {
			Point temp = (Point) o;
			if(this.x == temp.getX() && this.y == temp.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		if((x - this.x <= 3 && x-this.x >= -3) && 
				(y - this.y <= 3 && y-this.y >= -3)) {
			return true;
		}
		return false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}
