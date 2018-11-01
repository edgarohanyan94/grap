package triangle;

import line.Line;

public class Triangle{
	private Line line1;
	private Line line2;
	private Line line3;


	public Triangle(Line l1,Line l2,Line l3){
		this.line1 = l1;
		this.line2 = l2;
		this.line3 = l3;
	}
	public Triangle(){
		
	}

	public Line getLine1(){
		return this.line1;
	}
	
	public Line getLine2(){
		return this.line2;
	}

	public Line getLine3(){
		return this.line3;
	}

	// public double getPerimeter(){
	// 	return Point2d.getLength(p1,p2)+
	// 			Point2d.getLength(p1,p3)+
	// 			Point2d.getLength(p2,p3);
	// }

	// public double getArea(){
	// 	return Math.sqrt(getPerimeter()/2*
	// 						(getPerimeter()/2-Point2d.getLength(p1,p2))*
	// 						(getPerimeter()/2-Point2d.getLength(p1,p3))*
	// 						(getPerimeter()/2-Point2d.getLength(p2,p3)));
	// }

	// public static boolean isInsidePoint(Triangle triangle,Point2d point){
	// 	Triangle t1 = new Triangle(triangle.getPointP1(),triangle.getPointP2(),point);
	// 	Triangle t2 = new Triangle(triangle.getPointP1(),triangle.getPointP3(),point);
	// 	Triangle t3 = new Triangle(triangle.getPointP2(),triangle.getPointP3(),point);

	// 	return(triangle.getArea() == t1.getArea() + t2.getArea() + t3.getArea());

	// }

	// public static  boolean isTringle(Tringle tr){
	// 	double a=tr.l.getLine(tr.getPointA(),tr.getPointB());
	// 	double b=tr.l.getLine(tr.getPointA(),tr.getPointC());
	// 	double c=tr.l.getLine(tr.getPointB(),tr.getPointC());

	// 	System.out.println("Tringle coordinates");
	// 	System.out.println(tr.toString());

	// 	if (c<a+b && a<c+b && b<a+c) 
	// 		return true;
	// 	else{
	// 		System.out.println("Is not tringle");
	// 		return false;
	// 	}

}

