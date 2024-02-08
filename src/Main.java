import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class Main extends JFrame{
    Main() {
        (new TicTacToeThread()).start();
        buildGui();
    }

    int i = 0;


    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
//        g2d.translate(getWidth()/2,getHeight()/2);
//        g2d.drawString(Integer.toString(i),0,0);
//        g2d.drawArc(10,10,100,100,0,90);
        for(int x=0; x<10; x++)
        {
            for(int y=0; y<10; y++)
            {
                g2d.setColor(Color.decode("#131B23"));
                g2d.fillRect(1+50*y,1+50*x,49,49);
            }
        }


    }
    class TicTacToeThread extends Thread {
        @Override
        public void run() {
            for(;;)
            {

                i++;
                repaint();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    void buildGui()
    {

        MouseListener mouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Click");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Click");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Click");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Click");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }


//    public static void main(String[] args) {
//        JFrame frame = new JFrame("TicTacToe");
//        frame.setContentPane(new Main());
//        frame.setSize(600, 600);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(true);
//        frame.setVisible(true);
//
//
//
//
//    }
}