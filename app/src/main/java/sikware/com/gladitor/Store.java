package sikware.com.gladitor;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Store extends AppCompatActivity {
    Player p;
    Item i;
    TextView money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        p=Global.p1;
        TextView money=(TextView)findViewById(R.id.gold);
        money.setText("Denarii: " + p.Denarius);
        setPics();
    }
    protected void onResume(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        p=Global.p1;
        TextView money=(TextView)findViewById(R.id.gold);
        money.setText("Denarii: " + p.Denarius);
        setPics();
    }

    public void onBackPressed(View view){
        return;
    }

    private void setPics() {
        RelativeLayout  back = (RelativeLayout) findViewById(R.id.back);
        back.setBackgroundResource(Global.loc.storeScene);
        ImageView tri=(ImageView)findViewById(R.id.trident);
        ImageView ax=(ImageView)findViewById(R.id.axe);
        ImageView two=(ImageView)findViewById(R.id.twoHanded);
        ImageView swd=(ImageView)findViewById(R.id.sword);
        ImageView spr=(ImageView)findViewById(R.id.spear);
        ImageView knf=(ImageView)findViewById(R.id.knife);
        ImageView spe=(ImageView)findViewById(R.id.special);
        ImageView bow=(ImageView)findViewById(R.id.bow);
        tri.setImageResource(Global.loc.WStuffToBuy.get(0).image);
        ax.setImageResource(Global.loc.WStuffToBuy.get(1).image);
        two.setImageResource(Global.loc.WStuffToBuy.get(2).image);
        swd.setImageResource(Global.loc.WStuffToBuy.get(3).image);
        spr.setImageResource(Global.loc.WStuffToBuy.get(4).image);
        knf.setImageResource(Global.loc.WStuffToBuy.get(5).image);
        bow.setImageResource(Global.loc.WStuffToBuy.get(6).image);
        spe.setImageResource(Global.loc.WStuffToBuy.get(7).image);
        //TODO do same for armor and weapons

    }

    public void clearBacks(){
        TextView money = (TextView) findViewById(R.id.gold);
        money.setText("Denarii: " + p.Denarius);
        ImageView tri=(ImageView)findViewById(R.id.trident);
        ImageView ax=(ImageView)findViewById(R.id.axe);
        ImageView two=(ImageView)findViewById(R.id.twoHanded);
        ImageView swd=(ImageView)findViewById(R.id.sword);
        ImageView spr=(ImageView)findViewById(R.id.spear);
        ImageView knf=(ImageView)findViewById(R.id.knife);
        ImageView spe=(ImageView)findViewById(R.id.special);
        ImageView bow=(ImageView)findViewById(R.id.bow);
        //ImageView arw=(ImageView)findViewById(R.id.arrow);
        tri.setBackground(null);
        ax.setBackground(null);
        two.setBackground(null);
        swd.setBackground(null);
        spr.setBackground(null);
        knf.setBackground(null);
        spe.setBackground(null);
        bow.setBackground(null);
        //arw.setBackground(null);
    }

    public void highlightTri(View view) {
        clearBacks();
        ImageView tri=(ImageView)findViewById(R.id.trident);
        tri.setBackground(getDrawable(R.drawable.outline));
        i = Global.loc.WStuffToBuy.get(0);
        }
    public void highlightAxe(View view) {
        clearBacks();
        ImageView ax=(ImageView)findViewById(R.id.axe);
        ax.setBackground(getDrawable(R.drawable.outline));
        i = Global.loc.WStuffToBuy.get(1);
    }
    public void highlightTwo(View view) {
        clearBacks();
        ImageView two = (ImageView) findViewById(R.id.twoHanded);
        two.setBackground(getDrawable(R.drawable.outline));
        i = Global.loc.WStuffToBuy.get(2);
    }
    public void highlightSwd(View view) {
        clearBacks();
        ImageView swd = (ImageView) findViewById(R.id.sword);
        swd.setBackground(getDrawable(R.drawable.outline));
        i = Global.loc.WStuffToBuy.get(3);
    }
    public void highlightSpr(View view) {
        clearBacks();
        ImageView spr = (ImageView) findViewById(R.id.spear);
        spr.setBackground(getDrawable(R.drawable.outline));
        i = Global.loc.WStuffToBuy.get(4);
    }
    public void highlightKnf(View view) {
        clearBacks();
        ImageView knf = (ImageView) findViewById(R.id.knife);
        knf.setBackground(getDrawable(R.drawable.outline));
        i = Global.loc.WStuffToBuy.get(5);
    }
    public void highlightBow(View view) {
        clearBacks();
        ImageView bow = (ImageView) findViewById(R.id.bow);
        bow.setBackground(getDrawable(R.drawable.outline));
        i = Global.loc.WStuffToBuy.get(6);
    }
    public void highlightSpe(View view) {
        clearBacks();
        ImageView spe = (ImageView) findViewById(R.id.special);
        spe.setBackground(getDrawable(R.drawable.outline));
        i = Global.loc.WStuffToBuy.get(7);
    }

    //TODO add armor and transports, also add to cleaBacks()

    public void buy(View view){
        if(i==null){money.setText("Please make a selection");return;}
        TextView money=(TextView)findViewById(R.id.gold);
        if(i.price>p.Denarius){money.setText("sorry not enough monies");return;}
        else{
            p.Denarius=p.Denarius-i.price;
            money.setText("Denarii: "+p.Denarius);
        }
        money.setText("Denarii: "+p.Denarius);
        switch(i.type){
            case("w"):
                p.WStuff.add(i);
                money.setText("Purchased for "+i.price);
                break;
            case("a"):
                p.AStuff.add(i);
                money.setText("Purchased for "+i.price);
                break;
            case("t"):
                p.TStuff.add(i);
                money.setText("Purchased for "+i.price);
                break;
            default:
                Log.e("gladitor","nothing selected");
                break;
        }
    }

    public void giveMeStuff(View view){
        Global.p1.makeGod();
        TextView money=(TextView)findViewById(R.id.gold);
        money.setText("Denarii: " + p.Denarius);
        setPics();
    }

}
