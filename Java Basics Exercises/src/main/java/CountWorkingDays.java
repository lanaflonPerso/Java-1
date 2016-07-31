import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.time.LocalDate.parse;

/**
 * Created by Hristo on 30.07.2016 г..
 */
public class CountWorkingDays {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            String first = scanner.nextLine();
            String second = scanner.nextLine();

            LocalDate firstDate = parse(first);
            LocalDate secondDate = parse(second);

            int counterHolidays = GetWorkingDays(firstDate, secondDate);

            System.out.println(counterHolidays);

    }
    private static int GetWorkingDays(LocalDate firstDate, LocalDate secondDate)
    {
        List<LocalDate> holidayDates = new ArrayList<>();

        for (int i = firstDate.getYear(); i <= secondDate.getYear(); i++)
        {
            holidayDates.add(LocalDate.of(i, 1, 1));
            holidayDates.add(LocalDate.of(i, 3, 3));
            holidayDates.add(LocalDate.of(i, 5, 1));
            holidayDates.add(LocalDate.of(i, 5, 6));
            holidayDates.add(LocalDate.of(i, 5, 24));
            holidayDates.add(LocalDate.of(i, 9, 6));
            holidayDates.add(LocalDate.of(i, 9, 22));
            holidayDates.add(LocalDate.of(i, 11, 1));
            holidayDates.add(LocalDate.of(i, 12, 24));
            holidayDates.add(LocalDate.of(i, 12, 25));
            holidayDates.add(LocalDate.of(i, 12, 26));
        }

        int counterHolidays = 0;

        for (LocalDate i = firstDate; i.isBefore(secondDate); i.plusDays(1))
        {
            if (!(holidayDates.contains(i) || i.getDayOfWeek().toString() == "Saturday" || i.getDayOfWeek().toString() == "Sunday"))
            {
                counterHolidays++;
            }
        }

        return counterHolidays;
    }
}
