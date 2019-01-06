--秒杀执行的存储过程
DELIMITER $$--console;转换为$$
--参数定义：in标示传入参数，out:输出参数
--row_count():返回上一条修改类型sql（insert,delete,update）的影响行数
--row_count():0未修改，大于零：标示修改的行数，小于0：sql错误，未执行修改sql
create  procedure seckill.execute_seckill
(in v_seckill_id bigint,in v_phone bigint,
 in v_kill_time timestamp,out r_result int)
 BEGIN
  DECLARE
      insert_count int default 0;
      START TRANSACTION;
      insert ignore into success_killed
      (seckill_id,user_phone,create_time)
      VALUES(v_seckill_id,v_phone,v_kill_time);
      select row_count() into insert_count;
      IF(insert_count =0) THEN
        ROLLBACK;
        set r_result=-1;
      ELSEIF(insert_count<0) THEN
        ROLLBACK;
        set r_result=-2;
      ELSE
        update seckill
        set number = number-1
        where seckill_id = v_seckill_id
          and end_time > v_kill_time
          and start_time < v_kill_time
          and number>0;
        select row_count()  into insert_count ;
        IF(insert_count=0) THEN
          ROLLBACK ;
          set r_result=0;
        ELSEIF(insert_count<0)THEN
         ROLLBACK;
         set r_result=-2;
        ELSE
           COMMIT;
          set r_result=1;
        END IF;
       END IF;
   END;
  $$
  ---存储过程定义结束

  DELIMITER ;
   set @r_result=-3;
   --执行存储过程
   call execute_seckill(1003,15193611173,NOW(),@r_result);
   --获取结果
   select @r_result;
