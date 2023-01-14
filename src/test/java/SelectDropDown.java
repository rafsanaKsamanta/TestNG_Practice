import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SelectDropDown {
    private WebDriver _driver;
    public SelectDropDown(WebDriver driver){
        _driver=driver;
    }
    public void Perform(String className, int index, int nested){
        List<WebElement> ddl = _driver.findElements(By.className(className));
        ddl.get(index).click();

        Actions select = new Actions(_driver);

        for (int i = 0;i<nested;i++){
            select.sendKeys(Keys.ARROW_DOWN).perform();
        }

        select.sendKeys(Keys.ENTER).perform();
    }
}
