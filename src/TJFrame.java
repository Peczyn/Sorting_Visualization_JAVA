import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class TJFrame extends JFrame {
    TJPanel tjpanel = new TJPanel();

    TJFrame(){
        super("OKNO");
        buildGui();
    }

    void buildGui()
    {
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();

        JButton start = new JButton("start");
        northPanel.add(start);
        JButton stop = new JButton("stop");
        northPanel.add(stop);

        root.add(northPanel, BorderLayout.NORTH);
        root.add(tjpanel, BorderLayout.CENTER);

        setContentPane(root);

    }

    public static void main(String[] args){
        for(int i=0; i<612; i++)
        {
            Maze.arr.add(i);
        }
        Collections.shuffle(Maze.arr);



        TJFrame frame = new TJFrame();

        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);


        Maze.bubbleSort();

    }
}
