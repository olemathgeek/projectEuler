import java.text.SimpleDateFormat

/**
 * Created by EmilyJones on 8/12/14.
 */
class Problems11_20 {

    public static void problems11_20(){
        System.out.print("Problem 11:")
        Problems11_20.problem11()
        System.out.print("Problem 12:")
        Problems11_20.problem12()
        System.out.print("Problem 13:")
        Problems11_20.problem13()
        System.out.print("Problem 14:")
        Problems11_20.problem14()
        System.out.print("Problem 15:")
        Problems11_20.problem15()
        System.out.print("Problem 16:")
        Problems11_20.problem16()
        System.out.print("Problem 17:")
        Problems11_20.problem17()
        System.out.print("Problem 18:")
        Problems11_20.problem18()
        System.out.print("Problem 19:")
        Problems11_20.problem19()
        System.out.print("Problem 20:")
        Problems11_20.problem20()
    }

    public static final int[][] board = [[8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8],[49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0],[81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65],[52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91],[22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80],[24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50],[32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70],[67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21],[24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72],[21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95],[78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92],[16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57],[86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58],[19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40],[4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66],[88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69],[4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36],[20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16],[20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54],[1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48]]

    public static void problem11(){
        int maxProd = 0
        for(int x = 0; x<20; x++){
            for(int y = 0; y<20; y++){
                int rightProd = getProdToRight(x,y)
                if(rightProd > maxProd){
                    maxProd = rightProd
                }
                int downProd = getProdDown(x,y)
                if(downProd > maxProd){
                    maxProd = downProd
                }
                int downRightProd = getProdDownRight(x,y)
                if(downRightProd > maxProd){
                    maxProd = downRightProd
                }
                int upRightProd = getProdUpRight(x,y)
                if(upRightProd > maxProd){
                    maxProd = upRightProd
                }
            }
        }
        System.out.println(maxProd)
    }

    public static int getProdToRight(int x, int y){
        if(x>16){
            return 0
        }
        return board[x][y]*board[x+1][y]*board[x+2][y]*board[x+3][y]
    }

    public static int getProdDown(int x, int y){
        if(y>16){
            return 0
        }
        return board[x][y]*board[x][y+1]*board[x][y+2]*board[x][y+3]
    }

    public static int getProdDownRight(int x, int y){
        if(y>16 || x>16){
            return 0
        }
        return board[x][y]*board[x+1][y+1]*board[x+2][y+2]*board[x+3][y+3]
    }

    public static int getProdUpRight(int x, int y){
        if(y<3 || x>16){
            return 0
        }
        return board[x][y]*board[x+1][y-1]*board[x+2][y-2]*board[x+3][y-3]
    }

    public static void problem12(){
        long triangle = 0
        long numDivisors = 0
        for(long i=1; numDivisors<=500; i++){
            triangle += i
            long numDivsHere = HelperMethods.findDivisors(triangle,false).size()
            if(numDivsHere>numDivisors){
                numDivisors = numDivsHere
                System.out.println("("+triangle+":"+numDivsHere+")")
            }
        }
        System.out.println(triangle)
    }

//    number 12
//    (1:1)
//    (3:2)
//    (6:4)
//    (28:6)
//    (36:9)
//    (120:16)
//    (300:18)
//    (528:20)
//    (630:24)
//    (2016:36)
//    (3240:40)
//    (5460:48)
//    (25200:90)
//    (73920:112)
//    (157080:128)
//    (437580:144)
//    (749700:162)
//    (1385280:168)
//    (1493856:192)
//    (2031120:240)
//    (2162160:320)
//    (17907120:480)
//    (76576500:576)
//    76576500

