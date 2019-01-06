package org.seckill.exception;

/**
 * 重复秒杀（运行期异常）
 * Created by Administrator on 2016/12/5.
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
