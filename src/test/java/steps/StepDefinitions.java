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

    //Responces

    @Then("^response code is 200")
    public void responce_code_is_200() throws IOException {
        Assert.assertEquals(200, RequestSender.get_responce_code(connection));
    }

    //Post
    @Then("^response for the post returns correct (.*) as user ID")
    public void response_for_the_post_returns_correct_user_id(String ids) throws IOException {
        Assert.assertEquals(ids, RequestSender.get_data_from_post("author", connection));
    }

    @Then("^response for the post returns correct (.*) as title")
    public void response_for_the_post_returns_correct_title(String title) throws IOException {
        Assert.assertEquals(title, RequestSender.get_data_from_post("title", connection));
    }

    @Then("^response for the post returns correct (.*) as body")
    public void response_for_the_post_returns_correct_body(String body) throws IOException {
        Assert.assertEquals(body, RequestSender.get_data_from_post("body", connection));
    }

    // Comment

    @Then("^response for the comment returns correct (.*) as post id")
    public void response_or_the_comment_returns_correct_poctid(String postID) throws IOException {
        Assert.assertEquals(postID, RequestSender.get_data_from_comment("postId", connection));
    }

    @Then("^response for the comment returns correct (.*) as name")
    public void response_or_the_comment_returns_correct_name(String name) throws IOException {
        Assert.assertEquals(name, RequestSender.get_data_from_comment("name", connection));
    }

    @Then("^response for the comment returns correct (.*) as email")
    public void response_or_the_comment_returns_correct_email(String email) throws IOException {
        Assert.assertEquals(email, RequestSender.get_data_from_comment("email", connection));
    }

    @Then("^response for the comment returns correct (.*) as body")
    public void response_or_the_comment_returns_correct_body(String body) throws IOException {
        Assert.assertEquals(body, RequestSender.get_data_from_comment("body", connection));
    }

}
