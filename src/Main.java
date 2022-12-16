import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;

//Ahmet Demir Evrensel
//02215076002
public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] arr = input.split(",");

        int size = arr.length;
        int[] sayilar = new int[size];
        for (int i = 0; i < size; i++) {
            sayilar[i] = Integer.parseInt(arr[i]);
        }

        heap dh = new heap(sayilar.length, 3);

        boolean isMinHeap = true;
        for (int i = 0; i < sayilar.length; i++) {
            int indexControl;
            indexControl = i;
            if (isMinHeap) {
                if (indexControl * 3 + 1 < sayilar.length) {
                    if (sayilar[i] > sayilar[3 * i + 1]) {
                        isMinHeap = false;
                    }
                }
            }
        }

        if (!isMinHeap) {
            System.out.println("minimum heap degil.");
        } else {
            System.out.println("minimum heap.");
        }

        System.out.println("Heap;");

        dh.printHeap();
    }
}