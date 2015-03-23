

/**
 * 
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */
public class Koch implements Fractal{
	private double size = 0.9;
	private double x1 = 0.05;
	private double y1 = 0.5;
	private double x2 = x1+size;
	private double y2 = y1;
	
	@Override
	public LineSet transform(LineSet lineSet,int step) {
		LineSet newSet = new LineSet();
		
		if(step==0){
			//LineSet newSet = new LineSet();
			newSet.add(x1, y2, x2, y2);
			System.out.println("added the first line");
			return newSet;
		}
		System.out.println("Current Step:"+step);
		lineSet=transform(lineSet,--step);
		
		//LineSet newSet = new LineSet();
		lineSet.translate(-x1, -y1);
		lineSet.scale(1.0/3, 1.0/3);
		
		LineSet lineComponent1 = (LineSet) lineSet.copy();
		lineComponent1.translate(x1, y1);
		newSet.add(lineComponent1);
		
		LineSet lineComponent2 = (LineSet) lineSet.copy();
		lineComponent2.rotate(60);
		lineComponent2.translate(x1+size/3, y1);
		newSet.add(lineComponent2);
		
		LineSet lineComponent3 = (LineSet) lineSet.copy();
		lineComponent3.rotate(-60);
		lineComponent3.translate(x1+size/2, y1+size/(2*Math.sqrt(3)));
		newSet.add(lineComponent3);
		
		LineSet lineComponent4 = (LineSet) lineSet.copy();
		lineComponent4.translate(x1+2*size/3, y1);
		newSet.add(lineComponent4);
		
		return newSet;
	}
	
	
}
