package test1;



/**
 * @author Mr.Zhang
 * @create 2018-09-13 16:09
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] array = new int[n][2];

        int stations = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            array[i][0] = scan.nextInt();
            array[i][1] = scan.nextInt();
            stations = Math.max(stations,array[i][0]);
            stations = Math.max(stations,array[i][1]);
        }

        int max = Max(array,stations);
        System.out.println(max);
    }

    public static int Max(int[][] arrays,int stations){
        int max= 0;
        int [] stationsArray = new int [stations];//用来记录每个站被访问的次数
        for (int i = 0; i <arrays.length; i++) {
            int [] conOfStation = contion(arrays[i]);
            for (int j = 0; j < conOfStation.length; j++) {
                stationsArray[conOfStation[j]] ++;
            }
        }
        for (int i = 0; i < stations; i++) {
            max = Math.max(max,stationsArray[i]);
        }
        return max;
    }

    public static int [] contion(int [] array){
        int begin = array[0];
        int end = array[1];
        int len = end-begin;
        int [] con = new int [len];
        for (int i = 0; i < len; i++) {
            con[i] = begin++;
            //System.out.println(con[i]);
        }
        return con;
    }
}
