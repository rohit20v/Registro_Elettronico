import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String name;
    private String surname;
    private int[] twoPoints = new int[2];
    private int writtenPoints;
    private int projectPoints;
    private int outtaTen;

    public Student(String name, String surname, int[] twoPoints, int writtenPoints, int projectPoints) throws Exception {
        this.name = name;
        this.surname = surname;
        if (twoPoints[0] <= 100 && twoPoints[1] <= 100 && writtenPoints <= 100 && projectPoints <= 100) {
            this.twoPoints = twoPoints;
            this.writtenPoints = writtenPoints;
            this.projectPoints = projectPoints;
        }
    }

    public int getWrittenPoints() {
        return writtenPoints;
    }

    public int getProjectPoints() {
        return projectPoints;
    }

    public int[] getTwoPoints() {
        return twoPoints;
    }

    public double getScoreOuttaTen() {
        int sum2Es = Arrays.stream(getTwoPoints()).sum();
        return (double) Math.round(((double) (sum2Es / 2) * 0.25) + (getProjectPoints() * 0.25) + (0.50 * getWrittenPoints())) / 10;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", twoPoints=" + Arrays.toString(twoPoints) +
               ", writtenPoints=" + writtenPoints +
               ", projectPoints=" + projectPoints +
               ", outtaTen=" + outtaTen +
               '}';
    }

    public void getSummary(ArrayList<Student> lst) {
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            System.out.println(lst.stream().filter(o -> o.getScoreOuttaTen() == finalI).count() + "have gotten " + i);
        }
    }
}
