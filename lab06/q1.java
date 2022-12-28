import java.util.ArrayList;

public class q1 {
    ArrayList<Integer> arrayList = new ArrayList<>();
    int maxBudget = 0;
    
    int budgetTemp = 0;

    static int size;
    static ArrayList<Integer> temp1, temp2;
    int kacinciussu;

    public q1(){
        arrayList.add(4);
        arrayList.add(1);
        arrayList.add(8);
        arrayList.add(1);
        arrayList.add(7);
        arrayList.add(1);
        arrayList.add(6);
        arrayList.add(1);
        kacinciussu = zort(arrayList.size());

        recursiveFalan(arrayList);
    }

    public int zort(int x){
        int i = 0;
        while (x > 1){
            x = x/2;
            i++;
        }
        return i;
    }

    public int getMax(ArrayList<Integer> x){
        int max = 0;
        for (int i = 0; i < x.size(); i++){
            if (x.get(i) > max){
                max = x.get(i);
            }
        }
        return max;
    }

    public int recursiveFalan(ArrayList<Integer> x){
        int max1 = 0;
        int max2 = 0;
        if (x.size() == 2){
            return maxBudget + x.get(0) + x.get(1);
        }
        else {
            temp1 = new ArrayList<>();
            temp2 = new ArrayList<>();

            for (int i = 0; i < x.size()/2; i++){    //making temp1
                temp1.add(x.get(i));
            }

            for (int i = x.size()/2; i < x.size(); i++){
                temp2.add(x.get(i));
            }

            max1 = recursiveFalan(temp1);
            max2 = recursiveFalan(temp2);

            if(max1 > max2) maxBudget = max1;
            else maxBudget = max2;

            return maxBudget;
        }
    }

    public int getMaxBudget(){
        return maxBudget;
    }
}
