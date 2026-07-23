class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int g_idx=0;
        int s_idx=0;

        while(s_idx<s.length && g_idx<g.length){
            if(g[g_idx]<=s[s_idx]){
                s_idx++;
                g_idx++;
            }
            else{
                s_idx++;
            }
        }
        return g_idx;
    }
}