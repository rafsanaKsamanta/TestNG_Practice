import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LogOut_Page {
    public LogOut_Page(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "button.button_primarybtn__1ULat.w-100.undefined")
    List<WebElement> btnLogout;

    public void doLogOut(){
    btnLogout.get(0).click();
    }
}
