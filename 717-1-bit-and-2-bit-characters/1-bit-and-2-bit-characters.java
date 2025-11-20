class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;

        // direct cases to prevent loop
        if(n == 1 && ((bits[0]&1) == 0)) return true;
        else if(n >= 2 && ((bits[n-1] & 1) == 0  && (bits[n-2] & 1) == 0)) return true;
        
        // iterate and if bits[i] == 1 this means its a 2 bit character otherwise single bit.
        int i = 0;
        while(i < n-1){
            if(bits[i] == 1) i += 2;
            else i++;
        }
        return i == n-1;
    }
}