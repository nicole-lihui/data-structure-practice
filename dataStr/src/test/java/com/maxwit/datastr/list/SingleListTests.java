package com.maxwit.datastr.list;

import com.maxwit.datastr.list.SingleList;
import org.junit.Test;

public class SingleListTests {

    @Test
    public void SingleListTest(){
        SingleList<String> mylist = new SingleList<>();
        mylist.add("aa");
        mylist.add("bb");
        mylist.add("cc");
        mylist.display();

        SingleList<String> mylist1 = new SingleList<>("cc1");
        mylist1.add("aa2");
        mylist1.add("bb3");
        mylist1.add("cc4");
        mylist1.display();

        int len = mylist1.length;
        equals(len == 4);
    }
}
