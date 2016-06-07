package sikware.com.gladitor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.test.suitebuilder.annotation.Suppress;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by adam pluth on 5/2/2016.
 */
public class Player implements Serializable{
    public Integer avatar;
    public Integer str,agl,con,alrt,wits,chr,luck;
    public Integer dmg,ac;
    public Item weaponR=new Item("unarmed;0;1;w;0",R.drawable.sword1);
    public Item weaponL=new Item("unarmed;0;1;w;0",R.drawable.sword1);
    public Item suit=new Item("naked;0;1;a;0;",R.drawable.stick_glad);
    public Item helm=new Item("naked;0;1;a;0;",R.drawable.stick_glad);
    public Integer Hp=1,maxHP;
    public Integer Denarius=3;
    public Location current;
    protected String CountryOfOrigin;
    private String SocialStatus="slave";
    private Integer Charlvl=0,Classlvl=0;
    //public ArrayList<String> Skills=new ArrayList<String>();
    public ArrayList<Item> WStuff=new ArrayList<Item>();
    public ArrayList<Item> AStuff=new ArrayList<Item>();
    public ArrayList<Item> HStuff=new ArrayList<Item>();
    public ArrayList<Item> TStuff=new ArrayList<Item>();
    public Integer glory= 0;
    public Integer reputation=0,infamy=0;

    public Player(Context c){
        avatar = R.drawable.attack;
        WStuff.add(weaponR);
        AStuff.add(suit);
        HStuff.add(helm);
        TStuff.add(new Item("Barefoot;0;0;t;0", R.drawable.icon));
        randStat();
        //Denarius=10000;
        //makeGod();
        Hp=(con*(5/Global.difficulty))+1;
        maxHP=(con*(5/Global.difficulty))+1;
        //show();
    }

    public Integer maxHealth(){return (con*(5/Global.difficulty))+1;}

    public void heal(){Hp=maxHealth();}

    public void show() {
        Log.w("gladitor","Player stats");
        Log.w("gladitor","Hp: "+Hp.toString());
        Log.w("gladitor",weaponR.name+" "+weaponL.name+" and "+suit.name+" "+helm.name);
        Log.w("gladitor","Denarius: "+Denarius);
        Log.w("gladitor","str: "+str);
        Log.w("gladitor","agl: "+agl);
        Log.w("gladitor","con: "+con);
        Log.w("gladitor","alrt: "+alrt);
        Log.w("gladitor","wits: "+wits);
        Log.w("gladitor","chr: "+chr);
        Log.w("gladitor","luck: "+luck);
        Log.w("gladitor","origin: "+CountryOfOrigin);
        Log.w("gladitor","SocialStatus: "+SocialStatus);
        Log.w("gladitor","Charlvl: "+Charlvl);
        Log.w("gladitor","Classlvl: "+Classlvl);
        Log.w("gladitor","WStuff: "+WStuff.size());
        Log.w("gladitor","AStuff: "+AStuff.size());
        Log.w("gladitor","TStuff: "+TStuff.size());
        Log.w("gladitor","glory: "+glory);
        Log.w("gladitor","reputation: "+reputation);
        Log.w("gladitor","infamy: "+infamy);

    }

    public void makeGod(){
        Denarius+=10000;
    }

    public void getDamage(){//TODO change this math
        int dam=0,a=0;
        if(weaponR.type.equals("s")){a+=weaponR.power;}
        else {dam+=weaponR.power;}
        if(weaponL.type.equals("s")){a+=weaponL.power;}
        else {dam+=weaponL.power;}
        dmg=(dam+str)*Global.difficulty+2;
        ac=(suit.power+helm.power+a+agl)*Global.difficulty;
    }

    public ArrayList<String> getnames(ArrayList<Item> a){
        ArrayList<String> s = new ArrayList();
        for(Item i:a) {
            s.add(i.toString());
        }
        return s;
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
