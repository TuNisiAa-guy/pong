import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Table extends JFrame {
    private static final int WIDTH = 858;
    private static final int HEIGHT = 525;
    private Racket player1;
    private Racket player2;
    private Ball ball;

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void main(String[] args) {
        Table t = new Table();
        t.setVisible(true);
        t.center();
        while(true){
            t.ball.updatePos();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public Table(){
        setLayout(null);
        setSize(Table.WIDTH, Table.HEIGHT);
        setUndecorated(true);
        setBackground(Color.BLACK);
        getContentPane().setBackground(Color.BLACK);
        player1 = new Racket(false, true);
        player2 = new Racket(false, false);
        ball = new Ball();
        add(player1);
        add(player2);
        add(ball);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        player2.move(true);
                        break;
                    case KeyEvent.VK_DOWN:
                        player2.move(false);
                        break;
                    case KeyEvent.VK_W:
                        player1.move(true);
                        break;
                    case KeyEvent.VK_S:
                        player1.move(false);
                        break;
                }
            }
        });
    }
    public void center(){
        Dimension size = Toolkit. getDefaultToolkit(). getScreenSize();
        int x = (size.width - Table.WIDTH) / 2;
        int y = (size.height - Table.HEIGHT) / 2;
        setLocation(x, y);
    }
}