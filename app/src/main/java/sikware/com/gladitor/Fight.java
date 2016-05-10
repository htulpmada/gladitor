package sikware.com.gladitor;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

public class Fight extends AppCompatActivity implements Animation.AnimationListener  {
    Player p;
    ImageView pic1;
    AnimationDrawable attackAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        p=Global.p1;
        pic1=(ImageView)findViewById(R.id.fight);
        pic1.setBackgroundResource(R.drawable.attack);
        attackAnimation=(AnimationDrawable) pic1.getBackground();
        //attackAnimation.start();
    }
    public void fight(View view) {
        attackAnimation.start();
       }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        pic1=(ImageView)findViewById(R.id.fight);
        pic1.setBackgroundResource(R.drawable.attack);
        attackAnimation=(AnimationDrawable) pic1.getBackground();
        setContentView(R.layout.activity_fight);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
