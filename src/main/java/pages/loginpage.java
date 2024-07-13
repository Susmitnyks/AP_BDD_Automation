package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

public class loginpage extends basepage {
    public loginpage(WebDriver driver) throws MalformedURLException {
        super(driver);  //calls constructor of super class.

    }
    String AP_url="https://app-uat.accelerate-people.co.uk/";
    String Microsoft_url="https://login.microsoftonline.com/";
    String AP_login_btn="//*[@id=\"__nuxt\"]/div[2]/div/div/div[3]/div[2]/button/span";
    String email="//*[@id=\"i0116\"]";
    String password ="//*[@id=\"i0118\"]";
    String next_btn="//*[@id=\"idSIButton9\"]";
    String sign_btn="//*[@id=\"idSIButton9\"]";
    String yes_btn="//*[@id=\"idSIButton9\"]";
    String login_page="//*[@id=\"__nuxt\"]/div[2]/div/div/div[3]/div[1]/h1/span[2]";
    String tip="//*[@id=\"__nuxt\"]/div[2]/div/div/div[4]/div/div/div/div/div";
    String learner_drop_down="//*[@id=\"learner\"]";
    String ass_method="//*[@id=\"nK7dDJpdOWE_3\"]";

    String lgn_btn="//*[@id=\"publishedCanvas\"]/div/div[1]/div[2]/div/div/div[7]/div/div/div/div/button/div";
    String homepage_lbl="//*[@id=\"publishedCanvas\"]/div/div[1]/div[3]/div/div/div[2]/div/div/div/div/div";
    String submit_btn="//*[@id=\"__nuxt\"]/div[2]/div/div/div[4]/div/form/div[3]/button";
    String home_page_username="//*[@id=\"__nuxt\"]/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/span";
    String name="//*[@id=\"headlessui-combobox-input-nYMH7mn4R4k_6\"]";
    String name1="//*[@id=\"headlessui-combobox-input-nYMH7mn4R4k_85\"]";


    public void launch() throws InterruptedException, IOException, AWTException {
//        Properties pt=new Properties();
//        Properties pr=new Properties();
//        FileInputStream fp=new FileInputStream("src/demo.properties");
//        pr.load(fp);
//        String emailid=pr.getProperty("email");
//        String pass=pr.getProperty("password");
//        driver.manage().window().maximize();
//        driver.get(Microsoft_url);
//        Thread.sleep(4000);
//        driver.findElement(By.xpath(email)).sendKeys(emailid);
//        driver.findElement(By.xpath(next_btn)).click();
//        driver.findElement(By.xpath(password)).sendKeys(pass);
//        Thread.sleep(2000);
//        driver.findElement(By.xpath(sign_btn)).click();
//        Thread.sleep(20000);
//        driver.findElement(By.xpath(yes_btn)).click();
        driver.get(AP_url);
        /*Thread.sleep(8000);
        String db=driver.findElement(By.xpath(login_page)).getText();
        Assert.assertEquals("Accelerate People",db);
        Thread.sleep(4000);*/

    }

    public void Microsoft_login() throws InterruptedException, AWTException {
        /*driver.findElement(By.xpath(AP_login_btn)).click();
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
        */
        Thread.sleep(4000);
        String tp=driver.findElement(By.xpath(tip)).getText();
        Assert.assertEquals("You will have access to the allocated learners only.",tp);
    }

    public void learner_dropdown() throws InterruptedException {
        drop_down(learner_drop_down,"Craig Appleby",name);
    }
    public void assessment_dropdown() throws InterruptedException {
        drop_down(ass_method,"B5E940F8C625EDFC7C4FBDB77025D565 (AM1)",name1);
    }
    public void click_submit_btn() throws InterruptedException {
        Thread.sleep(4000);
        click(submit_btn);
    }

    public void verify_homepage()
    {
     explicitWait(driver,home_page_username, Duration.ofSeconds(30));
     String user_name=driver.findElement(By.xpath(home_page_username)).getText();
     Assert.assertEquals("Craig Appleby",user_name);
    }

}
