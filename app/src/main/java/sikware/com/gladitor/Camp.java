package sikware.com.gladitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Camp extends AppCompatActivity {
    PlayerManager pman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp);
        pman = (PlayerManager) getIntent().getSerializableExtra("Pman");
        TextView name= (TextView) findViewById(R.id.NameDisplay);
        name.setText(Global.p1.Name);
    }

    public void Shop(){
        Intent shop = new Intent(this,Store.class);
        shop.putExtra("Pman",pman);
        startActivity(shop);
    }

    public void Stuff(){
        Intent stuff = new Intent(this,Equip.class);
        stuff.putExtra("Pman",pman);
        startActivity(stuff);
    }

    public void Map(){
        Intent stuff = new Intent(this,Map.class);
        stuff.putExtra("Pman",pman);
        startActivity(stuff);
    }

    public void Self(){
        Intent self = new Intent(this,AboutPlayer.class);
        self.putExtra("Pman",pman);
        startActivity(self);
    }

    public void Fight(){
        Intent fight = new Intent(this,AboutPlayer.class);
        fight.putExtra("Pman",pman);
        startActivity(fight);
    }


}
