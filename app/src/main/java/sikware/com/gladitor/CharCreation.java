package sikware.com.gladitor;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class CharCreation extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Player p=new Player();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_creation);
        //TextView name=(TextView)findViewById(R.id.NameText);
        //name.setText("Name Goes Here");
        Spinner spinnerLoc = (Spinner) findViewById(R.id.location);
        ArrayAdapter<CharSequence> adapterLoc = ArrayAdapter.createFromResource(this, R.array.StartingLocation, android.R.layout.simple_spinner_item);
        adapterLoc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLoc.setAdapter(adapterLoc);

    }
    public void makeChar(View view){
        p.randStat();
        TextView name=(TextView)findViewById(R.id.NameText);
        p.Name= String.valueOf(name.getText());
//        String s= (String) name.getText();
 //       if(!(s.equals("Name Goes Here"))){p.Name=(String) name.getText();}
        if(p.iscomplete()){
            Global.p1=p;
            Intent newGame=new Intent(this,Camp.class);
            startActivity(newGame);
        }
        else{
            name.setHint("Character Not Complete");
            name.setBackgroundColor(Color.WHITE);
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Spinner spinnerLoc = (Spinner) findViewById(R.id.location);
        spinnerLoc.setOnItemSelectedListener(this);
        p.CountryOfOrigin = (String) parent.getItemAtPosition(pos);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        p.CountryOfOrigin= (String) parent.getItemAtPosition(0);
    }


}
