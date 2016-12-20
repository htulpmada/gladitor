package sikware.com.gladitor;


import android.util.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adam pluth on 5/2/2016.
 */
public class Player implements Serializable{
    public Integer avatar;
    public Integer str,agl,con,alrt,wits,chr,luck;
    public Integer mstr,magl,mcon,malrt,mwits,mchr,mluck;
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
    public int arenasBeatten=0;
    public Integer glory= 0;
    public Integer reputation=0,infamy=0;

    public Player(){
        avatar = R.drawable.attack;
        WStuff.add(weaponR);
        AStuff.add(suit);
        HStuff.add(helm);
        TStuff.add(new Item("Barefoot;0;0;t;0", R.drawable.icon));
        randStat();
        Hp=((mcon+1)*(4/Global.difficulty));
        maxHP=((mcon+1)*(4/Global.difficulty));
    }

    public Integer maxHealth(){return ((mcon+1)*(4/Global.difficulty));}

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

    public void makeGod(){Denarius+=1000000; glory+=100000;}

    public void getDamage(){//TODO change this math
        int dam=1,a=0;
        Random r=new Random();
        if(weaponR.type.equals("s")){a+=weaponR.power;}
        else {dam+=weaponR.power;}
        if(weaponL.type.equals("s")){a+=weaponL.power;}
        else {dam+=weaponL.power;}
        dmg=(dam+1+mstr)*Global.difficulty;
        if(dmg<1){dmg=1;}
        ac=(10+suit.power+helm.power+a+magl)*Global.difficulty;
    }

    public ArrayList<String> getnames(ArrayList<Item> a){
        ArrayList<String> s = new ArrayList();
        for(Item i:a) {
            s.add(i.toString());
        }
        return s;
    }

    public boolean Checknames(String t,String s){
        switch(t) {
            case("t"):
                for (Item i : TStuff) {
                    if (i.name.equals(s)) {
                        return true;
                    }
                }
                return false;
            case("a"):
                for (Item i : AStuff) {
                    if (i.name.equals(s)) {
                        return true;
                    }
                }
                return false;
            case("w"):
                for (Item i : WStuff) {
                    if (i.name.equals(s)) {
                        return true;
                    }
                }
                return false;
        }
        return false;
    }

    public void randStat() {
        str=getRandomStat();
        mstr=(str-10)/2;
        if(mstr<1){mstr=1;}
        agl=getRandomStat();
        magl=(agl-10)/2;
        if(magl<1){magl=1;}
        con=getRandomStat();
        mcon=(con-10)/2;
        if(mcon<1){mcon=1;}
        alrt=getRandomStat();
        malrt=(alrt-10)/2;
        if(malrt<1){malrt=1;}
        wits=getRandomStat();
        mwits=(wits-10)/2;
        if(mwits<1){mwits=1;}
        chr=getRandomStat();
        mchr=(chr-10)/2;
        if(mchr<1){mchr=1;}
        luck=getRandomStat();
        mluck=(luck-10)/2;
        if(mluck<1){mluck=1;}
        return;
    }
    public int getRandomStat(){
        Random generator= new Random();
        int[] j={generator.nextInt(6)+1,generator.nextInt(6)+1,generator.nextInt(6)+1,generator.nextInt(6)+1};
        Arrays.sort(j);
        int i=j[0]+j[1]+j[2];
        return i;
    }
}
