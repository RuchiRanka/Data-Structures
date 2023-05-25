import java.util.*;

public class GreedyAlgo {
    public static int activitySelection(int start[], int end[]) {
        ArrayList<Integer> ans = new ArrayList<>();

        int maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];

        for(int i=1; i<end.length; i++) {
            if(start[i] >= lastEnd) {
                maxAct++;
                lastEnd = end[i];
                ans.add(i);
            }
        }
        System.out.println(ans);
        return maxAct;
    }

    public static int activitySelectionUnsorted(int start[], int end[]) {
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for(int i=1; i<start.length; i++) {
            if(start[i] >= lastEnd) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println(ans);
        return maxAct;
    }

    public static int fractionalKnapsack(int value[], int weight[], int W) {
        int maxVal = 0;
        int capacity = W;
        double ratio[][] = new double[value.length][2];

        for(int i=0; i<value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        for(int i=ratio.length-1; i>=0; i--) {
            int index = (int)ratio[i][0];
            if(capacity >= weight[index]) {
                capacity -= weight[index];
                maxVal += value[index];
            } 
            else {
                maxVal += ratio[i][1] * capacity;
                return maxVal;
            }
        }
        return maxVal;
    }

    public static int minAbsoluteDiffPair(int arr1[], int arr2[]) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int sum = 0;
        for(int i=0; i<arr1.length; i++) {
            sum += Math.abs(arr1[i]-arr2[i]);
        }
        return sum;
    }

    public static int maxLengthChainPairs(int pairs[][]) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int maxLength = 1;
        int lastPair = 0;
        for(int i=1; i<pairs.length; i++) {
            if(pairs[lastPair][1] < pairs[i][0]) {
                lastPair = i;
                maxLength++;
            }
        }
        return maxLength;
    }

    public static int indianCoins(int V) {
        int change = V;
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        Arrays.sort(coins, Comparator.reverseOrder());  

        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<coins.length; i++) {
            while(coins[i]<=change) {
                count++;
                change -= coins[i];
                ans.add(coins[i]);
            }
        }
        System.out.println(ans);
        return count;
    }

    static class Job {
        int id;
        int deadline;
        int profit;
        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static int jobSequencing(int jobInfo[][]) {
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0; i<jobInfo.length; i++) {
            jobs.add(new Job(i,jobInfo[i][0],jobInfo[i][1]));
        }
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit);  //descending order of profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i=0; i<jobs.size(); i++) {
            Job curr = jobs.get(i);
            if(curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }
        for(int i=0; i<seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
        return seq.size();
    }

    public static int chocolaProblem(Integer costHor[], Integer costVer[]) {
        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int h=0, v=0;
        int hp=1, vp=1;
        int cost = 0;

        while(h<costHor.length && v<costVer.length) {
            if(costVer[v] <= costHor[h]) {
                //horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }
            else {
                //vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while(h<costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while(v<costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        return cost;
    }

    public static void main(String[] args) {
        // int start[] = {1,3,0,5,8,5};
        // int end[] = {2,4,6,7,9,9};
        // System.out.println(activitySelection(start, end));
        // System.out.println(activitySelectionUnsorted(start, end));

        // int value[] = {60,100,120};
        // int weight[] = {10,20,30};
        // int W = 50;
        // System.out.println(fractionalKnapsack(value, weight, W));

        // int arr1[] = {4,1,8,7};
        // int arr2[] = {2,3,6,5};
        // System.out.println(minAbsoluteDiffPair(arr1, arr2));

        // int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        // System.out.println(maxLengthChainPairs(pairs));

        // int V = 121;
        // System.out.println(indianCoins(V));

        // int jobInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
        // System.out.println(jobSequencing(jobInfo));

        int n=4, m=6;
        Integer costVer[] = {2,1,3,1,4}; //m-1
        Integer costHor[] = {4,1,2}; //n-1
        System.out.println(chocolaProblem(costVer, costHor));
    }
}
