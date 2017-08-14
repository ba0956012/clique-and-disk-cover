import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


public class diskCover {

	

public List<Point2D> greedyCover(List<Point2D> P,double r){
	
	List<Point2D> testPoint = new ArrayList();
	List<Point2D> coverPoint = new ArrayList();
	//System.out.println(P.size());
	for(double i=0;i<=25;i=i+0.01){
		for(double j=0;j<=25;j=j+0.01){
		Point2D p = new Point2D.Double();
		p.setLocation(i, j);
		testPoint.add(p);
		}
	}
	int coverNumber;
	int maxCoverNumber=0;
	int point=0;
	
	while(P.size()>0){
		maxCoverNumber=0;
		for(int i=0; i<testPoint.size();i++){
			coverNumber =0;
			for(int j=0; j<P.size();j++){
			  if(testPoint.get(i).distance(P.get(j))<=r)
				{
				  coverNumber++;	  
				}
			}
			if(coverNumber>maxCoverNumber){
				maxCoverNumber=coverNumber;
				point = i;
			}
		}
		coverPoint.add(testPoint.get(point));
		//System.out.println(testPoint.get(point));
		for(int j=0; j<P.size();j++){
			if(P.get(j).distance(testPoint.get(point))<=r){
				P.remove(j);
			}
		}
	}
	return coverPoint;
}


public List<Point2D> greedyCover1(List<Point2D> P,double r){
	
	List<Point2D> testPoint = new ArrayList();
	List<Point2D> coverPoint = new ArrayList();
	//System.out.println(P.size());
	for(double i=0;i<=25;i=i+0.01){
		for(double j=0;j<=25;j=j+0.01){
		Point2D p = new Point2D.Double();
		p.setLocation(i, j);
		testPoint.add(p);
		}
	}
	int coverNumber;
	int maxCoverNumber=0;
	int maxCoverpoint=0;
	
	
	List<List<Point2D>> coverList = new ArrayList<List<Point2D>>();
	
	for(int i=0; i<testPoint.size();i++){
		List<Point2D> testCover = new ArrayList();
		for(int j=0; j<P.size();j++){
			if(testPoint.get(i).distance(P.get(j))<=r)
			{
				testCover.add(P.get(j));
			}
		}
		coverList.add(testCover);
	}
	while(P.size()>0){
		maxCoverNumber=0;
		
		for(int i=0; i<coverList.size();i++){
			if(coverList.get(i).size()>maxCoverNumber){
				maxCoverNumber=coverList.get(i).size();
				maxCoverpoint = i;
			}
		}
		coverPoint.add(testPoint.get(maxCoverpoint));
		
		for(int i=0; i<testPoint.size();i++){
			for(int j=0; j<coverList.get(i).size();j++){
				for(int t=0; t<coverList.get(maxCoverpoint).size();t++){
					if(coverList.get(maxCoverpoint).get(t).getX()==coverList.get(i).get(j).getX()&&
							coverList.get(maxCoverpoint).get(t).getY()==coverList.get(i).get(j).getY()){
						coverList.get(i).remove(j);					
					}
				}
			}
		}
		
		for(int j=0; j<P.size();j++){
			if(P.get(j).distance(testPoint.get(maxCoverpoint))<=r){
				P.remove(j);
			}
		}
	}

	return coverPoint;
}


public List<Point2D> HexagonTessellation(List<Point2D> P, double region, double r){
	
	HexagonalGrid HG= new HexagonalGrid();
	HG.partation(region, r);
	List<Point2D> disk = new ArrayList();
	boolean cover = false;
	for(int i=0;i<HG.H.size();i++){
		cover = false;
		for(int j=0; j<P.size();j++){
			if(HG.H.get(i).contains(P.get(j))){
				cover = true;
			}	
		}
		if(cover == true){
			disk.add(HG.H.get(i).center);
		}
	}
	return disk;
}



}
