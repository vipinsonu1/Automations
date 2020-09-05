package compareui;

import apiServer.utils.XLUtility;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviderScreenShot {

    @DataProvider(name = "takeshots")
    public Object[][] dataScreenshot() throws IOException {

        String xlFilePath = System.getProperty("user.dir") + "/data/Screenshot.xlsx";
        int rowCount = XLUtility.getRowCount(xlFilePath, "Sheet1");
        System.out.println(rowCount);
        int columnCount = XLUtility.getCellCount(xlFilePath, "Sheet1", 1);
        System.out.println(columnCount);

        String takeshots[][] = new String[rowCount][columnCount];
        for (int currentRow = 1; currentRow <= rowCount; currentRow++) {
            for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
                takeshots[currentRow -1][currentColumn] = XLUtility.getCellData(xlFilePath, "Sheet1", currentRow, currentColumn);
            }
        }
        return (takeshots);
    }


    @DataProvider(name = "dashboardshots")
    public Object[][] dataDashboardshot() throws IOException {

        String xlFilePath = System.getProperty("user.dir") + "/data/Screenshot.xlsx";
        int rowCount = XLUtility.getRowCount(xlFilePath, "Sheet2");
        System.out.println(rowCount);
        int columnCount = XLUtility.getCellCount(xlFilePath, "Sheet2", 1);
        System.out.println(columnCount);

        String dashboardshots[][] = new String[rowCount][columnCount];
        for (int currentRow = 1; currentRow <= rowCount; currentRow++) {
            for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
                dashboardshots[currentRow -1][currentColumn] = XLUtility.getCellData(xlFilePath, "Sheet2", currentRow, currentColumn);
            }
        }
        return (dashboardshots);
    }


}
