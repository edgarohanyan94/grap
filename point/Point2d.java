package point;

public class Point2d{
	private  int x;
	private  int y;

	public Point2d(int x,int y){
		this.x=x;
		this.y=y;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public static double getLength(Point2d p1,Point2d p2){
			return  Math.sqrt( 
			   		Math.pow((p2.getX()-p1.getX()),2)+
		      	 	Math.pow((p2.getY()-p1.getY()),2));
	}

	public String toString(){
		return "["+this.x+","+this.y+"]";
	}
}