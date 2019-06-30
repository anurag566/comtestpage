package core.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs {
    public boolean isPrint = true;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

    public void log(String message) {
        if(isPrint){
            System.out.println(" Log : "+sdf.format(new Date())+" : "+ message);
        }
    }
}
