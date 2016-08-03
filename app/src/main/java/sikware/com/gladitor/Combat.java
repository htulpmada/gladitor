package sikware.com.gladitor;

import java.util.Random;

/**
 * Created by gomez on 7/29/16.
 */
public class Combat {
    Random Dice = new Random();
    int PlrHp,AiHp,PlrHit,AiHit,PlrArm,AiArm,PlrDam=0,AiDam=0;


    public Combat(){}

    public void Fight(Player p1, Enemy ai){
        PlrHp = p1.Hp;
        AiHp = ai.Hp;
        PlrHit = Dice.nextInt(20)+p1.str+Dice.nextInt(p1.luck);
        AiArm = Dice.nextInt(20)+ai.agl+Dice.nextInt(ai.luck);
        AiHit = Dice.nextInt(20)+p1.str+Dice.nextInt(p1.luck);
        PlrArm = Dice.nextInt(20)+ai.agl+Dice.nextInt(ai.luck);
        if(p1.weaponL.type!="s") {PlrDam += p1.weaponL.power;}
        else{PlrArm+=p1.weaponL.power;}
        if(p1.weaponR.type!="s") {PlrDam += p1.weaponR.power;}
        else{PlrArm+=p1.weaponR.power;}
        if(ai.weapon.type!="s") {AiDam += ai.weapon.power;}
        if(ai.shield!=null){AiArm+=ai.shield.power;}
    }

    public int Damage(boolean plr){
        if(plr){return PlrDam;}
        else{return AiDam;}
    }

    public boolean strike(boolean plrTurn){
        if(plrTurn){
            if(PlrHit>AiArm){return true;}
        }
        else{
            if(PlrHit<AiArm){return true;}
        }
        return false;
    }

}
