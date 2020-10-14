package com.sky.ddt.test;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * @author baixueping
 * @description 换成2013不行了
 * @date 2020/4/20 16:05
 */
public class ExcelPictureXSSFTest {
    public static void main(String[] args) throws Exception {

        FileOutputStream fileOut = null;

        //先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray

        String imgUrl = "https://ddt-file.oss-cn-beijing.aliyuncs.com/sku_pic/1582096213972.jpg?x-oss-process=image/resize,m_fill,h_66,w_66";
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

        XSSFWorkbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("abc");
        //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
        Drawing patriarch = sheet.createDrawingPatriarch();
        for(int i =0;i<10;i++){
            Row row = sheet.createRow(i);
            row.setHeight((short) 1000);
            //i是行号，就是列号
            setExcelImg(book, patriarch, i, 4, url);

        }
        fileOut = new FileOutputStream("D:/测试Excel4.xlsx");
        // 写入excel文件
        book.write(fileOut);
        System.out.println("----Excel文件已生成------");
    }
    /**
     * 导出写图片
     */
    private static void setExcelImg(XSSFWorkbook wb,
                                    Drawing patriarch, int rowIndex, int cloumIndex, URL url) {
        // （jdk1.7版本try中定义流可自动关闭）
        try (InputStream is = url.openStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream();) {
            byte[] buff = new byte[1024];
            int rc = 0;
            while ((rc = is.read(buff, 0, 1024)) > 0) {
                outputStream.write(buff, 0, rc);
            }
            // 设置图片位置
            XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 1000, 1000,
                    cloumIndex, rowIndex, cloumIndex + 1, rowIndex + 1);
            anchor.setAnchorType(0);
            Picture pict=patriarch.createPicture(anchor, wb.addPicture(
                    outputStream.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
            //pict.resize();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
