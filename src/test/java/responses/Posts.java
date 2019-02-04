package responses;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Posts {

    public Posts(){};

    private int userId;
    private int ids;
    private String title;
    private String body;

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public int getIds() {return ids;}

    public void setIds(int ids) {this.ids = ids;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getBody() {return body;}

    public void setBody (String body) {this.body = body;}
}
