import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Teacher {
    static ChromeDriver driver = new ChromeDriver();
    public static String register(String firstName, String lastName, String username, String gender, String address,String contact, String password) {
        System.setProperty("webdriver.chrome.driver","/home/ms10596/IdeaProjects/OnlineLibrarySystemTesting/chromedriver");
        driver.get("http://localhost/library-master/teacher_form.php");
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("username")).sendKeys(username);

        Select select = new Select(driver.findElement(By.name("gender")));
        select.selectByIndex(0);

        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("contact")).sendKeys(contact);

        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("submit")).click();
        String currentURL = new String(driver.getCurrentUrl());
        return currentURL;
    }
}
