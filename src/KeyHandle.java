import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandle implements KeyListener {
    Gui gui;

    public KeyHandle(Gui gui){
        this.gui=gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
            gui.file.save();
        }
        if(e.isShiftDown() && e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
            gui.file.saveAS();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z){
            gui.edit.doUndo();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Y){
            gui.edit.doRedo();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O){
            gui.file.open();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_E){
            gui.file.exit();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
