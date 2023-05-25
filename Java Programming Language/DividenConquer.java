public class DividenConquer {

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void mergeSort(int arr[], int si, int ei) {

        if(si>=ei) {
            return;
        }

        int mid = si + ((ei-si)/2);
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {

        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++; k++;
            }
            else {
                temp[k]= arr[j];
                j++; k++;
            }
        }

        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        while(j <= ei) {
            temp[k++] = arr[j++];
        }

        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei, int i) {

        if(si >= ei) {
            return;
        }
        
        int piv = arr[ei];

        for(int j=si; j<=ei; j++) {
            if(arr[j] <= piv) {
                
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        quickSort(arr, si, i-1, si-1);
        quickSort(arr, i+1, ei, i);
    }

    public static int search(int arr[], int si, int ei, int tar) {

        //base case
        if(si > ei) {
            return -1;
        }
        
        int mid = si + ((ei-si)/2); // (si+ei)/2

        //case FOUND
        if(arr[mid] == tar) {
            return mid;
        }

        //mid on L1
        if(arr[si] <= arr[mid]) {

            //case a: LEFT            
            if(arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, si, mid-1, tar);
            }
            //case b: RIGHT    
            else {
                return search(arr, mid+1, ei, tar);
            }
        }

        //mid on L2
        else {

            //case c: RIGHT    
            if(arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, mid+1, ei, tar);
            }

            //case d: LEFT
            else {
                return search(arr, si, mid-1, tar);
            }
        }
    }

    public static int iterationSearch(int arr[], int tar) {

        int si = 0;
        int ei = arr.length-1;

        while(si<=ei) {
            int mid = (si+ei)/2;
            
            if(arr[mid] == tar) {
                return mid;
            }

            if(arr[si] <= arr[mid]) {
          
            if(arr[si] <= tar && tar <= arr[mid]) {
                ei = mid-1;
            }

            else {
                si = mid+1;
            }
        }

        else {
  
            if(arr[mid] <= tar && tar <= arr[ei]) {
                si = mid+1;
            }

            else {
                ei = mid-1;
            }
        }
        }
        return -1;
    }

    public static void main(String args[]) {

        // int arr[] = {6,3,9,5,2,8};
        // mergeSort(arr,0,arr.length-1);
        // printArr(arr);

        // quickSort(arr, 0, arr.length-1, -1);
        // printArr(arr);

        int arr[] = {4,5,6,7,0,1,2};
        // System.out.println(search(arr, 0, arr.length-1, 0));

        //Homework
        System.out.println(iterationSearch(arr, 0));
        
    }
}
