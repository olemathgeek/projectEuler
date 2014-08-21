/**
 * Created by EmilyJones on 8/7/14.
 */
class HelperMethods {
    public static ArrayList<Long> factor(long num){
        return findDivisors(num, true)
    }

    public static ArrayList<Long> findDivisors(long num, boolean primeOnly){
        ArrayList<Long> divisors = new ArrayList<Long>()

        for(long i=1; i<=num; i++){
            if(primeOnly) {
                if(i!=1) {
                    while (num % i == 0) {
                        divisors.add(i)
                        num = num / i
                    }
                }
            }
            else{
                if(num % i == 0) {
                    divisors.add(i)
                }
            }
        }
        return divisors;
    }

    public static boolean isPalindrome(int num){
        String numString = String.valueOf(num)
        for(int i=0; i<numString.size(); i++){
            if(!numString.charAt(i).equals(numString.charAt(numString.size()-1-i))){
                return false
            }
        }
        return true
    }

    public static boolean isPrime(int n){
        for(int i=2; i<Math.sqrt(n); i++){
            if(n % i == 0){
                return false
            }
        }
        return true
    }

    public static boolean isPrime(ArrayList<Integer> pastPrimes, int n){
        for(int pastPrime : pastPrimes){
            if(n % pastPrime == 0){
                return false
            }
            if(pastPrime > n){
                return true
            }
        }
        return true
    }

    public static boolean isPythagoreanTriple(int a, int b, int c){
        if(a*a + b*b == c*c){
            return true
        }
        return false
    }

    public static isSumToValue(ArrayList<Integer> vals, int value){
        int sum = 0
        for(int i : vals){
            sum += i
        }
        return sum == value
    }

    public static isPerfectSquare(int n){
        int sqrt = Math.sqrt(n)
        return sqrt*sqrt==n
    }

    public static BigInteger getPower(int a, int b){
        BigInteger pow = 1
        for(int i=0; i<b; i++){
            pow = pow * a
        }
        return pow
    }

    public static Date addDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static int alphabeticValue(String str){
        int sum = 0;
        for(int i=0; i<str.length(); i++){
            sum += (int)str.charAt(i) - 64
        }
        return sum
    }
}
