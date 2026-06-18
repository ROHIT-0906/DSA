
import java.util.*;

public class JobSquencing {
    public static void main(String[] args) {
        int job[][] = {{4,20},{1,10},{1,40},{1,30}};

        Arrays.sort(job, Comparator.comparingDouble( o -> o[1]));

        int time = 0;
        for(int i=0; i<job.length; i++){
            if(job[i][0] != time){
                
            }
        }

        System.out.println(profit);

    }
}
