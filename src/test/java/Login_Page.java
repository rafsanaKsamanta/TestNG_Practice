import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Login_Page {
//properties
    @FindBy(className = "login_input__2-vJx")
    List<WebElement> txtCreds;

    @FindBy(css = "[type=submit]")
    WebElement btnSubmit;
//constructor = PageFactory creation
    public Login_Page(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    public void doLogin(String username , String password){
        txtCreds.get(0).sendKeys(username);
        txtCreds.get(1).sendKeys(password);
        btnSubmit.click();
    }



}
