package sikware.com.gladitor;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by adam pluth on 5/2/2016.
 */
public class Player implements Serializable{

    public Integer str,agl,con,alrt,wits,chr,luck;
    public Weapon weapon=new Weapon("unarmed",1);
    public Armor armor=new Armor("naked",1);
    public Integer Hp=1;
    public Integer Denarius=0;
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
    public Player(){
        Hurter.add(weapon);
        OwBeGone.add(armor);
        randStat();
        Hp=(con*(5/Global.difficulty))+1;
        show();
    }

    public void show() {
        Log.e("gladitor","Player stats");
        Log.e("gladitor","Hp: "+Hp.toString());
        Log.e("gladitor",weapon.name+" and "+armor.name);
        Log.e("gladitor","Denarius: "+Denarius);
        Log.e("gladitor","str: "+str);
        Log.e("gladitor","agl: "+agl);
        Log.e("gladitor","con: "+con);
        Log.e("gladitor","alrt: "+alrt);
        Log.e("gladitor","wits: "+wits);
        Log.e("gladitor","chr: "+chr);
        Log.e("gladitor","luck: "+luck);
        Log.e("gladitor","origin: "+CountryOfOrigin);
        Log.e("gladitor","SocialStatus: "+SocialStatus);
        Log.e("gladitor","Charlvl: "+Charlvl);
        Log.e("gladitor","Classlvl: "+Classlvl);
        Log.e("gladitor","Hurters: "+Hurter.size());
        Log.e("gladitor","OwBeGones: "+OwBeGone.size());
        Log.e("gladitor","Goers: "+Goers.size());
        Log.e("gladitor","Shinies: "+Shinies.size());
        Log.e("gladitor","glory: "+glory);
        Log.e("gladitor","reputation: "+reputation);
        Log.e("gladitor","infamy: "+infamy);

    }


    public boolean iscomplete() {
        boolean complete=true;
        if(str==null){complete=false;}
        if(CountryOfOrigin==null&&SocialStatus==null){complete=false;}
        if(Charlvl==null&&Classlvl==null){complete=false;}
        return complete;
    }

    public void randStat() {
        Random generator= new Random();
        str=generator.nextInt(6)+1;
        agl=generator.nextInt(6)+1;
        con=generator.nextInt(6)+1;
        alrt=generator.nextInt(6)+1;
        wits=generator.nextInt(6)+1;
        chr=generator.nextInt(6)+1;
        luck=generator.nextInt(6)+1;

        return;
    }
}
