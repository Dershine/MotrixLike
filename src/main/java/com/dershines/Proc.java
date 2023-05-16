package com.dershines;

public class Proc {

    private int pid;
    private String pname;
    private int sharedMryKey = -1;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getSharedMryKey() {
        return sharedMryKey;
    }

    public void setSharedMryKey(int sharedMryKey) {
        this.sharedMryKey = sharedMryKey;
    }

    public Proc(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", sharedMryKey=" + sharedMryKey +
                '}' + '\n';
    }
}
