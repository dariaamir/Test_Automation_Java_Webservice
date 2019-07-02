package support;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jayway.jsonpath.JsonPath;
import responses.Comments;
import responses.Posts;
import responses.Todos;
import org.json.JSONObject;


public class RequestSender {

    public RequestSender(){};
    private static int responseCode;
    private static String responseBody;

    public static void requestSend(String callMethod, String callURL, String callBody) throws IOException {
        URL url = new URL(callURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (callMethod.equals("PATCH")){
            connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            connection.setRequestMethod("POST");
        }
        else {
            connection.setRequestMethod(callMethod);
        }

        if (!callBody.equals("")){
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(callBody);
        }

        responseCode = connection.getResponseCode();

        responseBody = "";
        if (connection.getResponseCode() == 200 || connection.getResponseCode() == 201){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                responseBody += inputLine + "\n";
            }
        }
    }

    public static int getResponseCodeFromCall(){
        return responseCode;
    }

    public static String getResponseBodyFromCall(){
        return responseBody;
    }

    public static String getResponseBodyElementFromCall(String element){
        JSONObject responseBodyJSON = new JSONObject(responseBody);
        return responseBodyJSON.get(element).toString();
    }

    public static int getResponseBodyNumberOfElementsFromCall(String searchString){
        List <String> array = JsonPath.parse(responseBody).read(searchString);
        return array.size();
    }
}
