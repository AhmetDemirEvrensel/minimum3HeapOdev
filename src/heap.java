import java.util.Arrays;
import java.util.NoSuchElementException;

class heap
{
    private int d;
    private int boyut;
    private int[] heap;

    public heap(int kapasite, int cocukSayisi)
    {
        boyut = 0;
        d = cocukSayisi;
        heap = new int[kapasite + 1];
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty( )
    {
        return boyut == 0;
    }

    public boolean isFull( )
    {
        return boyut == heap.length;
    }

    public void clear( )
    {
        boyut = 0;
    }

    private int parent(int i)
    {
        return (i - 1)/d;
    }

    private int kthChild(int i, int k)
    {
        return d * i + k;
    }

    public void insert(int x)
    {
        if (isFull( ) )
            throw new NoSuchElementException("Overflow Exception");
        /** Percolate up **/
        heap[boyut++] = x;
        heapifyUp(boyut - 1);
    }

    public int findMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return heap[0];
    }

    public int delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int keyItem = heap[ind];
        heap[ind] = heap[boyut - 1];
        boyut--;
        heapifyDown(ind);
        return keyItem;
    }

    private void heapifyUp(int childInd)
    {
        int tmp = heap[childInd];
        while (childInd > 0 && tmp < heap[parent(childInd)])
        {
            heap[childInd] = heap[ parent(childInd) ];
            childInd = parent(childInd);
        }
        heap[childInd] = tmp;
    }

    private void heapifyDown(int ind)
    {
        int child;
        int tmp = heap[ ind ];
        while (kthChild(ind, 1) < boyut)
        {
            child = minChild(ind);
            if (heap[child] < tmp)
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
    }

    private int minChild(int ind)
    {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < boyut))
        {
            if (heap[pos] < heap[bestChild])
                bestChild = pos;
            pos = kthChild(ind, k++);
        }
        return bestChild;
    }

    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < boyut; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }
}