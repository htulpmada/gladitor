package sikware.com.gladitor;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by adam pluth on 5/3/2016.
 */
public class PlayerManager {
    ArrayList<Player> pList;
    private String pFile="PlayerList";
    private Player ptest;

    public PlayerManager(){}




    public void Reset(){
        pList=new ArrayList<Player>();
        pList.add(ptest);
        Close();
    }

    public void Close(){
        write(pList);
    }

    public ArrayList<Player> read(ArrayList<Player> plr){
        ArrayList<Player> aplr=plr;
        try{
            FileInputStream fileInm = new FileInputStream(pFile);
            ObjectInputStream inm = new ObjectInputStream(fileInm);
            try{
                aplr=(ArrayList<Player>)inm.readObject();
                for(Player p : pList){
                    System.out.println("Read Plr: "+p.Name);
                }
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

    public void write(ArrayList<Player> ptest){
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
    public Player findPlayer(String name){
        for(Player a : pList){
            String i=a.Name;
            if(i.equals(name)){return a;}
        }
        return null;
    }
    public void show(){
        for(Player p : pList){
            System.out.println("Read Player: "+p.Name);
        }
    }


}
