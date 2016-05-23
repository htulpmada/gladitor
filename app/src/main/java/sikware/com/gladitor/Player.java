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
    public Item weapon=new Item("unarmed;1;1;w;0",R.drawable.sword1);
    public Item armor=new Item("naked;0;1;a;0;",R.drawable.sword1);
    public Integer Hp=1;
    public Integer Denarius=3;
    public Location current;
    protected String CountryOfOrigin;
    private String SocialStatus="slave";
    private Integer Charlvl=0,Classlvl=0;
    public ArrayList<Item> Stuff=new ArrayList<Item>();
    public Float glory= Float.valueOf(0);
    public Integer reputation=0,infamy=0;
    //public Context context;
    public Player(Context c){
        avatar = R.drawable.attack;
        Stuff.add(weapon);
        Stuff.add(armor);
        Stuff.add(new Item("Barefoot;0;0;t;0",R.drawable.icon));
        randStat();
        Denarius=10000;
        //makeGod();
        Hp=(con*(5/Global.difficulty))+1;
        show();
    }

    public void heal(){Hp=(con*(5/Global.difficulty))+1;}

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
        Log.e("gladitor","Stuff: "+Stuff.size());
        Log.e("gladitor","glory: "+glory);
        Log.e("gladitor","reputation: "+reputation);
        Log.e("gladitor","infamy: "+infamy);

    }

    public void makeGod(){
        /*Stuff.add(new Item("sword;3"));
        Stuff.add(new Item("axe;2"));
        Stuff.add(new Item("sword;5"));
        Stuff.add(new Item("lance;6"));
        Stuff.add(new Item("trident;5"));
        Stuff.add(new Item("padding;1"));
        Stuff.add(new Item("leathers;2"));
        Stuff.add(new Item("chain Mail;4"));
        Stuff.add(new Item("Breast plate;6"));
        Denarius=10000;*/
    }

    public ArrayList<String> getWnames(ArrayList<Item> a){
        ArrayList<String> s = new ArrayList();
        for(Item i:a) {
            if (i.type.equals("w")) {
                s.add(i.toString());
            }
        }
        return s;
    }
    public ArrayList<String> getAnames(ArrayList<Item> a){
        ArrayList<String> s = new ArrayList();
        for(Item i:a) {
            if (i.type.equals("a")) {
                s.add(i.toString());
            }
        }
        return s;
    }
    public ArrayList<String> getTnames(ArrayList<Item> a){
        ArrayList<String> s = new ArrayList();
        for(Item i:a) {
            if (i.type.equals("t")) {
                s.add(i.toString());
            }
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
