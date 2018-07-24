package skeleton;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        Belly belly = new Belly();
        belly.eat(cukes);
    }
    
    @When("^I wait 1 hour")
	public void I_wait_hour() {
    	
	}
    
    @Then("^my belly should growl")
    public void my_belly_should_growl() {
        Assert.assertTrue(true);
    }
}
