package java_nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class ScatterGatherIO {

    public static void main(String[] args){
        String data = "显示散点和聚集示例";

        gatherBytes(data);
        scatterBytes();
    }

    /**
     * gatherBytes() is used for reading the bytes from the buffers and write it
     * to a file channel
     * @param data
     */
    public static void gatherBytes(String data){
        String path = "D:"+File.separator+"demo"+File.separator+"text2.txt";
        //the First Buffer is used for holding a random number
        ByteBuffer buffer1 = ByteBuffer.allocate(8);
        //The Second Buffer is used for holding a data that want to write
        ByteBuffer buffer2 = ByteBuffer.allocate(400);
        //创建此字节缓冲区的视图，作为 int 缓冲区。
        buffer1.asIntBuffer().put(420);
        buffer2.asCharBuffer().put(data);
        GatheringByteChannel gather  = createChannelInstance(path,true);

        //Write the data to file
        try{
            gather.write(new ByteBuffer[]{buffer1,buffer2});
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //scatterBytes() is used for reading thr bytes from a file channel into a set of buffers
    public static void scatterBytes(){
        String path = "D:"+File.separator+"demo"+File.separator+"text2.txt";
        //the First Buffer is used for holding a random number
        ByteBuffer buffer1 = ByteBuffer.allocate(8);
        //The Second Buffer is used for holding a data that want to write
        ByteBuffer buffer2 = ByteBuffer.allocate(400);

        ScatteringByteChannel scatter = createChannelInstance(path,false);
        //Reading a data from the cahnnel
        try{
            scatter.read(new ByteBuffer[]{buffer1,buffer2});
        }catch (Exception e){
            e.printStackTrace();
        }

        //分别读取两个缓冲区
        buffer1.rewind();
        buffer2.rewind();
        int bufferOne = buffer1.asIntBuffer().get();
        String bufferTwo = buffer2.asCharBuffer().toString();
        // Verification of content
        //验证内容
        System.out.println(bufferOne);
        System.out.println(bufferTwo);

    }


    public  static FileChannel createChannelInstance(String file,boolean isOutput){
        FileChannel FChannel = null;
        try{
            if(isOutput){
                FChannel = new FileOutputStream(file).getChannel();
            }else {
                FChannel = new FileInputStream(file).getChannel();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return  FChannel;
    }
}
