package com.vincent.algorithm.sortingbasic;

/**
 * Created by vincent on 2017/12/31.
 */
public class Student implements Comparable<Student> {
    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if (o.score == this.score)
            return this.name.compareTo(o.name);
        if (this.score < o.score)
            return 1;
        else if (this.score > o.score)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
