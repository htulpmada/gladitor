package sikware.com.gladitor;

import android.content.Context;
import android.util.Log;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Atree.ABst;
import Ctree.CBst;
import Ttree.TBst;
import Wtree.WBst;


/**
 * Created by adam pluth on 5/3/2016.
 */
public class ItemManager implements Serializable{
    private String pFile="ItemList";
    private WBst wtest=null;
    private ABst atest=null;
    private TBst ttest=null;
    private CBst ctest=null;
    private Context context;
    //public PlayerManager(){}

    public ItemManager(Context c) {
        context=c;
        Refresh();
    }

    public void Refresh(){
        Global.wList=Wread();
        Global.aList=Aread();
        Global.tList=Tread();
        Global.cList=Cread();
    }

    public void AddW(Weapon w){
        Global.wList.ins(w);
        Close();
    }
    public void AddA(Armor a){
        Global.aList.ins(a);
        Close();
    }
    public void AddT(Transport t){
        Global.tList.ins(t);
        Close();
    }
    public void AddC(Charm c){
        Global.cList.ins(c);
        Close();
    }

    public void Reset(){
        Global.wList=(null);
        Global.aList=(null);
        Global.tList=(null);
        Global.cList=(null);
        Close();
    }

    public void Close(){
        wtest=Global.wList;
        atest=Global.aList;
        ttest=Global.tList;
        ctest=Global.cList;
        Wwrite(wtest);
        Awrite(atest);
        Twrite(ttest);
        Cwrite(ctest);

    }

    public WBst Wread(){
        WBst aplr = null;
        try{
            FileInputStream fileInm = new FileInputStream(context.getApplicationContext().getFilesDir()+"/"+pFile+".gld");
            ObjectInputStream inm = new ObjectInputStream(fileInm);
            try {
                aplr = (WBst) inm.readObject();
                Log.d("gladitor", "Read item: " + aplr);
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
            return aplr;
        }
        catch(IOException i){
            i.printStackTrace();
            return aplr;
        }
        catch(ClassNotFoundException c){
            //System.out.println("Account Class Not Found!");
            c.printStackTrace();
            return aplr;
        }
    }

    public void Wwrite(WBst test){
        try{
            FileOutputStream fileOut = new FileOutputStream(context.getApplicationContext().getFilesDir()+"/"+pFile+".gld");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(test);
            out.close();
            fileOut.close();
            Log.d("gladitor","Serialized to: "+context.getApplicationContext().getFilesDir()+"/"+pFile+".gld");
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }

    public ABst Aread(){
        ABst aplr = null;
        try{
            FileInputStream fileInm = new FileInputStream(context.getApplicationContext().getFilesDir()+"/"+pFile+".gld");
            ObjectInputStream inm = new ObjectInputStream(fileInm);
            try {
                aplr = (ABst) inm.readObject();
                Log.d("gladitor", "Read item: " + aplr);
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
            return aplr;
        }
        catch(IOException i){
            i.printStackTrace();
            return aplr;
        }
        catch(ClassNotFoundException c){
            //System.out.println("Account Class Not Found!");
            c.printStackTrace();
            return aplr;
        }
    }

    public void Awrite(ABst test){
        try{
            FileOutputStream fileOut = new FileOutputStream(context.getApplicationContext().getFilesDir()+"/"+pFile+".gld");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(test);
            out.close();
            fileOut.close();
            Log.d("gladitor","Serialized to: "+context.getApplicationContext().getFilesDir()+"/"+pFile+".gld");
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }
    public TBst Tread(){
        TBst aplr = null;
        try{
            FileInputStream fileInm = new FileInputStream(context.getApplicationContext().getFilesDir()+"/"+pFile+".gld");
            ObjectInputStream inm = new ObjectInputStream(fileInm);
            try {
                aplr = (TBst) inm.readObject();
                Log.d("gladitor", "Read item: " + aplr);
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
            return aplr;
        }
        catch(IOException i){
            i.printStackTrace();
            return aplr;
        }
        catch(ClassNotFoundException c){
            //System.out.println("Account Class Not Found!");
            c.printStackTrace();
            return aplr;
        }
    }

    public void Twrite(TBst test){
        try{
            FileOutputStream fileOut = new FileOutputStream(context.getApplicationContext().getFilesDir()+"/"+pFile+".gld");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(test);
            out.close();
            fileOut.close();
            Log.d("gladitor","Serialized to: "+context.getApplicationContext().getFilesDir()+"/"+pFile+".gld");
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }
    public CBst Cread(){
        CBst aplr = null;
        try{
            FileInputStream fileInm = new FileInputStream(context.getApplicationContext().getFilesDir()+"/"+pFile+".gld");
            ObjectInputStream inm = new ObjectInputStream(fileInm);
            try {
                aplr = (CBst) inm.readObject();
                Log.d("gladitor", "Read item: " + aplr);
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
            return aplr;
        }
        catch(IOException i){
            i.printStackTrace();
            return aplr;
        }
        catch(ClassNotFoundException c){
            //System.out.println("Account Class Not Found!");
            c.printStackTrace();
            return aplr;
        }
    }

    public void Cwrite(CBst test){
        try{
            FileOutputStream fileOut = new FileOutputStream(context.getApplicationContext().getFilesDir()+"/"+pFile+".gld");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(test);
            out.close();
            fileOut.close();
            Log.d("gladitor","Serialized to: "+context.getApplicationContext().getFilesDir()+"/"+pFile+".gld");
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }

}
