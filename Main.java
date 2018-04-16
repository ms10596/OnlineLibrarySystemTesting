import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        ValidLoginTesting.start();
        InvalidLoginTesting.start();

        ValidMemberRegister.start();
        InvalidMemberRegister.start();

        ValidSearchTesting.start();


        ValidAdvancedSearchTesting.start();

        ValidTeacherRegister.start();
        InvalidTeacherRegister.start();

        TransactionTesting.start();

        new ChromeDriver().get("file:///home/ms10596/IdeaProjects/OnlineLibrarySystemTesting/output.html");
    }
}
