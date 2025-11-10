class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;
        
        Boolean primes[] = new Boolean[n];
        Arrays.fill(primes , false);
        // primes[0] = primes[1] = false;
        int count = 0;

        for(int i = 2; i < n; i++){
            if(!primes[i]){
                count++;
                for (int j = 2; j * i < n; j++) {
                    primes[i*j] = true;
                }
            }
        }

        return count;
    }
}