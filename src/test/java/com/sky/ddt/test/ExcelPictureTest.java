package com.sky.ddt.test;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.net.URL;

/**
 * @author baixueping
 * @description todo
 * @date 2020/4/20 16:05
 */
public class ExcelPictureTest {
    public static void main(String[] args) throws Exception {

        FileOutputStream fileOut = null;

        //先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray

        String imgUrl = "https://img2.woyaogexing.com/2019/04/17/e7370782b0484237926113770074cd81!400x400.jpeg";
        URL url = new URL(imgUrl);
        //获取文件后缀名
        String suffix = imgUrl.substring(imgUrl.lastIndexOf(".") + 1);
        BufferedImage bufferImg = ImageIO.read(url);

        //以本地的方式图片、注释上面四行有效代码
        //        BufferedImage bufferImg = null;
        //        bufferImg = ImageIO.read(new File("D:/test.jpg"));

        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();


        //这里要注意formatName要缓存后缀名
        ImageIO.write(bufferImg, suffix, byteArrayOut);

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet1 = wb.createSheet("test picture");
        sheet1.setDefaultColumnWidth((short)20);
        sheet1.setDefaultRowHeight((short)2000);
        //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
        HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
        for(int i =0;i<10;i++){
            //anchor主要用于设置图片的属性
            HSSFClientAnchor anchor =
                    new HSSFClientAnchor
                            (        0, //x缩放
                                    0, // y缩放
                                    1023, //最大1023
                                    255, //最大255
                                    (short) 4,  //于下下个参数进行定位 0开始
                                    i, //在第几行
                                    (short) 4, //宽度占几格 0开始
                                    i //第几列
                            );
//          anchor.setAnchorType(3);
            //插入图片
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));

        }
        fileOut = new FileOutputStream("D:/测试Excel.xls");
        // 写入excel文件
        wb.write(fileOut);
        System.out.println("----Excel文件已生成------");
    }

}
