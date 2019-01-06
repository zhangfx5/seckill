package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

//region Description

/**
 * Created by Administrator on 2016/12/3.
 */
public interface SeckillDao {
    /***
     *减库存
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /*****
     *根据id查询秒杀对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /****
     *根据偏移量来查询秒杀列表
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /***
     * 调用存储过程执行秒杀操作
     * @param paramMap
     */
    void killByProcedure(Map<String, Object> paramMap);
}
//endregion
