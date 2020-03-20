package academy.everyonecodes.creditcards;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class Luhn {
    public boolean isValid(String number) {
        List<Integer> reversedDigits = getReversedDigits(number);
        int sum = getLuhnSum(reversedDigits);
        return sum % 10 == 0;
    }

    private List<Integer> getReversedDigits(String number) {
        List<Integer> digits = Stream.of(number.split(""))
                .map(Integer::valueOf)
                .collect(toList());
        Collections.reverse(digits);
        return digits;
    }

    private int getLuhnSum(List<Integer> reversedDigits) {
        int sum = 0;
        boolean isEven = false;
        for (Integer number : reversedDigits) {
            if (isEven) {
                number *= 2;
            }
            number = getDigitalRoot(number);
            sum += number;
            isEven = !isEven;
        }
        return sum;
    }

    private Integer getDigitalRoot(Integer number) {
        if (number > 9) {
            return number - 9;
        }
        return number;
    }
}
/*public class Luhn {

   public boolean isValid(String number) {
       AtomicInteger multiplier = getMultiplierInitialValue(number);
       return number.chars()
               .map(ascii -> ascii - '0')
               .map(num -> num * multiplier.updateAndGet(actual -> actual == 1 ? 2 : 1))
               .map(num -> num > 9 ? num - 9 : num)
               .sum() % 10 == 0;
   }

   private AtomicInteger getMultiplierInitialValue(String number) {
       boolean hasAnEvenNumberOfDigits = number.length() % 2 == 0;
       return new AtomicInteger(hasAnEvenNumberOfDigits ? 1 : 2);
   }
}
*/
