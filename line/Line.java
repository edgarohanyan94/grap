package line;

import point.Point2d;

public class Line{
	private Point2d p1;
	private Point2d p2;

	public Line(Point2d p1,Point2d p2){
		this.p1 = p1;
		this.p2 = p2;
	}

	public Point2d getP1(){
		return this.p1;
	}


	public Point2d getP2(){
		return this.p2;
	}

}