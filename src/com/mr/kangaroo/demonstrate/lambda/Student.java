package com.mr.kangaroo.demonstrate.lambda;

import java.util.Date;

/**
 * @author daisy
 * @desc
 * @create 2018/5/9
 */
public class Student {

    private int id;
    private String name;
    private int teacherId;
    private Date updateTime;

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

    public Student(int id, String name, int teacherId, Long time) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
        this.updateTime = new Date(time);
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Student setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
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
