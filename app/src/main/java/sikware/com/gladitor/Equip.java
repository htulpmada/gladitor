package sikware.com.gladitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Equip extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip);
        Spinner spinW = (Spinner) findViewById(R.id.Wselect);
        ArrayAdapter adapterW = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Global.p1.Hurter);
        adapterW.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinW.setAdapter(adapterW);
        Spinner spinA = (Spinner) findViewById(R.id.Aselect);
        ArrayAdapter adapterA = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Global.p1.OwBeGone);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinA.setAdapter(adapterA);
    }

   // @Override
   // public void onBackPressed(){return;}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Spinner spinnerA = (Spinner) findViewById(R.id.Aselect);
        Spinner spinnerW = (Spinner) findViewById(R.id.Wselect);
        switch (parent.getId()) {
            case (R.id.Wselect):
                spinnerW.setOnItemSelectedListener(this);
                Global.p1.weapon = (Weapon) parent.getItemAtPosition(pos);
                break;
            case (R.id.Aselect):
                spinnerA.setOnItemSelectedListener(this);
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

