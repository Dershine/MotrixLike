package com.dershines;

public class disconnectSharedMry {

    /**
     * 删除共享内存与进程地址空间的映射关系
     * @param sharedMry
     * @param proc
     */
    public static void disconnect(SharedMry sharedMry, Proc proc) {
        sharedMry.setIpc_connect_number(sharedMry.getIpc_connect_number() - 1);
        proc.setSharedMryKey(-1);
    }
}
