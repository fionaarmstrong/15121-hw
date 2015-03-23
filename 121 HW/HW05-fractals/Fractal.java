

/**
 * 
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */

public interface Fractal {
	
	// given a Curve representing step n of the fractal,
	// uses it to return a new Curve representing step
    // n+1 of the fractal
	public LineSet transform(LineSet lineSet, int step);
}