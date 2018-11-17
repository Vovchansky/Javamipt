package com.company;

import java.util.Objects;

public class Student extends Person {
    private boolean hasScholarship;
    private int studyYear;

    Student(String name, int age, int height, int weight, boolean hasScholarship, int studyYear) {
        super(name, age, height, weight);
        this.hasScholarship = hasScholarship;
        this.studyYear = studyYear;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = result * 17 + studyYear;
        result = result + (hasScholarship ? 1 : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Student that = (Student) obj;
        return super.equals(obj)
                && Objects.equals(this.hasScholarship, that.hasScholarship)
                && Objects.equals(this.studyYear, that.studyYear);
    }
}
