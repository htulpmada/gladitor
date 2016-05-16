package sikware.com.gladitor;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by Adam Pluth on 5/2/2016.
 */
public class Armor extends Item implements Serializable {
    Integer power=1;
    public Armor(String s,int i){
        name=s;
        power=i;
    }

    public Armor(String s1) {
        String s2=s1.substring(0,s1.indexOf(";"));
        s1=s1.substring(s1.indexOf(";")+1);
        name=s2;
        power=Integer.parseInt(s1);
        Log.e("gladitor", "aName: " + s2 + " aPower" + s1);
    }

}
