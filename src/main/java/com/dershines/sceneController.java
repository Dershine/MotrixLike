package com.dershines;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class sceneController implements Initializable{

    sharedMryAndProc smap = new sharedMryAndProc();

    @FXML
    private TabPane Proc_Pane;

    @FXML
    private TabPane SharedMry_Pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        smap.main();
    }

    public void createProc(ActionEvent event){
        Proc proc = smap.createP();
        Tab tab = createTab.createProcTab(proc);
        Proc_Pane.getTabs().add(tab);
    }

    public void createSharedMry(ActionEvent event){
        SharedMry sharedMry = smap.createS();
        Tab tab = createTab.createSharedMryTab(sharedMry.getKey());
        SharedMry_Pane.getTabs().add(tab);
    }

    public void deleteProc(ActionEvent event){
        Tab tab = Proc_Pane.getSelectionModel().getSelectedItem();
        String tabID = tab.getId();
        String Proc_title = "Proc_title";
        int id = Integer.parseInt(tabID.substring(Proc_title.length()));
        Proc_Pane.getTabs().remove(tab);
        int result = smap.deleteP(id);
        if (result == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    public void deleteSharedMry(ActionEvent event){
        Tab tab = SharedMry_Pane.getSelectionModel().getSelectedItem();
        String tabID = tab.getId();
        String SharedMry_title = "SharedMry_title";
        int id = Integer.parseInt(tabID.substring(SharedMry_title.length()));
        SharedMry_Pane.getTabs().remove(tab);
        int result = smap.deleteS(id);
        if (result == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    public void connectPAS(ActionEvent event){
        Tab ptab = Proc_Pane.getSelectionModel().getSelectedItem();
        String ptabID = ptab.getId();
        String Proc_title = "Proc_title";
        int pid = Integer.parseInt(ptabID.substring(Proc_title.length()));
        Tab stab = SharedMry_Pane.getSelectionModel().getSelectedItem();
        String stabID = stab.getId();
        String SharedMry_title = "SharedMry_title";
        int sharedMryKey = Integer.parseInt(stabID.substring(SharedMry_title.length()));
        smap.connectPAS(pid, sharedMryKey);
    }

    public void disconnectPAS(ActionEvent event){
        Tab tab = Proc_Pane.getSelectionModel().getSelectedItem();
        String tabID = tab.getId();
        String Proc_title = "Proc_title";
        int id = Integer.parseInt(tabID.substring(Proc_title.length()));
        smap.disconnectPAS(id);
    }

    public void procW(){
        Tab ptab = Proc_Pane.getSelectionModel().getSelectedItem();
        String ptabID = ptab.getId();
        String Proc_title = "Proc_title";
        int pid = Integer.parseInt(ptabID.substring(Proc_title.length()));
        Tab stab = SharedMry_Pane.getSelectionModel().getSelectedItem();

        TextArea textArea = (TextArea) ptab.getContent();
        String info = textArea.getText();
        Label label = (Label) stab.getContent();
        label.setText(info);
        smap.procW(info, pid);
    }

    public void procR(){
        Tab ptab = Proc_Pane.getSelectionModel().getSelectedItem();
        String ptabID = ptab.getId();
        String Proc_title = "Proc_title";
        int pid = Integer.parseInt(ptabID.substring(Proc_title.length()));

        TextArea textArea = (TextArea) ptab.getContent();
        String info = smap.procR(pid);
        textArea.setText(info);
    }


}
