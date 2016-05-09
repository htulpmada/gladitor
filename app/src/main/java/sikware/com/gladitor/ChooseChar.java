package sikware.com.gladitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ChooseChar extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    PlayerManager pman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_char);
        pman = (PlayerManager) getIntent().getSerializableExtra("Pman");
        Spinner pspin = (Spinner) findViewById(R.id.PlayerSpinner);
        //pspin.
        ArrayAdapter<CharSequence> adapterP = new ArrayAdapter(this, android.R.layout.simple_spinner_item, pman.pList);
        adapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pspin.setAdapter(adapterP);
    }


    public void goToCamp() {
        Intent intent=new Intent(this,Camp.class);
        intent.putExtra("Pman",pman);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Spinner pspin = (Spinner) findViewById(R.id.PlayerSpinner);
        pspin.setOnItemSelectedListener(this);
        Global.p1= pman.findPlayer((String) parent.getItemAtPosition(pos));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Spinner pspin = (Spinner) findViewById(R.id.PlayerSpinner);
        pspin.setOnItemSelectedListener(this);
        Global.p1= pman.findPlayer((String) parent.getItemAtPosition(0));

    }
}
