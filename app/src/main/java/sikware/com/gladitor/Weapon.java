package sikware.com.gladitor;

import java.io.Serializable;

/**
 * Created by Adam Pluth on 5/2/2016.
 */
public class Weapon extends Item  implements Serializable {
    Integer power=1,speed=1;
    public Weapon(String s,Integer i){
        name=s;
        power=i;
    }
}
