package sikware.com.gladitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by adam pluth on 5/2/2016.
 */
public class Player implements Serializable{

    public String Name;
    public static Integer str,agl,con,alrt,wits,chr,luck;
    protected String CountryOfOrigin;
    private String SocialStatus="slave";
    private Integer Charlvl=0,Classlvl=0;
    public ArrayList<ArrayList<Item>> Stuff;
    public ArrayList<Weapon> Hurter;
    public ArrayList<Armor> OwBeGone;
    public ArrayList<Transport> Goers;
    public ArrayList<Charm> Shinies;
    public Float glory= Float.valueOf(0);
    public Integer reputation=0,infamy=0;
    boolean female;
    public Player(){}


    public boolean iscomplete() {
        boolean complete=true;
        if(Name==null){complete=false;}
        if(str==null){complete=false;}
        if(CountryOfOrigin==null&&SocialStatus==null){complete=false;}
        if(Charlvl==null&&Classlvl==null){complete=false;}
        return complete;
    }

    public void randStat() {
        Random generator= new Random();
        str=generator.nextInt(4)+1;
        agl=generator.nextInt(4)+1;
        con=generator.nextInt(4)+1;
        alrt=generator.nextInt(4)+1;
        wits=generator.nextInt(4)+1;
        chr=generator.nextInt(4)+1;
        luck=generator.nextInt(4)+1;

    }
}
