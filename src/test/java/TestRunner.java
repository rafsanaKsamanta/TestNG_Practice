import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestRunner extends Setup {
    //Test Case
    //Priority Set , Test Description = Test Case Title , Test Name = Feature Name/ID ,
    @Test(priority = 1 , description = "User Can Login Successfully",testName = "TC001")

    //Test Steps
    public void doLogin(){
        driver.get("https://erp.madina.co/");
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
}
