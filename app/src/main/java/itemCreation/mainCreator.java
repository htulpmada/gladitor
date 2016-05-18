package itemCreation;

import Atree.ABst;
import Ctree.CBst;
import Ttree.TBst;
import Wtree.WBst;
import sikware.com.gladitor.Armor;
import sikware.com.gladitor.Transport;
import sikware.com.gladitor.Weapon;

/**
 * Created by Adam Pluth on 5/18/2016.
 */
public class mainCreator {
    public static WBst wList;
    public static ABst aList;
    public static TBst tList;
    public static CBst cList;
    public mainCreator(){
        wList.ins(new Weapon("spear;4;1;spear;200"));
        aList.ins(new Armor("gloves;1;0;gloves;80"));
        tList.ins(new Transport("sadles;shoes;55"));
    }

}
