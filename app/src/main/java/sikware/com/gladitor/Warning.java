package sikware.com.gladitor;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by deucemonkey on 6/3/2016.
 */
public class Warning extends Dialog implements android.view.View.OnClickListener,Serializable {

    public Activity c;
    public Dialog d;
    public boolean show=false;
    public Button yes, no;

    public Warning(Activity a){
        super(a);
        this.c = a;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_warn);
        yes =(Button) findViewById(R.id.New);
        no =(Button) findViewById(R.id.No);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.New):
                Intent newPlayer=new Intent(c,CharCreation.class);
                c.startActivity(newPlayer);
                dismiss();
                break;
            case(R.id.No):
                dismiss();
                break;
        }

    }
}
