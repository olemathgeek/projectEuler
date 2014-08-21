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

}
