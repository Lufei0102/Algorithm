package test;
/*
梯形
 */
public class Trapezoid {
    private double upperBottom; //上底
    private double lowBottom; //下底
    private double height; //高


    public double getUpperBottom() {
        return upperBottom;
    }

    public void setUpperBottom(double upperBottom) {
        this.upperBottom = upperBottom;
    }

    public double getLowBottom() {
        return lowBottom;
    }

    public void setLowBottom(double lowBottom) {
        this.lowBottom = lowBottom;
    }

    public double getHeigh() {
        return height;
    }

    public void setHeigh(double heigh) {
        this.height = heigh;
    }

    @Override
    public String toString() {
        return "Trapezoid{" +
                "upperBottom=" + upperBottom +
                ", lowBottom=" + lowBottom +
                ", height=" + height +
                '}';
    }

    //求面积
    public double getTrapezoidArea(double upperBottom,double lowBottom,double height){
        return (upperBottom+lowBottom)*height/2;
    }


    //测试
    public static void main(String[] args) {
        Trapezoid trapezoid = new Trapezoid();
        double trapezoidArea = trapezoid.getTrapezoidArea(3, 2, 3);
        System.out.println("面积"+trapezoidArea);
    }
}
