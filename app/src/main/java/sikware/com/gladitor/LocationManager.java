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
        public static ArrayList<Location> AllLocs;
        private Location ltest;
        private Context context;

        public LocationManager(Context c) {
            context=c;
            Reset();
        }

        public void get(int i){if(i!=-1){Global.loc=AllLocs.get(i);}}

        public Integer getIndex(String s){
            for(int i=0;i<AllLocs.size();i++){
                if(AllLocs.get(i).name.equals(s)){curr=i;return i;}
            }
            return -1;
        }

        public void Refresh(){
            Global.loc=read().get(curr);
        }

        public void Add(Location l){
            AllLocs.add(l);
        }

        public void Reset(){
            Resources res = context.getResources();
            String[] s =res.getStringArray(R.array.StartingLocation);
            String[] w =res.getStringArray(R.array.Weapons);
            String[] a =res.getStringArray(R.array.Armor);
            String[] m =res.getStringArray(R.array.Movers);
            AllLocs=new ArrayList<Location>();
            //must be 5 locations each with
            //5 weapons 5 armor and 3 transports
            for(int i=0;i<s.length;i++){
                AllLocs.add(new Location(s[i],
                        Arrays.copyOfRange(w,i*5,(i+1)*5),
                        Arrays.copyOfRange(a,i*5,(i+1)*5),
                        Arrays.copyOfRange(m,i*3,(i+1)*3)));
            }
            AllLocs.get(0).campScence=(R.drawable.camp_scene);
            AllLocs.get(1).campScence=(R.drawable.camp_scene1);//1;
            AllLocs.get(2).campScence=(R.drawable.camp_scene1);//2;
            AllLocs.get(3).campScence=(R.drawable.camp_scene1);//3;
            AllLocs.get(4).campScence=(R.drawable.camp_scene1);//4;
            Close();
        }

        public void Close(){
            write();
        }

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

        public void write(){
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
        }


}
