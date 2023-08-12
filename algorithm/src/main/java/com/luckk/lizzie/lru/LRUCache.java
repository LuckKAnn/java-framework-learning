package com.luckk.lizzie.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liukun.inspire
 * @Date 2023/7/23 22:27
 * @PackageName: com.luckk.lizzie.lru
 * @ClassName: LRUCache
 * @Version 1.0
 */
public class LRUCache<T> {

    private int size;

    private DoubleLinkNode head;

    private DoubleLinkNode tail;

    private Map<String, DoubleLinkNode<T>> mp = new HashMap<>(size);

    public LRUCache(int size) {
        this.size = size;
        this.head = new DoubleLinkNode();
        this.tail = new DoubleLinkNode();
        head.next = tail;
        tail.pre = head;
    }


    public T get(String key) {
        DoubleLinkNode<T> result = mp.get(key);
        if (result != null) {
            // 有这个节点,先删除
            moveToHead(result);
            return result.data;
        }
        return null;
    }

    public void insert(String key, T data) {
        DoubleLinkNode<T> result = mp.get(key);
        if (result != null) {
            result.data = data;
            moveToHead(result);
        } else {
            DoubleLinkNode<T> dataNode = new DoubleLinkNode<>();
            dataNode.data = data;
            dataNode.key = key;
            mp.put(key, dataNode);
            addToHead(dataNode);
            if (mp.size() == size) {
                // 删除最后一个元素
                DoubleLinkNode<T> removeNode = removeTail();
                mp.remove(removeNode.key);
            }
        }
    }

    public void getCache() {
        DoubleLinkNode<T> node = head;

        while (node != null) {
            System.out.printf("Node %s ===>", node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache<String> cache = new LRUCache<>(3);

        cache.insert("v1", "V1");
        cache.insert("V2", "V2");
        cache.getCache();
        cache.insert("v3", "V3");
        cache.getCache();
        cache.get("V2");
        cache.getCache();
        cache.insert("v4", "v4");
        cache.getCache();
    }


    private void moveToHead(DoubleLinkNode node) {
        deleteNode(node);
        addToHead(node);
    }

    private void addToHead(DoubleLinkNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void deleteNode(DoubleLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    private DoubleLinkNode removeTail() {
        DoubleLinkNode dataNode = this.tail.pre;
        dataNode.pre.next = tail;
        tail.pre = dataNode.pre;
        dataNode.pre = null;
        dataNode.next = null;
        return dataNode;
    }

    public static class DoubleLinkNode<T> {
        public DoubleLinkNode<T> pre;

        public DoubleLinkNode<T> next;

        public T data;

        public String key;


    }
}
