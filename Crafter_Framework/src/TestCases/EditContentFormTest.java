package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import CrafterTools.ConstantsPropertiesManager;
import CrafterTools.FilesLocations;
import CrafterTools.UIElementsPropertiesManager;
import CrafterTools.WebDriverManager;
import pages.AdminConsolePage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyRecentActivityFramePage;
import pages.PreviewPage;

public class EditContentFormTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private PreviewPage previewPage;

	private AdminConsolePage adminConsolePage;

	private MyRecentActivityFramePage myRecentActivityFramePage1;
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

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new CrafterTools.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, this.UIElementsPropertiesManager);
		this.adminConsolePage = new AdminConsolePage(driverManager, this.UIElementsPropertiesManager);
		this.myRecentActivityFramePage1 = new MyRecentActivityFramePage(driverManager,
				this.UIElementsPropertiesManager);
	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void edit_Content_1() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

		// wait for element

		homePage.getDriverManager().driverWait();

		// go to dashboard page
		homePage.GoToDashboardPage();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Click on edit option of recent activity section
		homePage.ClickEditOptionOfRecentActivitySection();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element

		homePage.getDriverManager().driverWait();

		// Expand default section
		myRecentActivityFramePage1.ExpandDefaultSection();

		// Clealing title text field
		myRecentActivityFramePage1.CleaningTitleField();

		// Typing new text on title text field
		myRecentActivityFramePage1.TypeNewTextOnBodyField("Text for QA");

		// Save and close button.
		myRecentActivityFramePage1.ClickOnSaveAndCloseButton();

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		//reload page
		driverManager.getDriver().navigate().refresh();
		
		// wait for element

		homePage.getDriverManager().driverWait();

		// Click on edit option of recent activity section
		homePage.ClickEditOptionOfRecentActivitySection();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element

		homePage.getDriverManager().driverWait();

		// Expand default section
		myRecentActivityFramePage1.ExpandDefaultSection();

		// Assert validation
		String textTitle = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div/div[2]/div/input")).getAttribute("value");
		Assert.assertEquals(textTitle, "Text for QA");
		


	}
}
