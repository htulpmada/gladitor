package sikware.com.gladitor;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by adam pluth on 5/3/2016.
 */
public class Location implements Serializable {
    public ArrayList<Enemy> badguys=new ArrayList<Enemy>();
    public ArrayList<Item> WStuffToBuy=new ArrayList<Item>();
    public ArrayList<Item> AStuffToBuy=new ArrayList<Item>();
    public ArrayList<Item> TStuffToBuy=new ArrayList<Item>();
    public ArrayList<String> Arenas=new ArrayList<String>();
    public int campScene,storeScene,arenaScene,trainScene;
    public String name;
    //TODO alot of work need to revisit later
    //wtf is this   v v v v v v v v v v v v v v v v
    public Location(String s1,String[] s2,String s3[], String s4[], String s5[], int i, int[] i2, int[] i3, int[] i4,int j,String[] bg){
        name=s1;
        campScene=i;
        storeScene=j;
        WStuffToBuy.add(new Item(s2[0],i2[0]));
        WStuffToBuy.add(new Item(s2[1],i2[1]));
        WStuffToBuy.add(new Item(s2[2],i2[2]));
        WStuffToBuy.add(new Item(s2[3],i2[3]));
        WStuffToBuy.add(new Item(s2[4],i2[4]));
        WStuffToBuy.add(new Item(s2[5],i2[5]));
        WStuffToBuy.add(new Item(s2[6],i2[6]));
        WStuffToBuy.add(new Item(s2[7],i2[7]));

        AStuffToBuy.add(new Item(s3[0],i3[0]));
        AStuffToBuy.add(new Item(s3[1],i3[1]));
        AStuffToBuy.add(new Item(s3[2],i3[2]));
        AStuffToBuy.add(new Item(s3[3],i3[3]));
        AStuffToBuy.add(new Item(s3[4],i3[4]));
        AStuffToBuy.add(new Item(s3[5],i3[5]));

        TStuffToBuy.add(new Item(s4[0],i4[0]));
        TStuffToBuy.add(new Item(s4[1],i4[1]));
        TStuffToBuy.add(new Item(s4[2],i4[2]));
        TStuffToBuy.add(new Item(s4[3],i4[3]));
        TStuffToBuy.add(new Item(s4[4],i4[4]));

        Arenas.add(s5[0]);
        Arenas.add(s5[1]);
        Arenas.add(s5[2]);
        Arenas.add(s5[3]);
        Arenas.add(s5[4]);

        //TODO work on random badguys
        badguys.add(new Enemy(bg[0],1));
        badguys.add(new Enemy(bg[1],2));
        badguys.add(new Enemy(bg[2],3));
        badguys.add(new Enemy(bg[3],4));
        badguys.add(new Enemy(bg[4],5));
        badguys.add(new Enemy(bg[5],6));
        badguys.add(new Enemy(bg[6],7));
        badguys.add(new Enemy(bg[7],8));
    }

}
