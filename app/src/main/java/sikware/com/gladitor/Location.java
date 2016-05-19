package sikware.com.gladitor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by adam pluth on 5/3/2016.
 */
public class Location implements Serializable{
    public ArrayList<Enemy> badguys=new ArrayList<Enemy>();
    public ArrayList<Weapon> Hurter=new ArrayList<Weapon>();
    public ArrayList<Armor> OwBeGone=new ArrayList<Armor>();
    public ArrayList<Transport> Goers=new ArrayList<Transport>();
    //TODO alot of work need to revisit later
    public Location(){
        Enemy ai=new Enemy();

        badguys.add(ai);
    }
}
