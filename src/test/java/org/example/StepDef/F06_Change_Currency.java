package org.example.StepDef;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;
import static org.example.StepDef.Hooks.driver;

public class F06_Change_Currency
{

    @When("Change the currency")
    public void changeTheCurrencytoeuro()
    {
        Select select_currency=new Select(HomePage.Select_Currency());
        select_currency.selectByIndex(1);

    }

    @Then("The product currency is changed")
    public void theProductCurrencyIsChanged()
    {
        int count=driver.findElements(By.id("customerCurrency")).size();
        List<WebElement> list=driver.findElements(By.id("customerCurrency"));
        System.out.println(count);
        for (int i=0;i<count;i++)
        {
            System.out.println(list.get(i));
            //Assert Change currency
            boolean currency_sign= HomePage.Show_Currency().isDisplayed();
            Assert.assertTrue(currency_sign);
        }
    }
}
