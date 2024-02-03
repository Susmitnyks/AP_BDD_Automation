package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class loginpage extends  basepage {
    public loginpage(WebDriver driver) {
        super(driver);  //calls constructor of super class.

    }
    String MI_url="https://apl-ap-uat-001-ap.azurewebsites.net";
    String email="//*[@id=\"i0116\"]";
    String password ="//*[@id=\"i0118\"]";
    String next_btn="//*[@id=\"idSIButton9\"]";
    String sign_btn="//*[@id=\"idSIButton9\"]";
    String yes_btn="//*[@id=\"idSIButton9\"]";
    String login_page="//h2[@class='text-center mb-4']";


    String lgn_btn="//*[@id=\"publishedCanvas\"]/div/div[1]/div[2]/div/div/div[7]/div/div/div/div/button/div";
    String homepage_lbl="//*[@id=\"publishedCanvas\"]/div/div[1]/div[3]/div/div/div[2]/div/div/div/div/div";



    public void launch() throws InterruptedException, IOException {
        Properties pt=new Properties();
        Properties pr=new Properties();
        FileInputStream fp=new FileInputStream("src/demo.properties");
        pr.load(fp);
        String emailid=pr.getProperty("email");
        String pass=pr.getProperty("password");
        driver.manage().window().maximize();
        driver.get(MI_url);
        Thread.sleep(6000);
        driver.findElement(By.xpath(email)).sendKeys(emailid);
        driver.findElement(By.xpath(next_btn)).click();
        driver.findElement(By.xpath(password)).sendKeys(pass);
        Thread.sleep(2000);
        driver.findElement(By.xpath(sign_btn)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(yes_btn)).click();
        Thread.sleep(4000);
        String db=driver.findElement(By.xpath(login_page)).getText();
        Assert.assertEquals("Please select your apprentices authorised Submission Attempt ID:",db);
    }
}
