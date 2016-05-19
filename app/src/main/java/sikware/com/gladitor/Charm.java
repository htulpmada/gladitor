package sikware.com.gladitor;

import java.io.Serializable;

/**
 * Created by Adam Pluth on 5/2/2016.
 */
public class Charm extends Item  implements Serializable {
    String power;
    public Charm(String s,String t){
        name=s;
        power=t;
    }

    //TODO add bonus effects
    public String toString(){
        return ""+name+";"+power;
    }
}
