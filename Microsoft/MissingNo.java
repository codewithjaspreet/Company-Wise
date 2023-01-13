package Microsoft;

public class MissingNo {

    // Given an array of size n-1 and given that there are numbers from 1 to n with one missing,
    // the missing number is to be found.
    // algorithm: sum of n natural numbers = n(n+1)/2
    // sum of array elements = sum
    // missing number = n(n+1)/2 - sum

        int MissingNumber(int array[], int n) {
            // Your Code Here

            int sum = 0;

            for (int a : array) {

                sum += a;
            }

            return (n * (n + 1)) / 2 - sum;

        }
    }
