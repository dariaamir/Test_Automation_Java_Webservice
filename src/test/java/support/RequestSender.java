package support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import cucumber.api.java.sl.In;
import responses.Comments;
import responses.Posts;
import responses.Todos;

public class RequestSender {

    public RequestSender(){};


    public static HttpURLConnection establishCall(String method, String url) throws IOException{
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod(method);
        return connection;
    }

    public static int get_responce_code(HttpURLConnection connection) throws IOException {
        return connection.getResponseCode();
    }

    public static String get_data_from_post(String datatype, HttpURLConnection connection) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        ObjectMapper mapper = new ObjectMapper();
        Posts post = mapper.readValue(br, Posts.class);
        String response = "";

        switch (datatype) {
            case "author":
                response = String.valueOf(post.getUserId());
                break;
            case "title":
                response = post.getTitle();
                break;
            case "body":
                String body = post.getBody();
                response = (body.contains("\n")) ? response = body.replace("\n"," ") : body;
                break;
            case "id":
                response = String.valueOf(post.getId());
                break;
            case "all":
                String author = String.valueOf(post.getUserId());
                String title = post.getTitle();
                body = post.getBody();
                body = (body.contains("\n")) ? body = body.replace("\n"," ") : body;
                response = author + " " + title + " " + body;
        }
        return response;
    }

    public static String get_data_from_comment(String datatype, HttpURLConnection connection) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        ObjectMapper mapper = new ObjectMapper();
        Comments comment = mapper.readValue(br, Comments.class);
        String response = "";

        switch (datatype) {
            case "postId":
                response = String.valueOf((comment.getPostId()));
                break;
            case "name":
                response = comment.getName();
                break;
            case "email":
                response = comment.getEmail();
                break;
            case "body":
                response = comment.getBody().replace("\n"," ");
                break;
        }
        return response;
    }

    public static int get_data_from_todos_group(String datatype, HttpURLConnection connection) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        ObjectMapper mapper = new ObjectMapper();
        Todos[] groupOfTodos = mapper.readValue(br, Todos[].class);
        int response = 0;
        switch (datatype) {
            case "all_todos_count":
                response = groupOfTodos.length;
                break;
            case "all_completed_todos_count":
                int count = 0;
                for(Todos todo: groupOfTodos){
                    if (todo.getCompleted()){
                        count++;
                    }
                }
                response = count;
                break;
        }
        return response;
    }

    public static String get_data_from_todos(String datatype, HttpURLConnection connection) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        ObjectMapper mapper = new ObjectMapper();
        Todos todo = mapper.readValue(br, Todos.class);
        String response = "";

        switch (datatype) {
            case "status":
                response = String.valueOf((todo.getCompleted()));
                break;
        }
        return response;
    }

    public static void writePost(HttpURLConnection connection, String title, String body, String userId) throws IOException{
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        Posts post = new Posts(userId = userId, title = title, body = body);
        String json = ow.writeValueAsString(post);
        os.write(json.getBytes("UTF-8"));
        os.close();
    }

    public static void patchPost(HttpURLConnection connection, String old_userID, String old_title, String old_body, String post_field, String new_value) throws IOException{
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Posts post = new Posts(old_userID, old_title, old_body);

        switch (post_field){
            case "userID":
                post.setUserId(new_value);
                break;
            case "title":
                post.setTitle(new_value);
                break;
            case "body":
                post.setTitle(new_value);
                break;
        }

        String json = ow.writeValueAsString(post);
        os.write(json.getBytes("UTF-8"));
        os.close();
    }
}

