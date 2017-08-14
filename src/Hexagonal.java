import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


public class Hexagonal extends Polygon2D{

	public final Point2D center;
	public final Double r;
	
	
	public Hexagonal(Point2D c, double r) {
		this.center = c;
		this.r = r;
		this.addPoint(c.getX()-r, c.getY());
		this.addPoint(c.getX()-r/2, c.getY()+r*(Math.sqrt(3)*0.5));
		this.addPoint(c.getX()+r/2, c.getY()+r*(Math.sqrt(3)*0.5));
		this.addPoint(c.getX()+r, c.getY());
		this.addPoint(c.getX()+r/2, c.getY()-r*(Math.sqrt(3)*0.5));
		this.addPoint(c.getX()-r/2, c.getY()-r*(Math.sqrt(3)*0.5));
		
	}
	
	
}
