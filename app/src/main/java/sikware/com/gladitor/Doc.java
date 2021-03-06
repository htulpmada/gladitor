package sikware.com.gladitor;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Doc extends Dialog implements android.view.View.OnClickListener,Serializable {

    public Activity c;
    public Dialog d;
    public boolean show=false;
    public Button yes, no;
    int p = Global.p1.maxHealth()-Global.p1.Hp;
    Random r=new Random();

    public Doc(Activity a){
        super(a);
        this.c = a;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_doc);
        yes =(Button) findViewById(R.id.yes);
        no =(Button) findViewById(R.id.no);
        TextView pr = (TextView)findViewById(R.id.price);
        String s =String.format("%s %d %s", c.getString(R.string.warning1),p,c.getString(R.string.warning2));
        pr.setText(s);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //TODO make chance of death
        TextView pr = (TextView)findViewById(R.id.price);
        switch(v.getId()){
            case(R.id.yes):
                badrewards();
                Global.pman.Close();
                Global.ai=null;//new Enemy(Global.loc.badguys.get(r.nextInt(2)));
                break;
            case(R.id.no):
                if(Global.p1.Hp<0){pr.setText(R.string.notEnough);return;}
                goodrewards();
                Global.pman.Close();
                Global.ai=null;//new Enemy(Global.loc.badguys.get(r.nextInt(2)));
                break;
        }
        dismiss();
        Intent quit = new Intent(c, Camp.class);
        quit.addFlags(c.getIntent().FLAG_ACTIVITY_CLEAR_TOP);
        c.startActivity(quit);
        //c.finish();
    }

    private void goodrewards() {
        r=new Random();
        Global.p1.Denarius+=((r.nextInt(10)+1)*(p+1));
        Global.p1.glory+=p+10*Global.difficulty;
        //increase max health every so often
        Global.p1.tally++;
        if(Global.p1.tally%5==0){Global.p1.upStats();Global.p1.getModifiers();}//every five fights your stats increases leading to health, attack,and defense increase
    }
    private void badrewards() {
        Global.p1.heal();
        Global.p1.glory-=p;
        //Global.pman.Close();
    }


}
