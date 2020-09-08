package kmp;

public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "1234567890";
        String str2 = "0";
        int index = violenceMatch(str1, str2);
        System.out.println("index="+index);
    }

    public static int violenceMatch(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;
        int j = 0;

        while (i < s1Len && j < s2Len){
            if (s1[i] == s2[j]){ //匹配成功
                i ++;
                j++;
            }
            else {  //匹配失败，回溯
                i = i- (j - 1);
                j = 0;
            }
        }
        //退出循环
        if (j == s2Len){
            System.out.println("i="+i);
            System.out.println("j="+j);
            return i - j;
        }else {
            return  -1;
        }
    }
}
