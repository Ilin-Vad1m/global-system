public class SortMerge {

    private boolean validArray = false;

    public void sort(int[] array, int p, int r) {
        if(!validArray && p != 0){
            p-=1;
            r-=1;
            validArray = true;
        }else if(!validArray){
            r-=1;
            validArray = true;
        }

        if (p < r) {
            int q = ((p + r) / 2);

            sort(array, p, q);
            sort(array, q + 1, r);
            merge(array, p, q, r);

        }
    }



    private void merge(int[] array, int p, int q, int r) {

        int lengthLeft = q - p + 1;                                         // длина левого подмассива
        int lengthRight = r - q;                                            // длина правого подмассива

        int[] arrayLeft = new int[lengthLeft];                              // создание левой части подмассива
        int[] arrayRight = new int[lengthRight];                            // создание правой части подмассива

        System.arraycopy(array, p, arrayLeft, 0, lengthLeft);       // копирование левой части массива

        System.arraycopy(array, p + lengthLeft, arrayRight, 0, lengthRight); // копирование правой части массива

        int indexLeft = 0, indexRight = 0;                                  // создание начальных индексов для правого и левого подмассива

        int k = p;                                                           // создание начального индекса массива

        while (indexLeft < lengthLeft && indexRight < lengthRight) {
            if (arrayLeft[indexLeft] <= arrayRight[indexRight]){
                array[k] = arrayLeft[indexLeft];
                indexLeft++;
            }else{
                array[k] = arrayRight[indexRight];
                indexRight++;
            }
            k++;
        }

        while (indexLeft < lengthLeft){
            array[k] = arrayLeft[indexLeft];
            indexLeft++;
            k++;
        }

        while (indexRight < lengthRight){
            array[k] = arrayRight[indexRight];
            indexRight++;
            k++;
        }

    }

}