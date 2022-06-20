package com.zsl.easyexcelpro.utils;


import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.junit.Test;

import java.util.Random;

public class JNanoIdTest {

    @Test
    public void testGenerateJNanoId() {
        for (int i = 0; i < 1000; i++) {
            String id = NanoIdUtils.randomNanoId(); // "ku-qLNv1wDmIS5_EcT3j7"
            System.out.println(id);
        }
    }

    @Test
    public void test2() {
        // Use a faster, but non-secure, random generator
        Random random = new Random();

        // Use a custom alphabet containing only a, b, and c
        char[] alphabet = {'a','b','c'};

        // Make IDs 10 characters long
        int size = 10;

        String id = NanoIdUtils.randomNanoId(random, alphabet, 10); // "babbcaabcb"
        System.out.println(id);
    }
}
