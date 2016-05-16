package sikware.com.gladitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Store extends AppCompatActivity {
    Player p;
    //Item i;
    Item i=new Item();
    Weapon w;
    Armor a;
    Transport t;
    TextView money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        p=Global.p1;
        TextView money=(TextView)findViewById(R.id.gold);
        money.setText("Denarii: "+p.Denarius);
    }

    @Override
    public void onBackPressed(){
        Global.pman.Add(p);
        Intent quit = new Intent(this,Camp.class);
        quit.addFlags(getIntent().FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(quit);
    }

    public void onBackPressed(View view){
        Global.pman.Add(p);
        Intent quit = new Intent(this,Camp.class);
        quit.addFlags(getIntent().FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(quit);
    }
    public void buy(View view){
        TextView money=(TextView)findViewById(R.id.gold);
        if(i.price>p.Denarius){money.setText("sorry not enough monies");return;}
        else{
            p.Denarius=p.Denarius-i.price;
            money.setText("Denarii: "+p.Denarius);
        }
        money.setText("Denarii: "+p.Denarius);
        switch(i.getClass().getName()){
            case("Weapon"):
                p.Hurter.add((Weapon) i);
                money.setText("Purchased");
                break;
            case("Armor"):
                p.OwBeGone.add((Armor) i);
                money.setText("Purchased");
                break;
            case("Transport"):
                p.Goers.add((Transport) i);
                money.setText("Purchased");
                break;
            default:
                Log.e("gladitor","nothing selected");
                break;
        }
        //Global.pman.Close();
    }


}
