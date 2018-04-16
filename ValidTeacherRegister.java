import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ValidTeacherRegister {
    static String steps = new String("1.Go to site http://localhost/library-master/teacher_form.php<br>2.Enter Firstname<br>3.Enter Lastname<br>4.Enter Username<br>5.Enter Gender<br>6.Enter Address<br>7.Enter Contact<br>8.Enter password<br>9.Click submit");
    static String scenario = new String("Check teacher Register with valid data");
    static String expectedResult = new String("http://localhost/library-master/success.php");
    static File tests = new File("teacherRegisterTests/validTests.txt");
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
            String contact = cin.nextLine();
            String password = cin.nextLine();
            Summary summary = new Summary();
            summary.setId("VldTchrRgstr"+cnt++);
            summary.setScenario(scenario);
            summary.setSteps(steps);
            summary.setData("First Name: "+firstName+"<br>Last name: "+lastName+"<br>Username: "+username+"<br>Gender: "+gender+"<br>Address: "+ address+"<br>Contact: "+contact+"<br>Password: "+password);
            summary.setExpectedResults(expectedResult);
            String actualResult = Teacher.register(firstName, lastName, username, gender, address, contact, password);
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
