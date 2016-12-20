package sikware.com.gladitor;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by adamPluth on 5/11/2016.
 */
public class Enemy extends Player implements Serializable {
    public int avatar;
    public String name;
    //public Integer str,agl,con,alrt,wits,chr,luck;
    public Item weapon=new Item("unarmed;1;1;w;0",R.drawable.sword1);
    public Item armor=new Item("naked;0;1;a;0;",R.drawable.sword1);
    public Item shield = null;
    public Item helm = null;
    public Integer Hp,maxHP,diff;
    private Integer Charlvl=0,Classlvl=0;
    //TODO make this a player, done!!(need to test)
    public Enemy(String s,int i){
        super.randStat();
        avatar=R.drawable.attack;
        name=s;
        diff=i;
        maxHP=super.maxHealth();
        Hp=maxHP;
       // equip();
        show();
    }
    public Enemy(Enemy src,int i){
        randStat();
        name=src.name;
        avatar=src.avatar;
        diff=i;
        maxHP=super.maxHealth();
        Hp=maxHP;
        equip();
        show();
    }

    public void equip(){
        //Resources res=Resources.getSystem();
        switch(diff){
            case 0:
                weapon=Global.loc.WStuffToBuy.get(5);//knife
                armor=null;
                shield = null;
                helm = null;
                break;
            case 1:
                weapon=Global.loc.WStuffToBuy.get(6);//bow
                armor=Global.loc.AStuffToBuy.get(0);
                shield = null;
                helm = null;
                break;
            case 2:
                weapon=Global.loc.WStuffToBuy.get(3);//sword
                armor=Global.loc.AStuffToBuy.get(0);
                shield =Global.loc.AStuffToBuy.get(4);
                helm = null;
                break;
            case 3:
                weapon=Global.loc.WStuffToBuy.get(1);//axe
                armor=Global.loc.AStuffToBuy.get(2);
                shield = Global.loc.AStuffToBuy.get(4);
                helm = null;
                break;
            case 4:
                weapon=Global.loc.WStuffToBuy.get(7);//net
                armor=Global.loc.AStuffToBuy.get(2);
                shield = Global.loc.AStuffToBuy.get(4);
                helm = Global.loc.AStuffToBuy.get(5);
                break;
            case 5:
                weapon=Global.loc.WStuffToBuy.get(2);//two hand
                armor=Global.loc.AStuffToBuy.get(2);
                shield = Global.loc.AStuffToBuy.get(3);
                helm = Global.loc.AStuffToBuy.get(5);
                break;
            case 6:
                weapon=Global.loc.WStuffToBuy.get(4);//spear
                armor=Global.loc.AStuffToBuy.get(2);
                shield = Global.loc.AStuffToBuy.get(3);
                helm = Global.loc.AStuffToBuy.get(5);
                break;
            case 7:
                weapon=Global.loc.WStuffToBuy.get(0);//trident
                armor=Global.loc.AStuffToBuy.get(1);
                shield = Global.loc.AStuffToBuy.get(3);
                helm = Global.loc.AStuffToBuy.get(5);
                break;
        }
    }

    public void show() {
        Log.e("gladitor","Enemy stats:");
        Log.e("gladitor", Hp.toString());
        Log.e("gladitor",weapon.name);
        Log.e("gladitor",armor.name);
        Log.e("gladitor","str: "+str);
        Log.e("gladitor","agl: "+agl);
        Log.e("gladitor","con: "+con);
        Log.e("gladitor","alrt: "+alrt);
        Log.e("gladitor","wits"+wits);
        Log.e("gladitor","chr"+chr);
        Log.e("gladitor","luck"+luck);
        Log.e("gladitor","Charlvl: "+Charlvl);
        Log.e("gladitor","Classlvl"+Classlvl);
        }

}
