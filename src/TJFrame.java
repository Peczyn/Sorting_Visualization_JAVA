import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class TJFrame extends JFrame {
    public static boolean sorting = false;

    TJPanel tjpanel = new TJPanel();
    static int ArraySize = 100;

    TJFrame(){
        super("OKNO");
        buildGui();
//        (new BubbleSortActive()).start();
    }

    void buildGui()
    {
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());


        JPanel northPanel = new JPanel();

        Integer[] options = {10,50,100,200,300,450};
        JComboBox<Integer> comboBox = new JComboBox<>(options);
        comboBox.setSelectedItem(100);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!sorting)
                {
                    Maze.arr.clear();
                    ArraySize = (int) comboBox.getSelectedItem();

                    Maze.generateMaze(ArraySize);
                }
            }
        });
        northPanel.add(comboBox);

        JButton ShuffleButton = new JButton("Shuffle");
        ShuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!sorting)
                {
                    Collections.shuffle(Maze.arr);
                }

            }
        });
        northPanel.add(ShuffleButton);


        JButton BubbleSort = new JButton("BubbleSort Start");
        BubbleSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!sorting)
                {
                    (new BubbleSortThread()).start();
                    Maze.isRunning=true;
                }
                else{
                    Maze.isRunning=true;
                }
            }
        });
        northPanel.add(BubbleSort);


        JButton SelectionSort = new JButton("SelectionSort Start");
        SelectionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!sorting)
                {
                    (new SelectionSortThread()).start();
                    Maze.isRunning=true;
                }
                else{
                    Maze.isRunning=true;
                }

            }
        });
        northPanel.add(SelectionSort);

        JButton HeapSort = new JButton("HeapSort Start");
        HeapSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!sorting)
                {
                    (new HeapSortThread()).start();
                    Maze.isRunning=true;
                }
                else{
                    Maze.isRunning=true;
                }

            }
        });
        northPanel.add(HeapSort);

        JButton QuickSort = new JButton("QuickSort Start");
        QuickSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!sorting)
                {
                    (new QuickSortThread()).start();
                    Maze.isRunning=true;
                }
                else{
                    Maze.isRunning=true;
                }

            }
        });
        northPanel.add(QuickSort);


        JButton stop = new JButton("Stop");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maze.isRunning=false;
            }
        });
        northPanel.add(stop);

        root.add(northPanel, BorderLayout.NORTH);
        root.add(tjpanel, BorderLayout.CENTER);

        setContentPane(root);
    }

    static class BubbleSortThread extends Thread{
        @Override
        public void run(){
            sorting = true;
            Maze.bubbleSort();
        }
    }

    static class SelectionSortThread extends Thread{
        @Override
        public void run(){
            sorting = true;
            Maze.selectionSort();
        }
    }

    static class HeapSortThread extends Thread{
        @Override
        public void run(){
            sorting = true;
            Maze.heapSort();
        }
    }

    static class QuickSortThread extends Thread{
        @Override
        public void run(){
            sorting = true;
            Maze.quickSort(0,Maze.arr.size()-1);
        }
    }

    public static void main(String[] args){
        Maze.generateMaze(ArraySize);

        TJFrame frame = new TJFrame();
        frame.setSize(900,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
