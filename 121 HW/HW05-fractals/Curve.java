

/**
 * 
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */

public interface Curve {
	void draw(SketchPad pad);
	
	// translates to the right by tx and up by ty
	void translate(double tx, double ty); 
	
	// scales width by sx and height by of sy
	void scale(double sx, double sy); 
	
	// rotates counter-clockwise by degrees (about the origin)
	void rotate(double degrees); 
	
	Curve copy();
}