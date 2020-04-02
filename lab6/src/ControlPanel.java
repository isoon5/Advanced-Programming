import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){

        setLayout(new GridLayout(1,4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e){
        try{
            JFileChooser browse = new JFileChooser("D:\\Facultate");
            browse.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            browse.showSaveDialog(null);

            ImageIO.write(frame.canvas.image, "PNG", new File(browse.getSelectedFile().getAbsoluteFile(), "saved_img.png"));

        }catch (IOException ex){
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e) {
        JFileChooser browse = new JFileChooser();
        browse.setDialogTitle("Select the image you want to load");
        FileNameExtensionFilter filterFiles = new FileNameExtensionFilter("Image files extension: .png .jpg .jpeg", "jpg", "png", "gif", "jpeg");
        browse.addChoosableFileFilter(filterFiles);

        if(browse.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File file = browse.getSelectedFile();
            try{
                frame.canvas.image = ImageIO.read(file);
                frame.canvas.graphics = frame.canvas.image.createGraphics();
                frame.canvas.repaint();
            } catch (IOException ex){
                System.err.println(ex);
            }
        }
    }

    private void reset(ActionEvent e){
        frame.canvas.createOffscreenImage();
    }
    private void exit(ActionEvent e){

        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

}
