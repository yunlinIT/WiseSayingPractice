
public class WiseSaying {
	
	private int id;
	private String regDate;
	private String content;
	private String author;



	public WiseSaying(int id, String regDate, String content, String author) {
		this.id = id;
		this.regDate = regDate;
		this.content = content;
		this.author = author;	
		}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String getDate) {
		this.regDate = getDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
