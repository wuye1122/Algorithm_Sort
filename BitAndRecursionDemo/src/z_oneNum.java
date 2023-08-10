
public class z_oneNum {

    /*
     *  从1到n找出出现一的个数。
     *
     *  方法一:时间复杂度O(NlogN)
     *
     *   ( logN位数：  100  2  10  1  1000 3) *N
     *
     *
     *  方法二:观察法
     *
     *
     *
     *
     *
     * */

    //计算从1到n有几个1

    public int solution(int n) {
        if (n < 1) {
            return -1;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += getOneNum(i);
        }
        return count;


    }


    //获取一个数的含有1的个数类似于之前含有5的个数

    public int getOneNum(int i) {
        int num = 0;

        while (i != 0) {
            if (i % 10 == 1) {
                num++;
            }
            i /= 10;
        }
        return num;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        z_oneNum zz = new z_oneNum();

        System.out.println(zz.getOneNum(100));
        System.out.println(zz.getOneNum(1111));
        System.out.println(zz.getOneNum(11));

        System.out.println(zz.solution(100));
        System.out.println(zz.solution(1111));
        System.out.println(zz.solution(11));


    }

}
