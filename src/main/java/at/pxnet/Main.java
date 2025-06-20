package at.pxnet;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        University uni = new University();

        Person anna = new Person("s001", "Anna", 21, new int[]{1, 2, 3});
        Person bernd = new Person("s002", "Bernd", 23, new int[]{4, 4, 4});
        Person clara = new Person("s003", "Clara", 19, new int[]{5, 2, 1});

        uni.addStudent(anna);
        uni.addStudent(bernd);
        uni.addStudent(clara);

        System.out.println("\n Liste der Studierenden:");
        printStudentList(uni.getStudents());

        System.out.println("\n Negativ beurteilte Studierende:");
        printStudentList(uni.getFailingStudents());

        System.out.printf("\n Durchschnittsalter: %.2f Jahre%n", uni.getAverageAge());
    }

    private static void printStudentList(List<Person> list) {
        if (list.isEmpty()) {
            System.out.println("  (Keine Einträge)");
            return;
        }
        for (Person p : list) {
            System.out.printf("  • %-6s %-10s (%d Jahre), Noten: %s%n",
                    p.getId(), p.getName(), p.getAge(), arrayToString(p.getGrades()));
        }
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}


// Create a class "Person" in the at.pxnet package
        // Make sure it has a constructor to take the following parameters in order:
        // * id (string)
        // * name
        // * age (int)
        // * array of grades (int)
        //
        // A grade can be any number from 1 to 5. If a number outside this range is passed as a grade, an
        // IllegalArgumentException should be thrown.
        //
        // Make sure the principles of data encapsulation are followed
        // A Person's id can never change
        // A person's age can change
        //
        // ----
        //
        // Create a class "Grading" in the at.pxnet package
        // Since it is a utility class, it should not expose any constructors
        //
        // This class provides a public method "isFailing" that takes a Person as a parameter. A person is failing if
        // they have at least one "5" or at least three "4" in their grades. If a person does not have at least two
        // grades, the method throws an IllegalStateException, regardless of the grades
        //
        // ---
        //
        // Create a class "University" in the at.pxnet package.
        // It should only have the default constructor
        // The class provides three Methods:
        // * "addStudent" takes a Person as a parameter and add them as a new student to the university
        // * "removeStudent" takes a Person as a parameter and removes them from the list
        // * "getStudents" returns a List of Persons. The list must be unmodifiable
        // * "getFailingStudents" returns a List of Persons. The list must be unmodifiable
        //
        // An additional method "getAverageAge" does not take any parameters and returns the average age of the
        // students (double). If no students are enlisted in the university, "0" is returned.