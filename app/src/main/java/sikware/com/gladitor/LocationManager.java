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
public class LocationManager implements Serializable {
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
            int[] i1=new int[5], i2=new int[5],i3=new int[5],i4=new int[5];
            Location l=null;
            i1[0]=R.drawable.camp_scene;
            i1[1]=R.drawable.camp_scene1;
            i1[2]=R.drawable.camp_scene2;
            i1[3]=R.drawable.camp_scene3;
            i1[4]=R.drawable.camp_scene4;
            switch(str){
                case("Britian"):
                    //location specific drawables go here
                    //i1=camp
                    //i2=weapons
                    //i3=armor
                    //i4=transport
                    i2[0]=R.drawable.trident1;
                    i2[1]=R.drawable.sword1;
                    i2[2]=R.drawable.axe1;
                    i2[3]=R.drawable.two_handed1;
                    i2[4]=R.drawable.spear1;

                    i3[0]=R.drawable.trident1;
                    i3[1]=R.drawable.sword1;
                    i3[2]=R.drawable.axe1;
                    i3[3]=R.drawable.two_handed1;
                    i3[4]=R.drawable.spear1;

                    i4[0]=R.drawable.trident1;
                    i4[1]=R.drawable.sword1;
                    i4[2]=R.drawable.axe1;
                    i4[3]=R.drawable.two_handed1;
                    i4[4]=R.drawable.spear1;

                    AllLocs.set(i,l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(a, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4));
                    Global.loc=l;
                    break;
                case("Spain"):
                    i=1;
                    i2[0]=R.drawable.trident2;
                    i2[1]=R.drawable.sword2;
                    i2[2]=R.drawable.axe2;
                    i2[3]=R.drawable.two_handed1;
                    i2[4]=R.drawable.spear2;

                    i3[0]=R.drawable.trident1;
                    i3[1]=R.drawable.sword1;
                    i3[2]=R.drawable.axe1;
                    i3[3]=R.drawable.two_handed1;
                    i3[4]=R.drawable.spear1;

                    i4[0]=R.drawable.trident1;
                    i4[1]=R.drawable.sword1;
                    i4[2]=R.drawable.axe1;
                    i4[3]=R.drawable.two_handed1;
                    i4[4]=R.drawable.spear1;

                    AllLocs.set(i,l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(a, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4));
                    Global.loc=l;
                    break;
                case("Germany"):
                    i=2;
                    i2[0]=R.drawable.trident1;
                    i2[1]=R.drawable.sword1;
                    i2[2]=R.drawable.axe1;
                    i2[3]=R.drawable.two_handed1;
                    i2[4]=R.drawable.spear1;

                    i3[0]=R.drawable.trident1;
                    i3[1]=R.drawable.sword1;
                    i3[2]=R.drawable.axe1;
                    i3[3]=R.drawable.two_handed1;
                    i3[4]=R.drawable.spear1;

                    i4[0]=R.drawable.trident1;
                    i4[1]=R.drawable.sword1;
                    i4[2]=R.drawable.axe1;
                    i4[3]=R.drawable.two_handed1;
                    i4[4]=R.drawable.spear1;

                    AllLocs.set(i,l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(a, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4));
                    Global.loc=l;
                    break;
                case("Africa"):
                    i=3;
                    i2[0]=R.drawable.trident1;
                    i2[1]=R.drawable.sword1;
                    i2[2]=R.drawable.axe1;
                    i2[3]=R.drawable.two_handed1;
                    i2[4]=R.drawable.spear1;

                    i3[0]=R.drawable.trident1;
                    i3[1]=R.drawable.sword1;
                    i3[2]=R.drawable.axe1;
                    i3[3]=R.drawable.two_handed1;
                    i3[4]=R.drawable.spear1;

                    i4[0]=R.drawable.trident1;
                    i4[1]=R.drawable.sword1;
                    i4[2]=R.drawable.axe1;
                    i4[3]=R.drawable.two_handed1;
                    i4[4]=R.drawable.spear1;

                    AllLocs.set(i,l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(a, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4));
                    Global.loc=l;
                    break;
                case("Tuscany"):
                    i=4;
                    i2[0]=R.drawable.trident1;
                    i2[1]=R.drawable.sword1;
                    i2[2]=R.drawable.axe1;
                    i2[3]=R.drawable.two_handed1;
                    i2[4]=R.drawable.spear1;

                    i3[0]=R.drawable.trident1;
                    i3[1]=R.drawable.sword1;
                    i3[2]=R.drawable.axe1;
                    i3[3]=R.drawable.two_handed1;
                    i3[4]=R.drawable.spear1;

                    i4[0]=R.drawable.trident1;
                    i4[1]=R.drawable.sword1;
                    i4[2]=R.drawable.axe1;
                    i4[3]=R.drawable.two_handed1;
                    i4[4]=R.drawable.spear1;

                    AllLocs.set(i,l=new Location(s[i],
                            Arrays.copyOfRange(w, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(a, i * 5, (i + 1) * 5),
                            Arrays.copyOfRange(m, i * 5, (i + 1) * 5),
                            i1[i],
                            i2,
                            i3,
                            i4));
                    Global.loc=l;
                    break;
                default:{Log.e("gladitor","you have not made this level yet");}
            }
            return l;
        }

       // public void Close(){write();}

        public ArrayList<Location> read(){
            ArrayList<Location> lo = null;
            try{
                FileInputStream fileInm = new FileInputStream(context.getApplicationContext().getFilesDir()+"/locations.gld");
                ObjectInputStream inm = new ObjectInputStream(fileInm);
                try {
                    lo = (ArrayList<Location>) inm.readObject();
                    Log.d("gladitor", "Read "+lo.size()+" Location(s)");
                }
                catch(EOFException e){
                    e.printStackTrace();
                    Log.d("gladitor", "");
                    inm.close();
                    fileInm.close();
                }
                catch(NullPointerException n){
                    //System.out.println("Reading : "+"null");
                    n.printStackTrace();

                }
                return lo;
            }
            catch(IOException i){
                i.printStackTrace();
                return lo;
            }
            catch(ClassNotFoundException c){
                //System.out.println("Account Class Not Found!");
                c.printStackTrace();
                return lo;
            }
        }

        /*public void write(){
            try{
                FileOutputStream fileOut = new FileOutputStream(context.getApplicationContext().getFilesDir()+"/locations.gld");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(AllLocs);
                out.close();
                fileOut.close();
                Log.d("gladitor","Serialized to: "+context.getApplicationContext().getFilesDir()+"/locations.gld");
            }
            catch(IOException i){
                i.printStackTrace();
            }
        }*/


}
