import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ConvertToRoman {
    public static String intToRoman(int num) {

        String s="";
        Map<Integer,String> romannumber = new HashMap<>();
        romannumber.put(1,"I");
        romannumber.put(5,"V");
        romannumber.put(10,"X");
        romannumber.put(50,"L");
        romannumber.put(100,"C");
        romannumber.put(500,"D");
        romannumber.put(1000,"M");

        romannumber.put(4,"IV");
        romannumber.put(9,"IX");
        romannumber.put(40,"XL");
        romannumber.put(90,"XC");
        romannumber.put(400,"CD");
        romannumber.put(900,"CM");

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                s = s + romannumber.get(values[i]);
                num = num - values[i];
            }
        }
        return s;
    }
    public static void main(String args[]){

        System.out.println(intToRoman(444));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

}
