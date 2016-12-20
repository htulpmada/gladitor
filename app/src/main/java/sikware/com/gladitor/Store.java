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
    //Player p;
    Item i;
    TextView money,bubble;
    ImageView tri, ax, two, swd, spr, knf, spe, bow, light, heavy, medium, lShld, sShld, helm, feet, cart, horse, chariot, boat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        money = (TextView) findViewById(R.id.gold);
        money.setText("Denarii: " + Global.p1.Denarius);
        setPics();
    }
    protected void onResume(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        money = (TextView) findViewById(R.id.gold);
        money.setText("Denarii: " + Global.p1.Denarius);
        setPics();
    }

    public void onBackPressed(View view){
        Global.pman.Close();
        super.onBackPressed();
    }

    private void setPics() {
        RelativeLayout  back = (RelativeLayout) findViewById(R.id.back);
        back.setBackgroundResource(Global.loc.storeScene);
        money = (TextView) findViewById(R.id.gold);
        tri=(ImageView)findViewById(R.id.trident);
        ax=(ImageView)findViewById(R.id.axe);
        two=(ImageView)findViewById(R.id.twoHanded);
        swd=(ImageView)findViewById(R.id.sword);
        spr=(ImageView)findViewById(R.id.spear);
        knf=(ImageView)findViewById(R.id.knife);
        spe=(ImageView)findViewById(R.id.special);
        bow=(ImageView)findViewById(R.id.bow);
        light=(ImageView)findViewById(R.id.light);
        heavy=(ImageView)findViewById(R.id.heavy);
        medium=(ImageView)findViewById(R.id.medium);
        lShld=(ImageView)findViewById(R.id.lSheild);
        sShld=(ImageView)findViewById(R.id.sSheild);
        helm=(ImageView)findViewById(R.id.helm);
        feet=(ImageView)findViewById(R.id.shoes);
        cart=(ImageView)findViewById(R.id.cart);
        horse=(ImageView)findViewById(R.id.horse);
        chariot=(ImageView)findViewById(R.id.chariot);
        boat=(ImageView)findViewById(R.id.ship);
        tri.setImageResource(Global.loc.WStuffToBuy.get(0).image);
        ax.setImageResource(Global.loc.WStuffToBuy.get(1).image);
        two.setImageResource(Global.loc.WStuffToBuy.get(2).image);
        swd.setImageResource(Global.loc.WStuffToBuy.get(3).image);
        spr.setImageResource(Global.loc.WStuffToBuy.get(4).image);
        knf.setImageResource(Global.loc.WStuffToBuy.get(5).image);
        bow.setImageResource(Global.loc.WStuffToBuy.get(6).image);
        spe.setImageResource(Global.loc.WStuffToBuy.get(7).image);
        light.setImageResource(Global.loc.AStuffToBuy.get(0).image);
        heavy.setImageResource(Global.loc.AStuffToBuy.get(1).image);
        medium.setImageResource(Global.loc.AStuffToBuy.get(2).image);
        lShld.setImageResource(Global.loc.AStuffToBuy.get(3).image);
        sShld.setImageResource(Global.loc.AStuffToBuy.get(4).image);
        helm.setImageResource(Global.loc.AStuffToBuy.get(5).image);
        feet.setImageResource(Global.loc.TStuffToBuy.get(0).image);
        cart.setImageResource(Global.loc.TStuffToBuy.get(1).image);
        horse.setImageResource(Global.loc.TStuffToBuy.get(2).image);
        chariot.setImageResource(Global.loc.TStuffToBuy.get(3).image);
        boat.setImageResource(Global.loc.TStuffToBuy.get(4).image);
    }

    public void clearBacks(){
        money = (TextView) findViewById(R.id.gold);
        money.setText("Denarii: " + Global.p1.Denarius);
        tri=(ImageView)findViewById(R.id.trident);
        ax=(ImageView)findViewById(R.id.axe);
        two=(ImageView)findViewById(R.id.twoHanded);
        swd=(ImageView)findViewById(R.id.sword);
        spr=(ImageView)findViewById(R.id.spear);
        knf=(ImageView)findViewById(R.id.knife);
        spe=(ImageView)findViewById(R.id.special);
        bow=(ImageView)findViewById(R.id.bow);
        light=(ImageView)findViewById(R.id.light);
        heavy=(ImageView)findViewById(R.id.heavy);
        medium=(ImageView)findViewById(R.id.medium);
        lShld=(ImageView)findViewById(R.id.lSheild);
        sShld=(ImageView)findViewById(R.id.sSheild);
        helm=(ImageView)findViewById(R.id.helm);
        feet=(ImageView)findViewById(R.id.shoes);
        cart=(ImageView)findViewById(R.id.cart);
        horse=(ImageView)findViewById(R.id.horse);
        chariot=(ImageView)findViewById(R.id.chariot);
        boat=(ImageView)findViewById(R.id.ship);
        tri.setBackground(null);
        ax.setBackground(null);
        two.setBackground(null);
        swd.setBackground(null);
        spr.setBackground(null);
        knf.setBackground(null);
        spe.setBackground(null);
        bow.setBackground(null);
        light.setBackground(null);
        heavy.setBackground(null);
        medium.setBackground(null);
        lShld.setBackground(null);
        sShld.setBackground(null);
        helm.setBackground(null);
        feet.setBackground(null);
        cart.setBackground(null);
        horse.setBackground(null);
        chariot.setBackground(null);
        boat.setBackground(null);
    }

    public void highlightTri(View view) {
        clearBacks();
        tri=(ImageView)findViewById(R.id.trident);
        tri.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.WStuffToBuy.get(0);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightAxe(View view) {
        clearBacks();
        ax=(ImageView)findViewById(R.id.axe);
        ax.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.WStuffToBuy.get(1);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightTwo(View view) {
        clearBacks();
        two=(ImageView)findViewById(R.id.twoHanded);
        two.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.WStuffToBuy.get(2);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightSwd(View view) {
        clearBacks();
        swd=(ImageView)findViewById(R.id.sword);
        swd.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.WStuffToBuy.get(3);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightSpr(View view) {
        clearBacks();
        spr=(ImageView)findViewById(R.id.spear);
        spr.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.WStuffToBuy.get(4);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightKnf(View view) {
        clearBacks();
        knf=(ImageView)findViewById(R.id.knife);
        knf.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.WStuffToBuy.get(5);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightBow(View view) {
        clearBacks();
        bow=(ImageView)findViewById(R.id.bow);
        bow.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.WStuffToBuy.get(6);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightSpe(View view) {
        clearBacks();
        spe=(ImageView)findViewById(R.id.special);
        spe.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.WStuffToBuy.get(7);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightlight(View view) {
        clearBacks();
        light=(ImageView)findViewById(R.id.light);
        light.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.AStuffToBuy.get(0);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlighthev(View view) {
        clearBacks();
        heavy=(ImageView)findViewById(R.id.heavy);
        heavy.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.AStuffToBuy.get(1);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightmed(View view) {
        clearBacks();
        medium=(ImageView)findViewById(R.id.medium);
        medium.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.AStuffToBuy.get(2);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightlsh(View view) {
        clearBacks();
        lShld=(ImageView)findViewById(R.id.lSheild);
        lShld.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.AStuffToBuy.get(3);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightssh(View view) {
        clearBacks();
        sShld=(ImageView)findViewById(R.id.sSheild);
        sShld.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.AStuffToBuy.get(4);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlighthlm(View view) {
        clearBacks();
        helm=(ImageView)findViewById(R.id.helm);
        helm.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.AStuffToBuy.get(5);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightfeet(View view) {
        clearBacks();
        feet=(ImageView)findViewById(R.id.shoes);
        feet.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.TStuffToBuy.get(0);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightcart(View view) {
        clearBacks();
        cart=(ImageView)findViewById(R.id.cart);
        cart.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.TStuffToBuy.get(1);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlighthorse(View view) {
        clearBacks();
        horse=(ImageView)findViewById(R.id.horse);
        horse.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.TStuffToBuy.get(2);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightchar(View view) {
        clearBacks();
        chariot=(ImageView)findViewById(R.id.chariot);
        chariot.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.TStuffToBuy.get(3);
        bubble.setText(i.name+" will be "+i.price);
    }
    public void highlightboat(View view) {
        clearBacks();
        boat=(ImageView)findViewById(R.id.ship);
        boat.setBackground(getDrawable(R.drawable.outline));
        bubble = (TextView) findViewById(R.id.sBubble);
        i = Global.loc.TStuffToBuy.get(4);
        bubble.setText(i.name+" will be "+i.price);
    }

    public void buy(View view){
        if(i==null){money.setText("Please make a selection");return;}
        if(i.price>Global.p1.Denarius){money.setText(R.string.notEnoughMoney);return;}
        else{
            Global.p1.Denarius=Global.p1.Denarius-i.price;
            money.setText("Denarii: "+Global.p1.Denarius);
        }
        switch(i.type){
            case("w"):
                Global.p1.WStuff.add(i);
                money.setText("Purchased weapon for "+i.price);
                bubble = (TextView) findViewById(R.id.sBubble);
                bubble.setText("Thank You");
                break;
            case("a")://diff list for diff armor types and left and right hands
                Global.p1.AStuff.add(i);
                money.setText("Purchased armor for "+i.price);
                bubble = (TextView) findViewById(R.id.sBubble);
                bubble.setText("Thank You");
                break;
            case("s"):
                Global.p1.WStuff.add(i);
                money.setText("Purchased sheild for "+i.price);
                bubble = (TextView) findViewById(R.id.sBubble);
                bubble.setText("Thank You");
                break;
            case("h"):
                Global.p1.HStuff.add(i);
                money.setText("Purchased helm for "+i.price);
                bubble = (TextView) findViewById(R.id.sBubble);
                bubble.setText("Thank You");
                break;
            case("t"):
                Global.p1.TStuff.add(i);
                money.setText("Purchased transport for "+i.price);
                bubble = (TextView) findViewById(R.id.sBubble);
                bubble.setText("Thank You");
                setTrans();
                break;
            default:
                Log.e("gladitor","nothing selected");
                break;
        }
    }

    private void setTrans(){
        Global.p1.transports=i.tnum+(Global.loc.number*10);
    }

    public void giveMeStuff(View view) {
        Global.p1.makeGod();
        money.setText("Denarii: " + Global.p1.Denarius);
    }

}
