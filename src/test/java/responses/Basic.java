package responses;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Basic {

    public Basic(){};

    int userId;
    int ids;
    String title;
    boolean completed;

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public int getIds() {return ids;}

    public void setIds(int ids) {this.ids = ids;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public boolean isCompleted() {return completed;}

    public void setCompleted(boolean completed) {this.completed = completed;}
}
