package sikware.com.gladitor;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

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
        TextView php=(TextView)findViewById(R.id.playerHP);
        TextView ahp=(TextView)findViewById(R.id.aiHP);
        p=Global.p1;
        ai=new Enemy();

        //ai=p.current.badguys.get(0);
        p.Hp=p.con*(5/Global.difficulty)+1;
        ai.Hp=ai.con*(5/Global.difficulty)+1;
        php.setText(p.Hp.toString());
        ahp.setText(ai.Hp.toString());
        pic1=(ImageView)findViewById(R.id.fight);
        pic1.setBackgroundResource(R.drawable.attack);
        attackAnimation=(AnimationDrawable) pic1.getBackground();
        pic2=(ImageView)findViewById(R.id.aifight);
        pic2.setBackgroundResource(R.drawable.aiattack);
        aiattackAnimation=(AnimationDrawable) pic2.getBackground();
        //aiattackAnimation.;
    }
    public void fight(View view) {
        Damage();
        //p1goes then ai
        pic1.post(new Runnable() {
            @Override
            public void run() {
                attackAnimation.start();
            }
        });
        attackAnimation.stop();
        pic2.post(new Runnable() {
            @Override
            public void run() {
                aiattackAnimation.start();
            }
        });
        aiattackAnimation.stop();
        TextView php=(TextView)findViewById(R.id.playerHP);
        TextView ahp=(TextView)findViewById(R.id.aiHP);
        php.setText(p.Hp.toString());
        ahp.setText(ai.Hp.toString());

    }
    @Override
    public void onBackPressed(){return;}

    private void Damage() {
        Integer pd=0,ad=0,pa=0,aa=0;
        pd=(p.weapon.power+p.str)*Global.difficulty+1;
        ad=(ai.weapon.power+ai.str)*Global.difficulty;
        pa=(p.armor.power+p.str)*Global.difficulty;
        aa=(ai.armor.power+ai.str)*Global.difficulty;
        pd=pd-aa;
        ad=ad-pa;
        if(ad>0){p.Hp=p.Hp-ad;}
        if(pd>0){ai.Hp=ai.Hp-pd;}
        if(ai.Hp<1||p.Hp<0){finish();}
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
