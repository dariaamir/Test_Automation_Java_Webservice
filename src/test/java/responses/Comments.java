package responses;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Comments {

    public Comments(){};

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public int getPostID() {return postId;}

    public void setPostID(int postID) {this.postId = postID;}

    public int getCommentID() {return id;}

    public void setCommentID(int commentID) {this.id = commentID;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getBody() {return body;}

    public void setBody(String body) {this.body = body;}


}
