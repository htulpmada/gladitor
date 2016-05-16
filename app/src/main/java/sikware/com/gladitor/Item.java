package sikware.com.gladitor;

import java.io.Serializable;

/**
 * Created by Adam Pluth on 5/2/2016.
 */
public class Item implements Serializable {
    String name;
    Integer price=1;
    public int image=R.drawable.icon;//need to change to individual drawable image for item

    public void Item(){}
    public void setPic(int i){image=i;}
}
