package sikware.com.gladitor;

import android.app.Application;

import Atree.ABst;
import Ctree.CBst;
import Ttree.TBst;
import Wtree.WBst;


/**
 * Created by adampluth on 5/3/2016.
 */
public class Global extends Application {

    public static Player p1;//pulled from serialized file
    public static PlayerManager pman;
    public static Integer difficulty=1;//need to be set by location
    public static WBst wList;
    public static ABst aList;
    public static TBst tList;
    public static CBst cList;
}
