package matrix;
import point.Point2d;
import line.Line;
import triangle.Triangle;
import java.util.List;
import java.util.ArrayList;

public class Matrix{
	private int[][] matrix;
	private int row = 1024;
	private int col = 768;


	public Matrix(){
		matrix = new int[this.row][this.col];
	}

	public Matrix(int row,int col){
		this.row = row;
		this.col = col;
		matrix = new int[this.row][this.col];
	}

	public int[][] getMatrix(){
		return matrix;
	}

	public int getRow(){
		return row;
	}

	public int getCol(){
		return col;
	}
	
	public int[][] drawLine(Line line){

		Point2d p1 = line.getP1();
		Point2d p2 = line.getP2();

		int dx=p2.getX()-p1.getX();
		int dy=p2.getY()-p1.getY();

		
		if (Math.abs(dy)>Math.abs(dx)) {
			for (int j=p1.getY();j!=p2.getY();j+=sign(dy)) {
					int i=p1.getX()+((j-p1.getY())*dx)/dy;
					matrix[i][j] = 1;
				}
		}else{
			for (int i=p1.getX();i!=p2.getX();i+=sign(dx)) {
				int j=p1.getY()+((i-p1.getX())*dy)/dx;
				matrix[i][j] = 1;
			}
		}


		return matrix;
	}

	public  int[][] initializeMatrix(){
		for (int i=0;i<row;i++) {
			for (int j=0;j<col;j++) {
					matrix[i][j]=0;
			}
		}

		return matrix;
	}
	private int sign(int x) {
  	  if (x < 0){
		return -1;
		}
   		 else{
			return 1;
		}
	}

	public  void printMatrix(){
		for (int i=0;i<row;i++) {
			for (int j=0;j<col;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}


}