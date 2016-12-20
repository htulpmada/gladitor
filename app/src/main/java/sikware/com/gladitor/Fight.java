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
    boolean done=false;
    Random r = new Random();
    Enemy ai;
    ImageView pic1;
    AnimationDrawable attackAnimation;
    ImageView pic2;
    AnimationDrawable aiattackAnimation;
    Doc doc;
    //TODO make fancier and include speed factor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        TextView php=(TextView)findViewById(R.id.playerHP);
        TextView ahp=(TextView)findViewById(R.id.aiHP);
        BattlePrep();
        p=Global.p1;
        p.getDamage();
        //TODO change to Player class     v v v v(test needed)
        if(Global.ai==null){Global.ai=new Enemy(Global.loc.badguys.get(Global.arena+r.nextInt(2)));}
        ai=Global.ai;
        //p.show();
        php.setText(p.Hp.toString());
        ahp.setText(ai.Hp.toString());
        pic1=(ImageView)findViewById(R.id.fight);
        pic1.setBackgroundResource(p.avatar);
        attackAnimation=(AnimationDrawable) pic1.getBackground();
        pic2=(ImageView)findViewById(R.id.aifight);
        pic2.setBackgroundResource(ai.avatar);
        aiattackAnimation=(AnimationDrawable) pic2.getBackground();
    }

    private void BattlePrep() {
        //TODO put all math or combat engine HERE v v v v v v
    }

    @Override
    public void onPause(){
        super.onPause();
        Global.p1=p;
        Global.ai=ai;

    }
    @Override
    public void onResume(){
        super.onResume();
        if(done){
            endCombat();
        }
        setContentView(R.layout.activity_fight);
        TextView php=(TextView)findViewById(R.id.playerHP);
        TextView ahp=(TextView)findViewById(R.id.aiHP);
        p=Global.p1;
        p.getDamage();
        if(Global.ai==null){Global.ai=new Enemy(Global.loc.badguys.get(r.nextInt(2)));}
        ai=Global.ai;
        //p.show();
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
        if(ai==null){return;}
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
        }, 800);
        pic2.postDelayed(new Runnable() {
            @Override
            public void run() {
                pic2.setVisibility(View.GONE);
                pic2.setVisibility(View.VISIBLE);
                attackAnimation.stop();
                aiattackAnimation.stop();
                endCombat();
            }
        }, 1600);
        TextView php = (TextView)findViewById(R.id.playerHP);
        php.setText(p.Hp.toString());
        TextView ahp=(TextView)findViewById(R.id.aiHP);
        ahp.setText(ai.Hp.toString());


    }
    @Override
    public void onBackPressed(){return;}

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("done", done);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedIntanceState){
        super.onRestoreInstanceState(savedIntanceState);
        done=savedIntanceState.getBoolean("done",done);
    }

    public void endCombat() {
        if(ai==null){return;}//might cause problems
        if (ai.Hp < 1 || p.Hp < 0) {
            Global.pman.Add(p);
            rest();
        }
    }

    private void rest() {
        doc =new Doc(this);
        done=true;
        if (ai.Hp < 1){arenaBeaten();}
            ai=null;
        doc.show();
    }


    private void arenaBeaten(){
        if(Global.arena+(Global.loc.number*10) > Global.p1.arenasBeatten){
            Global.p1.arenasBeatten=Global.arena+(Global.loc.number*10);
        }
    }

    private void Damage() {
        Integer pd,ad,pa,aa,pat,aat;
        pat=p.mstr+r.nextInt(20);
        aat=ai.mstr+r.nextInt(20);
        pd=p.dmg+p.mluck;
        if(ai==null){return;}
        ad = (ai.weapon.power + ai.mstr) * Global.difficulty + 1 + r.nextInt(ai.luck);
        pa=p.ac+r.nextInt(p.luck);
        aa=(ai.armor.power+ai.magl)*Global.difficulty+r.nextInt(ai.luck);
        if(pat<=aa){pd=0;}
//        pd=pd-aa;
        if(aat<=pa){ad=0;}
//        ad=ad-pa;
        Log.e("gladitor","Pd: "+pd+" AId: "+ad);
        if(ad>0){p.Hp=p.Hp-ad;}
        if(pd>0){ai.Hp=ai.Hp-pd;}
    }

}
