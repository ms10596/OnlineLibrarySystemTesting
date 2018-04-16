import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;


public class Member {
    static ChromeDriver driver = new ChromeDriver();
    public static String login(String username, String password) {
        System.setProperty("webdriver.chrome.driver","/home/ms10596/IdeaProjects/OnlineLibrarySystemTesting/chromedriver");
        driver.get("http://localhost/library-master/member");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("submit")).click();
        String currentURL = new String(driver.getCurrentUrl());
        return currentURL;
    }
    public static String register(String firstName, String lastName, String username, String gender, String address,String rollNo, String contact,String yearLevel, String password) {
        System.setProperty("webdriver.chrome.driver","/home/ms10596/IdeaProjects/OnlineLibrarySystemTesting/chromedriver");
        driver.get("http://localhost/library-master/student_form.php");
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("username")).sendKeys(username);

        Select select = new Select(driver.findElement(By.name("gender")));
        select.selectByIndex((gender.equals("Male")?0:1));

        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("roll")).sendKeys(rollNo);
        driver.findElement(By.name("contact")).sendKeys(contact);

        select = new Select(driver.findElement(By.name("year_level")));
        select.selectByIndex(0);

        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("submit")).click();
        String currentURL = new String(driver.getCurrentUrl());
        return currentURL;
    }
    static String searchForBook(String bookName) {
        login("keya07", "123456");
        driver.get("http://localhost/library-master/member/books.php");
        driver.findElement(By.xpath("//*[@id=\"example_filter\"]/label/input")).sendKeys(bookName);
        return driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]")).getText();
    }
    static String advancedSearch(String title, String author) {
        login("keya07", "123456");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/ul/li[5]/a")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys(title);
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys(author);
        driver.findElement(By.xpath("//*[@id=\"myModal\"]/div[2]/form/div[3]/div/button")).click();
        return driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr")).getText();
    }
    static String transaction() {
        login("keya07", "123456");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/ul/li[3]/a")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/ul/li[3]/ul/li[1]/a")).click();
        return driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]")).getText();
    }
}
