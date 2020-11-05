public class FunctionEdit {
    Gui gui;

    public FunctionEdit(Gui gui){
        this.gui=gui;
    }

    public void doUndo(){
        gui.um.undo();
    }

    public void doRedo(){
        gui.um.redo();
    }

}
