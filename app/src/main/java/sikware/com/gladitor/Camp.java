package sikware.com.gladitor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class Camp extends AppCompatActivity {
    Player p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p1=Global.p1;
        setContentView(R.layout.activity_camp);
        TextView hp=(TextView)findViewById(R.id.hp);
        TextView dam=(TextView)findViewById(R.id.damage);
        TextView arm=(TextView)findViewById(R.id.armor);
        TextView gold=(TextView)findViewById(R.id.Gold);
        hp.setText("Health:  " + p1.Hp);
        gold.setText("Denarii:  " + p1.Denarius);
        dam.setText("Damage: " + p1.weapon.power + p1.str);
        arm.setText("Armor:  " + p1.armor.power + p1.agl);
        p1.show();



    }
    protected void onResume(Bundle savedInstanceState) {
        super.onResume();
        p1=Global.p1;
        setContentView(R.layout.activity_camp);
        TextView hp=(TextView)findViewById(R.id.hp);
        TextView dam=(TextView)findViewById(R.id.damage);
        TextView arm=(TextView)findViewById(R.id.armor);
        hp.setText("Health:  " + p1.Hp);
        dam.setText("Damage: " + p1.weapon.power + p1.str);
        arm.setText("Armor:  " + p1.armor.power + p1.agl);
        p1.show();

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
