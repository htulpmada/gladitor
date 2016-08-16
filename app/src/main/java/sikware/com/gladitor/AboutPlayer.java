package sikware.com.gladitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class AboutPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_creation);
        TextView t=(TextView)findViewById(R.id.mess1);
        t.setVisibility(View.GONE);
        t=(TextView)findViewById(R.id.mess2);
        t.setVisibility(View.GONE);
        Spinner s =(Spinner)findViewById(R.id.location);
        s.setVisibility(View.GONE);
        Button b=(Button)findViewById(R.id.button);
        b.setVisibility(View.GONE);
        t=(TextView)findViewById(R.id.St);
        t.setText(Global.p1.str.toString());
        t=(TextView)findViewById(R.id.Ag);
        t.setText(Global.p1.agl.toString());
        t=(TextView)findViewById(R.id.Cn);
        t.setText(Global.p1.con.toString());
        t=(TextView)findViewById(R.id.Al);
        t.setText(Global.p1.alrt.toString());
        t=(TextView)findViewById(R.id.Wt);
        t.setText(Global.p1.wits.toString());
        t=(TextView)findViewById(R.id.Ch);
        t.setText(Global.p1.chr.toString());
        t=(TextView)findViewById(R.id.Lk);
        t.setText(Global.p1.luck.toString());
    }
    //TODO make whole class maybe with tab views
    public void Quit(View v){
        finish();
    }
}
