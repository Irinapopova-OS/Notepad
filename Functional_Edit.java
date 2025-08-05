package Notebook;

public class Functional_Edit {
    Notebook notebook;

    public Functional_Edit(Notebook notebook){
        this.notebook = notebook;
    }
    public void undo(){
        notebook.un.undo();
    }
    public void redo(){
        notebook.un.redo();
    }
}
