import java.util.*;

public class Heaps {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);

            int x = arr.size()-1;
            int par = (x-1)/2;

            while(arr.get(x)<arr.get(par)) {
                //swap
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;
            
            if(left<arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            if(right<arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if(minIdx != i) {
                //swap
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);
                
                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            //step 1 - swap first and last node
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //step 2 - delete last node
            arr.remove(arr.size()-1);

            //step 3 - heapify fn
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size()==0;
        }
    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if(right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if(maxIdx != i) {
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr,maxIdx,size);
        }
    }

    public static void heapSort(int arr[]) {
        //step1 - build maxHeap
        int n=arr.length;
        for(int i=n/2; i>=0; i--) {
            heapify(arr,i,n);
        }

        //step2 - push largest at end
        for(int i=n-1; i>0; i--) {
            //swap
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr,0,i);
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int sqrDist;
        int idx;

        public Point(int x, int y, int sqrDist, int idx) {
            this.x = x;
            this.y = y;
            this.sqrDist = sqrDist;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p) {
            return this.sqrDist - p.sqrDist;
        }
    }
    
    public static void nearestCars(int pts[][], int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        for(int i=0; i<pts.length; i++) {
            int sqrDist = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], sqrDist, i));
        }
        
        for(int i=0; i<k; i++) {
            // System.out.println(pq.peek().x + ", " + pq.peek().y);
            // pq.remove();
            System.out.println("C" + pq.remove().idx);
        }
    }
    
    public static int connectNRopes(int ropes[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size()>1) {
            int val1 = pq.remove();
            int val2 = pq.remove();
            cost += val1+val2;
            pq.add(val1+val2);
        }
        
        return cost;
    }

    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r) {
            if(this.soldiers==r.soldiers) {
                return this.idx-r.idx;
            } else {
                return this.soldiers-r.soldiers;
            }
        }
    }

    public static void weakestSoldiers(int mat[][], int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i=0; i<mat.length; i++) {
            int soldiers=0;
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j]==1) {
                    soldiers++;
                } else {
                    break;
                }
            }
            pq.add(new Row(soldiers, i));
        }

        for(int i=0; i<k; i++) {
            System.out.println("R" + pq.remove().idx);
        }
    }

    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p) {
            return p.val-this.val;
        }
    }

    public static void slidingWindow(int arr[], int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int res[] = new int[arr.length-k+1];

        for(int i=0; i<k; i++) {
            pq.add(new Pair(arr[i],i));
        }
        res[0] = pq.peek().val;

        for(int i=k; i<arr.length; i++) {
            while(pq.size() > 0 && pq.peek().idx <= (i-k)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i],i));
            res[i-k+1] = pq.peek().val;
        }

        for(int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        // Heap hp = new Heap();
        // hp.add(2);
        // hp.add(3);
        // hp.add(4);
        // hp.add(5);
        // hp.add(10);
        // hp.add(1);

        // while(!hp.isEmpty()) {
        //     System.out.println(hp.peek());
        //     hp.remove();
        // }

        // int arr[] = {1,2,4,5,3};
        // heapSort(arr);

        // for(int i=0; i<arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }

        // int pts[][] = {{3,3},{5,-1},{-2,4}};
        // int k = 2;
        // nearestCars(pts,k);

        // int ropes[] = {2,3,4,6};
        // int ropes[] = {2,3,4,4};
        // System.out.println(connectNRopes(ropes));

        // int mat[][] = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        // weakestSoldiers(mat, 2);

        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        slidingWindow(arr,k);
    }
}