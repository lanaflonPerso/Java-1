import java.text.DecimalFormat;
import java.util.*;

public class AverageGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\r\n");
        int num = scanner.nextInt();

        List<Student> allData = new ArrayList<>();

        for (int i = 0; i < num; i++)
        {
            String[] line = scanner.next().split(" ");
            List<String> input = new ArrayList<>();
            for (int j = 0; j < line.length;j++) {
                input.add(line[j]);
            }
            List<Double> grades = new ArrayList<>();
            for (int j = 1; j < input.size(); j++) {
                grades.add(Double.parseDouble(input.get(j)));
            }

            Student personalData = new Student();
            personalData.Name = input.get(0);
            personalData.Grades = grades;
            personalData.Average = getAverage(personalData.Grades);
            allData.add(personalData);
        }

        List<Student> allDataVeryGoodStudents = new ArrayList<>();
        for (int i = 0; i < allData.size(); i++) {
            if (allData.get(i).Average > 5){
                allDataVeryGoodStudents.add(allData.get(i));
            }
        }
        DecimalFormat df = new DecimalFormat("#.00");
        Collections.sort(allDataVeryGoodStudents, SENIORITY_ORDER);
        for (Student student : allDataVeryGoodStudents) {
            System.out.print(student.Name + " -> ");
            System.out.println(df.format(student.Average));
        }
    }
    static final Comparator<Student> SENIORITY_ORDER =
            new Comparator<Student>() {
                public int compare(Student e1, Student e2) {
                    if(e1.Name.equals(e2.Name)){
                        return -1;
                    }
                    return e1.Name.compareTo(e2.Name);
                }
            };



    private static double getAverage(List<Double> grades) {

        double sum = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }
        double averageGrades = sum/grades.size();
        return averageGrades;
    }
}
class Student
{
    public String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Double> getGrades() {
        return Grades;
    }

    public void setGrades(List<Double> grades) {
        Grades = grades;
    }

    public List<Double> Grades;
    public double Average;
    public double getAverage() {
        return getAverage();
    }


    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", Grades=" + Grades +
                ", Average=" + Average +
                '}';
    }
}
