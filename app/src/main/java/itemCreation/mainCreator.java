package itemCreation;

import sikware.com.gladitor.Item;
import tree.Bst;


/**
 * Created by Adam Pluth on 5/18/2016.
 */
public class mainCreator {
    public static Bst ListOstuff;

    public mainCreator(){
        ListOstuff.ins(new Item("spear;4;1;spear;200"));
        ListOstuff.ins(new Item("gloves;1;0;gloves;80"));
        ListOstuff.ins(new Item("sandles;shoes;55"));
    }

}
