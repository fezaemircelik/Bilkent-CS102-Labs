import java.lang.reflect.Array;
import java.util.*;

public class FoodOrder {
    public ArrayList<MenuItem> yemekSepeti;

    public FoodOrder(){
        yemekSepeti = new ArrayList<>();
    }

    public void addItemToYemekSepeti(MenuItem x){
        boolean checker = false;
        int size = yemekSepeti.size();
        for (int i = 0; i < size; i++){
            if (yemekSepeti.get(i).getItemCost() > x.getItemCost()){
                for (int j = i; j < size; j++){
                    yemekSepeti.add(j + 1, yemekSepeti.get(j));
                }
                yemekSepeti.add(i, x);
                i = size + 10;
                checker = true;
            }
        }
        if (checker == false){
            yemekSepeti.add(x);
        }
    }

    public void emptyYemekSepeti(){
        for (int i = 0; i < yemekSepeti.size(); i++){
            yemekSepeti.remove(0);
        }
    }

    public int calculateTotalCalories(){
        int totalCalories = 0;
        for (int i = 0; i < yemekSepeti.size(); i++){
            if (yemekSepeti.get(i) != null){
                totalCalories += yemekSepeti.get(i).getItemCalories();
            }
        }
        return totalCalories;
    }

    public ArrayList<MenuItem> searchYemekSepeti(String x){
        ArrayList<MenuItem> result = new ArrayList<MenuItem>();
        int j = 0;
        for (int i = 0; i < yemekSepeti.size(); i++){
            if (yemekSepeti.get(i).getItemDescription().contains(x)){
                result.add(yemekSepeti.get(i));
            }
        }
        return result;
    }

    public String toString(){
        String result = "\n";
        for (int i = 0; i < yemekSepeti.size(); i++){
            result += i + ")" + yemekSepeti.get(i).getItemName() + ", total calories = " + calculateTotalCalories() +  "\n";
        }

        return result;
    }


}
