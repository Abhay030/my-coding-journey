class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        // total_bottles keeps track of total bottles drunk
        int total_bottles = numBottles;

        // remainder = leftover bottles after exchange
        int remainder = 0;

        // divident = number of new bottles obtained by exchange
        int divident = 0;

        // Continue until no more exchanges are possible
        while(numBottles != 0){
            
            // If we don't have enough bottles to exchange, return total
            if(numBottles < numExchange) return total_bottles;

            // Remainder bottles after exchanging
            remainder = numBottles % numExchange;

            // New bottles obtained from exchange
            divident = numBottles / numExchange;

            // Add new bottles to total count
            total_bottles += divident;

            // Update numBottles = new bottles + leftover
            numBottles = divident + remainder;
        }

        return total_bottles;
    }
}

/*
Time Complexity: O(log(numBottles))  
- Each iteration reduces the number of bottles approximately by a factor of numExchange, 
  so the loop runs logarithmically with respect to numBottles.

Space Complexity: O(1)  
- Only a constant number of variables are used (total_bottles, remainder, divident).
*/
