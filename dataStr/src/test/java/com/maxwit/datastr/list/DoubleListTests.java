package com.maxwit.datastr.list;

import com.maxwit.datastr.list.DoubleList;
import org.junit.Test;

public class DoubleListTests {
    @Test
    public void DoubleListTest() {
        DoubleList<String> mylist = new DoubleList<>();
        mylist.add("aa");
        mylist.add("bb");
        mylist.add("cc");
        mylist.display();

        DoubleList<String> mylist1 = new DoubleList<>("cc1");
        mylist1.add("aa2");
        mylist1.add("bb3");
        mylist1.add("cc4");
        mylist1.display();

        int len = mylist1.length;
        equals(len == 4);
    }
}
