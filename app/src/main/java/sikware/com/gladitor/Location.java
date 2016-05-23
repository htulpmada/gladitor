package sikware.com.gladitor;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by adam pluth on 5/3/2016.
 */
public class Location implements Serializable{
    public ArrayList<Enemy> badguys=new ArrayList<Enemy>();
    public ArrayList<Item> StuffToBuy=new ArrayList<Item>();
    public int campScence;
    public String name;
    //TODO alot of work need to revisit later
    public Location(String s1,String[] s2,String s3[], String s4[]){
        name=s1;

        StuffToBuy.add(new Item(s2[0],R.drawable.trident1));
        StuffToBuy.add(new Item(s2[1],R.drawable.spear1));
        StuffToBuy.add(new Item(s2[2],R.drawable.axe1));
        StuffToBuy.add(new Item(s2[3],R.drawable.two_handed1));
        StuffToBuy.add(new Item(s2[4],R.drawable.sword1));

        StuffToBuy.add(new Item(s3[0],R.drawable.trident1));
        StuffToBuy.add(new Item(s3[1],R.drawable.trident1));
        StuffToBuy.add(new Item(s3[2],R.drawable.trident1));
        StuffToBuy.add(new Item(s3[3],R.drawable.trident1));
        StuffToBuy.add(new Item(s3[4],R.drawable.trident1));

        StuffToBuy.add(new Item(s4[0],R.drawable.trident1));
        StuffToBuy.add(new Item(s4[1],R.drawable.trident1));
        StuffToBuy.add(new Item(s4[2],R.drawable.trident1));

        badguys.add(new Enemy());
        badguys.add(new Enemy());
        badguys.add(new Enemy());
    }

}
