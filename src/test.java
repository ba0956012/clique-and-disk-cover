import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Point2D;
import java.io.FileWriter;
import java.io.IOException;

public class test {
	
	public static void main(String args[]) throws Exception{

		
		/*
		//star test : create a clique and calculate probability
		double count=0;
		double round=1000;
		double edge = 1.74;
		double radius = 1;
		int size;
		int max_size = 100;
		//int max_edge = 2;
		
		//for(edge = 2;edge<=max_edge;edge=edge*10)
		//{
		String s = "C:\\Users\\sclab\\" + edge +"=3 random in IR_10W.txt";
		FileWriter	fw = new FileWriter(s);
		
		for(int j=3; j<= max_size; j=j+1){
		size = j;	
		count=0;

		//System.out.println(C.r);
		for(int i=0;i<round;i++){
		clique cq = new clique();
		//cq.create_clique_IR(size-1);	
		cq.create_clque(edge,size-1);
		Circle C = smallestenclosingcircle.makeCircle(cq.points);
		//System.out.println(C.r);
		if(C.r>radius){
			count++;
		}
		cq.clean_clque();
		}
		double p =count/round;
		if(p!=0){
			System.out.println("size : "+ size);
			System.out.println("% : "+ p);
			}
		fw.write(size + ","+p+ "\r\n");
		}
		
		fw.close();
		//}
		//end test : create a clique and calculate probability
		*/
		
		int nodeNumber=100;
		double r=2.7;
		double bound = 100;
		
		//
		/*
		//disk cover for each clique
		for (nodeNumber=nodeNumber;nodeNumber<=100;nodeNumber=nodeNumber+100){
			double stopNumber=0;
			for(int file=1;file<=1;file++){
				cliqueFile cf = new cliqueFile();
				cf.Read("c:\\"+nodeNumber+"\\"+file+".txt");
								
				int count=0;
				for(int i=0;i<cf.cliques.size();i++){
					
				Circle C = smallestenclosingcircle.makeCircle(cf.cliques.get(i).points);
				//System.out.println("C.r : "+C.r);
				if(C.r<=r){
					count++;
				}
				else if(cf.cliques.get(i).twoCover()==true){
					count=count+2;
					//System.out.println("two cover");
				}
				else{
					count=count+3;
					//System.out.println("three cover");
				}
				}
				//System.out.println(count);
				stopNumber=stopNumber+count;
			}//file
			String s = "C:\\Users\\sclab\\Documents\\count.txt";
			FileWriter	fw = new FileWriter(s,true);
			fw.write(stopNumber/100+"\r\n");
			fw.close();
			System.out.println(stopNumber);
		}
		//disk cover for each clique
		*/
		
		
		/*
		//greedy cover points 
		nodeNumber=100;
		for (nodeNumber=nodeNumber;nodeNumber<=1000;nodeNumber=nodeNumber+100){
			double stopNumber=0;
			for(int file=1;file<=1;file++){
				diskCover DC = new diskCover();
				cliqueFile cf = new cliqueFile();
				cf.Read("c:\\"+nodeNumber+"\\"+file+".txt");
				List<Point2D> P = new ArrayList();
				List<Point2D> C = new ArrayList();
				for(int i=0; i<cf.cliques.size(); i++){
					for(int j=0;j<cf.cliques.get(i).points.size();j++){
						Point2D p = new Point2D.Double();
						p.setLocation(cf.cliques.get(i).points.get(j).getX(),cf.cliques.get(i).points.get(j).getY());
						P.add(p);
					}
				}
				
				//C = DC.greedyCover(P, r);
				 stopNumber =stopNumber+ DC.greedyCover(P, r).size();
			}
			System.out.println(stopNumber);
		}
		//greedy cover points 
		*/
		
		
		
		//create ILP data
		
		for(int j=100; j<=1000;j=j+100){
			for(int i=1; i<=100;i++){
				String file = "c:\\"+j+"\\"+i+".dat";
				cliqueFile cf = new cliqueFile();
				cf.Read("c:\\"+j+"\\"+i+".txt");
				cf.ILPdata(r, file, bound);
			}
		}
		
		//create ILP data
		
		
		//Hexagonal grid cover
		/*
		HexagonalGrid HG= new HexagonalGrid();
		HG.partation(100, 5.4);
		System.out.println("Grid size: "+HG.H.size());
		
		String ReadFile; 
		String WriteFile;
		diskCover dc = new diskCover(); 
		
		for(int i=100; i<=1000;i=i+100){
			double NoD=0;
			for(int j=1;j<=100;j++){
				ReadFile="c:\\r=2\\region 25,25\\clique\\"+i+"\\"+j+".txt";
				WriteFile="c:\\r=2\\region 25,25\\points\\"+i+"\\"+j+".txt";
				cliqueFile cf = new cliqueFile();
				cf.Read(ReadFile);
				//cf.createVertexFile(ReadFile, WriteFile);
				NoD=NoD+dc.HexagonTessellation(cf.getPoint2DList(), bound, r).size();			
			}
			System.out.println(NoD/100);
		}
		*/
		//Hexagonal grid cover
		
	}//main

}
