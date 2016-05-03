package sikware.com.gladitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    private static PlayerManager pManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

    }

    public void CreatePlayer(View view){
        Intent newPlayer=new Intent(this,CharCreation.class);
        startActivity(newPlayer);
    }
    public void LoadGame(View view){
        Intent oldPlayer=new Intent(this,Camp.class);
        startActivity(oldPlayer);
    }
}
