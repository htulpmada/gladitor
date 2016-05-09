package sikware.com.gladitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Camp extends AppCompatActivity {
    Player p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp);
        p1=Global.p1;
    }
    protected void onResume(Bundle savedInstanceState) {
        super.onResume();
        setContentView(R.layout.activity_camp);
        p1=Global.p1;
    }
    @Override
    public void onBackPressed(){return;}

    public void Quit(){
        PlayerManager pman = new PlayerManager();
        p1=Global.p1;
        pman.Add(p1);
        Intent quit = new Intent(this,StartScreen.class);
        startActivity(quit);
    }

    public void Shop(){
        Intent shop = new Intent(this,Store.class);
        startActivity(shop);
    }

    public void Stuff(){
        Intent stuff = new Intent(this,Equip.class);
        startActivity(stuff);
    }

    public void Map(){
        Intent stuff = new Intent(this,Map.class);
        startActivity(stuff);
    }

    public void Self(){
        Intent self = new Intent(this,AboutPlayer.class);
        startActivity(self);
    }

    public void Fight(){
        Intent fight = new Intent(this,AboutPlayer.class);
        startActivity(fight);
    }


}
