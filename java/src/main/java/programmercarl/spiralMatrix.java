package programmercarl;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Hezal
 * @Date: 2023/06/19/21:08
 * @Description:59.螺旋矩阵Ⅱ
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3 输出: [ [ 1, 2, 3 ],
 *                [ 8, 9, 4 ],
 *                [ 7, 6, 5 ] ]
 * 1  2  3  4
 * 12 13 14 5
 * 11 16 15 6
 * 10 9  8  7
 */

public class spiralMatrix {
    public int[][] generateMatrix(int n) {  // 输入3
        int[][] res = new int[n][n];
        int loop = n/2; // 确定转几圈
        int x = 0, y=0;  // 每一圈的起始位置（x,y)
        int offset = 1; // 控制每一条边的长度
        int i,j;  // j遍历横轴；i遍历纵轴
        int num=1;
        while(loop-->0) {
            // 第一条边
            for(j=y; j<n-offset; j++) { // [0,2)
                res[x][j]=num++;
            }
            // 第二条边
            for(i=x; i<n-offset; i++) {
                res[i][j]=num++;
            }
            // 第三条边
            for(;j>y; j--) {
                res[i][j]=num++;
            }
            // 第四条边
            for(;i>x;i--){
                res[i][j]=num++;
            }
            x++;
            y++;
            offset++;
        }
        if(n%2 == 1){
            res[n/2][n/2] = num;
        }
        return res;
    }
}
