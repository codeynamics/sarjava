import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zc.component.object.ZCObject;
import com.zc.component.object.ZCRowObject;
import com.zc.component.object.ZCTable;
import com.zc.component.object.ZCRowObject; 
import com.zc.component.zcql.ZCQL;
import com.catalyst.advanced.CatalystAdvancedIOHandler;

public class Analysis implements CatalystAdvancedIOHandler {
    private static final Logger LOGGER = Logger.getLogger(Analysis.class.getName());
    static String GET = "GET";
    static String POST = "POST";
    @Override
    public void runner(HttpServletRequest request, HttpServletResponse response) throws Exception {

        
        try {
            String url = request.getRequestURI();
            String method = request.getMethod();
           String query = "SELECT * FROM Lead";
           ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
            LOGGER.log(Level.INFO,"rowList: "+ rowList.get(0).get("bakery", "Cust_Id"));
            response.setStatus(200);
            for(int i =0;i<rowList.size();i++)
                fname=response.getWriter().write("rowList: "+ rowList.get(i).get("bakery", "FirstName"));
                lname=response.getWriter().write("rowList: "+ rowList.get(i).get("bakery", "LastName"));
                
            //String email = rowList.get(0).get("Lead", "Email");
           
        }
        catch(Exception e) {
            LOGGER.log(Level.SEVERE,"Exception in Analysis",e);
            response.setStatus(500);
        }
        List<ZCRowObject> rows = new ArrayList<ZCRowObject>();
//Create a base Object Instance
ZCObject object = ZCObject.getInstance();
//Get a Table Instance referring the table ID on base object
ZCTable tab = object.getTable(13267000000004873);
//Create required number of row instances
ZCRowObject row1 = ZCRowObject.getInstance();
ZCRowObject row2 = ZCRowObject.getInstance();
ZCRowObject row3 = ZCRowObject.getInstance();
ZCRowObject row4 = ZCRowObject.getInstance();
ZCRowObject row5 = ZCRowObject.getInstance();
//Set the column values on the respective rows using set() method 
row1.set("FirstName", fname);
row1.set("LastName", lname);
row1.set("Age", 25);
row1.set("Age", 25);
row2.set("Name","Moana Violet"); 
row2.set("Age", 22);
row2.set("Name","Moana Violet"); 
row2.set("Age", 22);
row2.set("Name","Moana Violet"); 

row3.set("Name","Moana Violet"); 
row3.set("Age", 22);

//Add rows to List using add() method
rows.add(row1);
rows.add(row2);
//Add the list to table using insertRows() method
tab.insertRows(rows);
    }
    
}
