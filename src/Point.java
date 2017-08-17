import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
final class Point {
	
	public final double x;
	public final double y;
	
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point subtract(Point p) {
		return new Point(x - p.x, y - p.y);
	}
	
	
	public double distance(Point p) {
		return Math.hypot(x - p.x, y - p.y);
	}
	
	public double distance(double xx, double yy) {
		return Math.hypot(x - xx, y - yy);
	}
	
	
	// Signed area / determinant thing
	public double cross(Point p) {
		return x * p.y - y * p.x;
	}
	
	
	//public String toString() {
	//	return String.format("Point(%g, %g)", x, y);
	//}
	
}