import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class cliqueFile {
	List<clique> cliques = new ArrayList<>();

	public void Read(String file)throws IOException{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String s;
		int i=0;
		int j=0;
		List<Point> pl = new ArrayList<>();
		
		while (br.ready()){
			s = br.readLine();			
			if(s.contains(",")==true){
			String[] a = s.split(",");
			
			for(int t=0;t<a.length;t=t+2){
				Point p = new Point(Double.parseDouble(a[t]),Double.parseDouble(a[t+1]));
				pl.add(p);
				}
			}
			
			else if(i==0||i==1){
				//do nothing
			}
			
			else{
			 clique c = new clique();
			 for(int k=0; k<pl.size();k++){
			 Point p = new Point(pl.get(k).getX(),pl.get(k).getY());
			 c.points.add(p);
			 }
			 this.cliques.add(c);
			 pl.clear();
			}
			i++;
		}		
		 clique c = new clique();
		 for(int k=0; k<pl.size();k++){
		 Point p = new Point(pl.get(k).getX(),pl.get(k).getY());
		 c.points.add(p);
		 }
		 this.cliques.add(c);
		 pl.clear();
		//System.out.println(this.cliques.size());
		fr.close();
	}
	
	public List<Point> getPointList(){
		List<Point> P = new ArrayList();
		for(int i=0;i<this.cliques.size();i++){
			for(int j=0; j<this.cliques.get(i).points.size();j++){
				Point p = new Point(this.cliques.get(i).points.get(j).getX(),this.cliques.get(i).points.get(j).getY());
				P.add(p);
			}
		}
		return P;	
	}
	
	public List<Point2D> getPoint2DList(){
		List<Point2D> P = new ArrayList();
		for(int i=0;i<this.cliques.size();i++){
			for(int j=0; j<this.cliques.get(i).points.size();j++){
				Point2D p = new Point2D.Double();
				p.setLocation(this.cliques.get(i).points.get(j).getX(),this.cliques.get(i).points.get(j).getY());
				P.add(p);
			}
		}
		return P;	
	}
	
	public void ILPdata(double r, String file, double bound) throws IOException{
		List<Point> P = new ArrayList();
		P=this.getPointList();
		List<TestPoint> testPoint = new ArrayList();
		
		for(double i=0; i<=bound;i=i+1){
			for(double j=0; j<=bound;j=j+1){
				TestPoint p = new TestPoint();
				p.setLocation(i,j);
				for(int t=0; t<P.size();t++){
					Point2D.Double p2D = new Point2D.Double(P.get(t).getX(),P.get(t).getY());
					p.addCoverPoint(r, p2D);
					
				}
				//System.out.println(p.coverPoint.size());
				
				boolean reduce =false;
				for(int t=0; t<testPoint.size();t++){
					if(p.CoverEqule(testPoint.get(t))==true){
						reduce = true;
					}
				}
				if(testPoint.size()==0 || reduce == false){
					testPoint.add(p);
				}
			}
		}
		
		System.out.println(testPoint.size());
		
		
		FileWriter	fw = new FileWriter(file);
		
		fw.write("N="+testPoint.size()+";"+"\r\n");
		fw.write("M="+P.size()+";"+"\r\n");
		fw.write("A=["+"\r\n");
		for(int i=0;i<P.size();i++){
			fw.write("[");
			for(int j=0;j<testPoint.size();j++){
				Point2D.Double p2D = new Point2D.Double(P.get(i).getX(),P.get(i).getY());
				if(p2D.distance(testPoint.get(j))<=r){
					fw.write(" 1");
				}
				else
					fw.write(" 0");
			}
			fw.write("]"+"\r\n");
		}	
		fw.write("];");
		fw.close();
		
		
	}
	
	public void createVertexFile(String ReadFile, String WriteFile) throws IOException{
		this.Read(ReadFile);
		FileWriter	fw = new FileWriter(WriteFile);
		for(int i=0; i<this.cliques.size();i++){
			for(int j=0; j<this.cliques.get(i).points.size();j++){
				fw.write(this.cliques.get(i).points.get(j).x+","+this.cliques.get(i).points.get(j).y+"\r\n");
			}
		}
		fw.close();
	}

}
