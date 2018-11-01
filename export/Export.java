package export;

import matrix.Matrix;
import point.Point2d;
import triangle.Triangle;
import java.io.*;
import java.util.ArrayList;


public class Export{

	public static void export(Matrix matrix,String fileName) throws IOException{
			File file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(file);

			fos.write("P1".getBytes());
		    fos.write("\n".getBytes());
			fos.write(String.valueOf(matrix.getRow()).getBytes());
		 	fos.write(" ".getBytes());
		 	fos.write(String.valueOf(matrix.getCol()).getBytes());
		 	fos.write("\n".getBytes());

		 	int row = matrix.getRow();
		 	int col = matrix.getCol();

			for (int i = 0 ;i< col ;i++ ) {
				for (int j = 0;j< row ;j++ ) {
					if (matrix.getMatrix()[j][i] == 0) {
						fos.write(String.valueOf(0).getBytes());
						fos.write(" ".getBytes());
					}else{
						fos.write(String.valueOf(1).getBytes());
						fos.write(" ".getBytes());
						}
				}
				fos.write("\n".getBytes());
			}
			System.out.println("Check your file");
	}

	public static Matrix fillShape(Matrix matrix,Point2d point) throws IOException {
			

		 	ArrayList<Point2d> points = new ArrayList<Point2d>();
		 	points.add(point);
		 	matrix.getMatrix()[point.getX()][point.getY()] = 1;

		 	int row = matrix.getRow();
		 	int col = matrix.getCol();

		 	while(!points.isEmpty()){
		 		Point2d current = points.get(points.size() - 1);
		 		 int i = current.getX();
		 		 int j = current.getY();

		 		 points.remove(points.size() - 1);

		 		 if (i < row-1 && matrix.getMatrix()[i+1][j] == 0) {
		 		 	matrix.getMatrix()[i+1][j] = 1;
		 		 	points.add(new Point2d(i+1,j));
		 		   }

		 		  if(i-1>0 && matrix.getMatrix()[i-1][j] == 0){
              		 matrix.getMatrix()[i-1][j] = 1;
              		 points.add(new Point2d(i-1,j));
           		   }

           		  if(j<col-1 && matrix.getMatrix()[i][j+1]==0){
              		 matrix.getMatrix()[i][j+1]=1;
               		 points.add(new Point2d(i,j+1));
          		    }

          		   if(j-1>0 && matrix.getMatrix()[i][j-1]==0){
              		  matrix.getMatrix()[i][j-1]=1;
              		  points.add(new Point2d(i,j-1));
          			}
		 	}
		 	return matrix;
	}

}