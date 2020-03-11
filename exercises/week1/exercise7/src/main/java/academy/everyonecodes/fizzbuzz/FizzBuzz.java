package academy.everyonecodes.fizzbuzz;

public class FizzBuzz {
    private MultipleFinder multipleOfThree;
    private MultipleFinder multipleOfFive;

    public FizzBuzz(MultipleFinder multipleOfThree, MultipleFinder multipleOfFive) {
        this.multipleOfThree = multipleOfThree;
        this.multipleOfFive = multipleOfFive;
    }

    public String apply(int number) {
        if (multipleOfThree.isMultiple(number) && multipleOfFive.isMultiple(number)) {
            return "FizzBuzz";
        }
        if (multipleOfFive.isMultiple(number)) {
            return "Buzz";
        }
        if (multipleOfThree.isMultiple(number)) {
            return "Fizz";
        }
        return number + "";
    }
}
