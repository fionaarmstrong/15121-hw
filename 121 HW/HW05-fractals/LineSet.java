

import java.util.ArrayList;

public class LineSet implements Curve{
	ArrayList<OneLine> lineList = new ArrayList<OneLine>();
	public class OneLine implements Curve{
		private double x1,y1,x2,y2;
		
		public OneLine(double xx1, double yy1, double xx2, double yy2){
			x1=xx1;
			y1=yy1;
			x2=xx2;
			y2=yy2;
		}
		
		@Override
		public void draw(SketchPad pad) {
			pad.drawLine(x1, y1, x2, y2);
		}

		@Override
		public void translate(double tx, double ty) {
			x1+=tx;
			y1+=ty;
			x2+=tx;
			y2+=ty;
		}

		@Override
		public void scale(double sx, double sy) {
			x1*=sx;
			y1*=sy;
			x2*=sx;
			y2*=sy;
		}

		/** rotates counter-clockwise by degrees (about the origin)
		 * 
		 */
		public void rotate(double degrees) {
			degrees=Math.toRadians(degrees);
			double xx=x1*Math.cos(degrees)-y1*Math.sin(degrees);
			double yy=x1*Math.sin(degrees)+y1*Math.cos(degrees);
			x1=xx;
			y1=yy;
			xx=x2*Math.cos(degrees)-y2*Math.sin(degrees);
			yy=x2*Math.sin(degrees)+y2*Math.cos(degrees);
			x2=xx;
			y2=yy;
		}

		@Override
		public Curve copy() {
			return new OneLine(x1,y1,x2,y2);
		}
		
	}//End of inner class OneLine
	
	public void add(double xx1, double yy1, double xx2, double yy2){
		lineList.add(new OneLine(xx1,yy1,xx2,yy2));
	}

	public void add(OneLine line){
		lineList.add(line);
	}
	
	public void add(LineSet newList){
		for(OneLine one: newList.lineList){
			lineList.add((OneLine)one.copy());
		}
	}
	
	@Override
	public void draw(SketchPad pad) {
		for(OneLine line: lineList){
			line.draw(pad);
		}
	}

	@Override
	public void translate(double tx, double ty) {
		for(OneLine line: lineList){
			line.translate(tx, ty);
		}
	}

	@Override
	public void scale(double sx, double sy) {
		for(OneLine line: lineList){
			line.scale(sx, sy);
		}
	}

	@Override
	public void rotate(double degrees) {
		for(OneLine line: lineList){
			line.rotate(degrees);
		}
	}

	@Override
	public Curve copy() {
		LineSet deepCopy = new LineSet();
		for(OneLine line: lineList){
			deepCopy.add((OneLine)line.copy());
		}
		return deepCopy;
	}

}
