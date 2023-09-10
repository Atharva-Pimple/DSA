import java.util.*;

public class ChainOfPairs{
    public static void main(String args[]){
        int pairs[][]={{5,24},{39,60},{50,90},{5,28},{27,40}};

        Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));

        int pairEnd=pairs[0][1];
        int maxLen=1;

        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0] >= pairEnd){
                maxLen++;
                pairEnd=pairs[i][1];
            }
        }

        System.out.print("Maximum length of chain="+maxLen);
    }

}