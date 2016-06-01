package sikware.com.gladitor;

import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.Serializable;

/**
 * Created by Adam Pluth on 5/2/2016.
 */
public class Item implements Serializable {
    public String name;
    Integer price=1,power=1,speed=1;
    String type;
    int rank=0;
    public int image;//need to change to individual drawable image for item
    //TODO make bonuses from special items
    //format=name;power;speed;type;price;avatar//weapon or armor
   public Item(Item i){
        rank=++i.rank;
        name=(i.name.split("-"))[0]+"-"+rank;
        power=i.power+1;
        speed=i.speed+1;
        type=i.type;
        price=i.price+1000;
   }

   public Item(String s,int i){
        String[] values=s.split(";");
        name=values[0];
        power=Integer.parseInt(values[1]);
        speed=Integer.parseInt(values[2]);
        type=values[3];
        price=Integer.parseInt(values[4]);
        image=i;
        //image=Global.getAppContext().getDrawable(Integer.parseInt(values[5]));
        Log.e("gladitor", "wName: "+name+" wPower: "+power+" speed: "+speed+"type: "+type+" price: "+price);
        Log.e("gladitor", "wName: " + name + " price: " + price);
   }

   public String toString(){
       return ""+name+";"+power+";"+speed+";"+type+";"+price+";"+image;
   }

}
