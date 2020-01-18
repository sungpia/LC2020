package com.sungpi.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {
    int cur;
    int capacity;
    Map<Integer, Integer> data;
    Queue<Integer> q;
    public LRUCache(int capacity) {
        this.cur = 0;
        this.capacity = capacity;
        data = new HashMap<>();
        q = new LinkedList<>();
    }

    /* get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1. */
    public int get(int key) {
        // if in cache
        if (q.contains(key)) {
            q.remove(key);
            q.add(key);
            return data.get(key);
        }
        return -1;
    }

    /* put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. */
    public void put(int key, int value) {
        if (!q.contains(key)) {
            Integer k;
            if (!q.isEmpty() && this.cur >= this.capacity) {
                k = q.poll();
                data.remove(k);
            }

            cur++;
            q.add(key);
            data.put(key, value);
        } else {
            q.remove(key);

//            cur++;
            q.add(key);
            data.put(key, value);
        }
    }

}
