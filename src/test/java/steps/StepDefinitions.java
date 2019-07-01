package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.sl.In;
import org.junit.AfterClass;
import org.junit.Assert;
import support.RequestSender;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;


public class StepDefinitions {

    private String BaseURL = "https://jsonplaceholder.typicode.com/";
    private HttpURLConnection connection;

    //Requests

    @When("^user requests for the post by it's id$")
    public void user_requests_for_the_post_by_its_id(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String id = dataMap.get("id");
        RequestSender.requestSend("GET",BaseURL + "posts/" + id, "");
    }

    @When("^user requests for the comment by it's id$")
    public void user_requests_for_the_comment_by_its_id(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String id = dataMap.get("id");
        RequestSender.requestSend("GET",BaseURL + "comments/" + id, "");
    }

    @When("^user requests for all todos by user id$")
    public void user_requests_for_all_todos_by_user_id(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String id = dataMap.get("id");
        RequestSender.requestSend("GET",BaseURL + "todos?userId=" + id, "");
    }

    @When("^user requests for todo by id$")
    public void user_requests_for_todo_by_id(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String id = dataMap.get("id");
        RequestSender.requestSend("GET", BaseURL + "todos/" + id, "");
    }

    @When("^user creates new post with parameters$")
    public void userCreatesNewPostWithParameters(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String title = dataMap.get("title");
        String body = dataMap.get("body");
        String userId = dataMap.get("userId");
        String callBody = String.format("{\"title\": \"%s\", \"body\": \"%s\", \"userId\": %s}", title, body, userId);
        RequestSender.requestSend("POST", BaseURL + "posts", callBody);
    }

    @When("^user finds a post by id and updates one field with new value$")
    public void userUpdatesPostFieldWithNewValue(DataTable dataTable) throws IOException {

        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String post_field = dataMap.get("post_field");
        String new_value = dataMap.get("new_value");
        String postID = dataMap.get("postID");


        connection = RequestSender.establishCall("GET",BaseURL + "posts/" + postID);
        String post = RequestSender.get_data_from_post("all", connection);
        String old_userID = post.split(" ")[0];
        String old_title = post.split(" ")[1];
        String old_body = post.split(" ")[2];

        connection = RequestSender.establishCall("PUT", BaseURL + "posts/" + postID);
        RequestSender.patchPost(connection, old_userID, old_title, old_body, post_field, new_value);
    }

    //Responce codes

    @Then("^response code is (\\d+)$")
    public void responce_code_is(int code){
        Assert.assertEquals(code, RequestSender.getResponseCodeFromCall());
    }

    //Post

    @Then("^response for the post returns correct user ID$")
    public void response_for_the_post_returns_correct_user_id(DataTable dataTable){
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String author = dataMap.get("author");
        Assert.assertEquals(author, RequestSender.getResponseBodyElementFromCall("userId"));
    }

    @Then("^response for the post returns correct title$")
    public void response_for_the_post_returns_correct_title(DataTable dataTable){
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String title = dataMap.get("title");
        Assert.assertEquals(title, RequestSender.getResponseBodyElementFromCall("title"));
    }

    @Then("^response for the post returns correct body$")
    public void response_for_the_post_returns_correct_body(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String body = dataMap.get("body");
        Assert.assertEquals(body, RequestSender.getResponseBodyElementFromCall("body"));
    }

    @Then("^response contains updated data$")
    public void responseContainsNewPostId(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String title = dataMap.get("title");
        String body = dataMap.get("body");
        String userId = dataMap.get("userId");

        Assert.assertEquals(title, RequestSender.getResponseBodyElementFromCall("title"));
        Assert.assertEquals(body, RequestSender.getResponseBodyElementFromCall("body"));
        Assert.assertEquals(userId, RequestSender.getResponseBodyElementFromCall("userId"));
    }

    @Then("^response returns updated value at the changed field$")
    public void responseReturnsUpdatedValueAtTheChangedField(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String postField = dataMap.get("post_field");
        String changedValue = dataMap.get("new_value");
        Assert.assertEquals(changedValue, RequestSender.get_data_from_post(postField,connection));
    }

    @Then("^user deleted post by post id$")
    public void userDeletedPostByPostId(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String id = dataMap.get("postID");
        connection = RequestSender.establishCall("DELETE", BaseURL + "posts/" + id);
    }

    // Comment

    @Then("^response for the comment returns correct post id$")
    public void response_or_the_comment_returns_correct_poctid(DataTable dataTable){
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String postID = dataMap.get("postID");
        Assert.assertEquals(postID, RequestSender.getResponseBodyElementFromCall("postId"));
    }

    @Then("^response for the comment returns correct name$")
    public void response_or_the_comment_returns_correct_name(DataTable dataTable){
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String name = dataMap.get("name");
        Assert.assertEquals(name, RequestSender.getResponseBodyElementFromCall("name"));
    }

    @Then("^response for the comment returns correct email$")
    public void response_or_the_comment_returns_correct_email(DataTable dataTable){
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String email = dataMap.get("email");
        Assert.assertEquals(email, RequestSender.getResponseBodyElementFromCall("email"));
    }

    @Then("^response for the comment returns correct body$")
    public void response_for_the_comment_returns_correct_body(DataTable dataTable){
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String body = dataMap.get("body");
        String compageBody = RequestSender.getResponseBodyElementFromCall("body");
        Assert.assertEquals(body, compageBody);
    }

    // Todos
    @Then("^response returns correct number of todos$")
    public void response_returns_correct_number_of_todos(DataTable dataTable){
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        int number = Integer.parseInt(dataMap.get("number"));
        String searchString = dataMap.get("search_request");
        Assert.assertEquals(number, RequestSender.getResponseBodyNumberOfElementsFromCall(searchString));
    }

    @Then("^response returns correct number of completed todos$")
    public void responseReturnsCorrectNumberOfCompletedTodos(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        int number = Integer.parseInt(dataMap.get("number"));
        String searchString = dataMap.get("search_request");
        Assert.assertEquals(number, RequestSender.getResponseBodyNumberOfElementsFromCall(searchString));
    }

    @Then("^response returns correct status$")
    public void responseReturnsCorrectStatus(DataTable dataTable){
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String status = dataMap.get("status");
        Assert.assertEquals(status, RequestSender.getResponseBodyElementFromCall("completed"));
    }

    @Then("^todos list is empty$")
    public void todosListLsEmpty() throws IOException {
        Assert.assertEquals(0, RequestSender.get_data_from_todos_group("all_todos_count", connection));
    }

    @AfterClass()
    public void afterScenario() {
        connection.disconnect();
    }
}
