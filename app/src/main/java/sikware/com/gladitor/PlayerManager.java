package sikware.com.gladitor;

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
    private Player ptest=new Player();

    public PlayerManager(){}

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
        Player aplr=new Player();
        try{
            FileInputStream fileInm = new FileInputStream(pFile);
            ObjectInputStream inm = new ObjectInputStream(fileInm);
            try {
                aplr = (Player) inm.readObject();
                show();
                Log.d("gladitor", "Read Plr: " + aplr);
            }
            catch(EOFException e){
                inm.close();
                fileInm.close();
            }
            catch(NullPointerException n){
                //System.out.println("Reading : "+"null");

            }
            return aplr;
        }
        catch(IOException i){
            //i.printStackTrace();
            return aplr;
        }
        catch(ClassNotFoundException c){
            //System.out.println("Account Class Not Found!");
            //c.printStackTrace();
            return aplr;
        }
    }

    public void write(Player ptest){
        try{
            FileOutputStream fileOut = new FileOutputStream(pFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(ptest);
            out.close();
            fileOut.close();
            System.out.println("Serialized to: "+pFile);
        }
        catch(IOException i){}
    }

    public void show(){
        System.out.println("Read Player: "+ptest);
    }


}