package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class homepage extends basepage{
    public homepage(WebDriver driver) {
        super(driver);  //calls constructor of super class.

    }
    String evidence_no="//div[@x-data='EvidenceCard(item)']";
    String add_evidence_btn_popup="//button[@class=\"inline-flex w-full justify-center rounded-md bg-red-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-red-500 sm:ml-3 sm:w-auto\"]";
    String pageno_txtbox="//input[@class=\"block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-violet-600 sm:text-sm sm:leading-6\"]";
    String evidence_txt="The start of the process is to discuss the needs of the stakeholder, the aim of the \n" +
            "dashboard and the overall objectives/outcomes. In this case, both the Mental Health \n" +
            "Team and Area Teams want a dashboard to display their team’s data quality each \n" +
            "month and whether targets are being met.";
    String add_evidence_btn = "//button[@class='inline-flex items-center gap-x-1.5 rounded-md bg-violet-600 px-3.5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-violet-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-violet-600 disabled:bg-violet-300']";
    String evidence_textarea="//textarea[@class='block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-violet-600 sm:text-sm sm:leading-6']";
    String select_doc_dropdown="//select[@class='mt-2 block w-full rounded-md border-0 py-1.5 pl-3 pr-10 text-gray-900 ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-violet-600 sm:text-sm sm:leading-6']";
    private int countbefore;
    public int count_before()
    {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@x-data='EvidenceCard(item)']"));
        return elements.size();
    }
    public int count_after()
    {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@x-data='EvidenceCard(item)']"));
        return elements.size();
    }
    public void click_add_evidence()
    {
        countbefore=count_before();
        click(add_evidence_btn);
    }

    public void enter_evidence()
    {
      sendKeys(evidence_txt,evidence_textarea);
    }
    public void select_doc() throws InterruptedException {
        drop_down(select_doc_dropdown,"AM1 Project Presentation - Joe Allard.pdf");
    }

    public void enter_pageno()
    {
        sendKeys("2",pageno_txtbox);
    }
    public void add_evidence_btn_click_popup()
    {
        click(add_evidence_btn_popup);
    }

    public void verify_added_evidence() throws InterruptedException {
        Thread.sleep(4000);
        int countafter=count_after();
        assert countafter > countbefore;
    }

}

