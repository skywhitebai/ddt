package com.sky.ddt.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author baixueping
 * @description 下载加压文件
 * @date 2020/12/15 17:52
 */
public class ZipUtil {
    /**
     * 根据文件，进行压缩，批量下载
     *
     * @param response
     * @param files
     * @throws Exception
     */
    public static void downloadBatchByFile(HttpServletResponse response, Map<String, byte[]> files, String zipName) {
        try {
            response.setContentType("application/x-msdownload");
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(zipName, "utf-8")+DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + ".zip");

            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
            BufferedOutputStream bos = new BufferedOutputStream(zos);

            for (Map.Entry<String, byte[]> entry : files.entrySet()) {
                //每个zip文件名
                String fileName = entry.getKey();
                if(StringUtils.isEmpty(fileName)){
                    fileName="null";
                }
                //这个zip文件的字节
                byte[] file = entry.getValue();

                BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(file));
                zos.putNextEntry(new ZipEntry(fileName));

                int len = 0;
                byte[] buf = new byte[10 * 1024];
                while ((len = bis.read(buf, 0, buf.length)) != -1) {
                    bos.write(buf, 0, len);
                }
                bis.close();
                bos.flush();
            }
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
