package Notebook;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Notebook implements ActionListener {
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    JMenuItem iUndo, iRedo;
    JMenuItem iWrap, iFontAreal, iFontCSMS, iFontTNR, iFontSize12, iFontSize16, iFontSize20, iFontSize24;
    JMenu menuFont, menuFontSize;
    JMenuItem iColor, iColor1, iColor2,iColor3;

    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Color color = new Function_Color(this);
    Functional_Edit edit = new Functional_Edit(this);

    UndoManager un = new UndoManager();

    public static void main(String[] args) {
        new Notebook();
    }

    public Notebook() {
        createWinwow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColorMenu();
        format.selectedFont = "Arial";
        format.createFont(12);
        format.wordWrap();
        color.changeColor("White");
        window.setVisible(true);
    }

    public void createWinwow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();

        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                un.addEdit(e.getEdit());
            }
        });

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        menuFile.add(iExit);


    }

    public void createEditMenu() {
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }

    public void createFormatMenu() {
        iWrap = new JMenuItem("WordWrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontAreal = new JMenuItem("Arial");
        iFontAreal.addActionListener(this);
        iFontAreal.setActionCommand("Arial");
        menuFont.add(iFontAreal);

        iFontCSMS = new JMenuItem("CSMS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("CSMS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("TNR");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("TNR");
        menuFont.add(iFontTNR);


        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        menuFontSize.add(iFontSize24);
    }

    public void createColorMenu() {
        iColor = new JMenuItem("White");
        iColor.addActionListener(this);
        iColor.setActionCommand("White");
        menuColor.add(iColor);

        iColor1 = new JMenuItem("Black");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("Black");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Blue");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Blue");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Pink");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Pink");
        menuColor.add(iColor3);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.open();
                break;
            case "Save":
                file.save();
                break;
            case "Save As":
                file.saveAs();
                break;
            case "Exit":
                file.exit();
                break;
            case "Undo":
                edit.undo();
                break;
            case "Redo":
                edit.redo();
            case "Word Wrap":
                format.wordWrap();
                break;
            case "Arial":
                format.setFont(command);
                break;
            case "CSMS":
                format.setFont(command);
                break;
            case "TNR":
                format.setFont(command);
                break;
            case "12":
                format.createFont(12);
                break;
            case "16":
                format.createFont(16);
                break;
            case "20":
                format.createFont(20);
                break;
            case "24":
                format.createFont(24);
                break;
            case "White":
                color.changeColor(command);
                break;
            case "Black":
                color.changeColor(command);
                break;
            case "Blue":
                color.changeColor(command);
                break;
            case "Pink":
                color.changeColor(command);
                break;
        }

    }

}

