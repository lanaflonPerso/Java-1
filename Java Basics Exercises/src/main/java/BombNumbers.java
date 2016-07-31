import java.util.*;

/**
 * Created by Hristo on 29.07.2016 г..
 */
public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine();
        String[] tokens = line.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i < tokens.length;i++) {
            numbers.add(Integer.parseInt(tokens[i]));
        }

        List<Integer> bombNum = new ArrayList<Integer>();
        bombNum.add(scanner.nextInt());
        bombNum.add(scanner.nextInt());

        for (int i = 0; i < numbers.size(); i++)
        {
            if (numbers.get(i).equals(bombNum.get(0)))
            {
                for (int j = i + 1; j < i + 1 + bombNum.get(1); j++)
                {
                    if (i + 1 == numbers.size())
                    {
                        break;
                    }
                    else
                    {
                        numbers.remove(i + 1);
                    }
                }
                for (int j = i; j > i - bombNum.get(1); j--)
                {
                    if (j == 0)
                    {
                        break;
                    }
                    else
                    {
                        numbers.remove(j - 1);
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (!numbers.get(i).equals(bombNum.get(0)))
            sum += numbers.get(i);
        }
        System.out.println(sum);
    }
}
