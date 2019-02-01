package support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import responses.Basic;

public class RequestSender {

    public RequestSender(){};

    private static HttpURLConnection establishCall(String url) throws IOException{
        URL obj = new URL(url);
        return (HttpURLConnection) obj.openConnection();
    }

    public static int get_responce_code(String url) throws IOException {
        HttpURLConnection connection = establishCall(url);
        return connection.getResponseCode();
    }

    public static int get_responce_message(String url) throws IOException {
        HttpURLConnection connection = establishCall(url);
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        ObjectMapper mapper = new ObjectMapper();
        Basic m = mapper.readValue(br, Basic.class);
        return m.getUserId();
    }
}

