import javax.swing.*;
import java.awt.*;

public class Racket extends JPanel {
    private static final int HEIGHT = 130;
    private static final int WIDTH = 10;
    private int posX;
    private int posY;
    private static final int SPEED = 10;
    private boolean isPlayer;
    public Racket(boolean auto, boolean side){
        isPlayer = !auto;
        setBackground(Color.WHITE);
        setSize(new Dimension(WIDTH, HEIGHT));
        center(side);
    }

    public void center(boolean side){
        posX = side ? 10 : Table.getWIDTH() - 10 - WIDTH;
        posY = (Table.getHEIGHT() - HEIGHT) / 2;
        setLocation(posX, posY);
    }

    public void move(boolean up){
        if(up){
            if(posY - Racket.SPEED > 0){
                posY -= Racket.SPEED;
            }
        }else{
            if(posY + Racket.SPEED + HEIGHT < Table.getHEIGHT()){
                posY += Racket.SPEED;
            }
        }
        setLocation(posX, posY);
    }
}
