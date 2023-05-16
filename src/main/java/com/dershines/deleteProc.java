package com.dershines;

public class deleteProc {

    /**
     * 删除共享内存
     * @param proc
     * 由于java虚拟机没有主动释放内存的方式，因此将进程设为null，等待java虚拟机自动回收垃圾
     */
    public deleteProc(Proc proc) {
        proc = null;
    }
}
