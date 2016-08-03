package sikware.com.gladitor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Map extends AppCompatActivity{
    RelativeLayout map;
    RelativeLayout screen;
    Button go;
    TextView choice;
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
                break;
            case(60)://yellow
                choice.setText("Germany");
                if(requirements("ger")) {
                    go.setVisibility(View.VISIBLE);
                }
                break;
            case(325)://purple
                choice.setText("Spain");
                if(requirements("spn")) {
                    go.setVisibility(View.VISIBLE);
                }
                break;
            case(358)://red
                choice.setText("Italy");
                if(requirements("itl")) {
                    go.setVisibility(View.VISIBLE);
                }
                break;
            case(29)://tan
                choice.setText("Africa");
                if(requirements("afr")) {
                    go.setVisibility(View.VISIBLE);
                }
                break;
            /*case(218)://blue
                choice.setText("Greece");
                if(requirements("gre")) {
                    go.setVisibility(View.VISIBLE);
                }
                break;
            case(217)://blue
                choice.setText("Greece");
                if(requirements("gre")) {
                    go.setVisibility(View.VISIBLE);
                }
                break;
            case(26)://orange
                choice.setText("Scandinavia");
                if(requirements("scn")) {
                    go.setVisibility(View.VISIBLE);
                }
                break;
            case(25)://orange
                choice.setText("Scandinavia");
                if(requirements("scn")) {
                    go.setVisibility(View.VISIBLE);
                }
                break;
            case(0)://black/nothing
                choice.setText("Slavia");
                if(requirements("slv")) {
                    go.setVisibility(View.VISIBLE);
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
        if(true/*<---Change That*/){//TODO requirements for advancement to next level
            return true;
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
