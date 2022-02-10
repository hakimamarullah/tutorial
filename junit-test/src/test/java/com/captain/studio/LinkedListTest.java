package com.captain.studio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    LinkedList<String> test = new LinkedList<>();

    @Test
    void addTest(){
        test.add("1");
        test.add("2");
        Assertions.assertEquals(2,test.size());
    }

    @Test
    void addTest2(){
        test.add("1");
        test.add("2");
        test.remove("2");
        Assertions.assertEquals(1,test.size());
    }

}
