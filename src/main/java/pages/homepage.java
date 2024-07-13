package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.util.List;

public class homepage extends basepage{
    public homepage(WebDriver driver) throws InterruptedException, MalformedURLException {
        super(driver);  //calls constructor of super class.

    }
    String evidence_tab_click="//*[@id=\"criteria-content-wrapper\"]/div[3]/div/div/div[22]/h2/button";
    String evidence_no="//div[@x-data='EvidenceCard(item)']";
    String add_evidence_btn_popup="//button[text()='Add Evidence']";
    String pageno_txtbox="//input[@type='number' and contains(@class, 'form-input') and not(@disabled)]";
    String evidence_txt="AUTOMATION , The start of the process is to discuss the needs of the stakeholder, the aim of the \n" +
            "dashboard and the overall objectives/outcomes. In this case, both the Mental Health \n" +
            "Team and Area Teams want a dashboard to display their team’s data quality each \n" +
            "month and whether targets are being met.";
    String add_evidence_btn = "//*[@id=\"__nuxt\"]/div[2]/div/div[2]/div/div[1]/div[2]/div[4]/div/button";
    String evidence_textarea="//textarea[@placeholder='Evidence']";
    String select_doc_dropdown="//select[contains(@class, 'form-select') and not(@disabled)]";
    String suff_btn = "//button[normalize-space() = 'Sufficient']";
    private int countbefore;
    private int countafter;
    String DA_criteria_drp_down="//select[@id=\"criteria-label-dropdown\"]";
    String insufficient_review_btn="//*[text()='Insufficient' and @id='memory-option-0-label']";

    String submit_btn="//*[@id=\"__nuxt\"]/div[2]/div/div[2]/div/div[1]/div[2]/div[4]/button/span[2]";
    String per_bar="//*[@id=\"__nuxt\"]/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]";
    String rationale ="//*[@id=\"comment\"]";

    String ass_question="//*[@id=\"question\"]";

    public String perBefore;


