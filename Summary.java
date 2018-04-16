public class Summary {
    private String id, scenario, steps, data, expectedResults, actualResults, status;

    public Summary() {
        this.id = new String();
        this.scenario = new String();
        this.steps = new String();
        this.data = new String();
        this.expectedResults = new String();
        this.actualResults = new String();
        this.status = new String();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setExpectedResults(String expectedResults) {
        this.expectedResults = expectedResults;
    }

    public void setActualResults(String actualResults) {
        this.actualResults = actualResults;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        if(status.equals("pass")){
            return  "<table  >" +
                    "    <tr>" +
                    "        <td>Test Case ID</td><td>"+ id +"</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td>Test Scenario</td><td>"+scenario+"</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td>Test Steps</td><td>"+steps+"</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td>Test Data</td><td>"+data+"</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td>Expected Results</td><td>"+expectedResults+"</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td>Actual Results</td><td>"+actualResults+"</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td>Pass/Fail</td><td bgcolor=\"green\">"+status+"</td>" +
                    "    </tr><br>" +
                    "</table>";
        }
        else {
            return  "<table >" +
                    "    <tr>" +
                    "        <td>Test Case ID</td><td>"+ id +"</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td>Test Scenario</td><td>"+scenario+"</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td>Test Steps</td><td>"+steps+"</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td>Test Data</td><td>"+data+"</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td>Expected Results</td><td>"+expectedResults+"</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td>Actual Results</td><td>"+actualResults+"</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td>Pass/Fail</td><td bgcolor=\"red\">"+status+"</td>" +
                    "    </tr><br>" +
                    "</table>";

        }

    }
}
