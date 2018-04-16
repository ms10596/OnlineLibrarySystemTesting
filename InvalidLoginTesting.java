import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class InvalidLoginTesting {
    static String steps = new String("1.Go to site http://localhost/library-master/member/<br>2.Enter Username<br>3.Enter Password<br>4.Click Submit");
    static String scenario = new String("Check student login with invalid data");
    static String expectedResult = new String("http://localhost/library-master/member/");
    static File tests = new File("loginTests/invalidTests.txt");
    static File output = new File("output.html");
    static PrintWriter cout ;
    static Scanner cin;
    public static void start()  {
        try {
            cout = new PrintWriter(new FileWriter(output,true));
            cin = new Scanner(tests);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int cnt = 0;
        while(cin.hasNext()) {
            String username = cin.nextLine();
            String password = cin.nextLine();
            Summary summary = new Summary();
            summary.setId("InvldLgn"+cnt++);
            summary.setScenario(scenario);
            summary.setSteps(steps);
            summary.setData("Username: "+username+"<br>Password: "+password);
            summary.setExpectedResults(expectedResult);
            String actualResult = Member.login(username, password);
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
