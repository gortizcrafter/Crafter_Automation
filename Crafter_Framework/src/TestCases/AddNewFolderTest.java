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
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PreviewPage;

/**
 * Costa Rica Crafter Software team
 * @author Gustavo Andrei Ortiz Alfaro 
 *
 */

public class AddNewFolderTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private PreviewPage previewPage;

	private DashboardPage dashboardPage;

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
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Add_New_Folder_test() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to dashboard page

		homePage.GoToDashboardPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Show site content panel

		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// expand pages folder

		dashboardPage.ExpandPagesTree();

		// expand global entry content

		dashboardPage.ClickGlobalEntryTree();

		// expand home content

		dashboardPage.ClickHomeTree();

		// right click to see the the menu

		dashboardPage.RightClickNewFolder();

		// Set the name of the folder

		dashboardPage.FolderName("testing01");

		// Create folder button

		dashboardPage.ClickCreateButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// expand home content

		// dashboardPage.ClickHomeTree();

		// Assert find the new folder created

		String folderName = driverManager.getDriver()
				.findElement(By.cssSelector("span.status-icon.folder.no-preview.no-preview.over-effect-set")).getText();
		Assert.assertEquals(folderName, "testing01 *");

	}

}
