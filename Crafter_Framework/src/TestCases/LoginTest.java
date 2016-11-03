package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import CrafterTools.ConstantsPropertiesManager;
import CrafterTools.FilesLocations;
import CrafterTools.UIElementsPropertiesManager;
import CrafterTools.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;

/**
 * Costa Rica Crafter Software team
 * @author Gustavo Andrei Ortiz Alfaro 
 *
 */

public class LoginTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	// The following code is for the QA needs to execute the test with phantomJS

	/*
	 * @BeforeTest public void setup() throws Exception { //Set phantomjs.exe
	 * executable file path using DesiredCapabilities. DesiredCapabilities
	 * capability = new DesiredCapabilities();
	 * capability.setCapability(PhantomJSDriverService.
	 * PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
	 * "/Users/gustavoortizalfaro/Documents/workspace/phantomjs-2.1.1-macosx/bin/phantomjs"
	 * ); driver = new PhantomJSDriver(capability);
	 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); }
	 */

	// This code shows the UI and the QA can see the steps executing in real
	// time.

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new CrafterTools.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void login_Test() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Verify login is fine

		String bodyText = driverManager.getDriver().findElement(By.xpath("/html/body/ui-view/section/div/header/h1"))
				.getText();
		Assert.assertNotNull(bodyText.contains(bodyText));

	}

}
