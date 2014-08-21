/**
 * Created by EmilyJones on 8/7/14.
 */
class Problems1_10 {

    public static void problems1_10(){
        System.out.print("Problem 1:")
        Problems1_10.problem1()
        System.out.print("Problem 2:")
        Problems1_10.problem2()
        System.out.print("Problem 3:")
        Problems1_10.problem3()
        System.out.print("Problem 4:")
        Problems1_10.problem4()
        System.out.print("Problem 5:")
        Problems1_10.problem5()
        System.out.print("Problem 6:")
        Problems1_10.problem6()
        System.out.print("Problem 7:")
        Problems1_10.problem7()
        System.out.print("Problem 8:")
        Problems1_10.problem8()
        System.out.print("Problem 9:")
        Problems1_10.problem9()
        System.out.print("Problem 10:")
        Problems1_10.problem10()
    }

    public static void problem1(){
        int sum = 0
        for(int i=1; i<1000; i++){
            if(i%3==0 || i%5==0){
                sum += i
            }
        }
        System.out.println(sum)
    }


    public static void problem2(){
        int sum = 0;
        int fib1 = 1;
        int fib2 = 1;
        while(fib2<=4000000){
            int newFib = fib1 + fib2;
            if(newFib % 2 == 0){
                sum += newFib;
            }
            fib1 = fib2;
            fib2 = newFib;
        }
        System.out.println(sum);
    }

    public static void problem3(){
        ArrayList<Integer> factors= HelperMethods.factor(600851475143)
        factors.sort()
        System.out.println(factors[factors.size()-1])
    }

    public static void problem4(){
        //A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
        //Find the largest palindrome made from the product of two 3-digit numbers.
        ArrayList<Integer> palProds = new ArrayList<Integer>()
        for(int i = 100; i<1000; i++){
            for(int j=i; j<1000; j++){
                if(HelperMethods.isPalindrome(i*j)){
                    palProds.add(i*j)
                }
            }
        }
        palProds.sort()
        System.out.println(palProds[palProds.size()-1])
    }

    public static void problem5(){
//        2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//        What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
        HashMap<Integer, Integer> factors = new HashMap<Integer, Integer>()
        for(int i=2; i<=20; i++){
            ArrayList<Integer> indFactors = HelperMethods.factor(i)
            for(int factor:indFactors){
                int numFactor = indFactors.count(factor)
                if(factors.containsKey(factor)){
                    if(factors.get(factor)<numFactor){
                        factors.put(factor, numFactor)
                    }
                }
                else{
                    factors.put(factor, numFactor)
                }
            }
        }

        int product = 1;
        for(int key : factors.keySet()){
            for(int i=0; i<factors.get(key); i++){
                product *= key
            }
        }
        System.out.println(product)
    }

    public static void problem6(){
        int sumOfSquares = 0;
        int squareOfSum = 0;
        for(int i=1; i<=100; i++){
            sumOfSquares += (i * i)
            squareOfSum += i
        }
        squareOfSum = squareOfSum * squareOfSum
        System.out.println(squareOfSum-sumOfSquares)
    }

    public static void problem7(){
        //1001th prime
        int whichPrime = 10001
        int countPrimes = 0;
        int prime1001 = 0;
        ArrayList<Integer> pastPrimes = new ArrayList<Integer>()
        for(int i=2; countPrimes<whichPrime; i++){
            if(HelperMethods.isPrime(pastPrimes, i)){
                pastPrimes.add(i)
                countPrimes++;
                if(countPrimes == whichPrime){
                    prime1001 = i
                }
            }
        }
        System.out.println(prime1001)
    }

    public static void problem8(){
        String num = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"
        int largestProd = 0;
        for(int i=0; i<num.length()-5; i++){
            int a = Integer.valueOf(num.substring(i,i+1))
            int b = Integer.valueOf(num.substring(i+1,i+2))
            int c = Integer.valueOf(num.substring(i+2,i+3))
            int d = Integer.valueOf(num.substring(i+3,i+4))
            int e = Integer.valueOf(num.substring(i+4,i+5))
            int prod = a*b*c*d*e
            if(prod > largestProd){
                largestProd = prod
            }
        }
        System.out.println(largestProd)
    }

    public static void problem9(){
        boolean solved = false
        for(int a=1; !solved; a++){
            for(int b=a+1; !solved && b<1000-2*a; b++){
                if(HelperMethods.isPerfectSquare(a*a + b*b)){
                    int c = Math.sqrt(a*a+b*b)
                    if(HelperMethods.isSumToValue([a,b,c],1000)){
                        System.out.println(a*b*c)
                        solved = true
                    }
                }
            }
        }
    }

    public static void problem10(){
        ArrayList<Integer> pastPrimes = new ArrayList<Integer>()
        long sum = 0
        for(int i=2; i<2000000; i++){
            if(HelperMethods.isPrime(pastPrimes, i)){
                pastPrimes.add(i)
                sum += i
            }
        }
        System.out.println(sum)

    }
}
