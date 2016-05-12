package sikware.com.gladitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by adam pluth on 5/2/2016.
 */
public class Player implements Serializable{

    public static Integer str,agl,con,alrt,wits,chr,luck;
    public Weapon weapon=new Weapon("unarmed",1);
    public Armor armor=new Armor("naked",1);
    public Integer Hp=1;
    public Integer Health;
    public Location current;
    protected String CountryOfOrigin;
    private String SocialStatus="slave";
    private Integer Charlvl=0,Classlvl=0;
    public ArrayList<ArrayList<Item>> Stuff;
    public ArrayList<Weapon> Hurter=new ArrayList<Weapon>();
    public ArrayList<Armor> OwBeGone=new ArrayList<Armor>();
    public ArrayList<Transport> Goers=new ArrayList<Transport>();
    public ArrayList<Charm> Shinies=new ArrayList<Charm>();
    public Float glory= Float.valueOf(0);
    public Integer reputation=0,infamy=0;
    public Player(){}


    public boolean iscomplete() {
        boolean complete=true;
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
