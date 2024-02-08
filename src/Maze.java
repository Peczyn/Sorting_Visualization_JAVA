import java.time.Duration;
import java.util.ArrayList;

public class Maze {
    static boolean[][] test = {{true,true,true,false,false},{false, false, true ,false,false},{true,true,true,false,false},{false, false, true ,false,false},{true, false, true ,false,false}};
    public static ArrayList<Integer> arr = new ArrayList<>();

    static void bubbleSort() {
        int i, j, temp;
        int n = arr.size();
        System.out.println(n);

        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j+1)) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr.get(j);
                    arr.set(j,arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swapped = true;

                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
            System.out.println("Swapped");
        }
    }
}
