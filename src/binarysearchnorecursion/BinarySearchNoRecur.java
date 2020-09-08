package binarysearchnorecursion;


/*
二分查找的两种方式 递归调用和非递归的实现 本质区别 就是在进行二分查找循环的时候，非递归是用的while循环
而递归这是通过if条件的判断 进行递归 从而本质上实现了二分循环查找
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
    //测试非递归实现二分查找
        int [] arr = {1,3,5,6,8,10,23};
       // int index = binarySearchNoRecursion(arr, 6);
       // System.out.println("index="+index);

       binarSearchInRecursion(arr,6);
    }
    //非递归
    public static int binarySearchNoRecursion(int [] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
           if (arr[mid] == target){
               return mid;
           }else if (arr[mid] > target){
               right = mid -1;
           }else if (arr[mid] < target){
               left = mid + 1;
           }
        }
        return  -1;
    }

    //递归调用
    private static int binarSearchInRecursion(int [] arr,int left,int right,int target){
        if (left > right){
            return -1;
        }
        int mid = (left+right) / 2;
        int midVal = arr[mid];
        if (target > midVal){
            return binarSearchInRecursion(arr,midVal+1,right,target);
        }
        else if (target < midVal){
            return binarSearchInRecursion(arr,left,mid - 1,target);
        }else {
            return  mid;
        }
    }

    //便于调用，重写binarSearchInRecursion
    public static void binarSearchInRecursion(int [] arr,int target){
        int i = binarSearchInRecursion(arr, 0, arr.length - 1, target);
        System.out.println("index= "+i);
    }
}
