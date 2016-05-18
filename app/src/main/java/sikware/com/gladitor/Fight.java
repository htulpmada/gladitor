package sikware.com.gladitor;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Fight extends AppCompatActivity{
    Player p;
    Enemy ai;
    ImageView pic1;
    AnimationDrawable attackAnimation;
    ImageView pic2;
    AnimationDrawable aiattackAnimation;
    Random r =new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        TextView php=(TextView)findViewById(R.id.playerHP);
        TextView ahp=(TextView)findViewById(R.id.aiHP);
        p=Global.p1;
        ai=new Enemy();
        p.show();
        //ai=p.current.badguys.get(0);
        //p.Hp=(p.con*(5/Global.difficulty))+1;
        ai.Hp=(ai.con*(5/Global.difficulty))+1;
        php.setText(p.Hp.toString());
        ahp.setText(ai.Hp.toString());
        pic1=(ImageView)findViewById(R.id.fight);
        pic1.setBackgroundResource(p.avatar);
        attackAnimation=(AnimationDrawable) pic1.getBackground();
        pic2=(ImageView)findViewById(R.id.aifight);
        pic2.setBackgroundResource(ai.avatar);
        aiattackAnimation=(AnimationDrawable) pic2.getBackground();

    }
    public void fight(View view) {
        if(aiattackAnimation.isRunning()||attackAnimation.isRunning()){return;}
        Damage();
        //p1goes then ai
        pic1.post(new Runnable() {
            @Override
            public void run() {
                attackAnimation.start();
                }
        });
        pic2.postDelayed(new Runnable() {
            @Override
            public void run() {
                aiattackAnimation.start();
            }
        },1000);
        pic2.postDelayed(new Runnable() {
            @Override
            public void run() {
                pic2.setVisibility(View.GONE);
                pic2.setVisibility(View.VISIBLE);
                attackAnimation.stop();
                aiattackAnimation.stop();
                endCombat();
            }
        }, 1900);
        TextView php = (TextView)findViewById(R.id.playerHP);
        TextView ahp=(TextView)findViewById(R.id.aiHP);
        php.setText(p.Hp.toString());
        ahp.setText(ai.Hp.toString());


    }
    @Override
    public void onBackPressed(){return;}

    public void endCombat() {
        if (ai.Hp < 1 || p.Hp < 0) {
            //insert rewards/punishments here
            p.Denarius+=(int)(r.nextInt(120)*.3);
            Global.pman.Add(p);
            Intent quit = new Intent(this, Camp.class);
            quit.addFlags(getIntent().FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(quit);
        }
    }

    private void Damage() {
        Integer pd=0,ad=0,pa=0,aa=0;
        pd=(p.weapon.power+p.str)*Global.difficulty+2+r.nextInt(p.luck);
        ad=(ai.weapon.power+ai.str)*Global.difficulty+1+r.nextInt(ai.luck);
        pa=(p.armor.power+p.agl)*Global.difficulty+r.nextInt(p.luck);
        aa=(ai.armor.power+ai.agl)*Global.difficulty+r.nextInt(ai.luck);
        pd=pd-aa;
        ad=ad-pa;
        Log.e("gladitor","pd: "+pd+" AIdam: "+ad);
        if(ad>0){p.Hp=p.Hp-ad;}
        if(pd>0){ai.Hp=ai.Hp-pd;}
    }

}
