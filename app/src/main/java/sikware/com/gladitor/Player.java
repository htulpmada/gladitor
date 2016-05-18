package sikware.com.gladitor;

import android.test.suitebuilder.annotation.Suppress;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by adam pluth on 5/2/2016.
 */
public class Player implements Serializable{
    public int avatar;
    public Integer str,agl,con,alrt,wits,chr,luck;
    public Weapon weapon=new Weapon("unarmed",1);
    public Armor armor=new Armor("naked",1);
    public Integer Hp=1;
    public Integer Denarius=3;
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
        avatar=R.drawable.attack;
        Hurter.add(weapon);
        OwBeGone.add(armor);
        Goers.add(new Transport("Barefoot",1));
        randStat();
        //makeGod();
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

    public void makeGod(){
        Hurter.add(new Weapon("sword;3"));
        Hurter.add(new Weapon("axe;2"));
        Hurter.add(new Weapon("sword;5"));
        Hurter.add(new Weapon("lance;6"));
        Hurter.add(new Weapon("trident;5"));
        OwBeGone.add(new Armor("padding;1"));
        OwBeGone.add(new Armor("leathers;2"));
        OwBeGone.add(new Armor("chain Mail;4"));
        OwBeGone.add(new Armor("Breast plate;6"));
        Denarius=10000;
    }

    public ArrayList<String> getWnames(ArrayList<Weapon> a){
        ArrayList<String> s = new ArrayList();
        for(int i=0;i<a.size();i++){s.add(a.get(i).name);}
        return s;
    }
    public ArrayList<String> getAnames(ArrayList<Armor> a){
        ArrayList<String> s = new ArrayList();
        for(int i=0;i<a.size();i++){s.add(a.get(i).name);}
        return s;
    }
    public ArrayList<String> getTnames(ArrayList<Transport> a){
        ArrayList<String> s = new ArrayList();
        for(int i=0;i<a.size();i++){s.add(a.get(i).name);}
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
