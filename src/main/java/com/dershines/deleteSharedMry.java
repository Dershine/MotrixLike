package com.dershines;

public class deleteSharedMry {

    /**
     * 删除共享内存
     * @param sharedMry
     * 由于java虚拟机没有主动释放内存的方式，因此将共享内存设为null，等待java虚拟机自动回收垃圾
     */
    public deleteSharedMry(SharedMry sharedMry) {
        sharedMry = null;
    }
}
