package TestCases;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import CrafterTools.ConstantsPropertiesManager;
import CrafterTools.FilesLocations;
import CrafterTools.UIElementsPropertiesManager;
import CrafterTools.WebDriverManager;
import pages.CreatePage;
import pages.HomePage;
import pages.LoginPage;
import pages.PreviewPage;

public class DeleteSiteTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private CreatePage createPage;

	private PreviewPage previewPage;

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
		this.createPage = new CreatePage(driverManager, this.UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, this.UIElementsPropertiesManager);

	}

	// @AfterTest
	// public void afterTest() {
	// .closeConnection();
	// }

	@Test(priority = 0)

	public void delete_site() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on Delete icon

		homePage.ClickOnDeleteSiteIcon();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on YES to confirm the delete.

		homePage.ClickOnYesToDeleteSite();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Assert

		for (int i=1; i<6; i++)
		  {

		   //To verify element is present on page or not.
		   String XPath = "/html/body/ui-view/section/div/div/div[2]/table/tbody/tr/td[5]/a/i";
		   Boolean iselementpresent = driver.findElements(By.xpath(XPath)).size()!= 0;
		   if (iselementpresent == true)
		   {
		    System.out.print("\nTargeted TextBox"+i+" Is Present On The Page");
		   }
		   else
		   {
		    System.out.print("\nTargeted Text Box"+i+" Is Not Present On The Page PUTO");
		   }
		  }

	}
}
