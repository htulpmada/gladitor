package sikware.com.gladitor;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by Adam Pluth on 5/2/2016.
 */
public class Transport extends Item  implements Serializable {
    Integer MaxDis;
    public static String type;
    //formt=name;type;price
    public Transport(String s1) {
        String[] values=s1.split(";");
        name=values[0];
        type=values[1];
        price=Integer.parseInt(values[2]);
        Log.e("gladitor", "wName: " + name + "type: " + type + " price: " + price);
    }

    public String toString(){
        return ""+name+";"+type+";"+price;
    }



}
