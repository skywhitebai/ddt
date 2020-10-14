package com.sky.ddt.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.InternalOrderNumber;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @author baixueping
 * @description pdf工具类
 * @date 2020/7/1 11:12
 */
public class PdfUtil {
    /**
     * @param
     * @return
     * @description 导出内部单号pdf
     * @author baixueping
     * @date 2020/7/1 11:18
    */
    public static BaseResponse exportInternalOrderNumberPdf(InternalOrderNumber internalOrderNumber, HttpServletResponse response) throws Exception {
        //新建document对象10*10  大小
        //100mm=100*72/25.4=283.46456692913
        float size=283.46456692913f;
        Document document=new Document(new Rectangle(size,size),18,18,18,18);
        //新建书写器(Writer)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter pdfWriter=PdfWriter.getInstance(document,baos);
        String fileName="内部单号"+internalOrderNumber.getOrderNumber();
        document.addTitle("内部单号"+internalOrderNumber.getOrderNumber());
        document.open();
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 22, Font.NORMAL);
        Font fontPageInfo = new Font(bfChinese, 50, Font.BOLD);
        for(int i=1;i<=internalOrderNumber.getNumber();i++){

            //设置页码
            Paragraph paragraphPageInfo = new Paragraph(i+"/"+internalOrderNumber.getNumber(),fontPageInfo);
            paragraphPageInfo.setAlignment(Element.ALIGN_CENTER); //设置文字居中 0靠左   1，居中     2，靠右
            paragraphPageInfo.setPaddingTop(10);
            paragraphPageInfo.setSpacingAfter(20f); //设置段落下空白
            document.add(paragraphPageInfo);
            //设置单号
            Paragraph paragraphOrderNumber=new Paragraph("单号"+internalOrderNumber.getOrderNumber(),fontChinese);
            paragraphOrderNumber.setAlignment(Element.ALIGN_CENTER); //设置文字居中 0靠左   1，居中     2，靠右
            paragraphOrderNumber.setSpacingAfter(30f); //设置段落下空白
            document.add(paragraphOrderNumber);
            //设置条码
            PdfContentByte pdfContentByte=pdfWriter.getDirectContent();
            Barcode128 barcode128 = new Barcode128();
            //字号
            barcode128.setSize(15);
            //条码高度
            barcode128.setBarHeight(40);
            //条码与数字间距
            barcode128.setBaseline(20);
            //条码值
            barcode128.setCode(internalOrderNumber.getOrderNumber()+"-"+i);
            barcode128.setStartStopText(false);
            barcode128.setExtended(true);
            Image image=barcode128.createImageWithBarcode(pdfContentByte,null,null);
            image.setAlignment(Element.ALIGN_CENTER);
            document.add(image);
            if(i!=internalOrderNumber.getNumber()){
                document.newPage();
            }
        }
        /*Paragraph paragraph = new Paragraph("1/23");
        paragraph.setAlignment(1); //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setIndentationLeft(12); //设置左缩进
        paragraph.setIndentationRight(12); //设置右缩进
        paragraph.setFirstLineIndent(24); //设置首行缩进
        paragraph.setLeading(20f); //行间距
        paragraph.setSpacingBefore(5f); //设置段落上空白
        paragraph.setSpacingAfter(10f); //设置段落下空白*/
        document.close();
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8")+"-" + DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + ".pdf");//默认Excel名称
        response.setContentType("application/pdf");
        response.setContentLength(baos.size());
        OutputStream out = response.getOutputStream();
        //将监听输出流写到页面请求输出流中
        baos.writeTo(out);
        out.flush();
        out.close();
        return BaseResponse.success();
    }

}
