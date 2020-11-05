import java.awt.*;

public class FunctionFormat {
    Gui gui;
    Font arial,comicSansMS,timeNewRoman;
    String selected;

    public FunctionFormat(Gui gui){
        this.gui=gui;
    }

    public void createWordWrap(){
        if(!gui.wordWrap){
            gui.wordWrap=true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.formatWrap.setText("Word Wrap: On ");
        }else {
            gui.wordWrap=false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.formatWrap.setText("Word Wrap: Off");
        }
    }

    public void createFonts(int fontSize){
        arial =new Font("Arial",Font.PLAIN,fontSize);
        comicSansMS =new Font("Comic San Ms",Font.PLAIN,fontSize);
        timeNewRoman =new Font("Times New Roman",Font.PLAIN,fontSize);
        setFont(selected);
    }

    public void setFont(String font){
        selected=font;
        switch (selected){
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Comic Sans Ms":
                gui.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timeNewRoman);
                break;
        }
    }
}
