package model;

public class Todo {
	public int id;
	public String title; 
	public String done;
	
	public Todo(int id, String title, String done) {
		this.title = title;
		this.done = done;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
