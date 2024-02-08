import javax.swing.*;
import java.awt.*;

public class TJPanel extends JPanel{

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for(int i = 0; i<Maze.arr.size(); i++)
        {
            g2d.drawRect(i*getWidth()/Maze.arr.size(),getHeight(),getWidth()/Maze.arr.size(),-getHeight()/(Maze.arr.size()+1)* Maze.arr.get(i));
        }

    }

    class AnimationThread extends Thread{

        public void run(){
            for(;;)
            {
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                repaint();
            }
        }
    }

    TJPanel(){
        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.f),Color.BLACK)); //ustawiamy obrzeza Jpanelu
        (new AnimationThread()).start();
    }



}
