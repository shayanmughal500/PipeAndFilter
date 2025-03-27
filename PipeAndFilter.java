import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PipeAndFilter {
    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Create a pipeline
        List<Function<List<Integer>, List<Integer>>> filters = new ArrayList<>();
        filters.add(PipeAndFilter::filterEvenNumbers);
        filters.add(PipeAndFilter::squareNumbers);
        filters.add(PipeAndFilter::filterNumbersGreaterThanTen);
        filters.add(PipeAndFilter::filterPrime);

        // Process the input through the pipeline
        List<Integer> result = processPipeline(input, filters);

        // Output the result
        System.out.println(result);
    }

    // Process the input through the pipeline of filters
    private static List<Integer> processPipeline(List<Integer> input, List<Function<List<Integer>, List<Integer>>> filters) {
        List<Integer> output = input;
        for (Function<List<Integer>, List<Integer>> filter : filters) {
            output = filter.apply(output);
        }
        return output;
    }

    // Filter to keep even numbers
    private static List<Integer> filterEvenNumbers(List<Integer> input) {
        return input.stream()
                    .filter(n -> n % 2 == 0)
                    .collect(Collectors.toList());
    }



    // Filter to square the numbers
    private static List<Integer> squareNumbers(List<Integer> input) {
        return input.stream()
                    .map(n -> n * n)
                    .collect(Collectors.toList());
    }

    // Filter to keep numbers greater than 10
    private static List<Integer> filterNumbersGreaterThanTen(List<Integer> input) {
        return input.stream()
                    .filter(n -> n > 10)
                    .collect(Collectors.toList());
    }

    
    // Filter prime numbers
    private static List<Integer> filterPrime(List<Integer> input) {
        return input.stream()
                    .filter(PipeAndFilter::isPrime)
                    .collect(Collectors.toList());
    }

    // Helper method to check if a number is prime
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}