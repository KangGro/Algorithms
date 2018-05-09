package com.mr.kangaroo.demonstrate.lambda;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author daisy
 * @desc
 * @create 2018/5/9
 */
public class CollectionTest {
    private static List<Student> studentList = Lists.newArrayList();
    static {
        studentList.add(new Student(1, "a" , 2));
        studentList.add(new Student(2, "b" , 1));
        studentList.add(new Student(3, "c" , 2));
    }


    public static void main(String[] args) {
        Map<Integer, List<Student>> studentMap = studentList.stream().collect(Collectors.groupingBy(Student :: getTeacherId));
        studentMap.forEach((k,v) -> {
            System.out.println(k + " : " + Arrays.toString(v.toArray()));
        });
    }
}
