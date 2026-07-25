class Solution {
    public int minMaxDifference(int num) {

        String s =  String.valueOf(num);
        int[] digit=new int[s.length()];
        for(int i=0;i<s.length();i++){
            digit[i]=s.charAt(i)-'0';
        }

        int minarr[]=digit.clone();
        int maxarr[]=digit.clone();

        int maxdit=-1;
        for(int i=0;i<maxarr.length;i++){
            if(maxarr[i]!=9){
                maxdit=maxarr[i];
                break;
            }
        }

        if(maxdit!=-1){
            for(int i=0;i<maxarr.length;i++){
                if(maxarr[i]==maxdit){
                    maxarr[i]=9;
                }
            }
        }

        int mindit=-1;
        for(int i=0;i<minarr.length;i++){
            if(minarr[i]!=0){
                mindit=minarr[i];
                break;
            }
        }

        if(mindit!=-1){
            for(int i=0;i<minarr.length;i++){
                if(minarr[i]==mindit){
                    minarr[i]=0;
                }
            }
        }

        int max=0;
        int min=0;
        for (int i = 0; i < maxarr.length; i++) {
            max = max * 10 + maxarr[i];
            min = min * 10 + minarr[i];
        }

        return max - min;

    }
}