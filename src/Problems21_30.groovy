/**
 * Created by emily.jones on 8/21/2014.
 */

class Problems21_30 {
    public static int getProperDivisorSum(int num){
        ArrayList<Long> divisors = HelperMethods.findDivisors(num, false)
        int ret = 0;
        for(Long div : divisors){
            if(div != num){
                ret += div
            }
        }
        return ret
    }

    public static void problem21(){
        int sum = 0;
        for(int i=0; i<10000; i++){
            int amiable = getProperDivisorSum(i)
            if(amiable > i){
                int maybeI = getProperDivisorSum(amiable)
                if(maybeI == i){
                    sum += i + amiable
                }
            }
        }
        System.out.println(sum)
    }

    public static void problem22(){
        def f = new File("src/supportingFiles/22.txt")
        ArrayList<String> names = new ArrayList<String>()
        f.eachLine { line ->
            line = line.substring(1,line.size()-1)
            names = line.split("\",\"")
        }
        names = names.sort()

        BigInteger sum = 0
        for(int i=0; i<names.size(); i++){
            sum += HelperMethods.alphabeticValue(names[i])*(i+1)
            if(names[i].equals("COLIN")){
                System.out.println(HelperMethods.alphabeticValue(names[i])*(i+1))
            }
        }
        System.out.println(sum)
    }

    public static void problem23(){
//        A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
//        A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
//                As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
//                Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
        ArrayList<Integer> abundants = new ArrayList<Integer>()
        int max = 28124
        for(int i=1; i<max; i++){
            if(HelperMethods.isAbundant(i)){
                abundants.push(i)
            }
        }
        System.out.println("have "+abundants.size()+" abundants")
        Integer sum = 0;
        for(int i=1; i<max; i++){
            boolean works = false
            for(int j=0; j<abundants.size() && abundants[j]<i && !works; j++){
                for(int k=0; k<abundants.size() && k<=j && !works; k++){
                    if(abundants[j] + abundants[k]==i){
                        works = true
                    }
                }
            }
            if(!works){
                sum += i
            }
        }
        System.out.println()
        System.out.println(sum)
    }

    public ArrayList<String> perms = new ArrayList<String>()

    public void problem24(){
        String original = "0123456789"
        permute("",original)
        System.out.println(perms.get(999999))
    }

    public void permute(String beginningString, String endingString) {
        if (endingString.length() <= 1) {
            perms.add(beginningString + endingString);
        }
        else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);

                    permute(beginningString + endingString.charAt(i), newString);
                } catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public static void problem25(){
        ArrayList<BigInteger> fibs = new ArrayList<BigInteger>()
        fibs.push(new BigInteger(1))
        fibs.push(new BigInteger(1))
        while(fibs.get(fibs.size()-1).toString().length() < 1000){
            fibs.push(fibs.get(fibs.size()-1).add(fibs.get(fibs.size()-2)))
        }
//        System.out.println(fibs.get(fibs.size()-1))
        System.out.println(fibs.size())

    }

    public static void problem26(){
        //TODO
        System.out.println("TODO!")
    }

    public static void problem27(){

    }
}
