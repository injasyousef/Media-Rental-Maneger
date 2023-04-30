package application;

public abstract class Media {
	private String title;
	private int noc;
	private String code;
	
	
	public Media(String code,String title, int noc) {
		super();
		this.code=code;
		this.title = title;
		this.noc = noc;
	}
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getNoc() {
		return noc;
	}


	public void setNoc(int noc) {
		this.noc = noc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
