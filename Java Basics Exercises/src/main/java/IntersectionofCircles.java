import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntersectionofCircles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line1 = scanner.nextLine();
        String[] tokens1 = line1.split(" ");
        List<Long> coordinatesFirst = new ArrayList<>();
        for (int i=0; i < tokens1.length;i++) {
            coordinatesFirst.add(Long.parseLong(tokens1[i]));
        }

        String line2 = scanner.nextLine();
        String[] tokens2 = line1.split(" ");
        List<Long> coordinatesSecond = new ArrayList<>();
        for (int i=0; i < tokens2.length;i++) {
            coordinatesSecond.add(Long.parseLong(tokens2[i]));
        }

        CenterPolong one = new CenterPolong();
        one.X = coordinatesFirst.get(0);
        one.Y = coordinatesFirst.get(1);
        CenterPolong two = new CenterPolong();
        one.X = coordinatesSecond.get(0);
        one.Y = coordinatesSecond.get(1);

        Circle circleOne = new Circle();
        circleOne.CenterX = one.X;
        circleOne.CenterY = one.Y;
        circleOne.Radius = coordinatesFirst.get(2);
        Circle circleTwo = new Circle();
        circleTwo.CenterX = two.X;
        circleTwo.CenterY = two.Y;
        circleTwo.Radius = coordinatesSecond.get(2);

        longersect(one, two, circleOne, circleTwo);

    }

    private static void longersect(CenterPolong one, CenterPolong two, Circle circleOne, Circle circleTwo)
    {
        double diagonal = Math.round(Math.sqrt(Math.pow((one.X - two.X), 2) + Math.pow((one.Y - two.Y), 2)));

        if (diagonal <= circleOne.Radius + circleTwo.Radius)
        {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
class Circle
{
    public long CenterX;

    public long getCenterX() {
        return CenterX;
    }

    public void setCenterX(long centerX) {
        CenterX = centerX;
    }

    public long getCenterY() {
        return CenterY;
    }

    public void setCenterY(long centerY) {
        CenterY = centerY;
    }

    public long getRadius() {
        return Radius;
    }

    public void setRadius(long radius) {
        Radius = radius;
    }

    public long CenterY;
    public long Radius;

    @Override
    public String toString() {
        return "Circle{" +
                "CenterX=" + CenterX +
                ", CenterY=" + CenterY +
                ", Radius=" + Radius +
                '}';
    }

}

class CenterPolong
{
    public long X;

    public long getX() {
        return X;
    }

    public void setX(long x) {
        X = x;
    }

    public long getY() {
        return Y;
    }

    public void setY(long y) {
        Y = y;
    }

    public long Y;

    @Override
    public String toString() {
        return "CenterPolong{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
