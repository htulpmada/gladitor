package sikware.com.gladitor;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Fight extends AppCompatActivity {
    Player p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        p=Global.p1;
        ImageView p1=(ImageView)findViewById(R.id.fight);
        StateListDrawable background=(StateListDrawable)p1.getBackground();
        AnimationDrawable attackAnimation=(AnimationDrawable) background.getCurrent();
        attackAnimation.setVisible(true,true);
//        p1.setBackgroundResource(R.drawable.attack);
    }
    public void fight(View view){
        ImageView p1=(ImageView)findViewById(R.id.fight);
        p1.setBackgroundResource(R.drawable.attack);
        AnimationDrawable attackFrames=(AnimationDrawable)p1.getBackground();
        attackFrames.start();
    }
}
