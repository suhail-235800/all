import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class RoundToMillionMain {


    public static List<City> roundToMillion(List<City> cityList){

        List<City> NewList = new ArrayList<City>();
        for(City city : cityList){
            String s="";
            int population = Integer.parseInt(city.population());
            if(population<500000){
                NewList.add(new City(city.cityName(), "0"));
            }
            else{
                int rounded = (int) Math.round(population/1000000.0) * 10000000;
                s=s+rounded;
                NewList.add(new City(city.cityName(),s));

            }
        }
        return NewList;

    }

    public static void main(String[] args){

        List<City> cityList = new ArrayList<City>();
        cityList.add(new City("Nice", "942208"));
        cityList.add(new City("Abu Dhabi", "1482816"));
        cityList.add(new City("Naples", "2186853"));
        cityList.add(new City("Vatican City", "572"));

        System.out.println(cityList);

        System.out.println(roundToMillion(cityList));

    }
}


