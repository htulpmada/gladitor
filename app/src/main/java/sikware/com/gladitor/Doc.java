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

public class Doc extends Dialog implements android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    int p = Global.p1.maxHealth()-Global.p1.Hp;

    public Doc(Activity a){
        super(a);
        this.c = a;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_doc);
        yes =(Button) findViewById(R.id.yes);
        no =(Button) findViewById(R.id.no);
        TextView pr = (TextView)findViewById(R.id.price);
        String s =String.format("%s %d %s %s %d %s", c.getString(R.string.warning1),p,c.getString(R.string.warning2),c.getString(R.string.warning3),p,c.getString(R.string.warning4));
        pr.setText(s);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
    }
    //TODO show gold and glory take away or add based on user choice
    @Override
    public void onClick(View v) {
        TextView pr = (TextView)findViewById(R.id.price);
        switch(v.getId()){
            case(R.id.yes):
                if(p>Global.p1.Denarius){pr.setText(R.string.notEnough);return;}
                Global.p1.Denarius-=p;
                Global.p1.heal();
                Global.pman.Close();
                break;
            case(R.id.no):
                //dismiss();
                break;
        }
        dismiss();
        Intent quit = new Intent(c, Camp.class);
        quit.addFlags(c.getIntent().FLAG_ACTIVITY_CLEAR_TOP);
        c.startActivity(quit);
    }
}
