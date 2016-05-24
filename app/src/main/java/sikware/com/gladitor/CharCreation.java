package sikware.com.gladitor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static sikware.com.gladitor.Global.*;

public class CharCreation extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Player p;//=new Player(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_creation);
        Spinner spinnerLoc = (Spinner) findViewById(R.id.location);
        ArrayAdapter<CharSequence> adapterLoc = ArrayAdapter.createFromResource(this, R.array.StartingLocation, android.R.layout.simple_spinner_item);
        adapterLoc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLoc.setAdapter(adapterLoc);
        spinnerLoc.setOnItemSelectedListener(this);
        p = new Player(this);
    }

    public void Quit(View view) {
        Intent back = new Intent(this,StartScreen.class);
        back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(back);
        finish();
    }

    public void makeChar(View view) {
        pman.Add(p);
        Intent newGame = new Intent(this, Camp.class);
        newGame.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(newGame);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        p.CountryOfOrigin = (String) parent.getItemAtPosition(pos);
        p.current = locMan.makeLocation((String) parent.getItemAtPosition(pos));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        p.CountryOfOrigin = (String) parent.getItemAtPosition(0);
        p.current = locMan.makeLocation((String) parent.getItemAtPosition(0));
    }

}