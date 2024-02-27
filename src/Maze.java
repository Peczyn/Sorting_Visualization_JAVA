import java.util.ArrayList;
import java.util.Collections;

public class Maze {
    static boolean isRunning = false;
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
                while(!isRunning) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(arr.get(j) > arr.get(j+1)) {
                    temp = arr.get(j);
                    arr.set(j,arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
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
            while(!isRunning) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                try {
                    Thread.sleep(1, 500);
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
        while(!isRunning) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
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


    static void swap(ArrayList<Integer> arr, int i, int j)
    {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    static int partition(ArrayList<Integer> arr, int low, int high)
    {
        // Choosing the pivot

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        int pivot = arr.get(high);

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {


            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // If current element is smaller than the pivot
            if (arr.get(j) < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    static void quickSort(int low, int high)
    {
        while(!isRunning) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (low < high) {

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
        TJFrame.sorting = false;
    }

}
