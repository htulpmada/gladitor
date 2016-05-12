package sikware.com.gladitor;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by adam pluth on 5/3/2016.
 */
public class PlayerManager implements Serializable{
    private String pFile="PlayerList";
    private Player ptest;
    private Context context;
    //public PlayerManager(){}

    public PlayerManager(Context c) {
        context=c;
    }

    public void Refresh(){
        Global.p1=read();
    }

    public void Add(Player p){
        Global.p1=p;
        Close();
    }

    public void Reset(){
        ptest=null;
        Global.p1=(ptest);
        Close();
    }

    public void Close(){
        ptest=Global.p1;
        write(ptest);
    }

    public Player read(){
        Player aplr = null;
        try{
            FileInputStream fileInm = new FileInputStream(context.getApplicationContext().getFilesDir()+"/player.gld");
            ObjectInputStream inm = new ObjectInputStream(fileInm);
            try {
                aplr = (Player) inm.readObject();
                show(aplr);
                aplr.show();
                Log.d("gladitor", "Read Plr: " + aplr);
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

    public void write(Player ptest){
        try{
            FileOutputStream fileOut = new FileOutputStream(context.getApplicationContext().getFilesDir()+"/player.gld");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(ptest);
            out.close();
            fileOut.close();
            Log.d("gladitor","Serialized to: "+context.getApplicationContext().getFilesDir()+"/player.gld");
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }

    public void show(Player p){
        Log.e("gladitor","Read Player: "+p);
    }


}
