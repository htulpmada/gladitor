package sikware.com.gladitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void Quit(View view){
        PlayerManager pman = new PlayerManager(this);
        p1=Global.p1;
        pman.Add(p1);
        finish();
        System.exit(0);
    }

    public void Shop(View view){
        Intent shop = new Intent(this,Store.class);
        startActivity(shop);
    }

    public void Stuff(View view){
        Intent stuff = new Intent(this,Equip.class);
        startActivity(stuff);
    }

    public void Map(View view){
        Intent stuff = new Intent(this,Map.class);
        startActivity(stuff);
    }

    public void Self(View view){
        Intent self = new Intent(this,AboutPlayer.class);
        startActivity(self);
    }

    public void Fight(View view){
        Intent fight = new Intent(this,Fight.class);
        startActivity(fight);
    }

}
