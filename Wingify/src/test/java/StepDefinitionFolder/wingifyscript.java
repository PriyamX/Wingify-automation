package StepDefinitionFolder;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class wingifyscript {
	WebDriver driver = null;


	@Given("user launches browser")
	public void user_launches_browser() {
		//launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\priya\\git\\Wingify-automation\\Wingify\\src\\main\\resources\\chromedriver103\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@When("user navigates to vwo heatmap page")
	public void user_navigates_to_vwo_heatmap_page() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().to(
				"https://app.vwo.com/#/analyze/heatmap/129/reports?token=eyJhY2NvdW50X2lkIjo2LCJleHBlc%20mltZW50X2lkIjoxMjksImNyZWF0ZWRfb24iOjE1MDc3ODk0ODcsInR5cGUiOiJjYW1wYWlnbiIsI%20nZlcnNpb24iOjEsImhhc2giOiJiMzlmMTQ4MWE0ZDMyN2Q4MDllNTM1YzVlNWFjOGVlMCJ9");

		Thread.sleep(4000); // Adding a hard wait for page to load

	}

	@And("user clicks on view heatmap button ##validate new window is opened")
	public void user_clicks_on_view_heatmap_button_validate_new_window_is_opened() throws InterruptedException {
		//using mouse actions to locate heatmap button
		WebElement heatmap = driver.findElement(By.xpath("//img[@class=\"screenshot-thumb__img\"]"));
		Actions action= new Actions(driver);
		action.moveToElement(heatmap);
		WebElement button = driver.findElement(By.xpath("//div[@class=\"screenshot-thumb__click-msg show-on-hover\"]"));
		action.moveToElement(button).click();
		action.build().perform();
		//switch window from parent to child frame
		Set<String> windowhandle = driver.getWindowHandles();
		System.out.println(windowhandle); //get all windows handles in current instance
		Iterator<String> iterator = windowhandle.iterator(); //iterator on a set of tabs
		String parentwindow = iterator.next();
		String childwindow = iterator.next();
		driver.switchTo().window(childwindow);
		System.out.println(childwindow); 
	}

	@And("user clicks on element list tab ##verify element list panel is opened and displayed")
	public void user_clicks_on_element_list_tab_verify_element_list_panel_is_opened_and_displayed() throws InterruptedException {
		Thread.sleep(4000);
		//handling iframe
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class=\"_vwo_player-control-item _vwo_browse-mode Tt(u)\"]")).click(); //Click on navigation button
		if (driver.findElement(By.xpath("//div[@data-qa=\"zarujegatu\"]")).isDisplayed()) {
			System.out.println("Element list is displayed");
			driver.findElement(By.xpath("//div[@data-qa=\"zarujegatu\"]")).click();
			driver.findElement(By.xpath("//td[@data-qa=\"ganukuqena\"][contains(text(),'email')]")).click();

		}


	}

	@And("user clicks on email button on element list")
	public void user_clicks_on_email_button_on_element_list() {

	}

	@And("email button gets highlighted on the page")
	public void email_button_gets_highlighted_on_the_page() {

	}
}


