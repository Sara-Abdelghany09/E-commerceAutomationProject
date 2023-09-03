package org.example.StepDef;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.RegisterPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class F01_Register
{
   static Faker faker=new Faker();
    public static String Email=faker.internet().emailAddress();
    public static  String password=faker.internet().password();
  @Given("The user clicks on Register")
    public void NavigateToRegister()
  {
      HomePage.RegisterNowBtn().click();
  }

    @When("User selects gender")
    public void userSelectsGender()
    {
      RegisterPage.Female_Gender().click();
    }

    @And("user enter firstname and last name  and selects select date of birth")
    public void userEnterFirstnameAndLastNameAndSelectsSelectDateOfBirth()
    {
      RegisterPage.First_Name_Field().sendKeys(faker.name().firstName());
      RegisterPage.Last_Name_Field().sendKeys(faker.name().lastName());
        int min=1;
        int maxDay=31;
        int maxMonth=12;
        int minYear=1913;
        int maxYear=2023;
        //Random value

        Select selectDay=new Select(RegisterPage.Day_Select());
        Select selectMonth=new Select(RegisterPage.Month_Select());
        Select selectYear=new Select(RegisterPage.Year_Select());

        int RandomDay=(int)Math.floor(Math.random()*(maxDay-min+1)+min);
        int RandomMonth=(int)Math.floor(Math.random()*(maxMonth-min+1)+min);
        int RandomYear=(int)Math.floor(Math.random()*(maxYear-minYear+1)+minYear);
        selectDay.selectByValue(RandomDay+"");
        selectMonth.selectByIndex(RandomMonth);
        selectYear.selectByValue(RandomYear+"");
}

    @And("User enter a valid email as {string}")
    public void userEnterAValidEmail(String srg0)
    {

        RegisterPage.Email_Field().sendKeys(Email);
    }

    @And("User enters company name")
    public void userEntersCompanyName()

    {
        RegisterPage.Company_Field().sendKeys(faker.company().name());
    }

    @And("newsletter is Unselected")
    public void newsletterIsUnselected()

    {
        RegisterPage.Newsletter_Field().click();
    }

    @And("User enters password and confirms it")
    public void userEntersPasswordAndConfirmsIt( )
    {
        RegisterPage.Password_Field().sendKeys(password);

//        String tempPassword=faker.internet().password();
//       RegisterPage.Password_Field().sendKeys(tempPassword);
        RegisterPage.Confirm_Password_Field().sendKeys(password);
//       RegisterPage.Password_Field().sendKeys(password);
//        RegisterPage.Confirm_Password_Field().sendKeys(confirm_password);
        System.out.println(Email +"=="+password);
    }

    @And("user clicks the register button")
    public void userClicksTheRegisterButton()
    {
        RegisterPage.Registeration_Btn().click();

    }
    @Then("New account is created")
    public void newAccountIsCreated()

    {
        Assert.assertEquals(RegisterPage.ConfirmRegisteration().size(),1);
    }
}
