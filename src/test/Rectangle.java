package test;
/*
求长方形面积
 */
public class Rectangle {
    public static void main(String[] args) {
        //测试
        double rectangleArea = getRectangleArea(1.2, 2.2);
        System.out.println("长方形面积"+rectangleArea);
    }

    /**
     * 求长方形面积
     * @param length 长
     * @param width 宽
     * @return 面积
     */
    public static double getRectangleArea(double length,double width){
        return length*width;
    }
}
