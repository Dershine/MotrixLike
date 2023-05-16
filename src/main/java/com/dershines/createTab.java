package com.dershines;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class createTab {

    public static Tab createProcTab(Proc proc){
        Tab tab = new Tab(proc.getPname());
        TextArea textArea = new TextArea();
        Font font = new Font(24);
        String tabID = "Proc_title" + proc.getPid();
        String textAreaID = "Proc_text" + proc.getPid();
        tab.setId(tabID);
        textArea.setId(textAreaID);
        textArea.setPromptText("请输入要通信的内容");
        textArea.setFont(font);
        tab.setContent(textArea);
        return tab;
    }

    public static Tab createSharedMryTab(int sharedMryKey){
        String sharedMryName = "SharedMry " + sharedMryKey;
        Tab tab = new Tab(sharedMryName);
        Font font = new Font(24);
        Label label = new Label();
        String tabID = "SharedMry_title" + sharedMryKey;
        String labelID = "SharedMry_text" + sharedMryKey;
        tab.setId(tabID);
        label.setId(labelID);
        label.setText("这是新的共享内存");
        label.setFont(font);
        tab.setContent(label);
        return tab;
    }

}
