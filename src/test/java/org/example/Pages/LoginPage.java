package org.example.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.example.StepDef.Hooks.driver;
public class LoginPage
{
    public static WebElement Email_Field()
    {
        return driver.findElement(By.id("Email"));
    }
    public static WebElement Password_Field()
    {
        return driver.findElement(By.id("Password"));
    }
    public static WebElement Login_Btn()
    {
        return driver.findElement(By.cssSelector("[class=\"button-1 login-button\"]"));
    }
    public static WebElement ViewMyAccountText()
    {
        return driver.findElement(By.xpath("//*[contains(text(),'My account')]"));
    }
    public static WebElement clickonlogout()
    {
        return driver.findElement(By.linkText("Log out"));
    }
    //errorMessage
    public static WebElement Login_invalid_errorMessage()
    {
        return driver.findElement(By.cssSelector("[class=\"message-error validation-summary-errors\"]"));
    }

}
