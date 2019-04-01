package com.sunshine.shine.Util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputTemplate {

    @Test
    public void test(){
        readFile();
    }


    public void readFile(){
        String encoding="UTF-8";
        String path="/Users/yangguang/Desktop/private.pem";
        File file=new File(path);
        if(!(file.isFile()&&file.exists())){
            System.out.println("文件不存在");
        }
        try (InputStreamReader isr=new InputStreamReader(new FileInputStream(file),encoding)){
            BufferedReader br=new BufferedReader(isr);
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
