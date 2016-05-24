package sikware.com.gladitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class StartScreen extends AppCompatActivity {
    private LocationManager loc;
    private PlayerManager pManager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        View load=findViewById(R.id.LoadButton);
        if(Global.pman==null){
            pManager=new PlayerManager(this);
            Global.pman=pManager;
        }
        else{pManager=Global.pman;}
        loc=new LocationManager(this);
        Global.locMan=loc;
        pManager.Refresh();
        if(Global.p1==null) {
            load.setVisibility(View.INVISIBLE);
            load.setClickable(false);
        }
    }

    protected  void onResume(Bundle savedInstanceState){
        super.onResume();
        setContentView(R.layout.activity_start_screen);
        View load=findViewById(R.id.LoadButton);
        pManager.Refresh();
        if(Global.p1==null) {
            load.setVisibility(View.INVISIBLE);
            load.setClickable(false);
        }
    }

    public void Exit(View view){finish();}

    public void CreatePlayer(View view){
        //TODO make pop-up prompting this will erase your old game
        Intent newPlayer=new Intent(this,CharCreation.class);
        startActivity(newPlayer);
    }
    public void LoadGame(View view){
        Global.loc=Global.p1.current;
        Intent oldPlayer=new Intent(this,Camp.class);
        startActivity(oldPlayer);
    }
}
