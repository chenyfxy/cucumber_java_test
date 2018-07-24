package skeleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BaiduSearchStepFs {
	private WebDriver driver;
	
	@Given("^Go to baidu home$")
	public void go_to_baidu_home() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver/geckodriver.exe");
		
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.get("http://www.baidu.com/");
	}
	
	@When("^I find baidu logo")
	public WebElement i_find_baidu_logo() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.xpath("//div[@id='lg']/img"))));
		
		return element;
	}
	
    @And("^Type the search text \"([^\"]*)\"$")
    public void type_the_search_text(String searchText) throws Throwable {
    	this.driver.findElement(By.id("kw")).clear();
    	this.driver.findElement(By.id("kw")).sendKeys(searchText);
    }
 
    @And("^Click the submit$")
    public void click_the_submit() {
    	this.driver.findElement(By.id("su")).click();
    }
 
    @Then("^Wait the query result")
    public void wait_the_query_result() throws InterruptedException {
//        Thread.sleep(30000);
//        Assert.assertEquals("selenium_百度搜索", this.driver.getTitle());
        this.driver.close();
//        this.driver.quit();
    }
}
