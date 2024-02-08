import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

    public static int[] shuffle(int[] array){


        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
        return(array);
    }
}