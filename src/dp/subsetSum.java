package dp;

public class subsetSum {
        static Boolean isSubsetSum(int arr[], int sum) {
            // code here
            int n = arr.length;
            boolean dp[][] = new boolean[n+1][sum+1];
            return subsetsum(arr , arr.length , sum , dp);
        }

        static Boolean subsetsum(int []arr , int n , int sum , boolean dp[][]){

            for(int i = 0; i <= n; i++){
                dp[i][0] = true;
            }

            for(int i = 1; i<=n; i++){
                for(int j =1; j<=sum; j++){
                    if(arr[i-1] <= j){
                        dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                    }
                    else dp[i][j] = dp[i-1][j];
                }
            }

            return dp[n][sum];

        }
}
