import java.util.List;
import java.util.ArrayList;



public class clique {
	List<Point> points = new ArrayList<>();
	double r;
	
	
	
	public boolean checkClique(double r){
		for(int i=0;i<this.points.size();i++){
			for(int j=i+1;j<this.points.size();j++){
				if(this.points.get(i).distance(this.points.get(j))>r)
				{
					System.out.println(this.points.get(i).distance(this.points.get(j)));
					return false;
				}
			}
		}
		return true;
	}
	
	public void addpoint(){
	
		double x = Math.random()*2*r;
		double y = Math.random()*r*2;
		
		for(int i=0; i<points.size();i++){
		 if(points.get(i).distance(x,y)>r){	
			 x = Math.random()*2*r;
			 y = Math.random()*2*r;
			 i=-1;
		 }
		}
		Point p = new Point(x,y);
		points.add(p);
	}
	
	
	public void addpoint_in_IR(Point p1, Point p2, Point p3){
		
		Point c = new Point(6.5, 10.1);
		double x = p2.x+Math.random()*r;
		double y = p1.y-Math.random()*r;
		
		while(((p1.distance(x, y)<=r&&p2.distance(x, y)<=r&&p3.distance(x, y)<=r)||c.distance(x, y)<=r*0.5)!=true){
			x = p2.x+Math.random()*r;
			y = p1.y-Math.random()*r;
			//System.out.println("W1:"+x+","+y);
		}
		//System.out.println("w2");
		
		for(int i=0; i<points.size();i++){
		 if(points.get(i).distance(x,y)>r){	
			    
			  do{
				x = p2.x+Math.random()*r;
				y = p1.y-Math.random()*r;
				//System.out.println(x+","+y);
				//System.out.println("w2");
				}while(((p1.distance(x, y)<=r&&p2.distance(x, y)<=r&&p3.distance(x, y)<=r)||c.distance(x, y)<=r*0.5) !=true);
			 i=-1;
		 }
		 //System.out.println("F2,"+i);
		}
		Point p = new Point(x,y);
		points.add(p);
	}
	
	public void create_clque(double rr, int size){
		r=rr;
		double x = Math.random()*2*r;
		double y = Math.random()*r*2;
		Point str = new Point(x,y); 
		points.add(str);
		while(points.size()<=size){
			this.addpoint();
		}
	}
	
	
	public void create_clique_IR(int size){
		r=3;
		Point p1 = new Point(6.5,11.6);
		Point p2 = new Point(5.0,9.0);
		Point p3 = new Point(8.0,9.0);
		
		points.add(p1);
		while(points.size()<=size){
			this.addpoint_in_IR(p1,p2,p3);
			
		}
	}
	
	public void clean_clque(){
		points.clear();
		}
	
	public boolean twoCover(){
		double Left=Double.MAX_VALUE, Right=0, Up=0, Down=Double.MAX_VALUE;
		List<Point> testPoint = new ArrayList();
		
		
		for(int i=0;i<this.points.size();i++){
			
			if(this.points.get(i).getX()<Left){
				Left=this.points.get(i).getX();
			}
			
			if(this.points.get(i).getX()>Right){
				Right=this.points.get(i).getX();
			}
			
			if(this.points.get(i).getY()<Down){
				Down=this.points.get(i).getX();
			}
			
			if(this.points.get(i).getY()>Up){
				Up=this.points.get(i).getX();
			}
			
		}
		
		for(double x = Left; x<=Right; x=x+0.01){
			for(double y = Down; x<=Up; x=x+0.01){
				Point p = new Point(x,y);
				testPoint.add(p);	
			}
		}
		
		for(int i=0; i<testPoint.size();i++){
			for(int j=0; j<testPoint.size();j++){
				int count =0;
				for(int t=0;t<this.points.size();t++){
					if(this.points.get(t).distance(testPoint.get(i))<=2.7
							||this.points.get(t).distance(testPoint.get(j))<=2.7){
						count ++;
					}
				}
				if(count == this.points.size()-1)
					return true;
			}
		}
			
		
		return false;
	}
}
