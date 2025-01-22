package credit;
import java.util.Scanner;

public class Credit {
    public static boolean isValid(long number) {
		if(getSize(number) < 13 || getSize(number) > 16) {
            return false;
        }
		if(prefixMatched(getPrefix(number, 1), 4) || prefixMatched(getPrefix(number, 1), 5) ||
			prefixMatched(getPrefix(number, 1), 6) || prefixMatched(getPrefix(number, 2), 37)) {
			int k = sumOfDoubleEvenPlace(number)+sumOfOddPlace(number);
			if(k % 10 == 0) {
                return true;
            }
		}
		return false;

    }
    public static int sumOfDoubleEvenPlace(long number) {
        long n = number;
		int i = 0;
        int sum = 0;
		
		while(n>0) {
			if(i % 2 !=0) {
				sum+=getDigit((int)(n % 10));
			}
			i++;
			n = n / 10;
		}
		
		return sum;
    }
    public static int getDigit(int number) {
        number = number * 2;
		if(number < 10){
            return number;
        } 
		else {
            return number % 10 + 1;
        }
    }
    public static int sumOfOddPlace(long number) {
        long n = number;
		int i = 0;
        int sum = 0;
		
		while(n > 0) {
			if(i % 2 == 0) {
				sum += n % 10;
			}
			i++;
			n = n / 10;
		}
		
		return sum;
    }
    public static boolean prefixMatched(long number, int d) {
        if(number == (long) d) {
            return true;
        }
        return false;
    }
    public static int getSize(long d) {
        int l = 0; 
		while(d > 9) {
			d = d / 10;
			l++;
		}
		return l;
    }
    public static long getPrefix(long number, int k) {
        long n = number;
		while (String.valueOf(n).length() > k) {
			n = n / 10;
		}
		return n;
    }
    public static void main(String[] args) {
        System.out.println("Enter a credit card number as a long integer: ");
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();
        if (isValid(number)) {
            System.out.println(number + " is valid");
        }
        else {
            System.out.println(number + " is invalid");
        }
        input.close();
    }
}
