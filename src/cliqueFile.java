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
			Point p = new Point(Double.parseDouble(a[0]),Double.parseDouble(a[1]));
			pl.add(p);
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
	
	public void ILPdata(double r, String file, double bound) throws IOException{
		List<Point> P = new ArrayList();
		P=this.getPointList();
		List<Point> testPoint = new ArrayList();
		
		for(double i=0; i<=bound;i=i+1){
			for(double j=0; j<=bound;j=j+1){
				Point p = new Point(i,j);
				testPoint.add(p);
			}
		}
		
		FileWriter	fw = new FileWriter(file);
		
		fw.write("N="+testPoint.size()+";"+"\r\n");
		fw.write("M="+P.size()+";"+"\r\n");
		fw.write("A=["+"\r\n");
		for(int i=0;i<P.size();i++){
			fw.write("[");
			for(int j=0;j<testPoint.size();j++){
				if(P.get(i).distance(testPoint.get(j))<=r){
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
