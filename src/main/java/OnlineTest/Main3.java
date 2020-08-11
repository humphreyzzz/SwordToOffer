package OnlineTest;

import java.util.Scanner;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/8/5 19:22
 * @Version 1.0
 **/

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int abilityNum = in.nextInt();
        int magicPoints = in.nextInt();
        int liveSeconds = in.nextInt();
        int[] abilityDamage = new int[abilityNum];
        int[] abilityMagicCost = new int[abilityNum];
        int[] abilityCoolDown = new int[abilityNum];
        for(int i=0;i<abilityNum;i++){
            abilityDamage[i] = in.nextInt();
            abilityMagicCost[i] = in.nextInt();
            abilityCoolDown[i] = in.nextInt();
        }

        int[][] dp = new int[abilityNum+1][magicPoints+1];
        for(int i=0;i<=magicPoints;i++){
            dp[0][i] = 0;
        }
        for (int i=1;i<=abilityNum;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<=abilityNum;i++){
            for (int j=1;j<=magicPoints;j++){
                for(int k = 0;k*abilityMagicCost[i-1]<=j&&k*abilityCoolDown[i-1]<=liveSeconds;k++){
                    dp[i][j] = Math.max(dp[i-1][j-k*abilityMagicCost[i-1]]+k*abilityDamage[i-1],dp[i][j]);
                }
            }
        }
        System.out.println(dp[abilityNum][magicPoints]);

    }
}
