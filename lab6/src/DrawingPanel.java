import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame){
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    public void createOffscreenImage(){
        image = new BufferedImage(W,H, BufferedImage.TYPE_INT_ARGB);
        graphics =image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0, W, H);
    }

    private void init(){
        setPreferredSize(new Dimension(W,H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y){
        Random rand = new Random();
        int radius = rand.nextInt(50);
        int sides = (int) frame.configPanel.sidesField.getValue();

        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        Color color = new Color(r,g,b, .5f);
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
        //graphics.fill(new NodeShape(x,y,radius));
    }


    @Override
    public void update(Graphics g){

    }

    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(image, 0, 0,this);
    }

    public class RegularPolygon extends Polygon{
        public RegularPolygon(int x0, int y0, int radius, int sides){
            double alpha = 2 * Math.PI / sides;
            for(int i = 0; i < sides; i++){
                double x = x0 + radius * Math.cos(alpha * i);
                double y = y0 + radius * Math.sin(alpha * i);
                this.addPoint((int) x, (int) y);
            }
        }
    }

    public class NodeShape extends Ellipse2D.Double{
        public NodeShape(double x0, double y0, double radius){
            super(x0 - radius / 2, y0 - radius / 2, radius, radius);
        }
    }
}
