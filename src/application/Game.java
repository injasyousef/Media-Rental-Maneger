package application;


public class Game extends Media implements Comparable<Game> {
	private double weight;
	
	public Game(String code,String title, int noc, double weight) {
		super(code,title, noc);
		this.weight = weight;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public int compareTo(Game o) {
		return this.getTitle().compareTo(o.getTitle());
	}
	@Override
	public String toString() {
		return "Game [weight=" + weight + ", Title=" + getTitle() + ", Noc=" + getNoc() + ", Code="
				+ getCode() + "]";
	}
	

}
