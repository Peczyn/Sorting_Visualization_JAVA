import java.util.ArrayList;
import java.util.Collections;

public class Maze {
    static boolean isRunning = false;
    static boolean[][] test = {{true,true,true,false,false},{false, false, true ,false,false},{true,true,true,false,false},{false, false, true ,false,false},{true, false, true ,false,false}};
    public static ArrayList<Integer> arr = new ArrayList<>();

    static void generateMaze(int n){
        for(int i=0; i<n; i++)
        {
            Maze.arr.add(i);
        }
        Collections.shuffle(Maze.arr);
    }

    static void bubbleSort() {
        int i, j, temp;
        int n = arr.size();
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(!isRunning) {
                    j--;
                }
                else if (arr.get(j) > arr.get(j+1)) {
                    temp = arr.get(j);
                    arr.set(j,arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (swapped == false) {
                TJFrame.sorting = false;
                break;
            }
        }
    }


    static void selectionSort()
    {
        int n = arr.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            /////TUTAJ DZIWNIE TO DZIALA BO JAK NIE DAM TEGO TRY ALBO JAKIEJKOLWIEK FUNKCJI PRZED TYM IF'EM
            /////TO WTEDY PO ZATRZYMANIU PROGRAM SPOWROTEM JUZ NIE IDZIE XD
            if(!isRunning) {
                i--;
                continue;
            }

            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr.get(min_idx);
            arr.set(min_idx,arr.get(i));
            arr.set(i,temp);


        }
        TJFrame.sorting = false;
    }



}
