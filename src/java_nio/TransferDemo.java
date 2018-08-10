package java_nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 在Java NIO中，可以非常频繁地将数据从一个通道传输到另一个通道。
 * 批量传输文件数据是非常普遍的，因为几个优化方法已经添加到FileChannel类中，使其更有效率。
 *
 * 通道之间的数据传输在FileChannel类中的两种方法是：
 * FileChannel.transferTo()方法
 * FileChannel.transferFrom()方法
 */
public class TransferDemo {
    public static void main (String [] args){
        test();
    }
    //4个不同文件读取文件内容的简单示例，并将它们的组合输出写入第五个文件：
    public static void test(){
        String input1 = "D:"+File.separator+"demo"+File.separator+"input1.txt";
        String input2 = "D:"+File.separator+"demo"+File.separator+"input2.txt";
        String input3 = "D:"+File.separator+"demo"+File.separator+"input3.txt";
        String input4 = "D:"+File.separator+"demo"+File.separator+"input4.txt";
        String output = "D:"+File.separator+"demo"+File.separator+"output.txt";

        String [] inputFile = new String []{input1,input2,input3,input4};
        String outputFile = output;

        try{
            FileOutputStream outputStream = new FileOutputStream(new File(outputFile));
            //
            WritableByteChannel targetChnall = outputStream.getChannel();
            for(int j =0;j<inputFile.length;j++){
                //Get the channel for inout files
                FileInputStream inoutStream = new FileInputStream(inputFile[j]);
                FileChannel inputChnnel = inoutStream.getChannel();
                //The data is transfer from inout channel to output channel
                inputChnnel.transferTo(0,inputChnnel.size(),targetChnall);

                //close an input channel
                inputChnnel.close();
                inoutStream.close();
            }
            //close the target channel
            targetChnall.close();
            outputStream.close();
            System.out.println("All jobs done....");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}