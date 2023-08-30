package anmao.idoll.nekoweapon.cap.cooldown;

import anmao.idoll.nekoweapon.Config;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;

import java.util.Arrays;

public class PlayerCooldown {
    private static final String KEY = "PlayerItemCD";
    private static final String KEY_TIME = "PlayerItemTime";
    private final int itemNum = 1;
    private int[] itemCD = {
            0,//Adaptive Armor
            0
    };
    private final int itemTimeNum = 1;
    private int[] itemTime = {
            0,//Adaptive Armor
            0
    };

    public void setCD(int index,int time) {
        this.itemCD[index] = time;
    }
    public void setTime(int index,int time){this.itemTime[index] = time;}
    public boolean isCD(int index){
        return itemCD[index] > 0;
    }
    public boolean isTime(int index){return itemTime[index]>0;}
    public void subCD(){
        for (int i = 0; i < this.itemNum;i++){
            if (this.itemCD[i] > 0 ){
                this.itemCD[i] --;
            }
        }
        for (int i = 0; i < this.itemTimeNum;i++){
            if (this.itemTime[i] > 0 ){
                this.itemTime[i] --;
            }
        }
    }
    public void copyFrom(PlayerCooldown source){
        this.itemTime = source.itemTime;
        this.itemCD = source.itemCD;
    }
    public int getTest(){
        return itemCD[0];
    }





    public void saveNBTData(CompoundTag nbt)
    {
        nbt.putIntArray(KEY_TIME,itemTime);
        nbt.putIntArray(KEY,itemCD);
    }
    public void loadNBTData(CompoundTag nbt)
    {
        itemTime = nbt.getIntArray(KEY_TIME);
        itemCD = nbt.getIntArray(KEY);
    }
}
