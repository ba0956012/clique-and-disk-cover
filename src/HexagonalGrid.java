import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


public class HexagonalGrid {
	List<Hexagonal> H = new ArrayList<>();
	double region;
	double r;
	
	public void partation(double region, double r){
		this.region=region;
		this.r=r;
		region = (r-region%r)+region;
		
		for(double y=0.5*Math.sqrt(3)*r;y<region;y=y+Math.sqrt(3)*r){
			for(double x=0.5*r;x<region;x=x+3*r){
				Point2D p = new Point2D.Double();
				p.setLocation(x,y);
				Hexagonal h= new Hexagonal(p,r);
				H.add(h);
			}
		}
		
		for(double y=0;y<region;y=y+Math.sqrt(3)*r){
			for(double x=1.5*r;x<region;x=x+3*r){
				Point2D p = new Point2D.Double();
				p.setLocation(x,y);
				Hexagonal h= new Hexagonal(p,r);
				H.add(h);
			}
		}
		
		
	}
}
