package com.dershines;

/**
 * 共享内存类
 */
public class SharedMry {

    private int key;
    private int ipc_connect_number = 0;
    private String memory;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getIpc_connect_number() {
        return ipc_connect_number;
    }

    public void setIpc_connect_number(int ipc_connect_number) {
        this.ipc_connect_number = ipc_connect_number;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public SharedMry(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "{" +
                "key=" + key +
                ", ipc_connect_number=" + ipc_connect_number +
                ", memory='" + memory + '\'' +
                '}' + '\n';
    }
}
