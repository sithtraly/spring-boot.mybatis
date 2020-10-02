package sprint.boot.testing.model;

/**
 * @author Traly 
 * created date: Oct 2, 2020
 */

public class Article {
	private long id;
	private String title;
	private String author;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(long id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
}
