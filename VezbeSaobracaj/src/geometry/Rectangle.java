package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeft;
	private int width;
	private int height;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width,int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeft, int width,int height,boolean selected) {
		this(upperLeft,width,height);
		this.selected = selected;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeft.getX()-3, upperLeft.getY()-3, 6, 6);
			g.drawRect(upperLeft.getX()+width-3, upperLeft.getY()-3, 6, 6);
			g.drawRect(upperLeft.getX()-3, upperLeft.getY()+height-3, 6, 6);
			g.drawRect(upperLeft.getX()+width-3, upperLeft.getY()+height-3, 6, 6);
		}
		
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);	
	}
	
	@Override
	public String toString() {
		return "Upper left point: (" +this.getUpperLeft().getX() + "," + 
				this.getUpperLeft().getY() + "), width: " + this.getWidth() +
				", height: " + this.getHeigth();
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle) o;
			return area() - temp.area();
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle)o;
			if(this.getWidth() == temp.getWidth() 
					&& this.getHeigth() == temp.getHeigth()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		if( (y <= upperLeft.getY() + height && y >= upperLeft.getY())
				&& (x <= upperLeft.getX() + width && x >= upperLeft.getX()) ) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	public int area() {
		return height*width;
	}
	
	public int circumference() {
		return height*2 + width*2;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return height;
	}

	public void setHeigth(int height) {
		this.height = height;
	}

	

	
	
}
