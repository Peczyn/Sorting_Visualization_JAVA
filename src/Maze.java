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



            /////TUTAJ DZIWNIE TO DZIALA BO JAK NIE DAM TEGO TRY ALBO JAKIEJKOLWIEK FUNKCJI PRZED TYM IF'EM
            /////TO WTEDY PO ZATRZYMANIU PROGRAM SPOWROTEM JUZ NIE IDZIE XD
            if(!isRunning) {
                i--;
                continue;
            }

            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;
            }

            // Swap the found minimum element with the first
            // element
            int temp = arr.get(min_idx);
            arr.set(min_idx,arr.get(i));
            arr.set(i,temp);


        }
        TJFrame.sorting = false;
    }


    public static void heapSort()
    {
        int N = arr.size();
        System.out.println(N);
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr.get(0);
            arr.set(0,arr.get(i));
            arr.set(i,temp);

            // call max heapify on the reduced heap
            heapify(arr, i, 0);

        }
        TJFrame.sorting = false;
    }
    static void heapify(ArrayList<Integer> arr, int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr.get(l) > arr.get(largest))
            largest = l;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // If right child is larger than largest so far
        if (r < N && arr.get(r) > arr.get(largest))
            largest = r;

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // If largest is not root
        if (largest != i) {
            int swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest,swap);

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
