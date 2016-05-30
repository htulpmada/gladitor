package sikware.com.gladitor;

import android.app.Application;
import android.content.Context;

/**
 * Created by adampluth on 5/3/2016.
 */
public class Global extends Application {

    public static Player p1;//pulled from serialized file
    public static PlayerManager pman;//only one for congruency
    public static Integer difficulty=1;//need to be set by location
    public static Location loc;//holds location specific info
    public static LocationManager locMan;//only one for congruency
    private static Context context;// non-static context for static calls

    public void OnCreate(){
        super.onCreate();
        Global.context=getApplicationContext();
    }
    public static Context getAppContext(){
        return Global.context;
    }

}
