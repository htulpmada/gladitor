package sikware.com.gladitor;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Toast;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by adam pluth on 5/23/2016.
 */
public class LocationManager {
        public int curr;
        public Location current;
        private Location ltest=null;
        private Context context;

        public LocationManager(Context c) {
            current = ltest;
            context = c;
        }

        public void get(int i){
            if(current!=null){Global.loc=current;}
            else{
                switch(i){
                    case(0):
                        makeLocation("England");
                        break;
                    case(1):
                        makeLocation("Spain");
                        break;
                    case(2):
                        makeLocation("Germany");
                        break;
                    case(3):
                        makeLocation("Africa");
                        break;
                    case(4):
                        makeLocation("Italy");
                        break;
                    default:
                        Toast.makeText(context,"ooopps sorry havent made that level yet",Toast.LENGTH_LONG);
                }
            }
        }

        public Location makeLocation(String str){
            Resources res = context.getResources();
            String[] s =res.getStringArray(R.array.StartingLocation);
            String[] w =res.getStringArray(R.array.Weapons);
            String[] a =res.getStringArray(R.array.Armor);
            String[] m =res.getStringArray(R.array.Movers);
            String[] ar =res.getStringArray(R.array.Arenas);
            int i=0;
            int[] i1=new int[8], i2=new int[8],i3=new int[8],i4=new int[8],j=new int[8];
            Location l=null;
            i1[0]=R.drawable.camp_scene;
            i1[1]=R.drawable.camp_scene1;
            i1[2]=R.drawable.camp_scene2;
            i1[3]=R.drawable.camp_scene3;
            i1[4]=R.drawable.camp_scene4;
            j[0]=R.drawable.store_b;
            j[1]=R.drawable.store_s;
            j[2]=R.drawable.store_g;
            j[3]=R.drawable.store_a;
            j[4]=R.drawable.store_r;
            switch(str){
                case("Britain"):
                    //location specific drawables go here
                    //i1=camp
                    //i2=weapons
                    //i3=armor
                    //i4=transport
                    i2[0]=R.drawable.trident1;
                    i2[1]=R.drawable.axe1;
                    i2[2]=R.drawable.two_handed1;
                    i2[3]=R.drawable.sword1;
                    i2[4]=R.drawable.spear1;
                    i2[5]=R.drawable.knife1;
                    i2[6]=R.drawable.bow1;
                    i2[7]=R.drawable.special1;


                    i3[0]=R.drawable.light1;
                    i3[1]=R.drawable.heavy1;
                    i3[2]=R.drawable.medium1;
                    i3[3]=R.drawable.large1;
                    i3[4]=R.drawable.small1;
                    i3[5]=R.drawable.helm1;

                    i4[0]=R.drawable.shoe1;
                    i4[1]=R.drawable.cart1;
                    i4[2]=R.drawable.horse1;
                    i4[3]=R.drawable.large1;//chariot1;
                    i4[4]=R.drawable.large1;//ship1;

                    /*AllLocs.set(i,*/l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 8, (i + 1) * 8),
                            Arrays.copyOfRange(a, i * 6, (i + 1) * 6),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(ar, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4,
                            j[i]);
                    Global.loc=l;
                    break;
                case("Spain"):
                    i=1;
                    i2[0]=R.drawable.trident2;
                    i2[1]=R.drawable.sword2;
                    i2[2]=R.drawable.axe2;
                    i2[3]=R.drawable.two_handed1;
                    i2[4]=R.drawable.spear2;
                    i2[5]=R.drawable.knife2;
                    i2[6]=R.drawable.bow2;
                    i2[7]=R.drawable.special2;

                    i3[0]=R.drawable.light2;
                    i3[1]=R.drawable.heavy2;
                    i3[2]=R.drawable.medium2;
                    i3[3]=R.drawable.large2;
                    i3[4]=R.drawable.small2;
                    i3[5]=R.drawable.helm2;

                    i4[0]=R.drawable.shoe2;
                    i4[1]=R.drawable.cart2;
                    i4[2]=R.drawable.horse2;
                    i4[3]=R.drawable.large1;//chariot1;
                    i4[4]=R.drawable.large1;//ship1;

                    /*AllLocs.set(i,*/l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 8, (i + 1) * 8),
                            Arrays.copyOfRange(a, i * 6, (i + 1) * 6),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(ar, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4,
                            j[i]);
                    Global.loc=l;
                    break;
                case("Germany"):
                    i=2;
                    i2[0]=R.drawable.trident1;
                    i2[1]=R.drawable.sword1;
                    i2[2]=R.drawable.axe1;
                    i2[3]=R.drawable.two_handed1;
                    i2[4]=R.drawable.spear1;
                    i2[5]=R.drawable.knife1;
                    i2[6]=R.drawable.bow1;
                    i2[7]=R.drawable.special1;

