import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;


//using dependency injection
// Test Double
public class NotRandom extends Random {

    private LinkedList<Integer> nums;

    public NotRandom(){
        nums = new LinkedList<>();
    }

    public NotRandom(ArrayList<Integer> numsToAdd){
        nums = new LinkedList<>();
        addNums(numsToAdd);
    }

    public int nextInt(int upperBound){
        if(nums.isEmpty()){
            throw new NoSuchElementException("List is Empty");
        }
        return nums.pop();
    }

    public void addNums(ArrayList<Integer> numsToAdd){
        nums.addAll(numsToAdd);
    }

}