    public static void problem13(){
        ArrayList<String> numsForward = ["37107287533902102798797998220837590246510135740250","46376937677490009712648124896970078050417018260538","74324986199524741059474233309513058123726617309629","91942213363574161572522430563301811072406154908250","23067588207539346171171980310421047513778063246676","89261670696623633820136378418383684178734361726757","28112879812849979408065481931592621691275889832738","44274228917432520321923589422876796487670272189318","47451445736001306439091167216856844588711603153276","70386486105843025439939619828917593665686757934951","62176457141856560629502157223196586755079324193331","64906352462741904929101432445813822663347944758178","92575867718337217661963751590579239728245598838407","58203565325359399008402633568948830189458628227828","80181199384826282014278194139940567587151170094390","35398664372827112653829987240784473053190104293586","86515506006295864861532075273371959191420517255829","71693888707715466499115593487603532921714970056938","54370070576826684624621495650076471787294438377604","53282654108756828443191190634694037855217779295145","36123272525000296071075082563815656710885258350721","45876576172410976447339110607218265236877223636045","17423706905851860660448207621209813287860733969412","81142660418086830619328460811191061556940512689692","51934325451728388641918047049293215058642563049483","62467221648435076201727918039944693004732956340691","15732444386908125794514089057706229429197107928209","55037687525678773091862540744969844508330393682126","18336384825330154686196124348767681297534375946515","80386287592878490201521685554828717201219257766954","78182833757993103614740356856449095527097864797581","16726320100436897842553539920931837441497806860984","48403098129077791799088218795327364475675590848030","87086987551392711854517078544161852424320693150332","59959406895756536782107074926966537676326235447210","69793950679652694742597709739166693763042633987085","41052684708299085211399427365734116182760315001271","65378607361501080857009149939512557028198746004375","35829035317434717326932123578154982629742552737307","94953759765105305946966067683156574377167401875275","88902802571733229619176668713819931811048770190271","25267680276078003013678680992525463401061632866526","36270218540497705585629946580636237993140746255962","24074486908231174977792365466257246923322810917141","91430288197103288597806669760892938638285025333403","34413065578016127815921815005561868836468420090470","23053081172816430487623791969842487255036638784583","11487696932154902810424020138335124462181441773470","63783299490636259666498587618221225225512486764533","67720186971698544312419572409913959008952310058822","95548255300263520781532296796249481641953868218774","76085327132285723110424803456124867697064507995236","37774242535411291684276865538926205024910326572967","23701913275725675285653248258265463092207058596522","29798860272258331913126375147341994889534765745501","18495701454879288984856827726077713721403798879715","38298203783031473527721580348144513491373226651381","34829543829199918180278916522431027392251122869539","40957953066405232632538044100059654939159879593635","29746152185502371307642255121183693803580388584903","41698116222072977186158236678424689157993532961922","62467957194401269043877107275048102390895523597457","23189706772547915061505504953922979530901129967519","86188088225875314529584099251203829009407770775672","11306739708304724483816533873502340845647058077308","82959174767140363198008187129011875491310547126581","97623331044818386269515456334926366572897563400500","42846280183517070527831839425882145521227251250327","55121603546981200581762165212827652751691296897789","32238195734329339946437501907836945765883352399886","75506164965184775180738168837861091527357929701337","62177842752192623401942399639168044983993173312731","32924185707147349566916674687634660915035914677504","99518671430235219628894890102423325116913619626622","73267460800591547471830798392868535206946944540724","76841822524674417161514036427982273348055556214818","97142617910342598647204516893989422179826088076852","87783646182799346313767754307809363333018982642090","10848802521674670883215120185883543223812876952786","71329612474782464538636993009049310363619763878039","62184073572399794223406235393808339651327408011116","66627891981488087797941876876144230030984490851411","60661826293682836764744779239180335110989069790714","85786944089552990653640447425576083659976645795096","66024396409905389607120198219976047599490197230297","64913982680032973156037120041377903785566085089252","16730939319872750275468906903707539413042652315011","94809377245048795150954100921645863754710598436791","78639167021187492431995700641917969777599028300699","15368713711936614952811305876380278410754449733078","40789923115535562561142322423255033685442488917353","44889911501440648020369068063960672322193204149535","41503128880339536053299340368006977710650566631954","81234880673210146739058568557934581403627822703280","82616570773948327592232845941706525094512325230608","22918802058777319719839450180888072429661980811197","77158542502016545090413245809786882778948721859617","72107838435069186155435662884062257473692284509516","20849603980134001723930671666823555245252804609722","53503534226472524250874054075591789781264330331690"]
        ArrayList<String> totalBackwards = new ArrayList<String>()
        ArrayList<String> nums = new ArrayList<String>()
        for(String num : numsForward){
            nums.add(num.reverse())
        }
        boolean foundSomeLastTime = true
        for(int i = 0; foundSomeLastTime; i++){
            foundSomeLastTime = false
            int sumAtLocation = 0;
            for(String num : nums){
                if(num.length()>i){
                    foundSomeLastTime = true
                    sumAtLocation += Integer.valueOf(num.substring(i,i+1))
                }
            }
            String sumAtLocal = String.valueOf(sumAtLocation)
            sumAtLocal = sumAtLocal.reverse()
            for(int j=0; j<i; j++){
                sumAtLocal = "0"+sumAtLocal
            }
            nums.add(sumAtLocal)
            totalBackwards.add(sumAtLocal.substring(i,i+1))
            for(int k=0; k<totalBackwards.size(); k++){
                System.out.print(totalBackwards.get(k))
            }
            System.out.println()
        }

        ArrayList<String> total = totalBackwards.reverse()
        for(int i=1; i<11; i++){
            System.out.print(total.get(i))
        }
    }

