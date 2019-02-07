package responses;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Todos {

    public Todos(){
    };

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public boolean getCompleted() {return completed;}

    public void setCompleted (boolean completed) {this.completed = completed;}
}
