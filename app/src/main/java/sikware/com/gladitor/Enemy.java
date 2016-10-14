package sikware.com.gladitor;

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
        show();
    }
    public Enemy(Enemy src){
        randStat();
        avatar=src.avatar;
        diff=src.diff;
        maxHP=super.maxHealth();
        Hp=maxHP;
        show();
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
