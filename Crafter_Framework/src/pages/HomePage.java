package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CrafterTools.ConstantsPropertiesManager;
import CrafterTools.UIElementsPropertiesManager;
import CrafterTools.WebDriverManager;

public class HomePage {

	private WebDriverManager driverManager;
    private UIElementsPropertiesManager uIElementsManager;
    private WebDriver driver;
    private String homePageUserName;
    private String previewSite1;
    private String dashboardSite2;
    private String editRecentActivity;
    private String seeThePageEdited;
    /**
     * 
     */
    public HomePage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
        this.driverManager = driverManager;
        this.uIElementsManager = UIElementsPropertiesManager;
        this.driver = this.driverManager.getDriver();
        homePageUserName = uIElementsManager.getSharedUIElementsLocators().getProperty("home.create_site_button");
        previewSite1 = uIElementsManager.getSharedUIElementsLocators().getProperty("home.preview_link");
        dashboardSite2 = uIElementsManager.getSharedUIElementsLocators().getProperty("home.dashboard_link");
        editRecentActivity = uIElementsManager.getSharedUIElementsLocators().getProperty("home.edit_my_recent_activty");
        seeThePageEdited = uIElementsManager.getSharedUIElementsLocators().getProperty("home.see_page_recent_activity");
    }


		// Click on preview link
	

	public HomePage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}



	public void ClickPreviewOption() {

		 WebElement previewLink = driverManager.getDriver().findElement(By.xpath(previewSite1));
		 previewLink.click();

	}

	public void GoToPreviewPage() {

		// Click on preview link

		this.ClickPreviewOption();

	}

	// Click on dashboard link

	public void ClickDashboardOption() {

		 WebElement dashboardLink = driver.findElement(By.xpath(dashboardSite2));
		 dashboardLink.click();

	}

	public void GoToDashboardPage() {

		// Click on dashboard link

		this.ClickDashboardOption();

	}

	// Click on edit option of my recent activity senction

	public void ClickEditOptionOfRecentActivitySection() {

		 WebElement editOptionMyRecentActivity = driver.findElement(By.cssSelector(editRecentActivity));
		 editOptionMyRecentActivity.click();

	}

	public void ClickOnEditOptionRecentActivity() {

		// Click on edit option of my recent activity senction

		this.ClickEditOptionOfRecentActivitySection();

	}

	// See the page edited

	public void DisplayPageEdited() {

		WebElement seeThePageMyRecentActivity = driver.findElement(By.xpath(seeThePageEdited));
		seeThePageMyRecentActivity.click();

	}

	public void SeeThePageEdited() {

		// See the page edited

		this.DisplayPageEdited();

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