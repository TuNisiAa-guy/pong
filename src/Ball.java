import javax.swing.JPanel;
import java.awt.*;

public class Ball extends JPanel{
    private int direction = 30;
    private int deltaX = 0;
    private int deltaY = 0;
    private int posX = 0;
    private int posY = 0;
    private final int HEIGHT = 20;
    private final int WIDTH = 20;
    private static final int SPEED = 5;
    private Table table;
    public Ball(Table t){
        table = t;
        setBackground(Color.WHITE);
        center();
        setSize(WIDTH, HEIGHT);
        setVisible(true);

    }
    public void updatePos(){
        if(this.getBounds().intersects(table.getPlayer1().getBounds()) || this.getBounds().intersects(table.getPlayer2().getBounds())){
            deltaX = -1 * deltaX;
        }
        if(posY < 0 || posY > Table.getHEIGHT()){
            deltaY = -1 * deltaY;
        }
        posX += deltaX;
        posY += deltaY;
        setLocation(posX, posY);
    }
    public void center(){
        posX = (Table.getWIDTH() - WIDTH) / 2;
        posY = (Table.getHEIGHT() - HEIGHT) / 2;
        deltaX = (int) (Math.cos(direction*(360 / Math.TAU)) * SPEED);
        deltaY = (int) (Math.sin(direction*(360 / Math.TAU)) * SPEED);
    }
}
