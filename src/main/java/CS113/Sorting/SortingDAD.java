package CS113.Sorting;

import CS113.ArrayList.ArrayListDAD;

public class SortingDAD <E extends Comparable<E>> {

    public void bubbleSort(ArrayListDAD<E> unsortedList) {
        for (int i = 0; i < unsortedList.size(); i++) {
            boolean swapped = false; 

            for (int j = 0; j < unsortedList.size() - 1; j ++) {
                int k = j + 1;
                if (unsortedList.get(j).compareTo(unsortedList.get(k)) > 0) {
                    Swap(unsortedList, i, j);
                    swapped = true;
                }

            }

            if (!swapped) return;
        }
    }

   public void insertionSort(ArrayListDAD<E> unsortedArray) {
        for (int i = 1; i < unsortedArray.size(); i++) {
            E key = unsortedArray.get(i);
            int j = i - 1;

            // Shift elements to the right to make room for key
            while (j >= 0 && unsortedArray.get(j).compareTo(key) > 0) {
                unsortedArray.set(j + 1, unsortedArray.get(j));
                j--;
            }

            // Insert key at the correct position
            unsortedArray.set(j + 1, key);
        }
    }

    public ArrayListDAD<E> MergeSort(ArrayListDAD<E> unsortedArray) {
        int size = unsortedArray.size();

        if (size <= 1) return unsortedArray;

        int mid = size / 2;

        ArrayListDAD<E> left = new ArrayListDAD<>();
        ArrayListDAD<E> right = new ArrayListDAD<>();

        for (int i = 0; i < size; i++) {
            if ( i < mid) {
                left.add(unsortedArray.get(i));
            } else {
                right.add(unsortedArray.get(i));
            }
        }

        return merge(MergeSort(left), MergeSort(right));
    }

    public ArrayListDAD<E> QuickSort(ArrayListDAD<E> unsortedArray) {
        int size = unsortedArray.size();

        if (size <= 1) return unsortedArray;

        ArrayListDAD<E> left = new ArrayListDAD<>();
        ArrayListDAD<E> right = new ArrayListDAD<>();

        E pivot = unsortedArray.get(size - 1);

        for (int i = 0; i < size - 1; i++) {
            if (pivot.compareTo(unsortedArray.get(i)) > 0) {
                left.add(unsortedArray.get(i));
            } else {
                right.add(unsortedArray.get(i));
            }
        }

        return quickMerge(QuickSort(left), pivot, QuickSort(right));
    }

    public void SelectionSort(ArrayListDAD<E> unsortedArray) {
        int arraySize = unsortedArray.size();

        /* Buffet code
        ArrayListDAD<E> sortedArray = new ArrayListDAD<>();
        for (int i = 0; i < arraySize; i++) {
            E minElement = unsortedArray.min();
            sortedArray.set(i, minElement);
            unsortedArray.remove(minElement);
        }

        unsortedArray.clear();
        for (int i = 0; i < sortedArray.size(); i++) {
            unsortedArray.add(sortedArray.get(i));
        }
        */

        for (int i = 0; i < arraySize - 1; i++) {
            int minIndex = i;
    
            for (int j = i + 1; j < arraySize; j++) {
                if (unsortedArray.get(j).compareTo(unsortedArray.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
    
            // Swap only if needed
            if (minIndex != i) {
                Swap(unsortedArray, i, minIndex);
            }
        }

    }

    private ArrayListDAD<E> merge(ArrayListDAD<E> left, ArrayListDAD<E> right) {
        int l = 0;
        int r = 0;
        ArrayListDAD<E> merged = new ArrayListDAD<>();

        while (l < left.size() || r < right.size()) {
            if (l == left.size()) { // left is used up
                merged.add(right.get(r++));
            } else if (r == right.size()) {
                merged.add(left.get(l++));
            } else if (left.get(l).compareTo(right.get(r)) < 0) {
                merged.add(left.get(l++));
            } else {
                merged.add(right.get(r++));
            }
        } 
        return merged;
    }

    private ArrayListDAD<E> quickMerge(ArrayListDAD<E> left, E pivot, ArrayListDAD<E> right) {
        ArrayListDAD<E> merged = new ArrayListDAD<>();
    
        for (int i = 0; i < left.size(); i++) {
            merged.add(left.get(i));
        }
    
        merged.add(pivot); // add the pivot in the middle
    
        for (int i = 0; i < right.size(); i++) {
            merged.add(right.get(i));
        }
    
        return merged;
    }

    private void Swap(ArrayListDAD<E> array, int i, int j) {
        E temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }

}