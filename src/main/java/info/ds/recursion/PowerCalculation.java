package info.ds.recursion;

public class PowerCalculation {
    public static int calcPower(int x , int n){
        if(n==0){
            return 1;
        }
        if(x==0){
            return 1;
        }
        return x * calcPower(x,n-1);
    }

    public static int calcPowerLogNHeight(int x , int n){
        if(n==0){
            return 1;
        }
        if(x==0){
            return 1;
        }

        if(n%2==0){
            return calcPowerLogNHeight(x,n/2) * calcPowerLogNHeight(x,n/2);
        }
        else {
            return calcPowerLogNHeight(x,n/2) * calcPowerLogNHeight(x,n/2) *x;
        }

    }


}
