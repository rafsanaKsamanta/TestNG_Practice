import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class TestRunner extends Setup {
    String baseURL= "https://erp.madina.co/";
    //Test Case
    //Priority Set , Test Description = Test Case Title , Test Name = Feature Name/ID ,
    @Test(priority = 1 , description = "User Can Login Successfully",testName = "TC001")

    //Test Steps
    public void doLogin(){
        driver.get(baseURL);
        Login_Page loginPage=new Login_Page(driver);
    //Test Data
        loginPage.doLogin("parvej@madina.co","madina@123");

    // matching Expected Result = Actual Result
        List<WebElement> txtLabel= driver.findElements(By.tagName("b"));
        String welcomeMessage_Actual=txtLabel.get(0).getText();
        String welcomeMessage_Expected="Welcome to Madina ERP";
    //status
        Assert.assertEquals(welcomeMessage_Actual,welcomeMessage_Expected);
    }
//    @Test(priority = 2 , description = "User Can Logout Successfully",testName = "TC002")
//    public void doLogout (){
//        driver.get(baseURL);
//        LogOut_Page logOutPage=new LogOut_Page(driver);
//        logOutPage.doLogOut();
//    }

    @Test (priority = 2 , description = "User Can Logout Successfully",testName = "TC002")

    public void clickOnProcurementMenu() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='procurementmanagement']")).click();
        driver.findElement(By.xpath("//span[@id='purchaserequest']")).click();
        driver.findElement(By.xpath("//a[@id='standardpr']")).click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//a[@id='standardpr']")).getText(),"Standard Purchase Request");

    }
    @Test (priority = 3 , description = "User Can Logout Successfully",testName = "TC003")

    public void selectWarehosue(){
        List <WebElement> dropdowns= driver.findElements(By.className("ant-select-selection-item"));
        dropdowns.get(2).click();
        Actions Select=new Actions(driver);
        Select.sendKeys(Keys.ARROW_DOWN).perform();
//        Select.sendKeys(Keys.ARROW_DOWN).perform();
        Select.sendKeys(Keys.ENTER).perform();
        List <WebElement> buttons= driver.findElements(By.cssSelector("[type=button]"));
        buttons.get(0).click();


    }
    @Test (priority = 4 , description = "User Can Logout Successfully",testName = "TC004")
    public void standardPRcreate(){
//      List <WebElement> buttons= driver.findElements(By.cssSelector("[type=button]"));
//      buttons.get(0).click();
      driver.findElement(By.cssSelector("[placeholder= 'Required Date']")).click();
       Actions Select=new Actions(driver);
       Select.sendKeys(Keys.CONTROL+"a").perform();
       driver.findElement(By.cssSelector("[placeholder= 'Required Date']")).sendKeys(Keys.CONTROL+"a");
       driver.findElement(By.cssSelector("[placeholder= 'Required Date']")).sendKeys(Keys.BACK_SPACE);
       driver.findElement(By.cssSelector("[placeholder= 'Required Date']")).sendKeys("2023-01-16");
       driver.findElement(By.cssSelector("[placeholder= 'Required Date']")).sendKeys(Keys.ENTER);

        SelectDropDown ddl = new SelectDropDown(driver);
        ddl.Perform("ant-select-selection-search-input",1,0);
        driver.findElement(By.cssSelector("[placeholder=Remarks]")).sendKeys("Testing Purpose");


    }









//    @Test (priority = 3 , description = "User Can Logout Successfully",testName = "TC003")
//
//    public void clickOnPurchaseReq(){
//        driver.findElement(By.xpath("//span[@id='purchaserequest']")).click();
//
//    }
//
//    @Test (priority = 4 , description = "User Can Logout Successfully",testName = "TC003")
//
//    public void clickOnStandardPR(){
//        driver.findElement(By.xpath("//a[@id='standardpr']")).click();
//
//    }

}
