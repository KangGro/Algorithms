package com.mr.kangaroo.demonstrate.lambda;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author daisy
 * @desc
 * @create 2018/5/9
 */
public class CollectionTest {
    private static List<Student> studentList = Lists.newArrayList();
    static {
        studentList.add(new Student(1, "a" , 2, 1526992963000L));
        studentList.add(new Student(2, "b" , 1, 1526912959000L));
        studentList.add(new Student(3, "c" , 2,1526994952000L));
    }


    public static void main(String[] args) {
        List<Student> result = studentList.stream().sorted(Comparator.comparing(Student::getUpdateTime).reversed()).collect(Collectors.toList());
        for (Student student : result) {
            System.out.println(student.getUpdateTime().getTime());
        }
    }
}
