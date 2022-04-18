import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Слава", Arrays.asList(new Course("Математика"), new Course("Биология"),
                new Course("Тестирование"))));
        students.add(new Student("Антон", Arrays.asList(new Course("Математика"), new Course("География"),
                new Course("Тестирование6"), new Course("Тестирование2"))));
        students.add(new Student("Оксана", Arrays.asList(new Course("Физика"), new Course("Биология"),
                new Course("Тестирование"), new Course("Тестирование1"))));

        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet()));

        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));

        Course course = new Course("Тестирование");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}