package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.sl.In;
import org.junit.AfterClass;
import org.junit.Assert;
import support.RequestSender;

import javax.xml.crypto.Data;
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
        connection = RequestSender.establishCall("GET",BaseURL + "posts/" + id);
    }

    @When("^user requests for the comment by it's id$")
    public void user_requests_for_the_comment_by_its_id(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String id = dataMap.get("id");
        connection = RequestSender.establishCall("GET",BaseURL + "comments/" + id);
    }

    @When("^user requests for all todos by user id$")
    public void user_requests_for_all_todos_by_user_id(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String id = dataMap.get("id");
        connection = RequestSender.establishCall("GET",BaseURL + "todos?userId=" + id);
    }

    @When("^user requests for todo by id$")
    public void user_requests_for_todo_by_id(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String id = dataMap.get("id");
        connection = RequestSender.establishCall("GET", BaseURL + "todos/" + id);
    }

    @When("^user creates new post with parameters$")
    public void userCreatesNewPostWithParameters(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String title = dataMap.get("title");
        String body = dataMap.get("body");
        String userId = dataMap.get("userId");
        connection = RequestSender.establishCall("POST", BaseURL + "posts");
        RequestSender.writePost(connection, title, body, userId);
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
    public void responce_code_is(int code) throws IOException {
        Assert.assertEquals(code, RequestSender.get_responce_code(connection));
    }

    //Post

    @Then("^response for the post returns correct user ID$")
    public void response_for_the_post_returns_correct_user_id(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String author = dataMap.get("author");
        Assert.assertEquals(author, RequestSender.get_data_from_post("author", connection));
    }

    @Then("^response for the post returns correct title$")
    public void response_for_the_post_returns_correct_title(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String title = dataMap.get("title");
        Assert.assertEquals(title, RequestSender.get_data_from_post("title", connection));
    }

    @Then("^response for the post returns correct body$")
    public void response_for_the_post_returns_correct_body(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String body = dataMap.get("body");
        Assert.assertEquals(body, RequestSender.get_data_from_post("body", connection));
    }

    @Then("^response contains updated data$")
    public void responseContainsNewPostId(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String title = dataMap.get("title");
        String body = dataMap.get("body");
        String userId = dataMap.get("userId");

        Assert.assertEquals(userId, RequestSender.get_data_from_post("all",connection).split(" ")[0]);
        Assert.assertEquals(title, RequestSender.get_data_from_post("title",connection));
        Assert.assertEquals(body, RequestSender.get_data_from_post("body",connection));
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
    public void response_or_the_comment_returns_correct_poctid(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String postID = dataMap.get("postID");
        Assert.assertEquals(postID, RequestSender.get_data_from_comment("postId", connection));
    }

    @Then("^response for the comment returns correct name$")
    public void response_or_the_comment_returns_correct_name(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String name = dataMap.get("name");
        Assert.assertEquals(name, RequestSender.get_data_from_comment("name", connection));
    }

    @Then("^response for the comment returns correct email$")
    public void response_or_the_comment_returns_correct_email(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String email = dataMap.get("email");
        Assert.assertEquals(email, RequestSender.get_data_from_comment("email", connection));
    }

    @Then("^response for the comment returns correct body$")
    public void response_for_the_comment_returns_correct_body(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String body = dataMap.get("body");
        Assert.assertEquals(body, RequestSender.get_data_from_comment("body", connection));
    }

    // Todos
    @Then("^response returns correct number of todos$")
    public void response_returns_correct_number_of_todos(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        int number = Integer.parseInt(dataMap.get("number"));
        Assert.assertEquals(number, RequestSender.get_data_from_todos_group("all_todos_count", connection));
    }

    @Then("^response returns correct number of completed todos$")
    public void responseReturnsCorrectNumberOfCompletedTodos(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        int number = Integer.parseInt(dataMap.get("number"));
        Assert.assertEquals(number, RequestSender.get_data_from_todos_group("all_completed_todos_count", connection));
    }

    @Then("^response returns correct status$")
    public void responseReturnsCorrectStatus(DataTable dataTable) throws IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String status = dataMap.get("status");
        Assert.assertEquals(status, RequestSender.get_data_from_todos("status", connection));
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
