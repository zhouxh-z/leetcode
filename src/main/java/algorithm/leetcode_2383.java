package algorithm;

/**
 * 赢得比赛需要的最少训练时长
 *
 * @author zhouxianghui6
 * @description
 * @date 2023/3/13
 */
public class leetcode_2383 {
    /**
     *
     *
     * @param initialEnergy           5
     * @param initialExperience       3
     * @param energy                  [1,4,3,2]
     * @param experience              [2,6,3,1]
     * @return
     */
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int xl = 0;
        for(int i = 0 ;i < energy.length; i++){
            if(energy[i] >= initialEnergy){
                int i1 = energy[i] - initialEnergy + 1;
                xl += i1;
                initialEnergy = initialEnergy + i1;
            }
            initialEnergy -= energy[i] ;
            if(experience[i] >= initialExperience){
                int i1 = experience[i] - initialExperience + 1;
                xl += i1;
                initialExperience += i1;
            }
            initialExperience += experience[i];
        }
        return xl;
    }

    public static void main(String[] args) {
        System.out.println(minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));

    }

}
