import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.time.LocalTime;

public class Zegar extends JPanel {
    int x = 0;
    LocalTime time = LocalTime.now();
    Zegar()
    {
        (new ClockThread()).start();
    }



    class ClockThread extends Thread{
        @Override
        public void run() {
            for(;;){
                time = LocalTime.now();
                System.out.printf("%02d:%02d:%02d\n",time.getHour(),time.getMinute(),time.getSecond());

                x++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
            }
        }
    }



    public void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        g2d.translate(getWidth()/2,getHeight()/2); //to nam służy do przeniesienia zegara z (0,0) na środek ekranu

        //GODZINY
        for(int i=1;i<13;i++){
            AffineTransform at = new AffineTransform(); //AFFLINE TRANSFORM do transormacji wektora z 0,0 na 350,350
            at.rotate(2*Math.PI/12*(double)i); //OBRACAMY AFT tak aby przeksztalcony obiekt byl w odpowiednim miejscu
            Point2D src = new Point2D.Float(0,-125); //TWORZYMY PUNKT POCZATKOWY
            Point2D trg = new Point2D.Float();  //TWORZYMY PUNKT DOCELOWY
            at.transform(src,trg); //TRANSFORMUJEMY NASZ PUNKT POCZATKOWY ZA POMOCA MACIERZY PRZEKSZTALCENIA
            g2d.drawString(Integer.toString(x),(int)trg.getX(),(int)trg.getY()); //RYSUJEMY GODZINY W PUNKCIE DOCELOWYM
            //LICZBA jest wypisywana w odniesieniu do g2d ktore jest na srodku ekranu
        }

        AffineTransform saveAT = g2d.getTransform();
        //LINIE MINUT
        g2d.setStroke(new BasicStroke(1.f));
        for(int i=1;i<61;i++){
            g2d.rotate((double)i%60*2*Math.PI/60);
            g2d.drawLine(0,-100,0,-110);
            g2d.setTransform(saveAT);
        }

        //LINIE GODZIN
        g2d.setStroke(new BasicStroke(3.f));
        for(int i=1;i<13;i++){
            g2d.rotate(i*2*Math.PI/12);
            g2d.drawLine(0,-100,0,-110);
            g2d.setTransform(saveAT);
        }

        //WSKAZÓWKA SEKUNDOWA
        g2d.rotate(time.getSecond()%60*2*Math.PI/60);
        g2d.setStroke(new BasicStroke(2.f));
        g2d.drawLine(0,0,0,-100);

        g2d.setTransform(saveAT);

        //WSKAZÓWKA MINUTOWA
        g2d.rotate(time.getMinute()%60*2*Math.PI/60);
        g2d.setStroke(new BasicStroke(4.f));
        g2d.drawLine(0,0,0,-80);

        g2d.setTransform(saveAT);

        //WSKAZÓWKA GODZINOWA
        g2d.rotate(time.getHour()%12*2*Math.PI/12);
        g2d.setStroke(new BasicStroke(6.f));
        g2d.drawLine(0,0,0,-50);

        g2d.setTransform(saveAT);
    }


//
    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock");
        frame.setContentPane(new Zegar());
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }






}
