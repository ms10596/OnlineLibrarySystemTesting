import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ValidAdvancedSearchTesting {
    static String steps = new String("1.Go to site http://localhost/library-master/member/<br>2.Login as member<br>3.Click on advance search<br>4.Enter book title<br>5.Enter book author name<br>6.Click search");
    static String scenario = new String("Check advanced search function with valid data");
    static String expectedResult;
    static File tests = new File("advancedSearchTests/validTests.txt");
    static File output = new File("output.html");
    static PrintWriter cout ;
    static Scanner cin;
    public static void start() {
        try {
            cout = new PrintWriter(new FileWriter(output,true));
            cin = new Scanner(tests);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int cnt = 0;
        while(cin.hasNext()) {
            String title = cin.nextLine();
            String author = cin.nextLine();
            Summary summary = new Summary();
            summary.setId("VldAdvncdSrch"+cnt++);
            summary.setScenario(scenario);
            summary.setSteps(steps);
            summary.setData("Book name: "+title+"<br>AuthorName: "+author);
            expectedResult = cin.nextLine();
            summary.setExpectedResults(expectedResult);
            String actualResult = Member.advancedSearch(title, author);
            summary.setActualResults(actualResult);
            if(actualResult.equals(expectedResult)){
                summary.setStatus("pass");
            }
            else summary.setStatus("fail");
            cout.append(summary.toString());
        }
        cout.close();
    }
}
