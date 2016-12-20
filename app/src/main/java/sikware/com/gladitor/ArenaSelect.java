package sikware.com.gladitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static sikware.com.gladitor.R.id.rb1;
import static sikware.com.gladitor.R.id.rb2;
import static sikware.com.gladitor.R.id.rb3;
import static sikware.com.gladitor.R.id.rb4;
import static sikware.com.gladitor.R.id.rb5;

public class ArenaSelect extends AppCompatActivity {
    RadioGroup rbg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena_select);
        TextView t =(TextView)findViewById(R.id.location);
        t.setText(Global.loc.name);
        int i = getnum();
        int j = Global.p1.arenasBeatten;
        int k = Global.p1.transports;
        int z = Global.loc.number*10;
        rbg = (RadioGroup)findViewById(R.id.radioGroup);
        //always get to fight at first arena
        rb=(RadioButton)findViewById(rb1);
        rb.setText(Global.loc.Arenas.get(0));

        rb=(RadioButton)findViewById(rb2);
        rb.setText(Global.loc.Arenas.get(1));
        if(i>=j||k<1+z){
            rb.setVisibility(View.GONE);
        }
        i++;
        rb=(RadioButton)findViewById(rb3);
        rb.setText(Global.loc.Arenas.get(2));
        if(i>=j||k<2+z){
            rb.setVisibility(View.GONE);
        }
        i++;
        rb=(RadioButton)findViewById(rb4);
        rb.setText(Global.loc.Arenas.get(3));
        if(i>=j||k<3+z){
            rb.setVisibility(View.GONE);
        }
        i++;
        rb=(RadioButton)findViewById(rb5);
        rb.setText(Global.loc.Arenas.get(4));
        if(i>=j||k<4+z){
            rb.setVisibility(View.GONE);
        }
        i++;

       }

    private int getnum(){return Global.loc.number*10;}

    public void showBadGuys(View view){
        int i=-1;
        switch(view.getId()) {
            case rb1:
                i=1;
                break;
            case rb2:
                i=2;
                break;
            case rb3:
                i=3;
                break;
            case rb4:
                i=4;
                break;
            case rb5:
                i=5;
                break;

        }
        TextView t =(TextView)findViewById(R.id.location);
        t.setText(Global.loc.name);
        t = (TextView)findViewById(R.id.badguy);
        t.setText(Global.loc.badguys.get(i).name+"\n"+Global.loc.badguys.get(i+1).name+"\n"+Global.loc.badguys.get(i+2).name);
        Button b =(Button)findViewById(R.id.button5);
        b.setVisibility(View.VISIBLE);
        Global.arena=i;
    }

    public void go(View view){
        Intent fight = new Intent(this, Fight.class);
        fight.putExtra("arena", rbg.getCheckedRadioButtonId());
        startActivity(fight);
    }
}
