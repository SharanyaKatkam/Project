package com.sample.test.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static com.sample.test.demo.TestBase.driver;

public class OrderPage {

    @FindBy(id = "pizza1Pizza")
    WebElement pizza1;

    @FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings1']")
    WebElement toppings1;

    @FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings2']")
    WebElement toppings2;

    @FindBy(id = "pizza1Qty")
    WebElement quantity;

    @FindBy(id = "pizza1Cost")
    WebElement cost;

    @FindBy(id = "name")
    WebElement name;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "phone")
    WebElement phone;

    @FindBy(id = "ccpayment")
    WebElement creditCardRadioBtn;

    @FindBy(id = "cashpayment")
    WebElement cashOnPickupRadioBtn;

    @FindBy(id = "placeOrder")
    WebElement placeOrderBtn;

    @FindBy(id = "reset")
    WebElement resetBtn;

    @FindBy(xpath = "//div[@id='dialog']/p")
     WebElement popup;

    @FindBy(xpath = "//button[@class = 'ui-button ui-corner-all ui-widget ui-button-icon-only ui-dialog-titlebar-close']")
    WebElement closeBtn;

    //Intializing the elements
    public OrderPage()
    {
        PageFactory.initElements(driver,this);
    }


    public void enterOrderDetails(String pizza,String topp1,String topp2,int q)
    {
        pizza1.sendKeys(pizza);
        toppings1.sendKeys(topp1);
        toppings2.sendKeys(topp2);
        quantity.sendKeys(String.valueOf(q));

    }

    public void enterPickUpInfo(String customerName,String customerEmail,String phone_number)
    {
        name.sendKeys(customerName);
        email.sendKeys(customerEmail);
        phone.sendKeys(phone_number);
    }

    public void selectPaymentInfoRadioBtn(String valueToSelect)
    {
        switch(valueToSelect) {
            case "Credit Card":
                creditCardRadioBtn.click();
                break;
            case "Cash On PickUp":
                cashOnPickupRadioBtn.click();
                break;

        }
    }

    public void clickCloseButton()
    {
        closeBtn.click();
    }

    public void clickResetButton()
    {

         resetBtn.click();
    }

    public void clickOrderButton()
    {
       placeOrderBtn.click();
    }

    public void VerifyPopUpMsg()
    {
        String msg = "Thank you for your order!"  ;
        Assert.assertTrue(popup.getText().contains(msg));
    }

    public void  VerifyPopUp()
    {
        String msg1 = "Missing name";
        String text = "phone number";
        Assert.assertTrue(popup.getText().contains(msg1));
        Assert.assertTrue(popup.getText().contains(text));
    }

    //Method to verify the fields resetted on clicking Reset button
    public boolean VerifyResetBtnFunctionality()
    {
          List<WebElement> myFields = driver.findElements(By.xpath("//input"));
            for(WebElement element:myFields)
            {
                if((element.getAttribute("value type") != "" ) || (element.getAttribute("value")!="0") )
                {
                    return false;
                }
            }
            return true;
    }
}
