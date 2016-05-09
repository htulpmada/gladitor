package sikware.com.gladitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Camp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp);
    }

    public void Shop(){
        Intent shop = new Intent(this,Store.class);
        startActivity(shop);
    }

    public void Stuff(){
        Intent stuff = new Intent(this,Equip.class);
        startActivity(stuff);
    }

    public void Map(){
        Intent stuff = new Intent(this,Map.class);
        startActivity(stuff);
    }

    public void Self(){
        Intent self = new Intent(this,AboutPlayer.class);
        startActivity(self);
    }

    public void Fight(){
        Intent fight = new Intent(this,AboutPlayer.class);
        startActivity(fight);
    }


}
