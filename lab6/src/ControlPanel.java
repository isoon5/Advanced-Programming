import javax.imageio.ImageIO;
import javax.swing.*;
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
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
        }catch (IOException ex){
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e) {
        try {
            String path = "d:/test.png";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().add(label);
            f.pack();
            f.setLocation(200,200);
            f.setVisible(true);

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void reset(ActionEvent e){
        frame.canvas.createOffscreenImage();
    }
    private void exit(ActionEvent e){

        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

}
