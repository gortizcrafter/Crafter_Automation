package pages;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CrafterTools.UIElementsPropertiesManager;
import CrafterTools.WebDriverManager;
 
public class PreviewPage {
 
	private WebDriverManager driverManager;
    private UIElementsPropertiesManager uIElementsManager;
    private WebDriver driver;
    private String adminConsole;
    /**
     * 
     */
    public PreviewPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
        this.driverManager = driverManager;
        this.uIElementsManager = UIElementsPropertiesManager;
        this.driver = this.driverManager.getDriver();
        adminConsole = uIElementsManager.getSharedUIElementsLocators().getProperty("preview.admin_console_link");
       
    }
    //Click on admin console link
    
    public PreviewPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	public void ClickAdminConsoleOption(){
 
    	 WebElement adminConsoleOption = driver.findElement(By.xpath(adminConsole));
    	 adminConsoleOption.click();
 
    }
 
     
 
 
	public void GoToAdminConsolePage(){
 
      
        //Click on admin console link
 
        this.ClickAdminConsoleOption();        
 
         
 
    }
 
}