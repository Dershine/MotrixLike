package com.dershines;

public class connectSharedMry {


    /**
     * 使创建的共享内存与调用该函数进程的进程地址空间参数关联
     * @param sharedMry
     * @param proc
     */
    public static void connect(Proc proc, SharedMry sharedMry) {
        sharedMry.setIpc_connect_number(sharedMry.getIpc_connect_number() + 1);
        proc.setSharedMryKey(sharedMry.getKey());
    }
}
