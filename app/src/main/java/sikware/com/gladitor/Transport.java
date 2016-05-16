package sikware.com.gladitor;

import java.io.Serializable;

/**
 * Created by Adam Pluth on 5/2/2016.
 */
public class Transport extends Item  implements Serializable {
    Integer MaxDis;
    public Transport(String s,int i){
        name=s;
        MaxDis=i;
    }
}