                    i3[0]=R.drawable.light1;
                    i3[1]=R.drawable.heavy1;
                    i3[2]=R.drawable.medium1;
                    i3[3]=R.drawable.large1;
                    i3[4]=R.drawable.small1;
                    i3[5]=R.drawable.helm1;

                    i4[0]=R.drawable.shoe1;
                    i4[1]=R.drawable.cart1;
                    i4[2]=R.drawable.large1;//horse1;
                    i4[3]=R.drawable.large1;//chariot1;
                    i4[4]=R.drawable.large1;//ship1;

                    /*AllLocs.set(i,*/l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 8, (i + 1) * 8),
                            Arrays.copyOfRange(a, i * 6, (i + 1) * 6),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(ar, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4,
                            j[i]);
                    Global.loc=l;
                    break;
                case("Africa"):
                    i=3;
                    i2[0]=R.drawable.trident1;
                    i2[1]=R.drawable.sword1;
                    i2[2]=R.drawable.axe1;
                    i2[3]=R.drawable.two_handed1;
                    i2[4]=R.drawable.spear1;
                    i2[5]=R.drawable.knife1;
                    i2[6]=R.drawable.bow1;
                    i2[7]=R.drawable.special1;

                    i3[0]=R.drawable.light1;
                    i3[1]=R.drawable.heavy1;
                    i3[2]=R.drawable.medium1;
                    i3[3]=R.drawable.large1;
                    i3[4]=R.drawable.small1;
                    i3[5]=R.drawable.helm1;

                    i4[0]=R.drawable.shoe1;
                    i4[1]=R.drawable.cart1;
                    i4[2]=R.drawable.large1;//horse1;
                    i4[3]=R.drawable.large1;//chariot1;
                    i4[4]=R.drawable.large1;//ship1;

                    /*AllLocs.set(i,*/l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 8, (i + 1) * 8),
                            Arrays.copyOfRange(a, i * 6, (i + 1) * 6),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(ar, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4,
                            j[i]);
                    Global.loc=l;
                    break;
                case("Italy"):
                    i=4;
                    i2[0]=R.drawable.trident1;
                    i2[1]=R.drawable.sword1;
                    i2[2]=R.drawable.axe1;
                    i2[3]=R.drawable.two_handed1;
                    i2[4]=R.drawable.spear1;
                    i2[5]=R.drawable.knife1;
                    i2[6]=R.drawable.bow1;
                    i2[7]=R.drawable.special1;

                    i3[0]=R.drawable.light1;
                    i3[1]=R.drawable.heavy1;
                    i3[2]=R.drawable.medium1;
                    i3[3]=R.drawable.large1;
                    i3[4]=R.drawable.small1;
                    i3[5]=R.drawable.helm1;

                    i4[0]=R.drawable.shoe1;
                    i4[1]=R.drawable.cart1;
                    i4[2]=R.drawable.large1;//horse1;
                    i4[3]=R.drawable.large1;//chariot1;
                    i4[4]=R.drawable.large1;//ship1;

                    /*AllLocs.set(i,*/l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 8, (i + 1) * 8),
                            Arrays.copyOfRange(a, i * 6, (i + 1) * 6),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(ar, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4,
                            j[i]);
                    Global.loc=l;
                    break;
                default:{Log.e("gladitor","you have not made the "+str+" level yet");}
            }
            return l;
        }

}
