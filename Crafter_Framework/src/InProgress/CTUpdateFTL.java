package InProgress;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pages.AdminConsolePage;
import pages.HomePage;

import pages.LoginPage;

import pages.PreviewPage;

public class CTUpdateFTL {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	PreviewPage objPreviewPage;

	AdminConsolePage objAdminConsolePage;

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
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", "/Users/gustavoortizalfaro/Documents/workspace/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 0)

	public void test_Home_Page_Appear_Correct() {
		driver.get("http://localhost:8080/studio#/login");

		// Create Login Page object

		objLogin = new LoginPage(driver);

		// login to application

		objLogin.loginToCrafter("admin", "1234");

		// Verify login is fine

		objHomePage = new HomePage(driver);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie1) {
			ie1.printStackTrace();
		}

		// go to preview page
		objHomePage.GoToPreviewPage();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie1) {
			ie1.printStackTrace();
		}

		objPreviewPage = new PreviewPage(driver);

		// Show site content panel
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie1) {
			ie1.printStackTrace();
		}

		// go to admin console page

		objPreviewPage.GoToAdminConsolePage();

		objAdminConsolePage = new AdminConsolePage(driver);

		// select content types
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie1) {
			ie1.printStackTrace();
		}

		objAdminConsolePage.SelectContentTypeOption();

		// open content types

		objAdminConsolePage.ClickExistingTypeOption();

		// Select the generic content type

		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie1) {
			ie1.printStackTrace();
		}

		objAdminConsolePage.SelectGenericContentType();

		// Confirm the content type selected

		objAdminConsolePage.ConfirmContentTypeSelected();

		// Drag and drop Form Section

		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie1) {
			ie1.printStackTrace();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		WebElement From = driver.findElement(By.cssSelector(".control-section"));

		WebElement To = driver.findElement(By.cssSelector("#content-type-canvas .content-form-name"));

		Actions builder = new Actions(driver);

		Action dragAndDrop = builder.clickAndHold(From)

		.moveToElement(To)

		.release(To)

		.build();

		dragAndDrop.perform();

		// Save the drag and drop process

		objAdminConsolePage.SaveDragAndDropProcess();
		
		//Ok for the dialog window when appears
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		// validate the control added

		try {
			driver.findElement(By.cssSelector("#content-type-canvas .content-section-name"));

		} catch (NoSuchElementException e) {

		}

		// Do click on the generic title

		objAdminConsolePage.DoClickOnGenericTitle();

		// Do click on the display template field

		objAdminConsolePage.DoClickOnDisplayTemplateField();  
		
		// Do click on edit ftl option (pencil icon)

	    objAdminConsolePage.DoClickOnEditFTLOption();  
	    
	    //Edit the FTL
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    String innerHtml = "$('.CodeMirror-lines > div > div > pre:nth-child(32)').after('<pre></pre><pre><span class='cm-tag DUPLICATE'>&lt;div</span> <span class='cm-attribute'>&lt;@studio.iceAttr</span> <span class='cm-word'>iceGroup</span><span class='cm-error'>='body'</span><span class='cm-tag'>/&gt;</span> class='about-text'&gt;</pre><pre>${model.body_html}</pre><pre><span class='cm-tag'>&lt;/div&gt;</span></pre>')";
	    executor.executeScript(innerHtml);
	    
		//driver.quit();
	}

}
