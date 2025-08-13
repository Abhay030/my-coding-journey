package dp;

public class subsetSum {
    public static boolean subsetSumToK(int n, int sum, int arr[]){
        // Write your code here.
        boolean dp[][] = new boolean[n+1][sum+1];
        return subsetsum(arr , arr.length , sum , dp);
    }

    public static boolean isSubsetSumToKPossible(int n, int k, int arr[]){
        if(k == 0) return true;
        if(n == -1) return false;

        if(k >= arr[n]){
            return isSubsetSumToKPossible(n-1 , k - arr[n] , arr) || isSubsetSumToKPossible(n-1 , k , arr);
        }
        else return isSubsetSumToKPossible(n-1 , k , arr);
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
