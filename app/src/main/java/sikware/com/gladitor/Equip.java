package sikware.com.gladitor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Equip extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //Player p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip);
        Spinner spinW = (Spinner) findViewById(R.id.Wselect);
        spinW.setAdapter(new MyWeaponAdapter(this,R.layout.custom_spinner,Global.p1.getWnames(Global.p1.Hurter)));
        Spinner spinA = (Spinner) findViewById(R.id.Aselect);
        spinA.setAdapter(new MyArmorAdapter(this, R.layout.custom_spinner, Global.p1.getAnames(Global.p1.OwBeGone)));
        spinW.setOnItemSelectedListener(this);
        spinA.setOnItemSelectedListener(this);
        }

    @Override
    public void onBackPressed(){
        Global.pman.Close();
        Intent quit = new Intent(this,Camp.class);
        quit.addFlags(getIntent().FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(quit);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
       switch (parent.getId()) {
            case (R.id.Wselect):
                Global.p1.weapon = new Weapon((String)parent.getItemAtPosition(pos));
                break;
            case (R.id.Aselect):
                Global.p1.armor = new Armor((String)parent.getItemAtPosition(pos));
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Global.p1.weapon = new Weapon((String)parent.getItemAtPosition(0));
        Global.p1.armor = new Armor((String)parent.getItemAtPosition(0));
    }


    public class MyWeaponAdapter extends ArrayAdapter<String> {
        public MyWeaponAdapter(Context context, int resource, ArrayList<String> objects) {super(context, resource, objects);}
        @Override
        public View getDropDownView(int position, View contextView, ViewGroup prnt){return getCustomView(position,contextView,prnt);}
        public String getItem(int i){return Global.p1.Hurter.get(i).name+";"+Global.p1.Hurter.get(i).power.toString();}
        @Override
        public View getView(int pos,View cnvtView, ViewGroup prnt){return getCustomView(pos, cnvtView, prnt);}
        public View getCustomView(int pos, View convertView, ViewGroup parent){
            LayoutInflater inflater = getLayoutInflater();
            View mySpinner=inflater.inflate(R.layout.custom_spinner, parent, false);
            TextView main_text = (TextView) mySpinner.findViewById(R.id.text_main_seen);
            main_text.setText(Global.p1.Hurter.get(pos).name);
            TextView sub_text = (TextView) mySpinner.findViewById(R.id.sub_text_seen);
            sub_text.setText("+" + Global.p1.Hurter.get(pos).power.toString());
            ImageView left_icon =(ImageView) mySpinner.findViewById(R.id.left_pic);
            left_icon.setImageResource(Global.p1.Hurter.get(pos).image);
            return mySpinner;
        }
    }
    public class MyArmorAdapter extends ArrayAdapter<String> {
        public MyArmorAdapter(Context context, int resource, ArrayList<String> objects) {super(context, resource, objects);}
        @Override
        public View getDropDownView(int position, View contextView, ViewGroup prnt){return getCustomView(position,contextView,prnt);}
        public String getItem(int i){return Global.p1.Hurter.get(i).name+";"+Global.p1.Hurter.get(i).power.toString();}
        @Override
        public View getView(int pos,View cnvtView, ViewGroup prnt){return getCustomView(pos, cnvtView, prnt);}
        public View getCustomView(int pos, View convertView, ViewGroup parent){
            LayoutInflater inflater = getLayoutInflater();
            View mySpinner=inflater.inflate(R.layout.custom_spinner, parent, false);
            TextView main_text = (TextView) mySpinner.findViewById(R.id.text_main_seen);
            main_text.setText(Global.p1.OwBeGone.get(pos).name);
            TextView sub_text = (TextView) mySpinner.findViewById(R.id.sub_text_seen);
            sub_text.setText("+"+Global.p1.OwBeGone.get(pos).power.toString());
            ImageView left_icon =(ImageView) mySpinner.findViewById(R.id.left_pic);
            left_icon.setImageResource(Global.p1.OwBeGone.get(pos).image);
            return mySpinner;
        }
    }


}

