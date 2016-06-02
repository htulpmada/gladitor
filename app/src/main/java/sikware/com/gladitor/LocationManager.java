package sikware.com.gladitor;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;

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
        public static ArrayList<Location> AllLocs=new ArrayList<Location>(6);//TODO change to 5 maybe will save MEMORY might double capacity
        private Location ltest=null;
        private Context context;

        public LocationManager(Context c) {
            AllLocs.add(ltest);
            AllLocs.add(ltest);
            AllLocs.add(ltest);
            AllLocs.add(ltest);
            AllLocs.add(ltest);
            context=c;
        }

        public void get(int i){if(i!=-1){Global.loc=AllLocs.get(i);}}

        public Integer getIndex(String s){
            for(int i=0;i<AllLocs.size();i++){
                if(AllLocs.get(i).name.equals(s)){curr=i;return i;}
            }
            return -1;
        }

        public Location makeLocation(String str){
            Resources res = context.getResources();
            String[] s =res.getStringArray(R.array.StartingLocation);
            String[] w =res.getStringArray(R.array.Weapons);
            String[] a =res.getStringArray(R.array.Armor);
            String[] m =res.getStringArray(R.array.Movers);
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
                case("Britian"):
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

                    i4[0]=R.drawable.shoe1;//shoes
                    i4[1]=R.drawable.cart1;//cart
                    i4[2]=R.drawable.horse1;//horse
                    i4[3]=R.drawable.chariot1;//charoit
                    i4[4]=R.drawable.ship1;//ship

                    AllLocs.set(i,l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 8, (i + 1) * 8),
                            Arrays.copyOfRange(a, i * 6, (i + 1) * 6),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4,
                            j[i]));
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

                    i4[0]=R.drawable.shoe2;//shoes
                    i4[1]=R.drawable.cart2;//cart
                    i4[2]=R.drawable.horse2;//horse
                    i4[3]=R.drawable.chariot2;//charoit
                    i4[4]=R.drawable.ship2;//ship

                    AllLocs.set(i,l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 8, (i + 1) * 8),
                            Arrays.copyOfRange(a, i * 6, (i + 1) * 6),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4,
                            j[i]));
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

                    i4[0]=R.drawable.shoe1;//shoes
                    i4[1]=R.drawable.cart1;//cart
                    i4[2]=R.drawable.horse1;//horse
                    i4[3]=R.drawable.chariot1;//charoit
                    i4[4]=R.drawable.ship1;//ship

                    AllLocs.set(i,l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 8, (i + 1) * 8),
                            Arrays.copyOfRange(a, i * 6, (i + 1) * 6),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4,
                            j[i]));
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

                    i4[0]=R.drawable.shoe1;//shoes
                    i4[1]=R.drawable.cart1;//cart
                    i4[2]=R.drawable.horse1;//horse
                    i4[3]=R.drawable.chariot1;//charoit
                    i4[4]=R.drawable.ship1;//ship

                    AllLocs.set(i,l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 8, (i + 1) * 8),
                            Arrays.copyOfRange(a, i * 6, (i + 1) * 6),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4,
                            j[i]));
                    Global.loc=l;
                    break;
                case("Tuscany"):
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

                    i4[0]=R.drawable.shoe1;//shoes
                    i4[1]=R.drawable.cart1;//cart
                    i4[2]=R.drawable.horse1;//horse
                    i4[3]=R.drawable.chariot1;//charoit
                    i4[4]=R.drawable.ship1;//ship

                    AllLocs.set(i,l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 8, (i + 1) * 8),
                            Arrays.copyOfRange(a, i * 6, (i + 1) * 6),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4,
                            j[i]));
                    Global.loc=l;
                    break;
                default:{Log.e("gladitor","you have not made this level yet");}
            }
            return l;
        }

}
