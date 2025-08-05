package Notebook;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;

public class Function_File {
    Notebook notebook;
    String fileName;
    String fileAddress;

    public Function_File(Notebook notebook){
        this.notebook = notebook;

    }
    public void newFile(){
        notebook.textArea.setText("");
        notebook.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }
    public void open(){
        FileDialog fd = new FileDialog(notebook.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            notebook.window.setTitle(fileName);


        }
        System.out.println("File address and file name" +fileAddress+fileName);
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
            notebook.textArea.setText("");
            String line = null;
            while ((line = br.readLine()) != null) {
                notebook.textArea.append(line+"\n");

            }
            br.close();

        }catch (Exception e){
            System.out.println("FILE NOT OPENED!");

        }
    }
    public void save(){
        if(fileName==null){
            saveAs();
        }
        else{
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(notebook.textArea.getText());
                notebook.window.setTitle(fileName);
                fw.close();

            }catch (Exception e){
                System.out.println("SOMETHING WRONG");
            }
        }

    }
    public void saveAs(){
        FileDialog fd = new FileDialog(notebook.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            notebook.window.setTitle(fileName);
        }
        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(notebook.textArea.getText());
            fw.close();

        }catch (Exception e){
            System.out.println("SOMETHING WRONG");
        }
    }
    public void exit(){
        System.exit(0);
    }
}
