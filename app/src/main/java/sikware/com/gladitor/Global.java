package sikware.com.gladitor;

import android.app.Application;

/**
 * Created by adampluth on 5/3/2016.
 */
public class Global extends Application {

    public static Player p1;//pulled from serialized file
    public static PlayerManager pman;
    public static Integer difficulty=1;//need to be set by location
}