    public static long getNextTerm(long n){
        if(n%2==0){
            return n/2
        }
        else{
            return (3*n + 1)
        }
    }

    public static void problem14() {
        long maxTerms = 0;
        long startNumForMaxTerms = 0;
        for(long i=1; i<1000000; i++){
            long n = i;
            long num = 0;
            while(n != 1){
                num++
                n = getNextTerm(n)
            }
            if(num > maxTerms){
                maxTerms = num
                startNumForMaxTerms = i
                System.out.println(i + " runs " + num + " times")
            }
        }
        System.out.println(startNumForMaxTerms)

//        The following iterative sequence is defined for the set of positive integers:
//
//        n → n/2 (n is even)
//        n → 3n + 1 (n is odd)
//
//        Using the rule above and starting with 13, we generate the following sequence:
//
//                13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
//        It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
//
//                Which starting number, under one million, produces the longest chain?
//
//        NOTE: Once the chain starts the terms are allowed to go above one million.


    }

    public static void problem15(){
        System.out.println("40 choose 20 = 137846528820")
    }

    public static void problem16(){
//        2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
//
//        What is the sum of the digits of the number 2^1000?
        BigInteger power = HelperMethods.getPower(2,1000)
        String powerStr = power.toString()
        Long digitSum = 0;
        for(int i = 0; i<powerStr.size(); i++){
            digitSum += Integer.valueOf(powerStr.substring(i,i+1))
        }
        System.out.println(digitSum)
    }

    public static int getNumForTens(int i){
        switch(i){
            case[9,2,3,8]:
                return 6
                break
            case[4,5,6]:
                return 5
                break
            case [7]:
                return 7
                break
            default:
                return 0
                break
        }
    }

    public static int getNumForInt(int i){
        switch(i){
            case{it>=20}:
                return getNumForInt(Integer.valueOf(String.valueOf(i).substring(1,2))) + getNumForTens(Integer.valueOf(String.valueOf(i).substring(0,1)))
                break
            case [1,2,6,10]:
                return 3
                break
            case [4,5,9]:
                return 4
                break
            case [3,7,8]:
                return 5
                break
            case [11,12]:
                return 6
                break
            case [15,16]:
                return 7
                break
            case [13,14,18,19]:
                return 8
                break
            case [17]:
                return 9
                break
            default:
                return 0
                break
        }
    }

    public static void problem17(){
        long totalSum=0;
        for(int i=1; i<=1000; i++){
            long numSum=0;
            if(i==1000) {
                numSum = 11;
            } else if(i>=100){
                numSum = 7 + getNumForInt(Integer.valueOf(String.valueOf(i).substring(0,1))) + getNumForInt(Integer.valueOf(String.valueOf(i).substring(1,3)))
                if(Integer.valueOf(String.valueOf(i).substring(1,3))!=0){
                    numSum += 3
                }
            } else {
                numSum = getNumForInt(i)
            }
            totalSum += numSum;
        }
        System.out.println(totalSum)
    }

    public static void problem18(){
        def f = new File("src/supportingFiles/18.txt")
        ArrayList<Integer> previous = new ArrayList<Integer>()
        f.eachLine { line ->
            ArrayList<Integer> current = new ArrayList<Integer>()
            String[] nums = line.split(" ")
            for(int i = 0; i< nums.size(); i++){
                int a = 0
                int b = 0
                if(i<previous.size()){
                    a = previous[i]
                }
                if(i-1>-1 && i-1<previous.size()){
                    b = previous[i-1]
                }
                int newVal = Integer.valueOf(nums[i])
                if(a>b){
                    newVal += a
                } else {
                    newVal += b
                }
                current.push(newVal)
            }
            previous = current
        }
        int max = 0
        for(Integer i : previous){
            if(max<i){
                max = i
            }
        }
        System.out.println(max)
    }

    public static void problem19(){
        Date testDate = new Date(1,0,1)
        int numSundays = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("d")
        while(testDate.before(new Date(101,0,1))){
            Calendar cal = Calendar.getInstance();
            cal.setTime(testDate);
            if(testDate.getDay() == 0 && sdf.format(cal.getTime()).equals("1")){
                numSundays++
            }
            testDate = HelperMethods.addDays(testDate,1)
        }
        System.out.println(numSundays)
    }

    public static void problem20(){
        BigInteger fact = 1
        for(int i=1; i<=100; i++){
            fact = fact * i
        }
        String factorial = String.valueOf(fact)
        int sum = 0;
        for(int i=0; i<factorial.length(); i++){
            sum += Integer.valueOf(factorial.substring(i,i+1))
        }
        System.out.println(sum)
    }

}
