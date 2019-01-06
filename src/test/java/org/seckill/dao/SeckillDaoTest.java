package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/****
 *配置spring和junit整合，junit启动时候加载Spring容器
 *spring-test,junit
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉spring的junit的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    //注入dao实现依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void testQueryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
    }

    @Test
    public void testReduceNumber() throws Exception {
        /****
         * Caused by: org.apache.ibatis.binding.BindingException:
         * Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
         * List<Seckill> queryAll(int offset,int limit);
         *java没有保存形参的记录 queryAll(int offset,int limit)--->queryAll(arg0,arg1)
         */
        List<Seckill> seckillList = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckillList) {
            System.out.println(seckill.getName());
        }
    }


    @Test
    public void testQueryAll() throws Exception {
        Date killTime = new Date();
        int i = seckillDao.reduceNumber(1000L, killTime);
        System.out.println("updateCount=" + i);
    }
}