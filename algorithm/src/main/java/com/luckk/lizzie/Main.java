package com.luckk.lizzie;

import com.luckk.lizzie.dto.PersonDTO;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list
                .add("name");
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()){
            list.add(UUID.randomUUID().toString());
            System.out.println(iterator.next());
            iterator.remove();

        }
    }
}

