package cn.pine.zk;

import org.I0Itec.zkclient.ZkClient;

/**
 *
 * @author pine
 * @date 20200221
 */
public abstract class ZookeeperAbstractLock extends AbstractLock {
    // zk连接地址
    private static final String CONNECTSTRING = "47.93.206.149:20181";
    // 创建zk连接
    protected ZkClient zkClient = new ZkClient(CONNECTSTRING);
    protected static final String PATH = "/lock";


    protected static final String PATH2 = "/lock2";



}