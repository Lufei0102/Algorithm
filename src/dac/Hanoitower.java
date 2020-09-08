package dac;

public class Hanoitower {
    private static int counts = 0;
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        hanoiTower(5,'A','B','C');
        long end = System.currentTimeMillis();
//        所耗时间：0.196
//        递归次数134217728
        System.out.println("所耗时间："+(double)(end-begin)/1000);
        System.out.println("递归次数"+counts);
    }

    /**
     *
     * @param num
     * @param a
     * @param b 中间参数是辅助盘
     * @param c
     */
    public static void hanoiTower(int num,char a , char b,char c){
        counts +=1;
        //如果只有一个盘
        if (num == 1){
            //System.out.println("第一个盘从 "+ a + "->" + c);
        } else {
            //如果n >= 2,总是可以看作是两个盘和对下面的一个盘
            //1，先把最上面的所有盘A-B 移动过程会使用到c
            hanoiTower(num - 1,a,c,b);
            //2.把最下面的盘 A->C
           // System.out.println("第" + num + "个盘从 " +a+ "->" + c);
            //3.把B塔的所有盘从B—>C,移动过程使用到a塔
            hanoiTower(num - 1,b,a,c);
        }
    }
}
