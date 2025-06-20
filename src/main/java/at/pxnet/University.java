package at.pxnet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class University {

    private final List<Person> students = new ArrayList<>();

    public University() {}

    public void addStudent(Person person) {
        Objects.requireNonNull(person);
        if (!students.contains(person)) {
            students.add(person);
        }
    }

    public boolean removeStudent(Person person) {
        Objects.requireNonNull(person);
        return students.remove(person);
    }

    public List<Person> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public List<Person> getFailingStudents() {
        return Collections.unmodifiableList(
                students.stream()
                        .filter(Grading::isFailing)
                        .collect(Collectors.toList())
        );
    }

    public double getAverageAge() {
        return students.isEmpty()
                ? 0
                : students.stream().mapToInt(Person::getAge).average().orElse(0);
    }
}
