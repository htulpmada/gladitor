package sikware.com.gladitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Equip extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Player p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip);
        Spinner spinW = (Spinner) findViewById(R.id.Wselect);
        ArrayAdapter adapterW = new ArrayAdapter(this, android.R.layout.simple_spinner_item, p.getWnames(Global.p1.Hurter));
        adapterW.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinW.setAdapter(adapterW);
        Spinner spinA = (Spinner) findViewById(R.id.Aselect);
        ArrayAdapter adapterA = new ArrayAdapter(this, android.R.layout.simple_spinner_item, p.getAnames(Global.p1.OwBeGone));
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinA.setAdapter(adapterA);
        spinW.setOnItemSelectedListener(this);
        spinA.setOnItemSelectedListener(this);
        p=Global.p1;
    }

    @Override
    public void onBackPressed(){
        Global.pman.Add(p);
        Intent quit = new Intent(this,Camp.class);
        quit.addFlags(getIntent().FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(quit);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
       switch (parent.getId()) {
            case (R.id.Wselect):
                Global.p1.weapon = (Weapon) parent.getItemAtPosition(pos);
                break;
            case (R.id.Aselect):
                Global.p1.armor = (Armor) parent.getItemAtPosition(pos);
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Global.p1.weapon = (Weapon) parent.getItemAtPosition(0);
        Global.p1.armor = (Armor) parent.getItemAtPosition(0);
    }


}

