package sikware.com.gladitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Camp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp);
        TextView name= (TextView) findViewById(R.id.NameDisplay);
        name.setText(Global.p1.Name);
    }


}
