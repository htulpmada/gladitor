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
        money.setText("Denarii: " + p.Denarius);
    }
    protected void onResume(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        p=Global.p1;
        TextView money=(TextView)findViewById(R.id.gold);
        money.setText("Denarii: " + p.Denarius);
    }

    @Override
    public void onBackPressed(){
        Global.pman.Add(p);
        Intent quit = new Intent(this,Camp.class);
        quit.addFlags(getIntent().FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(quit);
    }

    public void highlight(View view){
        TextView money=(TextView)findViewById(R.id.gold);
        money.setText("Denarii: " + p.Denarius);
        //need to figureout what was clicked
        switch(view.getRootView().getId()){
          case(R.id.weapons):
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
              switch(view.getId()){
                case(R.id.trident):
                    tri.setBackground(getDrawable(R.drawable.outline));
                    i=new Weapon("trident",5,10);
                    w=new Weapon("trident",5,10);
                    a=null;
                    t=null;
                    break;
                case(R.id.axe):
                    ax.setBackground(getDrawable(R.drawable.outline));
                    i=new Weapon("axe",3,7);
                    w=new Weapon("axe",3,7);
                    a=null;
                    t=null;
                    break;
                case(R.id.twoHanded):
                    two.setBackground(getDrawable(R.drawable.outline));
                    i=new Weapon("two hand",4,8);
                    w=new Weapon("two hand",4,8);
                    a=null;
                    t=null;
                    break;
                case(R.id.sword):
                    swd.setBackground(getDrawable(R.drawable.outline));
                    i=new Weapon("sword",2,5);
                    w=new Weapon("sword",2,5);
                    a=null;
                    t=null;
                    break;
                case(R.id.spear):
                    spr.setBackground(getDrawable(R.drawable.outline));
                    i=new Weapon("spear",2,5);
                    w=new Weapon("spear",2,5);
                    a=null;
                    t=null;
                    break;
                case(R.id.knife):
                    knf.setBackground(getDrawable(R.drawable.outline));
                    i=new Weapon("knife",2,5);
                    w=new Weapon("knife",2,5);
                    a=null;
                    t=null;
                    break;
                case(R.id.special):
                    spe.setBackground(getDrawable(R.drawable.outline));
                    i=new Weapon("sword",2,5);
                    w=new Weapon("sword",2,5);
                   a=null;
                   t=null;
                   break;
                case(R.id.bow):
                    bow.setBackground(getDrawable(R.drawable.outline));
                    i=new Weapon("bow",2,5);
                    w=new Weapon("bow",2,5);
                    a=null;
                    t=null;
                    break;
                case(R.id.arrow):
                    arw.setBackground(getDrawable(R.drawable.outline));
                    i=new Weapon("arrow",2,5);
                    w=new Weapon("arrow",2,5);
                    a=null;
                    t=null;
                    break;
            }
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

    public void onBackPressed(View view){
        Global.pman.Add(p);
        Intent quit = new Intent(this,Camp.class);
        quit.addFlags(getIntent().FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(quit);
    }
    public void buy(View view){
        if(i==null&&w==null&&a==null&&t==null){money.setText("Please make a selection");return;}
        TextView money=(TextView)findViewById(R.id.gold);
        if(i.price>p.Denarius){money.setText("sorry not enough monies");return;}
        else{
            p.Denarius=p.Denarius-i.price;
            money.setText("Denarii: "+p.Denarius);
        }
        money.setText("Denarii: "+p.Denarius);
        String s="";
        if(w!=null){s="w";}
        if(a!=null){s="a";}
        if(t!=null){s="t";}
        switch(s){
            case("w"):
                p.Hurter.add(w);
                money.setText("Purchased");
                
                break;
            case("a"):
                p.OwBeGone.add(a);
                money.setText("Purchased");
                break;
            case("t"):
                p.Goers.add(t);
                money.setText("Purchased");
                break;
            default:
                Log.e("gladitor","nothing selected");
                break;
        }
        //Global.pman.Close();
    }


}
