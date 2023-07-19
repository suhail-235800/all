
public class ProductofRemainingElements {


    public static boolean canPartition(int a[]) {

        int n = 0;
        int product;
        for(int i=0; i<a.length; i++) {
            n=a[i];
            product=1;
            for(int j=0; j<a.length; j++) {
                if (a[i] != a[j]) {
                    product = product * a[j];
                }
            }
            if(n==product){
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args){
        System.out.println(canPartition(new int[]{2, 8, 4, 1}));
        System.out.println(canPartition(new int[]{-1, -10, 1, -2, 20}));
        System.out.println(canPartition(new int[]{-1, -20, 5, -1, -2, 2}));;
    }
}
