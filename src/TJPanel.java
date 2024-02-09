import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class TJPanel extends JPanel{

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;



//        System.out.println(-getHeight()/(Maze.arr.size()+1)*10);
//        g2d.drawRect(getWidth()/Maze.arr.size(), getHeight(),getWidth()/Maze.arr.size(),-getHeight()/(Maze.arr.size()+1)*10);
        for(int i = 0; i<Maze.arr.size(); i++)
        {
            Rectangle2D x = new Rectangle2D.Float((float) (i * getWidth()) /Maze.arr.size(), getHeight()-5- (float) getHeight() /(Maze.arr.size()+1)* Maze.arr.get(i), (float) getWidth() /Maze.arr.size(), 5+(float) getHeight() /(Maze.arr.size()+1)* Maze.arr.get(i));
            g2d.setColor(Color.darkGray);
            g2d.fill(x);
            g2d.setColor(Color.black);
            g2d.draw(x);
            //WERSJA NA MAC
//            g2d.fillRect(i*getWidth()/Maze.arr.size(), getHeight()-getHeight()/(Maze.arr.size()+1)* Maze.arr.get(i),getWidth()/Maze.arr.size(),getHeight()/(Maze.arr.size()+1)* Maze.arr.get(i));
            //WERSJA NA WINDOWS
            //g2d.fillRect(i*getWidth()/Maze.arr.size(), getHeight(),getWidth()/Maze.arr.size(),-getHeight()/(Maze.arr.size()+1)* Maze.arr.get(i));
        }

    }

    class AnimationThread extends Thread{

        public void run(){
            while(true)
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
