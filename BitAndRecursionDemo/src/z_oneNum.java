
public class z_oneNum {

    /*
     *  ��1��n�ҳ�����һ�ĸ�����
     *
     *  ����һ:ʱ�临�Ӷ�O(NlogN)
     *
     *   ( logNλ����  100  2  10  1  1000 3) *N
     *
     *
     *  ������:�۲취
     *
     *
     *
     *
     *
     * */

    //�����1��n�м���1

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


    //��ȡһ�����ĺ���1�ĸ���������֮ǰ����5�ĸ���

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
