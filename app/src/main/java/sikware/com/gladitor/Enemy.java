package sikware.com.gladitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by adamPluth on 5/11/2016.
 */
public class Enemy implements Serializable {
    public String name;
    public Integer str,agl,con,alrt,wits,chr,luck;
    public Weapon weapon=new Weapon("unarmed",1);
    public Armor armor=new Armor("naked",1);
    public Integer Hp;
    private Integer Charlvl=0,Classlvl=0;
    public Charm Shinies=new Charm();
    public Integer reputation=0,infamy=0;
    public Enemy(){
        randStat();
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
