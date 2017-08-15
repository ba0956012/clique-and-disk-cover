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
		region = region+2*r;
		double d = 0.5*Math.sqrt(3)*r;
		
		for(double y=d;y<=region;y=y+2*d){
			for(double x=0.5*r;x<=region;x=x+3*r){
				Point2D p = new Point2D.Double();
				p.setLocation(x,y);
				Hexagonal h= new Hexagonal(p,r);
				H.add(h);
			}
		}
		
		for(double y=0;y<=region;y=y+2*d){
			for(double x=2*r;x<=region;x=x+3*r){
				Point2D p = new Point2D.Double();
				p.setLocation(x,y);
				Hexagonal h= new Hexagonal(p,r);
				H.add(h);
			}
		}
		
		
	}
}
