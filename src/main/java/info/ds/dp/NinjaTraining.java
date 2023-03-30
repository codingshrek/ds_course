package info.ds.dp;

public class NinjaTraining {



    private static int trainingMemoization(int last, int day , int points[][], int[][] dp){
        if(day==0) {
            int temp = Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i!=last) temp = Math.max(temp,points[day][i]);
            }
            return temp;
        }
        if(dp[day][last]!=-1) return dp[day][last];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(i==last) continue;
            int pt = points[day][i]+ trainingMemoization(i,day-1,points,dp);
            max=Math.max(pt,max);
        }
        dp[day][last] = max;

        return max;
    }

    public static int trainingTabulation(int n, int[][] points){

        int dp[][] = new int[n][4];
        for(int i=0;i<3;i++){
            int tempMax = Integer.MIN_VALUE;
            for(int j=0;j<3;j++){
                if(i==j) continue ;
                tempMax = Math.max(tempMax,points[0][j]);
                dp[0][i] = tempMax;
            }
        }

        //dp[day][last] holds the value , max of todays when last was done yesterday.
        for(int day = 1;day<n;day++){
            for(int last = 0;last<4;last++){
                int max = Integer.MIN_VALUE;
                for(int task=0;task<3;task++){
                    if(last!=task){
                        //today + max(last days when todays task was x).
                        //if task = 1 , then todays[1] + lastDays[1].
                        int pt = points[day][task] + dp[day-1][task];
                        max = Math.max(max,pt);
                    }
                }
                dp[day][last]=max;
                for(int i =0;i<dp.length;i++){
                    System.out.println(dp[i][0]+" "+dp[i][1]+" "+dp[i][2]+" "+dp[i][3]);
                }
                System.out.println("--------------");
            }
        }

        return dp[n-1][3];
    }


    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=-1;
            }
        }

        trainingMemoization(3, n-1, points, dp);
        for(int i =0;i<dp.length;i++){
            System.out.println(dp[i][0]+" "+dp[i][1]+" "+dp[i][2]+" "+dp[i][3]);
        }
        System.out.println("--------------");
        return dp[n-1][3];

    }

    public static void main(String[] args) {
        int[][] points = {
                {1,2,5},
                {3,1,1},
                {3,3,3}
        };
        int n = 3;

        ninjaTraining(n,points);
        System.out.println("*************************************");
        trainingTabulation(n,points);
    }
}
