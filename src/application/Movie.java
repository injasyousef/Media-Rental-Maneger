package application;


public class Movie extends Media implements Comparable<Movie> {
	private String rating;
		
	
	public Movie(String code,String title, int noc, String rating) {
		super(code,title, noc);
		this.rating = rating;
	}

	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public int compareTo(Movie o) {
		return this.getTitle().compareTo(o.getTitle());
	}
	@Override
	public String toString() {
		return "Movie [rating=" + rating + ", Title=" + getTitle() + ", Noc=" + getNoc() + ", Code="
				+ getCode() + "]";
	}

}
