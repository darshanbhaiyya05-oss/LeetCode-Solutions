class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder str=new StringBuilder();
        char[] arr=new char[26];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = (char)('A' + i);
        }

        while(columnNumber > 0){
            columnNumber--;
            str.append(arr[columnNumber % 26]);
            columnNumber = columnNumber / 26;
        }
        return str.reverse().toString();
    }
}