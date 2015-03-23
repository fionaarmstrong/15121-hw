

/**
 * 
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */

public class Fractals {
	
	public static Curve generateFractal(Fractal fractal, int step) {
		LineSet newSet = new LineSet();
		newSet=fractal.transform(new LineSet(), step);
		newSet.draw(new SketchPad());
		
		return null; //remove this line when you are done
	}

	public static void main(String[] args) {
	//new Fractals().generateFractal(new Koch(), 5);
		new Fractals().generateFractal(new Sierpinski(), 5);
	}
}