package logical;

import framework.keywords.engine.KeywordEngine;
import org.testng.annotations.Test;

public class DashboardLogicTest {
    public KeywordEngine keywordEngine;

    @Test
    public void loginTest() throws InterruptedException {
        keywordEngine =new KeywordEngine();
        Thread.sleep(5000);
        keywordEngine.startExecution("screenShot");

    }


}
