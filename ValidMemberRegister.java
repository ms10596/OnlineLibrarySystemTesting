import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ValidMemberRegister {
    static String steps = new String("1.Go to site http://localhost/library-master/member/<br>2.Enter Firstname<br>3.Enter Lastname<br>4.Enter Username<br>5.Enter Gender<br>6.Enter Address<br>7.Enter Roll No<br>8.Enter Contact<br>9.Enter Type<br>10.Enter Year Level<br>11.Enter password<br>12.Click submit");
    static String scenario = new String("Check student Resgister with valid data");
    static String expectedResult = new String("http://localhost/library-master/success.php");
    static File tests = new File("memberRegisterTests/validTests.txt");
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
            String firstName = cin.nextLine();
            String lastName = cin.nextLine();
            String username = cin.nextLine();
            String gender = cin.nextLine();
            String address = cin.nextLine();
            String rollNo = cin.nextLine();
            String contact = cin.nextLine();
            String type = cin.nextLine();
            String yearLevel = cin.nextLine();
            String password = cin.nextLine();
            Summary summary = new Summary();
            summary.setId("VldStdntRgstr"+cnt++);
            summary.setScenario(scenario);
            summary.setSteps(steps);
            summary.setData("First Name: "+firstName+"<br>Last name: "+lastName+"<br>Username: "+username+"<br>Gender: "+gender+"<br>Address: "+ address+"<br>Roll No:"+rollNo+"<br>Contact: "+contact+"<br>Type: "+type+"<br>Year Level: "+yearLevel+"<br>Password: "+password);
            summary.setExpectedResults(expectedResult);
            String actualResult = Member.register(firstName, lastName, username, gender, address, rollNo, contact, yearLevel, password);
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
