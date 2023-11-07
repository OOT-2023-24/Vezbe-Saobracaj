package geometry;

public class Donut extends Circle {

	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center,radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center,radius,innerRadius);
		super.setSelected(selected);
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
//	public Donut(Circle c1, int innerRadius) {
//		this.setCenter(c1.getCenter());
//		this.setRadius(c1.getRadius());
//		this.innerRadius = innerRadius;
//	}
	
	
}
