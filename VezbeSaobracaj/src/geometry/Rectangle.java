package geometry;

public class Rectangle {

	private Point upperLeft;
	private int width;
	private int heigth;
	private boolean selected;
	
	public int area() {
		return heigth*width;
	}
	
	public int circumference() {
		return heigth*2 + width*2;
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
