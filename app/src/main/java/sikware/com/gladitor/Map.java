package sikware.com.gladitor;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static java.util.logging.Logger.global;

public class Map extends AppCompatActivity{
    RelativeLayout map;
    RelativeLayout screen;
    Button go;
    TextView choice, next;
    int x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        screen = (RelativeLayout)findViewById(R.id.scrn);
        screen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                x = (int)e.getX();
                y = (int)e.getY();
                getColor(x,y);
                return true;
        }});
        next = (TextView) findViewById(R.id.next);
        next.setText(getNext());
        next = (TextView) findViewById(R.id.needed);
        next.setText(Global.p1.glory+ " / "+getNeeded());
    }

    private String getNext(){
        switch(Global.loc.name){
            case "Britain":
                return "Spain";
            case "Spain":
                return "Germany";
            case "Germany":
                return "Africa";
            case "Africa":
                return "Italy";
            case "Tuscany":
                return "where to next?";
        }
        return "";
    }

    private int getNeeded(){
        switch(Global.loc.name){
            case "Britain":
                return 250;
            case "Spain":
                return 500;
            case "Germany":
                return 1000;
            case "Africa":
                return 1500;
            case "Tuscany":
                return 3000;
        }
        return 0;
    }

    public void getColor(int x, int y){
        choice = (TextView)findViewById(R.id.locate);
        go = (Button)findViewById(R.id.Go);
        map = (RelativeLayout)findViewById(R.id.scrn);
        map.setDrawingCacheEnabled(true);
        map.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);
        map.buildDrawingCache();
        if(map.getDrawingCache() == null){return;}
        Bitmap bitmap = map.getDrawingCache();
        int pixel = bitmap.getPixel(x,y);
        float[] hsv = new float[3];
        Color.colorToHSV(pixel,hsv);
        map.setDrawingCacheEnabled(false);
        map.destroyDrawingCache();
        switch((int) hsv[0]){
            case(120)://green
                choice.setText("Britain");
                if(requirements("eng")) {
                    go.setVisibility(View.VISIBLE);
                }
                else{
                    choice.setText("Sorry, you don't have the transport needed for this trip");
                    go.setVisibility(View.INVISIBLE);
                }
                break;
            case(60)://yellow
                choice.setText("Germany");
                if(requirements("ger")) {
                    go.setVisibility(View.VISIBLE);
                }
                else{
                    choice.setText("Sorry, you don't have the transport needed for this trip");
                    go.setVisibility(View.INVISIBLE);
                }
                break;
            case(325)://purple
                choice.setText("Spain");
                if(requirements("spn")) {
                    go.setVisibility(View.VISIBLE);
                }
                else{
                    choice.setText("Sorry, you don't have the transport needed for this trip");
                    go.setVisibility(View.INVISIBLE);
                }
                break;
            case(358)://red
                choice.setText("Italy");
                if(requirements("itl")) {
                    go.setVisibility(View.VISIBLE);
                }
                else{
                    choice.setText("Sorry, you don't have the transport needed for this trip");
                    go.setVisibility(View.INVISIBLE);
                }
                break;
            case(29)://tan
                choice.setText("Africa");
                if(requirements("afr")) {
                    go.setVisibility(View.VISIBLE);
                }
                else{
                    choice.setText("Sorry, you don't have the transport needed for this trip");
                    go.setVisibility(View.INVISIBLE);
                }
                break;
            /*case(218)://blue
                choice.setText("Greece");
                if(requirements("gre")) {
                    go.setVisibility(View.VISIBLE);
                }
                else{
                    choice.setText("Sorry, you don't have the transport needed for this trip");
                    go.setVisibility(View.INVISIBLE);
                }
                break;
            case(217)://blue
                choice.setText("Greece");
                if(requirements("gre")) {
                    go.setVisibility(View.VISIBLE);
                }
                else{
                    choice.setText("Sorry, you don't have the transport needed for this trip");
                    go.setVisibility(View.INVISIBLE);
                }
                break;
            case(26)://orange
                choice.setText("Scandinavia");
                if(requirements("scn")) {
                    go.setVisibility(View.VISIBLE);
                }
                else{
                    choice.setText("Sorry, you don't have the transport needed for this trip");
                    go.setVisibility(View.INVISIBLE);
                }
                break;
            case(25)://orange
                choice.setText("Scandinavia");
                if(requirements("scn")) {
                    go.setVisibility(View.VISIBLE);
                }
                else{
                    choice.setText("Sorry, you don't have the transport needed for this trip");
                    go.setVisibility(View.INVISIBLE);
                }
                break;
            case(0)://black/nothing
                choice.setText("Slavia");
                if(requirements("slv")) {
                    go.setVisibility(View.VISIBLE);
                }
                else{
                    choice.setText("Sorry, you don't have the transport needed for this trip");
                    go.setVisibility(View.INVISIBLE);
                }
                break;*/
            default:
                choice.setText("Choice not Recognized");
                go.setVisibility(View.INVISIBLE);
                return;
        }
        return;
    }

    private boolean requirements(String loc) {
        String s=Global.loc.name;
        Resources res = getResources();
        //res.getStringArray(R.array.StartingLocation)[0];
        switch(loc) {
            case("eng"):
//                if (Global.p1.glory > 250 && Global.p1.Checknames("t","Dinghy")/*<---TEST */) {//TODO requirements for advancement to next level
                    return true;
 //               }
 //               break;
            case("spn"):
                if (Global.p1.glory > 250 && Global.p1.Checknames("t","Dinghy")/*<---TEST */) {//TODO requirements for advancement to next level
                    return true;
                }
                break;
            case("ger"):
                if (Global.p1.glory > 500 && Global.p1.Checknames("t","Fishing Boat")/*<---TEST */) {//TODO requirements for advancement to next level
                    return true;
                }
                break;
            case("afr"):
                if (Global.p1.glory > 1000 && Global.p1.Checknames("t","Merchant Vessel")/*<---TEST */) {//TODO requirements for advancement to next level
                    return true;
                }
                break;
            case("itl"):
                if (Global.p1.glory > 1500 && Global.p1.Checknames("t","Scooner")/*<---TEST */) {//TODO requirements for advancement to next level
                    return true;
                }
                break;
            case("gre"):
                if (Global.p1.glory > 3000 && Global.p1.Checknames("t","Triremis")/*<---TEST */) {//TODO requirements for advancement to next level
                    return true;
                }
                break;
            case("scn"):
                if (Global.p1.glory > 5000 && Global.p1.Checknames("t","Pentekontor")/*<---TEST */) {//TODO requirements for advancement to next level
                    return true;
                }
                break;
            case("slv"):
                if (Global.p1.glory > 10000 && Global.p1.Checknames("t","Viking LongShip")/*<---TEST */) {//TODO requirements for advancement to next level
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    public void GoTo(View view){
        choice = (TextView)findViewById(R.id.locate);
        Global.p1.current=Global.locMan.makeLocation((String)choice.getText());
        Global.pman.Close();
        Intent i = new Intent(this, Camp.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

}
