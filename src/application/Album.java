package application;



public class Album extends Media implements Comparable<Album> {
	private String artist;
	private String song;
		
	
	public Album(String code,String title, int noc, String artist, String song) {
		super(code,title, noc);
		this.artist = artist;
		this.song = song;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	@Override
	public int compareTo(Album o) {
		return this.getTitle().compareTo(o.getTitle());
	}
	@Override
	public String toString() {
		return "Album [artist=" + artist + ", song=" + song + ", Title=" + getTitle() + ", Noc=" + getNoc()
				+ ", Code=" + getCode() + "]";
	}
	

}
