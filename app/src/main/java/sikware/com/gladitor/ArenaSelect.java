package sikware.com.gladitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ArenaSelect extends AppCompatActivity {
    RadioGroup rbg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena_select);
        rbg = (RadioGroup)findViewById(R.id.radioGroup);
        rb=(RadioButton)findViewById(R.id.rb1);
        rb.setText(Global.loc.Arenas.get(0));
        rb=(RadioButton)findViewById(R.id.rb2);
        rb.setText(Global.loc.Arenas.get(1));
        rb=(RadioButton)findViewById(R.id.rb3);
        rb.setText(Global.loc.Arenas.get(2));
        rb=(RadioButton)findViewById(R.id.rb4);
        rb.setText(Global.loc.Arenas.get(3));
        rb=(RadioButton)findViewById(R.id.rb5);
        rb.setText(Global.loc.Arenas.get(4));
        TextView t =(TextView)findViewById(R.id.location);
        t.setText(Global.loc.name);
        t = (TextView)findViewById(R.id.badguy);
        t.setText(Global.loc.badguys.get(0).name+"\n"+Global.loc.badguys.get(1).name+"\n"+Global.loc.badguys.get(2).name);
    }
    public void go(View view){
        Intent fight = new Intent(this, Fight.class);
        fight.putExtra("arena", rbg.getCheckedRadioButtonId());
        startActivity(fight);
    }
}
