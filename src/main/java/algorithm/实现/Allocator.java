package algorithm.实现;

public class Allocator {

    int[] cate ;

    public Allocator(int n) {
        this.cate = new int[n];
    }
    
    public int allocate(int size, int mID) {
        int low = 0;
        int high = size - 1;
        while (low <= cate.length - size + 1 && high <= this.cate.length - 1){
            boolean f = true;
            for (int i = low; i <= high; i++) {
                if (this.cate[i] != 0){
                    low  =  i + 1 ;
                    high =  i + size;
                    f = false;
                    break;
                }
            }
            if (f){
                for (int i = low; i <= high; i++) {
                    this.cate[i] = mID;
                }
                return low;
            }
        }

        return -1;
    }
    
    public int freeMemory(int mID) {

        int ans = 0;
        for (int i = 0; i < this.cate.length ; i++) {
            if (this.cate[i] == mID){
                this.cate[i] = 0;
                ans ++;
            }
        }
        return ans;
    }

}