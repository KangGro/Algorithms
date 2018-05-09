package com.mr.kangaroo.demonstrate.lambda;

/**
 * @author daisy
 * @desc
 * @create 2018/5/9
 */
public class Student {

    private int id;
    private String name;
    private int teacherId;


    public int getId() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public Student setTeacherId(int teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public Student(int id, String name, int teacherId) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", teacherId=").append(teacherId);
        sb.append('}');
        return sb.toString();
    }
}
