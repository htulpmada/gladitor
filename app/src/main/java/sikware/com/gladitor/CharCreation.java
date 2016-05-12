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
        Spinner spinnerLoc = (Spinner) findViewById(R.id.location);
        ArrayAdapter<CharSequence> adapterLoc = ArrayAdapter.createFromResource(this, R.array.StartingLocation, android.R.layout.simple_spinner_item);
        adapterLoc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLoc.setAdapter(adapterLoc);
        spinnerLoc.setOnItemSelectedListener(this);

    }

    @Override
    public void onBackPressed(){return;}

    public void makeChar(View view){
        Global.pman.Add(p);
        Intent newGame=new Intent(this,Camp.class);
        startActivity(newGame);
        //not sure if this is necessary
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        p.CountryOfOrigin = (String) parent.getItemAtPosition(pos);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        p.CountryOfOrigin= (String) parent.getItemAtPosition(0);
    }


}
