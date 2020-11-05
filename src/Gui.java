import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {


    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat;
    JMenuItem itemNew, itemSave, itemOpen, itemSaveAs, itemExit;

    JMenu formatFont, formatFontSize;
    JMenuItem formatWrap, fontArial, fontComicSansMs, fontTimesNewRoman;
    JMenuItem fontSize8, fontSize10, fontSize12, fontSize14, fontSize16, fontSize18, fontSize20, fontSize24, fontSize28;

    JMenuItem editUndo, editRedo;

    boolean wordWrap = false;

    FunctionFile file = new FunctionFile(this);
    FunctionFormat format = new FunctionFormat(this);
    UndoManager um = new UndoManager();
    FunctionEdit edit = new FunctionEdit(this);
    KeyHandle kh = new KeyHandle(this);


    public Gui() {
        createWindow();
        createTextArea();
        createMenuBar();
        createMenuItems();
        createFormat();
        createEdit();
        format.selected = "Arial";
        format.createFonts(16);
        window.setVisible(true);
    }


    public void createWindow() {
        window = new JFrame("NotePad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();
        textArea.getDocument().addUndoableEditListener(
                e -> um.addEdit(e.getEdit())
        );
        textArea.addKeyListener(kh);
        scrollPane = new JScrollPane(textArea, scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, scrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
    }

    public void createMenuItems() {
        itemNew = new JMenuItem("New");
        itemNew.addActionListener(this);
        itemNew.setActionCommand("New");
        menuFile.add(itemNew);

        itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("Open");
        menuFile.add(itemOpen);

        itemSave = new JMenuItem("Save");
        itemSave.addActionListener(this);
        itemSave.setActionCommand("Save");
        menuFile.add(itemSave);

        itemSaveAs = new JMenuItem("SaveAs");
        itemSaveAs.addActionListener(this);
        itemSaveAs.setActionCommand("SaveAS");
        menuFile.add(itemSaveAs);

        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(this);
        itemExit.setActionCommand("Exit");
        menuFile.add(itemExit);
    }

    public void createEdit() {
        editUndo = new JMenuItem("Undo");
        menuEdit.add(editUndo);
        editUndo.addActionListener(this);
        editUndo.setActionCommand("Undo");

        editRedo = new JMenuItem("Redo");
        menuEdit.add(editRedo);
        editRedo.addActionListener(this);
        editRedo.setActionCommand("Redo");
    }

    public void createFormat() {
        formatWrap = new JMenuItem("Word Wrap: Off");
        menuFormat.add(formatWrap);
        formatWrap.addActionListener(this);
        formatWrap.setActionCommand("Wrap");

        formatFont = new JMenu("Font");
        menuFormat.add(formatFont);
        fontArial = new JMenuItem("Arial");
        fontComicSansMs = new JMenuItem("Comic Sans Ms");
        fontTimesNewRoman = new JMenuItem("Times New Roman");

        formatFont.add(fontArial);
        formatFont.add(fontTimesNewRoman);
        formatFont.add(fontComicSansMs);

        fontArial.addActionListener(this);
        fontArial.setActionCommand("Arial");
        fontTimesNewRoman.addActionListener(this);
        fontTimesNewRoman.setActionCommand("Times New Roman");
        fontComicSansMs.addActionListener(this);
        fontComicSansMs.setActionCommand("Comic Sans Ms");

        formatFontSize = new JMenu("Font Size");
        menuFormat.add(formatFontSize);

        fontSize8 = new JMenuItem("8");
        formatFontSize.add(fontSize8);
        fontSize8.addActionListener(this);
        fontSize8.setActionCommand("size8");

        fontSize10 = new JMenuItem("10");
        formatFontSize.add(fontSize10);
        fontSize10.addActionListener(this);
        fontSize10.setActionCommand("size10");

        fontSize12 = new JMenuItem("12");
        formatFontSize.add(fontSize12);
        fontSize12.addActionListener(this);
        fontSize12.setActionCommand("size12");

        fontSize14 = new JMenuItem("14");
        formatFontSize.add(fontSize14);
        fontSize14.addActionListener(this);
        fontSize14.setActionCommand("size14");

        fontSize16 = new JMenuItem("16");
        formatFontSize.add(fontSize16);
        fontSize16.addActionListener(this);
        fontSize16.setActionCommand("size16");

        fontSize18 = new JMenuItem("18");
        formatFontSize.add(fontSize18);
        fontSize18.addActionListener(this);
        fontSize18.setActionCommand("size18");

        fontSize20 = new JMenuItem("20");
        formatFontSize.add(fontSize20);
        fontSize20.addActionListener(this);
        fontSize20.setActionCommand("size20");

        fontSize24 = new JMenuItem("24");
        formatFontSize.add(fontSize24);
        fontSize24.addActionListener(this);
        fontSize24.setActionCommand("size24");

        fontSize28 = new JMenuItem("28");
        formatFontSize.add(fontSize28);
        fontSize28.addActionListener(this);
        fontSize28.setActionCommand("size28");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New": file.newFile();break;

            case "Open": file.open();break;

            case "Save": file.save();break;

            case "SaveAS": file.saveAS();break;

            case "Exit": file.exit();break;

            case "Undo": edit.doUndo();break;

            case "Redo": edit.doRedo();break;

            case "Wrap": format.createWordWrap();break;

            case "Arial": format.setFont("Arial");break;

            case "Times New Roman": format.setFont("Times New Roman");break;

            case "Comic Sans Ms": format.setFont("Comic Sans Ms");break;

            case "size8": format.createFonts(8);break;

            case "size10": format.createFonts(10);break;

            case "size12": format.createFonts(12);break;

            case "size14": format.createFonts(14);break;

            case "size16": format.createFonts(16);break;

            case "size18": format.createFonts(18);break;

            case "size20": format.createFonts(20);break;

            case "size24": format.createFonts(24);break;

            case "size28": format.createFonts(28);break;

        }
    }
}

