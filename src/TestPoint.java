import java.awt.geom.Point2D;
import java.util.ArrayList;


public class TestPoint extends Point2D.Double {

	ArrayList<Point2D.Double> coverPoint = new ArrayList<>();
	
	public boolean addCoverPoint(double r, Point2D.Double p){
		if(p.distance(this)<=r){
			coverPoint.add(p);
			return true;
		}
		else
			return false;
	}
	
	public boolean CoverEqule(TestPoint p){
		
		boolean c = true;
		
		for(int i=0; i<this.coverPoint.size();i++){
			boolean equlePoint = false;
			for(int j=0;j<p.coverPoint.size();j++){
				if(this.coverPoint.get(i).getX()==p.coverPoint.get(j).getX()
						&&this.coverPoint.get(i).getY()==p.coverPoint.get(j).getY()){
					equlePoint = true;
				}				
			}
			if(equlePoint==false){
				c = false;
				return c;
			}
			
		}
		return c;
	}
	
}
