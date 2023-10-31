package geometry;

public class Rectangle {

	private Point upperLeft;
	private int width;
	private int heigth;
	private boolean selected;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width,int heigth) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.heigth = heigth;
	}
	
	public Rectangle(Point upperLeft, int width,int heigth,boolean selected) {
		this(upperLeft,width,heigth);
		this.selected = selected;
	}
	
	public int area() {
		return heigth*width;
	}
	
	public int circumference() {
		return heigth*2 + width*2;
	}
	
	@Override
	public String toString() {
		return "Upper left point: (" +this.getUpperLeft().getX() + "," + 
				this.getUpperLeft().getY() + "), width: " + this.getWidth() +
				", height: " + this.getHeigth();
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
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
