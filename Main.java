import point.Point2d;
import line.Line;
import triangle.Triangle;
import matrix.Matrix;
import export.Export;
import java.util.Scanner;
import shapeList.ShapeList;


public class Main{
 

	public static void main(String[] args) {

		menu();
	}

	private static void menu(){

		Scanner scanner = new Scanner(System.in);

		boolean isMenuActive = true;

		while(isMenuActive){
		 	System.out.println("Enter the command");
		 	System.out.println("(E) Export");
		 	System.out.println("(F) Fill at point (Extra point)");
		 	System.out.println("(C) Create a shape");
		 	System.out.println("(Q) Exit");

		 	String command = scanner.next().toUpperCase();
		 	switch(command){
		 		case "E": 
		 				String fileName = "text.pbm";
		 				Matrix matrix = new Matrix(1024,1024);

		 				if (!ShapeList.pointList.isEmpty()) {
		 					for (Point2d p : ShapeList.pointList) {
		 						matrix.getMatrix()[p.getX()][p.getY()] = 1;
		 					}
		 				}

		 				if (!ShapeList.lineList.isEmpty()) {
		 					for (Line l : ShapeList.lineList ) {
		 						matrix.drawLine(l);
		 					}
		 				}

		 				if (!ShapeList.triangleList.isEmpty()) {
		 					for (Triangle t : ShapeList.triangleList ) {
		 						matrix.drawLine(t.getLine1());
		 						matrix.drawLine(t.getLine2());
		 						matrix.drawLine(t.getLine3());
		 					}
		 				}
		 				
		 			try{
		 				if (ShapeList.extraPoint != null) {
		 					Export.fillShape(matrix,ShapeList.extraPoint);
		 					ShapeList.extraPoint = null;
		 				}
		 				Export.export(matrix,fileName);
		 			}catch(Exception e){
		 				System.out.println(e);
		 			}
		 			break;
		 		case "F":
		 				System.out.println("input point coordinates:");
		 				int xCord = scanner.nextInt();
		 				int yCord = scanner.nextInt();

		 				ShapeList.extraPoint = new Point2d(xCord,yCord);

		 			break;
		 		case "C":
		 			boolean isSapeActive = true;
		 			while(isSapeActive){
		 				System.out.println("(P) Point");
		 				System.out.println("(L) Line");
		 				System.out.println("(T) Trangle");
		 				System.out.println("(B) Back");

		 				String com = scanner.next().toUpperCase();
		 				switch(com){
		 					case "P":
		 							System.out.println("input p1 coordinates");
		 							int x1 = scanner.nextInt();
		 							int x2 = scanner.nextInt();

		 							Point2d point = new Point2d(x1,x2);
		 							ShapeList.pointList.add(point);
		 							System.out.println("Point is created");

		 						break;
		 					case "L":
		 							System.out.println("input p1 p2 coordinates");
		 							int x1cord = scanner.nextInt();
		 							int y1cord = scanner.nextInt();
		 							int x2cord = scanner.nextInt();
		 							int y2cord = scanner.nextInt();

		 							Line line = new Line(new Point2d(x1cord,y1cord),
		 												 new Point2d(x2cord,y2cord)
		 												);
		 							ShapeList.lineList.add(line);
		 							System.out.println("Line is created");
		 						    	
		 						break;
		 					case "T":
		 							System.out.println("input p1 p2 p3 coordinates");
		 							int x1cor = scanner.nextInt();
		 							int y1cor = scanner.nextInt();
		 							int x2cor = scanner.nextInt();
		 							int y2cor = scanner.nextInt();
		 							int x3cor = scanner.nextInt();
		 							int y3cor = scanner.nextInt();

		 							Line line1 = new Line(new Point2d(x1cor,y1cor),
		 												  new Point2d(x2cor,y2cor)
		 												 );

		 							Line line2 = new Line(new Point2d(x1cor,y1cor),
		 												  new Point2d(x3cor,y3cor)
		 												 );

		 							Line line3 = new Line(new Point2d(x2cor,y2cor),
		 												  new Point2d(x3cor,y3cor)
		 												  );

		 							Triangle triangle = new Triangle(line1,line2,line3);
									ShapeList.triangleList.add(triangle);
									System.out.println("Triangle is created");

			 						break;
		 					case "B":
		 						isSapeActive = false;
		 						break;	
		 					default:
		 						System.out.println("invalid command");
		 						break;
		 				}
		 			}
		 			break;
		 		case "Q":
		 			isMenuActive = false;
		 			System.out.println("bye bye");
		 			break;
		 		default:
		 			System.out.println("invalid command");
		 			break;
		 	}

		 }
	}

}
