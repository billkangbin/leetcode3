package com.billkang;

import java.util.HashMap;
import java.util.Map;


public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer ,Integer> mapAB =new HashMap<>();
        int res =0;

        for(int i =0 ; i<A.length ;i++){
            for(int j =0 ; j<B.length ;j++){
                int key =A[i]+B[j];
                if(mapAB.containsKey(key))
                    mapAB.put(key,mapAB.get(key)+1);
                else mapAB.put(key,1);
            }
        }

        for(int i =0 ; i<C.length ;i++){
            for(int j =0 ; j<D.length ;j++){
                int key =C[i]+D[j];
                if(mapAB.containsKey(0-key)){
                    res += mapAB.get(0-key);
                }
            }
        }
        return res;

    }
}
