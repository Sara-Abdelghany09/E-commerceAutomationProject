package org.example.StepDef;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.example.Pages.RegisterPage;
import org.example.StepDef.F01_Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.StepDef.F01_Register.*;
import static org.example.StepDef.F01_Register.faker;
import static org.example.StepDef.Hooks.driver;


public class F02_Login
{
    SoftAssert soft=new SoftAssert();
    @Given("the user clicks on login")
    public void NavigateToLogin()
   {
    HomePage.LoginNowBtn().click();
   }
    @When("the user fills email as {string} and password {string} and clicks on login")
    public void theUserFillsEmailAsAndPasswordAndClicksOnLogin(String arg0, String arg1)
    {
        System.out.println(Email +"=="+password);
        RegisterPage.Email_Field().sendKeys(Email);
        RegisterPage.Password_Field().sendKeys(password);
        LoginPage.Login_Btn().click();

    }
    @Then("The user login successfully")
    public void theUserLoginSuccessfully()
    {
      //Confirm that user login to the system successfully
        String expected_login="My account";
        String actual_login=LoginPage.ViewMyAccountText().getText();
        Assert.assertEquals(actual_login,expected_login);
        // LoginPage.clickonlogout().click();

    }
    @When("the user fills invalid email as {string} and password {string} and clicks on login")
    public void theUserFillsInvalidEmailAsAndPasswordAndClicksOnLogin(String email, String password)
    {
        LoginPage.Email_Field().sendKeys(email);
        LoginPage.Password_Field().sendKeys(password);
        LoginPage.Login_Btn().click();

    }
    @Then("Error message is displayed")
    public void errorMessageIsDisplayed()
    {
        //Confirm that user could not log in to the system
        String expected_invalid_text="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        WebElement element_Text=LoginPage.Login_invalid_errorMessage();
        String actual_invalid_text=element_Text.getText();

        System.out.println("The invalid text :  "+actual_invalid_text);
        Assert.assertEquals(actual_invalid_text,expected_invalid_text);
        //check the error message color is red

        //retrieve color
        String rgbaColor =LoginPage.Login_invalid_errorMessage().getCssValue("color");
        String actualColor= Color.fromString(rgbaColor).asHex();
        System.out.println("actualColor");
        Assert.assertEquals(actualColor,"#e4434b");
        soft.assertAll();

    }

}
