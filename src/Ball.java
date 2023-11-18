import javax.swing.JPanel;
import java.awt.*;

public class Ball extends JPanel{
    private int direction = 0;
    private int posX = 0;
    private int posY = 0;
    private final int HEIGHT = 20;
    private final int WIDTH = 20;
    private static final int SPEED = 20;
    public Ball(){
        setBackground(Color.WHITE);
        center();
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }
    public void updatePos(){
        posX += (int) Math.sin(direction/(360 * Math.TAU)) * SPEED;
        posX += (int) Math.cos(direction/(360 * Math.TAU)) * SPEED;
        setLocation(posX, posY);
    }

    public void center(){
        posX = (Table.getWIDTH() - WIDTH) / 2;
        posY = (Table.getHEIGHT() - HEIGHT) / 2;
    }
}
