package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import support.RequestSender;

import java.io.IOException;
import java.net.HttpURLConnection;


public class StepDefinitions {

    private String BaseURL = "https://jsonplaceholder.typicode.com/";
    HttpURLConnection connection;

    //Requests

    @When("^user requests for the post by it's (.*) as id$")
    public void user_requests_for_the_post_by_its_id(int id) throws IOException {
        connection = RequestSender.establishCall(BaseURL + "posts/" + id);
    }

    @When("^user requests for the comment by it's (.*) as id$")
    public void user_requests_for_the_comment_by_its_id(int id) throws IOException {
        connection = RequestSender.establishCall(BaseURL + "comments/" + id);
    }

    @When("^user requests for all todos by user id (.*)$")
    public void user_requests_for_all_todos_by_user_id(int id) throws IOException {
        connection = RequestSender.establishCall(BaseURL + "todos?userId=" + id);
    }

    @When("^user requests for todo by id (.*)$")
    public void user_requests_for_todo_by_id(int id) throws IOException {
        connection = RequestSender.establishCall(BaseURL + "todos/" + id);
    }

    //Responces

    @Then("^response code is 200")
    public void responce_code_is_200() throws IOException {
        Assert.assertEquals(200, RequestSender.get_responce_code(connection));
    }

    //Post
    @Then("^response for the post returns correct user ID (.*)")
    public void response_for_the_post_returns_correct_user_id(String ids) throws IOException {
        Assert.assertEquals(ids, RequestSender.get_data_from_post("author", connection));
    }

    @Then("^response for the post returns correct title (.*)")
    public void response_for_the_post_returns_correct_title(String title) throws IOException {
        Assert.assertEquals(title, RequestSender.get_data_from_post("title", connection));
    }

    @Then("^response for the post returns correct body (.+)")
    public void response_for_the_post_returns_correct_body(String body) throws IOException {
        Assert.assertEquals(body, RequestSender.get_data_from_post("body", connection));
    }

    // Comment

    @Then("^response for the comment returns correct post id (.*)")
    public void response_or_the_comment_returns_correct_poctid(String postID) throws IOException {
        Assert.assertEquals(postID, RequestSender.get_data_from_comment("postId", connection));
    }

    @Then("^response for the comment returns correct name (.*)")
    public void response_or_the_comment_returns_correct_name(String name) throws IOException {
        Assert.assertEquals(name, RequestSender.get_data_from_comment("name", connection));
    }

    @Then("^response for the comment returns correct email (.*)")
    public void response_or_the_comment_returns_correct_email(String email) throws IOException {
        Assert.assertEquals(email, RequestSender.get_data_from_comment("email", connection));
    }

    @Then("^response for the comment returns correct body (.*)")
    public void response_for_the_comment_returns_correct_body(String body) throws IOException {
        Assert.assertEquals(body, RequestSender.get_data_from_comment("body", connection));
    }

    // Todos
    @Then("^response returns correct number of todos (.*)")
    public void response_returns_correct_number_of_todos(int number) throws IOException {
        Assert.assertEquals(number, RequestSender.get_data_from_todos_group("all_todos_count", connection));
    }

    @Then("^response returns correct number of completed todos (.*)")
    public void responseReturnsCorrectNumberOfCompletedTodos(int number) throws IOException {
        Assert.assertEquals(number, RequestSender.get_data_from_todos_group("all_completed_todos_count", connection));
    }

    @Then("^response returns correct status (.*)")
    public void responseReturnsCorrectStatus(String status) throws IOException {
        Assert.assertEquals(status, RequestSender.get_data_from_todos("status", connection));
    }
}
