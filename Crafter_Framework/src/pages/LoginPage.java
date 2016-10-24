package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import CrafterTools.UIElementsPropertiesManager;
import CrafterTools.WebDriverManager;

public class LoginPage {

	private WebDriverManager driverManager;
    private UIElementsPropertiesManager uIElementsManager;
    private WebDriver driver;
    private String userNameTextBoxLocator;
    private String passwordTextBoxLocator;
    private String loginButtonLocator;
    /**
     * 
     */
    public LoginPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
        this.driverManager = driverManager;
        this.driverManager.openConnection();
        this.uIElementsManager = UIElementsPropertiesManager;
        this.driver = this.driverManager.getDriver();
        userNameTextBoxLocator = uIElementsManager.getSharedUIElementsLocators().getProperty("login.txtbox_UserName");
        passwordTextBoxLocator = uIElementsManager.getSharedUIElementsLocators().getProperty("login.txtbox_Password");
        loginButtonLocator = uIElementsManager.getSharedUIElementsLocators().getProperty("login.btn_Login");
    }
	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	// Set user name in textbox

	public void setUserName(String strUserName) {
		
    WebElement userCrafter = driver.findElement(By.id(userNameTextBoxLocator));
    userCrafter.sendKeys(strUserName);
		

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		 WebElement pwdCrafter = driver.findElement(By.id(passwordTextBoxLocator));
		 pwdCrafter.sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		 WebElement loginButton = driver.findElement(By.cssSelector(loginButtonLocator));
		 loginButton.click();

	}

	//Login to crafter
	public void loginToCrafter(String strUserName, String strPasword) {

		// Fill user name

		this.setUserName(strUserName);

		// Fill password

		this.setPassword(strPasword);

		// Click Login button

		this.clickLogin();

	}
	public WebDriverManager getDriverManager() {
		return driverManager;
	}
	public void setDriverManager(WebDriverManager driverManager) {
		this.driverManager = driverManager;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	

}