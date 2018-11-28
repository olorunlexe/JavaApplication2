/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author therapy
 */
public class Utility {
    
public String generatePIN(String prefix) {
        Random r = new Random();
        IntStream ints = r.ints(14);
        int[] toArray = ints.toArray();
        String pin = "";
        for (int i = 0; i < toArray.length; i++) {
            pin = pin + i;
        }
        return prefix.concat(pin);
    }

    public static String pinGen(String prifix) {
        Long number = (long) Math.floor(Math.random() * 900000000000L) + 10000000000000L;
        return prifix.concat(number.toString());
    }

    public static void main(String[] args) {
        Utility u = new Utility();
        System.out.println("..." + u.pinGen("NC"));
    }
}
