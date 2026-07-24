class Solution {
    public int maximum69Number (int num) {
        String str=String.valueOf(num);
        char[] arr=new char[str.length()];
        for(int i=0;i<str.length();i++){
            arr[i]=str.charAt(i);
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]== '6'){
                arr[i]='9';
                break;
            }
        }
        int max = 0;

        for (char c : arr) {
            max = max * 10 + (c - '0');
        }

        return max;
    }
}