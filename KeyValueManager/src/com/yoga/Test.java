package com.yoga;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("two", 2);
        map.put("five", 5);
        map.put("four",4);
        map.put("one",1);
        map.put("three", 3);

//        List<Map.Entry<String, Integer>> listOfEntries = new ArrayList<>(map.entrySet());
//        Collections.sort(listOfEntries, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> stringIntegerEntry, Map.Entry<String, Integer> t1) {
//                return stringIntegerEntry.getValue() - t1.getValue();
//            }
//        });
//
//       map = new LinkedHashMap<String, Integer>();
//       for(Map.Entry<String, Integer> e : listOfEntries)
//           map.put(e.getKey(), e.getValue());

        map = map.entrySet().stream().sorted((a,b) ->  a.getValue() - b.getValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));

        System.out.println(map.toString());



    }
}
