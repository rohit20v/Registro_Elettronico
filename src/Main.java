import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Student student;
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            try {
                student = new Student("Rohit", "Verma", new int[]{rand.nextInt(1, 100), rand.nextInt(1, 100)}, rand.nextInt(1, 100), rand.nextInt(1, 100));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Two exams: " + Arrays.toString(student.getTwoPoints()));
            System.out.println("Project: " + student.getProjectPoints());
            System.out.println("Written: " + student.getWrittenPoints());
            System.out.println("Outta 10: " + student.getScoreOuttaTen() + "\n");
            students.add(student);

        }
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            System.out.println(students.stream().filter(o -> (int) o.getScoreOuttaTen() == finalI).count() + " students scored " + i + " outta 10.");
        }
//        System.out.println("\n");
//        IntStream.rangeClosed(1, 10).forEach(i -> System.out.println(students.stream().filter(o -> (int) o.getScoreOuttaTen() == i).count() + " students scored " + i + " outta 10."));

    }
}