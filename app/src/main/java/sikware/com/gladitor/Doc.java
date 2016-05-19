package sikware.com.gladitor;

import android.app.Activity;
import android.app.Dialog;
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

    public Doc(Activity a){
        super(a);
        this.c = a;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_doc);
        yes =(Button) findViewById(R.id.yes);
        no =(Button) findViewById(R.id.no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
    }
    //TODO show gold and glory take away or add based on user choice
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.yes):
                Global.p1.heal();
                Global.pman.Close();
                //TextView hp=(TextView)findViewById(R.id.hp);
                //hp.setText("Health:  " + Global.p1.Hp);
                break;
            case(R.id.no):
                dismiss();
                break;
        }
        dismiss();
        Intent quit = new Intent(c, Camp.class);
        quit.addFlags(c.getIntent().FLAG_ACTIVITY_CLEAR_TOP);
        c.startActivity(quit);
    }
}
