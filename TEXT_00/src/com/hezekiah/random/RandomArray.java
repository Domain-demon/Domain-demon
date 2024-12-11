package com.hezekiah.random;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    public static void main(String[] args) {
        //int randNumber = rand.nextInt(MAX - MIN + 1) + MIN;
        int[] array1 ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int [] array2 = new int[16];
        int[][] data = new int[4][4];


        //随机数组1  --空数组随机填入
        int[] arr1 = Rand1(array2);

        //随机数组2  --实数组随机打乱
        int[] arr2 = Rand2(array1);

        //1维 to 2维 --遍历2维
        int[][] data1 = RandData1(arr1,data);

        //1维 to 2维 --遍历1维
        int[][] data2 = RandData2(arr2,data);















        //打印2维数组
        PrintArray2(data1);
        PrintArray2(data2);
        //打印1维数组
        PrintArray1("arr1:" + Arrays.toString(arr1));
        PrintArray1("arr2:" + Arrays.toString(arr2));
    }

    public static void PrintArray1(String arr) {
        System.out.println(arr);
    }

    public static void PrintArray2(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                PrintArray1(data[i][j] + " ");
            }
            PrintArray1(" ");
        }
    }

    public static int[][] RandData2(int[] arr, int[][] data) {
        for (int i = 0; i < arr.length; i++) {
            data[i / 4][i % 4] = arr[i];
        }
        return data;
    }

    public static int[][] RandData1(int[] arr, int[][] data) {
        int k = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = arr[k];
                k++;
            }
        }
        return data;
    }

    public static int[] Rand2(int[] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            int index = r.nextInt(array.length);
            int sss = array[i];
            array[i] = array[index];
            array[index] = sss;
        }
        return array;
    }

    public static int[] Rand1(int[] array) {
        Random rand = new Random();
        for (int k = 0; k < array.length; k++) {
            array[k] = rand.nextInt(array.length - 1 + 1) + 1;
            for (int l = 0; l < k; l++) {
                if (array[k] == array[l]){
                    array[k] = rand.nextInt(array.length - 1 + 1) + 1;
                    l = -1;
                }
            }
        }
        return array;
    }
}
