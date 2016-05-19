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
    public Weapon weapon=new Weapon("unarmed;1;1;unarmed;0");
    public Armor armor=new Armor("naked;0;1;chest;0");
    public Integer Hp;
    private Integer Charlvl=0,Classlvl=0;
    public Charm Shinies;

    public Enemy(){
        randStat();
        avatar=R.drawable.attack;
        Hp=(con*(5/Global.difficulty))+1;
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
        Log.e("gladitor","Shinies"+Shinies);
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
