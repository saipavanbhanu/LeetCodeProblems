class Solution {
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        Arrays.sort(hc);
        Arrays.sort(vc);
        long mod = (long)1e9+7;
        long hmax = hc[0];
        long vmax = vc[0];

        for(int i = 1; i < hc.length; i++){
            long max = hc[i] - hc[i-1];
            if( max > hmax){
                hmax = max;
            }
        }
        if(h - hc[hc.length-1] > hmax){
            hmax = h - hc[hc.length-1];
        }

        for(int i = 1; i < vc.length; i++){
            long max = vc[i] - vc[i-1];
            if( max > vmax){
                vmax = max;
            }
        }
        if(w - vc[vc.length-1] > vmax){
            vmax = w - vc[vc.length-1];
        }

        long result = hmax * vmax;
        return (int)( result % mod );
    }
}