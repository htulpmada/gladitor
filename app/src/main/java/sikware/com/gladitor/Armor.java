package sikware.com.gladitor;

import java.io.Serializable;

/**
 * Created by Adam Pluth on 5/2/2016.
 */
public class Armor extends Item implements Serializable {
    Integer power=1;
    public Armor(String s,Integer i){
        name=s;
        power=i;
    }
}
