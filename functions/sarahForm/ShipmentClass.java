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
                response.getWriter().write("rowList: "+ rowList.get(i).get("bakery", "FirstName"));
            //String email = rowList.get(0).get("Lead", "Email");
           
        }
        catch(Exception e) {
            LOGGER.log(Level.SEVERE,"Exception in Analysis",e);
            response.setStatus(500);
        }
    }
    
}
