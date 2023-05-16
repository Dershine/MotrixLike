package com.dershines;

public class procCommunication {

    /**
     * 将进程要交换的信息写入共享内存
     * @param sharedMry
     * @param sentence
     */
    public procCommunication(SharedMry sharedMry, String sentence) {
        sharedMry.setMemory(sentence);
    }
}
