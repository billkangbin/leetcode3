package com.billkang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kangbin on 2017/7/8.
 */
public class LogSystem {
    private Map<String, Integer> mapTable;
    private Map<String, Integer> mapPlace;

    private void init() {
        mapPlace = new HashMap<String, Integer>();
        mapPlace.put("Year",5);
        mapPlace.put("Month",8);
        mapPlace.put("Day",11);
        mapPlace.put("Hour",14);
        mapPlace.put("Minute",17);
        mapPlace.put("Second",19);
    }

    public LogSystem() {
        mapTable = new HashMap<String, Integer>();
        init();
    }

    public void put(int id, String timestamp) {
        mapTable.put(timestamp, id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> result = new ArrayList<Integer>();
        int lens = mapPlace.get(gra);
        String start = s.substring(0,lens);
        String finish = e.substring(0, lens);
        for(Map.Entry<String, Integer> entry:mapTable.entrySet()) {
            String key = entry.getKey();
            String tmp = key.substring(0, lens);
            // 时间上的对比直接可以用字符串的比较函数来做
            if(tmp.compareTo(start)>=0 && tmp.compareTo(finish)<=0) {
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
