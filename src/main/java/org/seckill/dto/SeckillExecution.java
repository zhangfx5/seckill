package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;

/**
 * Created by Administrator on 2016/12/5.
 */
public class SeckillExecution {

    private long seckillId;
    //秒杀状态
    private int state;
    private String stateinfo;

    private SuccessKilled sucessKilled;


    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateinfo() {
        return stateinfo;
    }

    public void setStateinfo(String stateinfo) {
        this.stateinfo = stateinfo;
    }

    public SuccessKilled getSucessKilled() {
        return sucessKilled;
    }

    public void setSucessKilled(SuccessKilled sucessKilled) {
        this.sucessKilled = sucessKilled;
    }

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccessKilled sucessKilled) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateinfo = statEnum.getStateInfo();
        this.sucessKilled = sucessKilled;
    }

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateinfo = statEnum.getStateInfo();
    }
}
