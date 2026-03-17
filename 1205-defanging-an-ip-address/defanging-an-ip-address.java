class Solution {
    public String defangIPaddr(String address) {
        // String[] addr = address.split("\\.");
        // int n = addr.length;

        // StringBuilder sb = new StringBuilder();
        // for(int i = 0; i < addr.length-1; i++){
        //         sb.append(addr[i]);
        //         sb.append("[.]");
        // }
        // if(n > 0) sb.append(addr[addr.length-1]);
        // return sb.toString();

        return address.replace("." , "[.]");
    }
}