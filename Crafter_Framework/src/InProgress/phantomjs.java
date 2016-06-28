package InProgress;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class phantomjs {
 WebDriver driver;
 
 @BeforeTest
 public void setup() throws Exception {
  //Set phantomjs.exe executable file path using DesiredCapabilities.
  DesiredCapabilities capability = new DesiredCapabilities();  
  capability.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/Users/gustavoortizalfaro/Documents/workspace/phantomjs-2.1.1-macosx/bin/phantomjs");
  driver = new PhantomJSDriver(capability);
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  
 }
 
 @Test
 public void phantomTest() throws IOException{
  driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");
  //Get current page title using javascript executor.
    JavascriptExecutor javascript = (JavascriptExecutor) driver;
    String pagetitle=(String)javascript.executeScript("return document.title");  
    System.out.println("My Page Title Is  : "+pagetitle);    
  driver.findElement(By.xpath("//input[@id='2']")).click();
  driver.findElement(By.xpath("//input[@id='plus']")).click();
  driver.findElement(By.xpath("//input[@id='3']")).click();
  driver.findElement(By.xpath("//input[@id='equals']")).click();
  String sum = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
  System.out.println("****** Sum Is : "+sum+" ******");  
 }
}