package com.data.sparsearray;

/**
 * 二维数组和稀疏数组 相互转换
 * 稀疏数组可以压缩二维数组
 */
public class SparseArray {

    public static void main(String[] args) throws Exception {

        // 初始化二维数组
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[6][3] = 2;
        // 输出二维数组
        System.out.println("初始二维数组为：");
        for (int[] row : chessArray) {
            for (int data : row) {
                Thread.sleep(10);
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("初始二维数组长度为："+chessArray.length);

        // 开始转换成稀疏数组
        // 1、统计二维数组中有效的数字、共几行、共几列
        int sum = 0;
        int rows = 0;
        int culs = 0;
        for (int[] row : chessArray) {
            rows++;
            culs = row.length;
            for (int data : row) {
                if(data>0){

                    sum++;
                }
            }
        }
        System.out.println("此二维数组有效数字："+sum);

        // 2、创建稀疏数组
        int sparseArray[][] = new int[sum+1][3];
        // 定义稀疏数组的第一行
        sparseArray[0][0] = rows;
        sparseArray[0][1] = culs;
        sparseArray[0][2] = sum;

        // 3、遍历二维数组，将非0的值赋到稀疏数组中
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < culs; j++) {
                if(chessArray[i][j]>0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }

        // 输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为:");

        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t \n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);

        }


        // 将稀疏数组转为二维数组
        convertTo2(sparseArray);


    }


    private static void convertTo2(int[][] sparseArray) {
        // 初始化二维数组（初始二维数组中全部是数字0）
        int chessArray[][] = new int[sparseArray[0][0]][sparseArray[0][1]];

        // 遍历稀疏数组（从第二行开始遍历），开始赋值
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println();
        System.out.println("恢复后的二维数组为：");
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }

}
