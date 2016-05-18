package sikware.com.gladitor;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by Adam Pluth on 5/2/2016.
 */
public class Armor extends Item implements Serializable {
    Integer power=1,speed=1;
    public static String type;
   //format=name;power;speed;type;price
    public Armor(String s1) {
        String[] values=s1.split(";");
        name=values[0];
        power=Integer.parseInt(values[1]);
        speed=Integer.parseInt(values[2]);
        type=values[3];
        price=Integer.parseInt(values[4]);
        Log.e("gladitor", "wName: "+name+" wPower: "+power+" speed: "+speed+"type: "+type+" price: "+price);
    }

    public String toString(){
        return ""+name+";"+power+";"+speed+";"+type+";"+price;
    }



}
