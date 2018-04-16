import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TransactionTesting {
    static String steps = new String("1.Go to site http://localhost/library-master/member/<br>2.Login as member<br>3.Click on transaction");
    static String scenario = new String("Check book transactions");
    static String expectedResult;
    static File output = new File("output.html");
    static PrintWriter cout;

    public static void start() {
        try {
            cout = new PrintWriter(new FileWriter(output, true));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int cnt = 0;
        Summary summary = new Summary();
        summary.setId("Trnsctn" + cnt++);
        summary.setScenario(scenario);
        summary.setSteps(steps);
        summary.setExpectedResults("Assembly Language Programming Mokhlesur Rahman First Year 12105408 mokhles08@gmail.com 2015-12-14 11:21:17 15/12/2015 2015-12-14 11:21:27");
        String actualResult = Member.transaction();
        summary.setActualResults(actualResult);
        if (actualResult.equals(expectedResult)) {
            summary.setStatus("pass");
        } else summary.setStatus("fail");
        cout.append(summary.toString());
        cout.close();
    }

}
