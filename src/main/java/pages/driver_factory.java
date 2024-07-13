package pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class driver_factory {
    public static String getcell_value(int row_no, int cell_no) throws IOException {
        FileInputStream fs = new FileInputStream("C:\\Susmit\\Blenheim Chalcot\\Accelerate People Ltd\\QA automation\\test.xlsx");
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String value = String.valueOf(sheet.getRow(row_no).getCell(cell_no));
        return value;
    }

    public WebDriver getdriver() throws IOException {
        String browser = this.getcell_value(1, 0);
        WebDriver driver = null;

        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
                options.addArguments("user-data-dir=C:\\Users\\SusmitSurwade\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
}