    public int count_before()
    {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class=\"w-full flex flex-col\"]"));
        return elements.size();

    }
    public int count_after()
    {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class=\"w-full flex flex-col\"]"));
        return elements.size();
    }
    public void click_add_evidence() throws InterruptedException {
        countbefore=count_before();
        Thread.sleep(2000);
        click(add_evidence_btn);
    }

    public void enter_evidence() throws InterruptedException {
      Thread.sleep(2000);
      sendKeys(evidence_txt,evidence_textarea);
    }
    public void select_doc() throws InterruptedException {
        dropdown(select_doc_dropdown,"553e9f51-3a68-4285-8aa2-d825f290a4b9");
        Thread.sleep(2000);
    }

    public void enter_pageno()
    {
        sendKeys("2",pageno_txtbox);
    }
    public void add_evidence_btn_click_popup() throws InterruptedException {
        Thread.sleep(2000);
        click(add_evidence_btn_popup);
    }

    public int verify_added_evidence() throws InterruptedException {
        Thread.sleep(2000);
        countafter=count_after();
        assert countafter > countbefore;
        return countafter;
    }

    public void click_added_evidence() throws InterruptedException {
        int a=verify_added_evidence()-1;
        String added_evd = "//*[@id='__nuxt']/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div/div[" + a + "]";
        click(added_evd);
    }



    public void verify_evidence() throws InterruptedException {
        // drop down

       /* String drop_down_xpath = "//*[@id=\"criteria-content-wrapper\"]/div[3]/div/div/div["+verify_added_evidence()+"]/div/div/div[2]/div[2]/div[1]/select";
        WebElement drop_down_element = driver.findElement(By.xpath(drop_down_xpath));
        // Get the selected option from the dropdown
        String drop_down_item = new Select(drop_down_element).getFirstSelectedOption().getText();
        Assert.assertEquals("AM1 Project Presentation - Joe Allard.pdf", drop_down_item);

        // page no
        String page_no_txt="//*[@id=\"criteria-content-wrapper\"]/div[3]/div/div/div["+verify_added_evidence()+"]/div/div/div[2]/div[2]/div[2]/input";
        String page_txt=driver.findElement(By.xpath(page_no_txt)).getAttribute("value");
        Assert.assertEquals("2",page_txt);

        //comment
        // //*[@id="__nuxt"]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div/div[8]/button[1]/p[1]*/
        System.out.println("verified");
        driver.quit();

    }

    public void select_da_criteria(String criteriaText) throws InterruptedException {
        Thread.sleep(2000);
        String criteria = "//button[.//span[contains(text(), '" + criteriaText + "')]]";
        click(criteria);
    }

    public void select_da_sub_criteria(String criteriaText) throws InterruptedException {
        String criteria = "//button[.//span[contains(text(), '" + criteriaText + "')]]";
        click(criteria);
    }


    public void click_submit() throws InterruptedException {
        Thread.sleep(2000);
        perBefore = driver.findElement(By.xpath(per_bar)).getText();
        Thread.sleep(2000);
        click(submit_btn);

    }

    public void per_bar() throws InterruptedException {
        Thread.sleep(4000);
        String perAfter = driver.findElement(By.xpath(per_bar)).getText();
        Assert.assertNotEquals(perBefore,perAfter);
        driver.quit();
    }
    public void click_evidence_review_insuff()
    {
        click(insufficient_review_btn);
    }

    public void click_evd_review_suff() throws InterruptedException {

        click(suff_btn);
        driver.navigate().refresh();
        Thread.sleep(2000);

    }

    public void check_review() throws InterruptedException {
        WebElement buttonElement = driver.findElement(By.xpath(suff_btn));
        String class_name = buttonElement.getAttribute("class");
        String sel_class="focus:outline-none disabled:cursor-not-allowed disabled:opacity-75 flex-shrink-0 font-medium rounded-md text-sm gap-x-2 px-3 py-2 shadow-sm text-white dark:text-gray-900 bg-green-500 hover:bg-green-600 disabled:bg-green-500 dark:bg-green-400 dark:hover:bg-green-500 dark:disabled:bg-green-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-green-500 dark:focus-visible:outline-green-400 inline-flex items-center uppercase flex-auto justify-center";
        System.out.println(class_name);
        System.out.println(sel_class);
        Assert.assertEquals(class_name,sel_class);
        driver.quit();
    }

    public void update_rationale() throws InterruptedException {
        Thread.sleep(4000);
        String text="The evidence provided demonstrates that the student understands and applies the principles of the data analysis lifecycle in their work. They have outlined the steps involved in the data analysis lifecycle and have shown how they apply Data Understanding by identifying appropriate and relevant data sources (structured quantitative data in a CSV file) in their data analysis updated.";
        driver.findElement(By.xpath(rationale)).clear();
        sendKeys(text,rationale);
    }

    public void check_rationale(){
        WebElement rat=driver.findElement(By.xpath(rationale));
        String value=rat.getAttribute("value");
        String text="The evidence provided demonstrates that the student understands and applies the principles of the data analysis lifecycle in their work. They have outlined the steps involved in the data analysis lifecycle and have shown how they apply Data Understanding by identifying appropriate and relevant data sources (structured quantitative data in a CSV file) in their data analysis updated.";
        Assert.assertEquals(value,text);
        driver.quit();

    }

    public void update_ass_quest() throws InterruptedException {
        Thread.sleep(4000);
        String text="In your report, you mentioned that you \"intentionally did not add anything that could relate to our clients\" and that \"only a minimal amount of people are able to access our data lake\". Can you elaborate on the steps you took to ensure the privacy and security of the data while operating the data systems updated?";
        driver.findElement(By.xpath(ass_question)).clear();
        sendKeys(text,ass_question);
    }


    public void check_ass_question(){
        WebElement ass_ques=driver.findElement(By.xpath(ass_question));
        String value=ass_ques.getAttribute("value");
        String text="In your report, you mentioned that you \"intentionally did not add anything that could relate to our clients\" and that \"only a minimal amount of people are able to access our data lake\". Can you elaborate on the steps you took to ensure the privacy and security of the data while operating the data systems updated?";
        Assert.assertEquals(value,text);
        driver.quit();

    }



}

