class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;
        
        Boolean primes[] = new Boolean[n];
        Arrays.fill(primes , true);
        primes[0] = primes[1] = false;

        for(int i = 2; i * i < n; i++){
            if(primes[i]){
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        int count = 0;
        for(int i = 0 ; i<primes.length; i++){
            if(primes[i] == true) count++;
        }

        return count;
    }
}