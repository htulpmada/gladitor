package sikware.com.gladitor;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
    }
    protected void onResume(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        p=Global.p1;
        TextView money=(TextView)findViewById(R.id.gold);
        money.setText("Denarii: " + p.Denarius);
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
        ImageView arw=(ImageView)findViewById(R.id.arrow);
        tri.setBackground(null);
        ax.setBackground(null);
        two.setBackground(null);
        swd.setBackground(null);
        spr.setBackground(null);
        knf.setBackground(null);
        spe.setBackground(null);
        bow.setBackground(null);
        arw.setBackground(null);
    }

    public void highlightTri(View view) {
        clearBacks();
        ImageView tri=(ImageView)findViewById(R.id.trident);
        tri.setBackground(getDrawable(R.drawable.outline));
        i = new Item("trident;5;0;w;1000;R.drawable.trident1");
    }
    public void highlightAx(View view) {
        clearBacks();
        ImageView ax=(ImageView)findViewById(R.id.axe);
        ax.setBackground(getDrawable(R.drawable.outline));
        i = new Item("axe;3;0;w;200;R.drawable.axe1");
    }
    public void highlightTwo(View view) {
        clearBacks();
        ImageView two = (ImageView) findViewById(R.id.twoHanded);
        two.setBackground(getDrawable(R.drawable.outline));
        i = new Item("two hand;4;0;w;500;R.drawable.twoHand1");
    }
    public void highlightSwd(View view) {
        clearBacks();
        ImageView swd = (ImageView) findViewById(R.id.sword);
        swd.setBackground(getDrawable(R.drawable.outline));
        i = new Item("sword;2;1;w;300;R.drawable.sword1");
    }
    public void highlightSpr(View view) {
        clearBacks();
        ImageView spr = (ImageView) findViewById(R.id.spear);
        spr.setBackground(getDrawable(R.drawable.outline));
        i = new Item("spear;4;1;w;400;R.drawable.spear1");
    }
    public void highlightKnf(View view) {
        clearBacks();
        ImageView knf = (ImageView) findViewById(R.id.knife);
        knf.setBackground(getDrawable(R.drawable.outline));
        i = new Item("knife;1;3;w;100;knife1");
    }
    public void highlightSpe(View view) {
        clearBacks();
        ImageView spe = (ImageView) findViewById(R.id.special);
        spe.setBackground(getDrawable(R.drawable.outline));
        i = new Item("net;3;0;w;600;R.drawable.special1");
    }
    public void highlightBow(View view) {
        clearBacks();
        ImageView bow = (ImageView) findViewById(R.id.bow);
        bow.setBackground(getDrawable(R.drawable.outline));
        i = new Item("bow;2;2;w;400;R.drawable.bow1");
    }
    public void highlightArw(View view) {
        clearBacks();
        ImageView arw=(ImageView)findViewById(R.id.arrow);
        arw.setBackground(getDrawable(R.drawable.outline));
        i=new Item("arrow;1;1;w;100;R.drawable.arrow1");
    }
    //TODO add armor and transports, also add to cleaBacks()
/*    public void highlightAx(View view) {
        clearBacks();
        ImageView ax=(ImageView)findViewById(R.id.axe);
        case(R.id.sheilds):
                switch(view.getId()){
                    case(R.id.small):
                    case(R.id.medium):
                    case(R.id.large):
                }
            case(R.id.arms):
                switch(view.getId()){
                    case(R.id.head):
                    case(R.id.chest):
                    case(R.id.gloves):
                    case(R.id.legs):
                    case(R.id.pants):
                    case(R.id.feet):
                    case(R.id.bracer):
                    case(R.id.shoulder):
                }
        }
    }
*/
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
                p.Stuff.add(i);
                money.setText("Purchased for "+i.price);
                break;
            case("a"):
                p.Stuff.add(i);
                money.setText("Purchased for "+i.price);
                break;
            case("t"):
                p.Stuff.add(i);
                money.setText("Purchased for "+i.price);
                break;
            default:
                Log.e("gladitor","nothing selected");
                break;
        }
    }

}
