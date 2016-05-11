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
    Enemy ai;
    ImageView pic1;
    AnimationDrawable attackAnimation;
    ImageView pic2;
    AnimationDrawable aiattackAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        p=Global.p1;
        ai=p.current.badguys.get(0);
        pic1=(ImageView)findViewById(R.id.fight);
        pic1.setBackgroundResource(R.drawable.attack);
        attackAnimation=(AnimationDrawable) pic1.getBackground();
        pic2=(ImageView)findViewById(R.id.aifight);
        pic2.setBackgroundResource(R.drawable.aiattack);
        aiattackAnimation=(AnimationDrawable) pic2.getBackground();
        //aiattackAnimation.;
    }
    public void fight(View view) {
        //p1goes then ai
        pic1.post(new Runnable() {
            @Override
            public void run() {
                attackAnimation.start();
            }
        });
        attackAnimation.stop();
        pic2.post(new Runnable(){
            @Override
            public void run(){aiattackAnimation.start();}
        });
        aiattackAnimation.stop();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {


    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
