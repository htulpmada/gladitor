package sikware.com.gladitor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Equip extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //Player p;
    ArrayList<String> w=Global.p1.getWnames(Global.p1.Stuff);
    ArrayList<String> a=Global.p1.getAnames(Global.p1.Stuff);
    //TODO left hand, right hand, and armor parts tabbed views
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip);
        TextView hp=(TextView)findViewById(R.id.heal);
        TextView dam=(TextView)findViewById(R.id.dam);
        TextView arm=(TextView)findViewById(R.id.arm);
        hp.setText("Health:  " + Global.p1.Hp);
        dam.setText("Damage: " + Global.p1.weapon.power + Global.p1.str);
        arm.setText("Armor:  " + Global.p1.armor.power + Global.p1.agl);
        Spinner spinW = (Spinner) findViewById(R.id.Wselect);
        spinW.setAdapter(new MyWeaponAdapter(this,R.layout.custom_spinner,w));
        Spinner spinA = (Spinner) findViewById(R.id.Aselect);
        spinA.setAdapter(new MyArmorAdapter(this, R.layout.custom_spinner,a));
        spinW.setOnItemSelectedListener(this);
        spinA.setOnItemSelectedListener(this);
    }

    protected void onResume(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip);
        TextView hp=(TextView)findViewById(R.id.heal);
        TextView dam=(TextView)findViewById(R.id.dam);
        TextView arm=(TextView)findViewById(R.id.arm);
        hp.setText("Health:  " + Global.p1.Hp);
        dam.setText("Damage: " + Global.p1.weapon.power + Global.p1.str);
        arm.setText("Armor:  " + Global.p1.armor.power + Global.p1.agl);
        Spinner spinW = (Spinner) findViewById(R.id.Wselect);
        spinW.setAdapter(new MyWeaponAdapter(this,R.layout.custom_spinner,Global.p1.getWnames(Global.p1.Stuff)));
        Spinner spinA = (Spinner) findViewById(R.id.Aselect);
        spinA.setAdapter(new MyArmorAdapter(this, R.layout.custom_spinner, Global.p1.getAnames(Global.p1.Stuff)));
        spinW.setOnItemSelectedListener(this);
        spinA.setOnItemSelectedListener(this);
    }


    @Override
    public void onBackPressed(){
        //Global.pman.Close();
        Intent quit = new Intent(this,Camp.class);
        quit.addFlags(getIntent().FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(quit);
    }

    public void Quit(View view){
        Global.pman.Close();
        Intent quit = new Intent(this,Camp.class);
        quit.addFlags(getIntent().FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(quit);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
       switch (parent.getId()) {
            case (R.id.Wselect):
                Global.p1.weapon = new Item((String)parent.getItemAtPosition(pos));
                TextView dam=(TextView)findViewById(R.id.dam);
                dam.setText("Damage: " + Global.p1.weapon.power + Global.p1.str);
                break;
            case (R.id.Aselect):
                Global.p1.armor = new Item((String)parent.getItemAtPosition(pos));
                TextView arm=(TextView)findViewById(R.id.arm);
                arm.setText("Armor:  " + Global.p1.armor.power + Global.p1.agl);
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Global.p1.weapon = new Item((String)parent.getItemAtPosition(0));
        Global.p1.armor = new Item((String)parent.getItemAtPosition(0));
    }


    public class MyWeaponAdapter extends ArrayAdapter<String> {
        public MyWeaponAdapter(Context context, int resource, ArrayList<String> objects) {super(context, resource, objects);}
        @Override
        public View getDropDownView(int position, View contextView, ViewGroup prnt){return getCustomView(position,contextView,prnt);}
        @Override
        public View getView(int pos,View cnvtView, ViewGroup prnt){return getCustomView(pos, cnvtView, prnt);}
        public View getCustomView(int pos, View convertView, ViewGroup parent){
            LayoutInflater inflater = getLayoutInflater();
            View mySpinner=inflater.inflate(R.layout.custom_spinner, parent, false);
            TextView main_text = (TextView) mySpinner.findViewById(R.id.text_main_seen);
            main_text.setText(w.get(pos).split(";")[0]);
            TextView sub_text = (TextView) mySpinner.findViewById(R.id.sub_text_seen);
            sub_text.setText("+" + w.get(pos).split(";")[1].toString());
            ImageView left_icon =(ImageView) mySpinner.findViewById(R.id.left_pic);
            left_icon.setImageResource(Integer.parseInt(w.get(pos).split(";")[5]));
            return mySpinner;
        }
    }
    public class MyArmorAdapter extends ArrayAdapter<String> {
        public MyArmorAdapter(Context context, int resource, ArrayList<String> objects) {super(context, resource, objects);}
        @Override
        public View getDropDownView(int position, View contextView, ViewGroup prnt){return getCustomView(position,contextView,prnt);}
        @Override
        public View getView(int pos,View cnvtView, ViewGroup prnt){return getCustomView(pos, cnvtView, prnt);}
        public View getCustomView(int pos, View convertView, ViewGroup parent){
            LayoutInflater inflater = getLayoutInflater();
            View mySpinner=inflater.inflate(R.layout.custom_spinner, parent, false);
            TextView main_text = (TextView) mySpinner.findViewById(R.id.text_main_seen);
            main_text.setText(a.get(pos).split(";")[0]);
            TextView sub_text = (TextView) mySpinner.findViewById(R.id.sub_text_seen);
            sub_text.setText("+" + a.get(pos).split(";")[1].toString());
            ImageView left_icon =(ImageView) mySpinner.findViewById(R.id.left_pic);
            left_icon.setImageResource(Integer.parseInt(a.get(pos).split(";")[5]));
            return mySpinner;
        }
    }


}

