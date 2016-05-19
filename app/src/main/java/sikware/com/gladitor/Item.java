package sikware.com.gladitor;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by Adam Pluth on 5/2/2016.
 */
public class Item implements Serializable {
    public String name;
    public Integer price=1;
    public int image=R.drawable.icon;//need to change to individual drawable image for item
    String type;
    public void Item(String s){
        String[] values=s.split(";");
        name=values[0];
        if(s.length()<3){
            price=Integer.parseInt(values[4]);
            type=values[3];
        }
        else{
            price=Integer.parseInt(values[2]);
            type=values[1];
        }
        Log.e("gladitor", "wName: " + name + " price: " + price);
    }

    public String toString(){
        return ""+name+";"+type+";"+price;
    }

    public void setPic(int i){image=i;}

}
