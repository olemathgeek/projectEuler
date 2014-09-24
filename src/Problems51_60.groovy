/**
 * Created by emily.jones on 9/24/2014.
 */
class Problems51_60 {
    public static Double nChooseR(Double n, Double r){
        Double top = factorial(n)
        Double bottom = factorial(r) * factorial(n-r)
        Double nChooseR = top/bottom
        return nChooseR
        //n!/(r!(n-r!))

    }
    public static Double factorial(Double n){
        int soln = 1
        for(Double i=1; i<=n; i++){
            soln *= i
        }
        return soln
    }
    public static void problem53(){
        int numOverOneMillion = 0
        for(Double n = 0; n<=100; n++){
            for(Double r = 0; r<=n; r++){
                if(nChooseR(n,r) > 1000000){
                    numOverOneMillion++
                }
            }
        }
        System.out.println(numOverOneMillion)

    }

}
