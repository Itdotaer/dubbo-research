package demo.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayListDemo
 *
 * @author jt_hu
 * @date 2018/6/29
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<String>();

        arrayList.add("a");

        arrayList.add(1, "b");
    }

}
