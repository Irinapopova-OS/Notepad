package Notebook;

import java.awt.*;

public class Function_Format {
    Notebook notebook;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;

    public Function_Format(Notebook notebook) {
        this.notebook = notebook;

    }

    public void wordWrap() {

        if (notebook.wordWrapOn == false) {
            notebook.wordWrapOn = true;
            notebook.textArea.setLineWrap(true);
            notebook.textArea.setWrapStyleWord(true);
            notebook.iWrap.setText("Word Wrap: On");
        } else if (notebook.wordWrapOn == true) {
            notebook.wordWrapOn = false;
            notebook.textArea.setLineWrap(false);
            notebook.textArea.setWrapStyleWord(false);
            notebook.iWrap.setText("Word Wrap: Off");

        }

    }

    public void createFont(int fontSize) {
        arial = new Font("Arial",Font.PLAIN,fontSize);
        comicSansMS = new Font("CSMS",Font.PLAIN,fontSize);
        timesNewRoman = new Font("TNR",Font.PLAIN,fontSize);
        setFont(selectedFont);

    }
    public void setFont(String font){
        selectedFont = font;
        switch(selectedFont){
            case "Arial":
                notebook.textArea.setFont(arial);
                break;
            case "CSMS":
                notebook.textArea.setFont(comicSansMS);
                break;
            case "TNR":
                notebook.textArea.setFont(timesNewRoman);
                break;
        }


    }
}

