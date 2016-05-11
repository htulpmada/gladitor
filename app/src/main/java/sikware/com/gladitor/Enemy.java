package sikware.com.gladitor;

import java.util.ArrayList;

/**
 * Created by adamPluth on 5/11/2016.
 */
public class Enemy {
    public String name;
    public Integer str,agl,con,alrt,wits,chr,luck;
    public Weapon weapon;
    public Armor armor;
    public Integer Hp;
    private Integer Charlvl=0,Classlvl=0;
    public Weapon Hurter=new Weapon();
    public Armor OwBeGone=new Armor();
    public Transport Goers=new Transport();
    public Charm Shinies=new Charm();
    public Integer reputation=0,infamy=0;
    public Enemy(){}


}
