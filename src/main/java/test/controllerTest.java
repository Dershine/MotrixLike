package test;

import com.dershines.*;

public class controllerTest {
    public static void main(String[] args) {
        sharedMryAndProc smsp = new sharedMryAndProc();
        smsp.main();
        //创建进程
        smsp.createP();
        smsp.createP();
        //创建共享内存
        smsp.createS();
        //关联共享内存和进程
        smsp.connectPAS(2, 1);
        smsp.connectPAS(3, 1);
        //删除映射关系
        smsp.disconnectPAS(2);
        //进程通信
        smsp.procW("hello ", 0);
        smsp.procW("world!", 1);
        //读取信息
        smsp.procR(0);
        smsp.procR(1);
        smsp.details();
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        //删除共享内存
        smsp.deleteS(1); //此后再使用proc4通信会报错
        smsp.details();
        //删除进程
        smsp.deleteP(2);
        smsp.details();
        //向不存在的共享内存写入信息
        smsp.procW("world!", 1);
    }
}
