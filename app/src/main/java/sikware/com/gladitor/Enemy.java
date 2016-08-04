package sikware.com.gladitor;

import android.util.Log;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by adamPluth on 5/11/2016.
 */
public class Enemy implements Serializable {
    public int avatar;
    public String name;
    public Integer str,agl,con,alrt,wits,chr,luck;
    public Item weapon=new Item("unarmed;1;1;w;0",R.drawable.sword1);
    public Item armor=new Item("naked;0;1;a;0;",R.drawable.sword1);
    public Item shield = null;
    public Integer Hp,maxHP,diff;
    private Integer Charlvl=0,Classlvl=0;
    //TODO make this a player
    public Enemy(int i){
        randStat();
        avatar=R.drawable.attack;
        diff=i;
        maxHP=(con*(5/Global.difficulty))+10*diff;
        Hp=maxHP;
        show();
    }
    public Enemy(Enemy src){
        randStat();
        avatar=src.avatar;
        diff=src.diff;
        maxHP=src.maxHP;
        Hp=maxHP;
        show();
    }

    private void show() {
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
