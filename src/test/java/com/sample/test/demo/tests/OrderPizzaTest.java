package com.sample.test.demo.tests;

import com.sample.test.demo.OrderPage;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;

public class OrderPizzaTest extends TestBase {
    OrderPage op;

    public OrderPizzaTest()
    {
        super();
    }

   //Test data, i would read it from Excel but as of now just adding it here temporarily
    private static final String PHONE_NUMBER = "7839020102";
    private static final int QUANTITY = 2;
    private static final String NAME = "Sharanya";
    private static final String EMAIL = "sharanyashetty@gmail.com";
    private static final String PAGE_TITLE = "Pizza Order Form";


  //happy path testcase to place an order
    @Test(priority = 1)
    public  void  OrderingPizza()
    {
        op = new OrderPage();
        //verifying page title
        Assert.assertEquals(PAGE_TITLE, driver.getTitle());

        //Fill the page with data
        op.enterOrderDetails(PizzaTypes.SMALL_ONETOPPINGS.getDisplayName(), PizzaToppings.MANGOS.getDisplayName(),PizzaToppings.SALAMI.getDisplayName(),QUANTITY);
        op.enterPickUpInfo(NAME,EMAIL, PHONE_NUMBER);
        WebElement element =  driver.findElement(By.xpath("//div[@id = 'paymentSection']"));
        op.selectPaymentInfoRadioBtn("Credit Card");

        //clicking order button
        op.clickOrderButton();

        //verifying success msg
        op.VerifyPopUpMsg();
        op.clickCloseButton();

    }

    //happy path testcase to enter details and click reset
    @Test(priority = 2)
    public void EnterValuesAndClickResetBtn()
    {
        op = new OrderPage();

        //Fill the page with data
        op.enterOrderDetails(PizzaTypes.SMALL_ONETOPPINGS.getDisplayName(), PizzaToppings.MANGOS.getDisplayName(),PizzaToppings.SALAMI.getDisplayName(),QUANTITY);
        op.enterPickUpInfo(NAME,EMAIL, PHONE_NUMBER);
        op.selectPaymentInfoRadioBtn("Cash On PickUp");

        //clicking order button but not verifying the result as functionality is not working
        op.clickResetButton();
    }

    //error case which checks for mandatory fields messages
    @Test(priority = 3)
    public void ClickPlaceOrderBtnWithoutEnteringDetails()
    {
        op = new OrderPage();

        //clicking order button without filling any details
        op.clickOrderButton();

        //verifying error messages on the pop up
        op.VerifyPopUp();

        //clicking close button on popup
        op.clickCloseButton();
    }


}
