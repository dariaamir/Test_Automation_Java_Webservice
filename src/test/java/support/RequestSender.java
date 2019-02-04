package support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import responses.Comments;
import responses.Posts;

public class RequestSender {

    public RequestSender(){};

    public static HttpURLConnection establishCall(String url) throws IOException{
        URL obj = new URL(url);
        return (HttpURLConnection) obj.openConnection();
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
                response = post.getBody();
                break;
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
                response = String.valueOf((comment.getPostID()));
                break;
            case "name":
                response = comment.getName();
                break;
            case "email":
                response = comment.getEmail();
                break;
            case "body":
                response = comment.getBody();
                break;
        }
        return response;
    }
}

