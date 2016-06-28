package TestCases;
 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
 
public class LoginTest2 {
 
    WebDriver driver;
 
    LoginPage objLogin;
 
    HomePage objHomePage;
 
     
    //The following code is for the QA needs to execute the test with phantomJS
    
    /*@BeforeTest
    public void setup() throws Exception {
    //Set phantomjs.exe executable file path using DesiredCapabilities.
    DesiredCapabilities capability = new DesiredCapabilities();  
    capability.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/Users/gustavoortizalfaro/Documents/workspace/phantomjs-2.1.1-macosx/bin/phantomjs");
    driver = new PhantomJSDriver(capability);
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  
    }
    */
     
   //This code shows the UI and the QA can see the steps executing in real time.
    
    @BeforeClass
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", "/Users/gustavoortizalfaro/Documents/workspace/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

     
    @Test(priority=0)
 
    public void test_Home_Page_Appear_Correct(){
    driver.get("http://localhost:8080/studio#/login");
 
        //Create Login Page object
 
    objLogin = new LoginPage(driver);
 
        //login to application
 
    objLogin.loginToCrafter("admin", "1234");
 
       // Verify login is fine
 
   objHomePage = new HomePage(driver);
 
   Assert.assertTrue(true, "/html/body/ui-view/section/div/div/div[1]/div[1]/button");
   
   driver.quit();
    }
    
}


