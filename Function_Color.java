package Notebook;

import java.awt.*;

public class Function_Color {
    Notebook notebook;

    public Function_Color(Notebook notebook){
    this.notebook = notebook;
    }
    public void changeColor(String color){

        switch(color){
            case "White":
                notebook.window.getContentPane().setBackground(Color.white);
                notebook.textArea.setBackground(Color.white);
                notebook.textArea.setForeground(Color.black);
                break;
            case "Black":
                notebook.window.getContentPane().setBackground(Color.black);
                notebook.textArea.setBackground(Color.black);
                notebook.textArea.setForeground(Color.white);
                break;
            case "Blue":
                notebook.window.getContentPane().setBackground(Color.blue);
                notebook.textArea.setBackground(Color.blue);
                notebook.textArea.setForeground(Color.white);
                break;
            case "Pink":
                notebook.window.getContentPane().setBackground(Color.pink);
                notebook.textArea.setBackground(Color.pink);
                notebook.textArea.setForeground(Color.black);
                break;


        }

    }
}
