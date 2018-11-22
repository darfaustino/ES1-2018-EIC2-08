package BDA;

import java.util.Date;

import com.restfb.types.Post;

public class FacePost {

	private int id;
	private String message;
	private Post post;
	private Date date;
	private String story;
	
	public FacePost (Post p, int counter){
		post=p;
		id=counter;
		message=post.getMessage();
		date=post.getCreatedTime();
		story=post.getStory();
	}
	//System.out.println("---- Post " + counter + " ----");
	//System.out.println("Id: " + "fb.com/" + aPost.getId());
	
	@Override
	public String toString() {
		return "<html> FacePost: "+ id +"<br/>Date:"+date+"<br/Story:"+story;
	}

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}
	
	public String getStory() {
		return story;
	}

	public Post getPost() {
		return post;
	}

	public Date getDate() {
		return date;
	}
}
