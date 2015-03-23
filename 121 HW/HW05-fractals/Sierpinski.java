

public class Sierpinski implements Fractal{
	private double side = 0.8;
	private double x1 = 0.1;
	private double y1 = 0.2;
	private double x2 = x1+side;
	private double y2 = y1;
	private double x3 = x1+side/2;
	private double h = side*Math.cos(Math.toRadians(30));
	private double y3 = y1+h;
	
	@Override
	public LineSet transform(LineSet lineSet, int step) {
		LineSet newLineSet = new LineSet();
		
		if(step==0){
			newLineSet.add(x1, y1, x2, y2);
			newLineSet.add(x2, y2, x3, y3);
			newLineSet.add(x3, y3, x1, y1);
			return newLineSet;
		}
		
		lineSet=transform(lineSet,--step);
		
		lineSet.translate(-x1, -y1);
		lineSet.scale(0.5, 0.5);
		
		lineSet.translate(x1, y1);
		newLineSet.add((LineSet)lineSet.copy());
		
		lineSet.translate(side/2, 0);
		newLineSet.add((LineSet)lineSet.copy());
		
		lineSet.translate(-side/4, Math.sqrt(3)*side/4);
		
		lineSet.add(newLineSet);
		
		return lineSet;
	}

}
