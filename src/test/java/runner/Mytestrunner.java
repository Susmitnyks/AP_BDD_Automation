package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/Pre-assessment.feature",
        glue = {"stepdefinitions"},
        tags = "",
        monochrome = true,
        dryRun = false,
        //plugin = {"pretty","html:target/cucumber-html-report","json:cucumber.json" }
        plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class Mytestrunner {
        /*@AfterClass
        public static void sendEmail() {
            try {

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                // Create an email attachment
                EmailAttachment attachment = new EmailAttachment();
                attachment.setPath("C:\\Users\\SusmitSurwade\\IdeaProjects\\AP_BDD_Automation\\test-output\\SparkReport\\Spark.html"); // Replace with the actual path
                attachment.setDisposition(EmailAttachment.ATTACHMENT);
                attachment.setDescription("Extent Report");
                attachment.setName("ExtentReport.html");

                // Create an email
                MultiPartEmail email = new MultiPartEmail();
                email.setHostName("smtp.gmail.com"); // Replace with your SMTP server
                email.setSmtpPort(465); // Replace with the SMTP port
                email.setAuthenticator(new DefaultAuthenticator("automationsreport@gmail.com", "ixwe pwrz xprs adwf"));
                email.setSSLOnConnect(true); // Use SSL if needed
                email.setFrom("susmit.surwade@blenheimchalcot.com"); // Replace with your email
                email.addTo("susmit.surwade@blenheimchalcot.com"); // Replace with recipient's email
                //email.addTo("ajinkya.gavali@blenheimchalcot.com");
                email.setSubject("AP Daily Test Automation Report " + dtf.format(now));

                // Set the message body
                email.setMsg("Please find the attached Extent Report.");

                // Add the attachment
                email.attach(attachment);
                // Send the email
                email.send();
                System.out.println("Email sent successfully.");
            } catch (EmailException e) {
                e.printStackTrace();
            }
        }*/
    }

