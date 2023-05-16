package com.dershines;

import java.util.HashMap;
import java.util.Map;

public class sharedMryAndProc {

    private int pid = 0;
    private int sharedMryKey = 0;
    private Map<Integer, SharedMry> sharedMryList = new HashMap<>();
    private Map<Integer, Proc> procList = new HashMap<>();

    public void main() {
        //初始化两个进程
        String pname1 = "Proc 0";
        String pname2 = "Proc 1";
        Proc proc1 = new Proc(pid, pname1);
        procList.put(pid, proc1);
        pid++;
        Proc proc2 = new Proc(pid, pname2);
        procList.put(pid, proc2);
        pid++;

        //初始化一个共享内存
        SharedMry sharedMry = new SharedMry(sharedMryKey);
        sharedMryList.put(sharedMryKey, sharedMry);
        sharedMryKey++;

        //关联初始的两个进程与共享内存
        connectSharedMry.connect(proc1, sharedMry);
        connectSharedMry.connect(proc2, sharedMry);
    }

    //进程写入信息到共享内存
    public int procW(String sentence, int pid){
        SharedMry sharedMry = null;
        int tempSharedMryKey = 0;
        try {
            tempSharedMryKey = procList.get(pid).getSharedMryKey();
            sharedMry = sharedMryList.get(tempSharedMryKey);
            sharedMry.setMemory(sentence);
            sharedMryList.put(tempSharedMryKey, sharedMry);
        } catch (NullPointerException e) {
            System.out.println("该进程未关联共享内存或关联的共享内存不存在");
        } finally {
            return 1;
        }
    }

    //进程从共享内存读取信息
    public String procR(int pid){
        String info = null;
        try {
            int tempSharedMryKey = procList.get(pid).getSharedMryKey();
            info = sharedMryList.get(tempSharedMryKey).getMemory();
        } catch (NullPointerException e){
            String warning = "警告，该进程未关联共享内存";
            return warning;
        }
        return info;
    }

    //创建新进程
    public Proc createP(){
        String pname = "Proc " + pid;
        Proc proc = new Proc(pid, pname);
        procList.put(pid, proc);
        pid++;
        return proc;
    }

    //创建新共享内存
    public SharedMry createS(){
        SharedMry sharedMry = new SharedMry(sharedMryKey);
        sharedMryList.put(sharedMryKey, sharedMry);
        sharedMryKey++;
        return sharedMry;
    }

    //删除进程
    public int deleteP(int pid){
        Proc proc = procList.get(pid);
        SharedMry sharedMry = sharedMryList.get(proc.getSharedMryKey());
        int key = 0;
        try {
            key = sharedMry.getKey();
            sharedMry.setIpc_connect_number(sharedMry.getIpc_connect_number() - 1);
            sharedMryList.put(key, sharedMry);
        } catch (NullPointerException e) {
            return 0;
        } finally {
            procList.remove(pid);
            return 1;
        }
    }

    //删除共享内存
    public int deleteS(int key){
        sharedMryList.remove(key);
        return 1;
    }

    //将共享内存挂接到进程
    public int connectPAS(int pid, int sharedMryKey){
        Proc proc = procList.get(pid);
        SharedMry sharedMry = sharedMryList.get(sharedMryKey);
        disconnectPAS(pid); //断开原本的连接
        connectSharedMry.connect(proc, sharedMry);
        procList.put(pid, proc);
        sharedMryList.put(sharedMryKey, sharedMry);
        return 1;
    }

    //删除共享内存与进程地址空间的映射关系
    public int disconnectPAS(int pid){
        Proc proc = procList.get(pid);
        try {
            int sharedMryKey = proc.getSharedMryKey();
            SharedMry sharedMry = sharedMryList.get(sharedMryKey);
            disconnectSharedMry.disconnect(sharedMry, proc);
        } catch (NullPointerException e){
            return 0;
        }finally {
            return 1;
        }
    }

    //观察共享内存及进程情况
    public void details(){
        System.out.println(procList);
        System.out.println("-------------------------------");
        System.out.println(sharedMryList);
    }


}
