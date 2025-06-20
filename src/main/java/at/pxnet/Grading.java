package at.pxnet;

import java.util.Arrays;
import java.util.Objects;

public final class Grading {

    private Grading() {
        throw new AssertionError("Utility class – do not instantiate");
    }

    public static boolean isFailing(Person person) {
        Objects.requireNonNull(person, "person must not be null");

        int[] grades = person.getGrades();
        if (grades.length < 2) {
            throw new IllegalStateException("A person must have at least two grades");
        }

        long countFours = Arrays.stream(grades).filter(g -> g == 4).count();
        boolean hasFive = Arrays.stream(grades).anyMatch(g -> g == 5);

        return hasFive || countFours >= 3;
    }
}
