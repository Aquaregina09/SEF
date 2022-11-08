package sef.module6.activity;


public class Point2DImpl implements Point2D {
	
	
	
	/**
	 * Creates a Point2D object at a default location (0,0)
	 */
	
	double x;
	double y;
	
	public Point2DImpl(){
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Create a Point2D object that represents a 2D coordinate specified 
	 * by the constructor parameters
	 * 
	 * @param x coordinate of the point along the x-axis
	 * @param y coordinate of the point along the y-axis
	 */
	public Point2DImpl(double x, double y){
		this.x = x;
		this.y = y;
		
	}
	

	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#move(double, double)
	 */
	public final void move(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#setX(double)
	 */
	public void setX(double x){
		this.x = x;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#setY(double)
	 */
	public void setY(double y){
		this.y =y;
	}
	

	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#getX()
	 */
	public double getX(){
	
		return x;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#getY()
	 */
	public double getY(){
		
		return y;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#translate(double, double)
	 */
	public final void translate(double dx, double dy){
		this.x = this.x + dx;
		this.y = this.y + dy;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object p){
		if(p instanceof Point2D) {
		    
            if(this.x == ((Point2D) p).getX() && this.y == ((Point2D) p).getY() ) {
                return true;
            }
        }
        return false;
	}
	

	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#equals(double, double)
	 */
	public boolean equals(double x2, double y2){
		if (this.x == x2 && this.y == y2) {
			return true;
		}
		return false;
	}
	
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#getDistance(sef.module5.activity.Point2D)
	 */
	public final double getDistance(Point2D p){
		double x3 = Math.pow(p.getX() -this.x, 2);
		double y3 = Math.pow(p.getY() - this.y, 2);
		return Math.sqrt(x3 + y3);
	}
	
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#getDistance(double, double)
	 */
	public final double getDistance(double x2, double y2){
		double x3 = Math.pow(x2 -this.x, 2);
		double y3 = Math.pow(y2 - this.y, 2);
		return Math.sqrt(x3 + y3);
	}
	
	
	
}
