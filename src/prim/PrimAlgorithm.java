package prim;



import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        //创建MGraph对象
        MGraph mGraph = new MGraph(verxs);
        //创建MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);
        minTree.showGraph(mGraph);

        //测试prim算法
        minTree.prim(mGraph,0);
    }
}

//最小生成树
class MinTree{
    /**
     * 创建图的邻接矩阵---输出显示
     * @param graph
     * @param verxs
     * @param data
     * @param weight
     */
    public void createGraph(MGraph graph,int verxs,char data[],int weight [][]){
        int i , j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs ; j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(MGraph graph){
        for(int[] link : graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGraph graph,int v){
        //visited[] 标记节点是否被访问
        int[] visited = new int[graph.verxs];

        //把这个节点标记为已访问
        visited[v] = 1;
        //h1,h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000; //将minWeight 初始成一个大数，后面在遍历的过程中，会被替换
        for (int k = 1; k < graph.verxs; k++) {

            //这个是确定每一次生成的子图，和哪一个节点的距离最近
            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight){
                    //替换minWeight
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边最小
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将当前这个节点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值10000
            minWeight = 10000;
        }
    }
}

class MGraph{
    int verxs;  //顶点个数
    char data[]; //图各个顶点的值
    int weight [] []; //图的邻接矩阵

    public MGraph(int verxs){
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
