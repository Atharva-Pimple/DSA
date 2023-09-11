import java.util.*;

public class ChocolaProblem{
    public static void main(String args[]){
        int n=4,m=6;
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int hp=1,vp=1;// pieces count
        int v=0, h=0;
        int cost=0;

        while(v<costVer.length && h<costHor.length){
            if(costHor[h]>=costVer[v]){//horizontal cut
                cost += vp*costHor[h];
                hp++;
                h++;
            }else{// vertical cut
                cost +=hp*costVer[v];
                v++;
                vp++;
            }
        }

        while(h<costHor.length){
            cost += vp*costHor[h];
            hp++;
            h++;
        }
        while(v<costVer.length){
            cost +=hp*costVer[v];
            v++;
            vp++;
        }

        System.out.print("Total cost:"+cost);
    }
}