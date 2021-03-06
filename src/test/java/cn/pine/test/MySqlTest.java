package cn.pine.test;

import cn.pine.simple.OrderNumGenerator;
import cn.pine.zk.Lock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by VULCAN on 2018/9/20.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MySqlTest {
    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
    // 使用lock锁
    // private java.util.concurrent.locks.Lock lock = new ReentrantLock();


    @Resource
    private Lock lock;



    @Test
    public  void testGetOrderNumber() throws InterruptedException {
        System.out.println("####生成唯一订单号###");
//		OrderService orderService = new OrderService();
        for (int i = 0; i < 50; i++) {
            new Thread(
                    new Runnable() {
                        public void run() {
                            getNumber();
                        }
                    }
            ).start();
        }

        Thread.currentThread().join();
    }


    public void getNumber() {
        try {
            lock.getLock();
            String number = orderNumGenerator.getNumber();
            System.out.println(Thread.currentThread().getName() + ",生成订单ID:" + number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
        }
    }
}