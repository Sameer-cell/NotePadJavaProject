import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionFile {
    Gui gui;
    String fileName;
    String fileAddress;

    public FunctionFile(Gui gui) {
        this.gui = gui;
    }

    public void newFile() {

        gui.textArea.setText("");
        gui.window.setTitle("New File");
        fileName = null;
        fileAddress = null;
    }

    public void open() {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            String line;
            while ((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File Cannot be Opened");
        }
    }

    public void save() {
        if (fileName == null) {
            saveAS();
        } else {
            try {
                FileWriter pw = new FileWriter(fileAddress + fileName);
                pw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                pw.close();
            } catch (Exception e) {
                System.out.println("could not save");
            }
        }
    }

    public void saveAS() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
            try {
                FileWriter pw = new FileWriter(fileAddress + fileName);
                pw.write(gui.textArea.getText());
                pw.close();
            } catch (Exception e) {
                System.out.println("Could not save");
            }
        }
    }

    public void exit() {
        System.exit(0);
    }
}


