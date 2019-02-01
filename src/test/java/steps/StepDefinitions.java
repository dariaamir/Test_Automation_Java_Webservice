package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import support.RequestSender;

import java.io.IOException;


public class StepDefinitions {

    @When("^User sends a call to address$")
    public void user_sends_a_call_to_address() {

    }

    @Then("^response code is 200")
    public void responceCodeIs() throws IOException {
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        Assert.assertEquals(200, RequestSender.get_responce_code(url));
    }

    @Then("^response answer id is 1")
    public void responseAnswerIdIsOne() throws IOException {
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        Assert.assertEquals(1, RequestSender.get_responce_message(url));
    }
}
