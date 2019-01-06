package org.seckill.exception;

/**
 * 秒杀结束
 * Created by Administrator on 2016/12/5.
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
