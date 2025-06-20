package at.pxnet;

import java.util.Arrays;
import java.util.Objects;

public class Person {

    private final String id;
    private String name;
    private int age;
    private int[] grades;

    public Person(String id, String name, int age, int[] grades) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.age = age;
        this.grades = Objects.requireNonNull(grades, "grades must not be null").clone();
        validateGrades(this.grades);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int[] getGrades() {
        return grades.clone();
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrades(int[] grades) {
        this.grades = Objects.requireNonNull(grades).clone();
        validateGrades(this.grades);
    }

    private static void validateGrades(int[] grades) {
        for (int grade : grades) {
            if (grade < 1 || grade > 5) {
                throw new IllegalArgumentException("Grade must be between 1 and 5: " + grade);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof Person p && id.equals(p.id));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Person{id='%s', name='%s', age=%d, grades=%s}"
                .formatted(id, name, age, Arrays.toString(grades));
    }
}
