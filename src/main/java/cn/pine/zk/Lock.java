package cn.pine.zk;

/**
 *
 * @author pine
 * @date 20200221
 */
public interface Lock {
    /**
     * 获取到锁的资源
     */
    void getLock();

    /**
     * 释放锁
     */
    void unLock();
}
