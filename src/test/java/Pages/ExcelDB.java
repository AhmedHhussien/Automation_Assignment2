package Pages;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.openqa.selenium.WebDriver;
//Method to extract data from excel sheet using SQL Queries
public class ExcelDB {
    WebDriver driver;

    public ExcelDB(WebDriver driver) {
        this.driver = driver;
    }

    public String GetDataFromExcel(String DataColumn, int Iteration) throws Exception {
        String Result = "";
        Fillo fillo=new Fillo();
        Connection conn = fillo.getConnection(System.getProperty("user.dir")+"/Test_data.xlsx");
        String strQuery="Select * from TestData where Iteration = "+Iteration;
        Recordset recordset= conn.executeQuery(strQuery);

        while(recordset.next()){
            Result = recordset.getField(DataColumn);
            System.out.println(DataColumn+"is:  "+Result);
        }

        recordset.close();
        conn.close();
        return Result;
    }
}
