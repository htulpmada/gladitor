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
        TextView hp=(TextView)findViewById(R.id.hp);
        TextView dam=(TextView)findViewById(R.id.damage);
        TextView arm=(TextView)findViewById(R.id.armor);
        p1=Global.p1;
        p1.show();
        hp.setText("Health:  " + p1.Hp);
        dam.setText("Damage: " + p1.weapon.power + p1.str);
        arm.setText("Armor:  " + p1.armor.power + p1.agl);



    }
    protected void onResume(Bundle savedInstanceState) {
        super.onResume();
        setContentView(R.layout.activity_camp);
        TextView hp=(TextView)findViewById(R.id.hp);
        TextView dam=(TextView)findViewById(R.id.damage);
        TextView arm=(TextView)findViewById(R.id.armor);
        p1=Global.p1;
        hp.setText("Health:  " + p1.Hp);
        dam.setText("Damage: " + p1.weapon.power + p1.str);
        arm.setText("Armor:  "+p1.armor.power+p1.agl);

    }
    @Override
    public void onBackPressed(){return;}

    public void Quit(View view){
        Global.pman.Close();
        Intent quit = new Intent(this,StartScreen.class);
        quit.addFlags(getIntent().FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(quit);
    }

    public void Shop(View view){
        Intent shop = new Intent(this,Store.class);
        startActivity(shop);
        //Global.pman.Close();
    }

    public void Stuff(View view){
        Intent stuff = new Intent(this,Equip.class);
        startActivity(stuff);
        //Global.pman.Close();
    }

    public void Map(View view){
        Intent stuff = new Intent(this,Map.class);
        startActivity(stuff);
        //Global.pman.Close();
    }

    public void Self(View view){
        Intent self = new Intent(this,AboutPlayer.class);
        startActivity(self);
        //Global.pman.Close();
    }

    public void Fight(View view){
        Intent fight = new Intent(this,Fight.class);
        startActivity(fight);
        //Global.pman.Close();
    }

}
