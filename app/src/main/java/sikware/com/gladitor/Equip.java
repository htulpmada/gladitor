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
    ArrayList<String> w=Global.p1.getnames(Global.p1.WStuff);
    ArrayList<String> h=Global.p1.getnames(Global.p1.HStuff);
    ArrayList<String> a=Global.p1.getnames(Global.p1.AStuff);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip);
        TextView hp=(TextView)findViewById(R.id.heal);
        TextView dam=(TextView)findViewById(R.id.dam);
        TextView arm=(TextView)findViewById(R.id.arm);
        hp.setText("Health:  " + Global.p1.Hp);
        dam.setText("Damage: " + Global.p1.dmg);
        arm.setText("Armor:  " + Global.p1.ac);
        Spinner spinWr = (Spinner) findViewById(R.id.Wrselect);
        spinWr.setAdapter(new MyWeaponAdapter(this, R.layout.custom_spinner, w));
        Spinner spinWl = (Spinner) findViewById(R.id.Wlselect);
        spinWl.setAdapter(new MyWeaponAdapter(this, R.layout.custom_spinner, w));
        Spinner spinH = (Spinner) findViewById(R.id.Hselect);
        spinH.setAdapter(new MyHelmAdapter(this, R.layout.custom_spinner, h));
        Spinner spinA = (Spinner) findViewById(R.id.Aselect);
        spinA.setAdapter(new MyArmorAdapter(this, R.layout.custom_spinner, a));
        spinWr.setOnItemSelectedListener(this);
        spinWl.setOnItemSelectedListener(this);
        spinH.setOnItemSelectedListener(this);
        spinA.setOnItemSelectedListener(this);
    }

    protected void onResume(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip);
        TextView hp=(TextView)findViewById(R.id.heal);
        TextView dam=(TextView)findViewById(R.id.dam);
        TextView arm=(TextView)findViewById(R.id.arm);
        hp.setText("Health:  " + Global.p1.Hp);
        dam.setText("Damage: " + Global.p1.dmg);
        arm.setText("Armor:  " + Global.p1.ac);
        Spinner spinWr = (Spinner) findViewById(R.id.Wrselect);
        spinWr.setAdapter(new MyWeaponAdapter(this, R.layout.custom_spinner, w));
        Spinner spinWl = (Spinner) findViewById(R.id.Wlselect);
        spinWl.setAdapter(new MyWeaponAdapter(this,R.layout.custom_spinner,w));
        Spinner spinH = (Spinner) findViewById(R.id.Hselect);
        spinH.setAdapter(new MyHelmAdapter(this,R.layout.custom_spinner,h));
        Spinner spinA = (Spinner) findViewById(R.id.Aselect);
        spinA.setAdapter(new MyArmorAdapter(this, R.layout.custom_spinner, a));
        spinWr.setOnItemSelectedListener(this);
        spinWl.setOnItemSelectedListener(this);
        spinH.setOnItemSelectedListener(this);
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
        TextView dam=(TextView)findViewById(R.id.dam);
        TextView arm=(TextView)findViewById(R.id.arm);
        switch (parent.getId()) {
           case (R.id.Wrselect):
               Global.p1.weaponR = new Item((String)parent.getItemAtPosition(pos),Global.p1.WStuff.get(pos).image);
               Global.p1.getDamage();
               dam.setText("Damage: " + Global.p1.dmg);
               arm.setText("Armor:  " + Global.p1.ac);
               break;
           case (R.id.Wlselect):
               Global.p1.weaponL = new Item((String)parent.getItemAtPosition(pos),Global.p1.WStuff.get(pos).image);
               Global.p1.getDamage();
               dam.setText("Damage: " + Global.p1.dmg);
               arm.setText("Armor:  " + Global.p1.ac);
               break;
           case (R.id.Hselect):
               Global.p1.helm = new Item((String)parent.getItemAtPosition(pos),Global.p1.HStuff.get(pos).image);
               Global.p1.getDamage();
               dam.setText("Damage: " + Global.p1.dmg);
               arm.setText("Armor:  " + Global.p1.ac);
               break;
            case (R.id.Aselect):
                Global.p1.suit = new Item((String)parent.getItemAtPosition(pos),Global.p1.AStuff.get(pos).image);
                Global.p1.getDamage();
                dam.setText("Damage: " + Global.p1.dmg);
                arm.setText("Armor:  " + Global.p1.ac);
                break;
        }
    }
    //TODO make current equipped item, default on start of activity
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        /**Global.p1.weaponR = new Item((String)parent.getItemAtPosition(0),Global.p1.WStuff.get(0).image);
        Global.p1.weaponL = new Item((String)parent.getItemAtPosition(0),Global.p1.WStuff.get(0).image);
        Global.p1.helm = new Item((String)parent.getItemAtPosition(0),Global.p1.HStuff.get(0).image);
        Global.p1.suit = new Item((String)parent.getItemAtPosition(0),Global.p1.AStuff.get(0).image);**/
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
            left_icon.setImageResource(Global.p1.WStuff.get(pos).image);
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
            left_icon.setImageResource(Global.p1.AStuff.get(pos).image);
            return mySpinner;
        }
    }

    public class MyHelmAdapter extends ArrayAdapter<String> {
        public MyHelmAdapter(Context context, int resource, ArrayList<String> objects) {super(context, resource, objects);}
        @Override
        public View getDropDownView(int position, View contextView, ViewGroup prnt){return getCustomView(position,contextView,prnt);}
        @Override
        public View getView(int pos,View cnvtView, ViewGroup prnt){return getCustomView(pos, cnvtView, prnt);}
        public View getCustomView(int pos, View convertView, ViewGroup parent){
            LayoutInflater inflater = getLayoutInflater();
            View mySpinner=inflater.inflate(R.layout.custom_spinner, parent, false);
            TextView main_text = (TextView) mySpinner.findViewById(R.id.text_main_seen);
            main_text.setText(h.get(pos).split(";")[0]);
            TextView sub_text = (TextView) mySpinner.findViewById(R.id.sub_text_seen);
            sub_text.setText("+" + h.get(pos).split(";")[1].toString());
            ImageView left_icon =(ImageView) mySpinner.findViewById(R.id.left_pic);
            left_icon.setImageResource(Global.p1.HStuff.get(pos).image);
            return mySpinner;
        }
    }

}

