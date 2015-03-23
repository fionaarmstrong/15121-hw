package HW6;

/**
 * 
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */


public class Movie implements Comparable<Movie> {
	private String title;
	private int year;

	public Movie(String title, Integer year) {
		this.title = title;
		this.year = year;
	}

	public String getTitle() {
		return this.title;
	}

	public int getYear() {
		return this.year;
	}

	public String toString() {
		return this.title + " (" + this.year + ")";
	}

	public boolean equals(Movie other) {
		return this.title.equals(other.getTitle()) && this.year == other.getYear();
	}

	public int compareTo(Movie other) {
		// write your compareTo method here
		return -1;
	}
}