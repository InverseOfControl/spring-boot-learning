package com.gaohx.web.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 文件下载
 * @see Files
 * @see Paths
 *
 */
@RestController
public class FileController {

    @GetMapping(value = "downloadFile1")
    public StreamingResponseBody downloadFile1(HttpServletResponse response) throws IOException {
        InputStream is = getInputStream(response);
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                outputStream.write(data, 0, nRead);
            }
        };
    }

    @GetMapping(value = "downloadFile2")
    public void downloadFile2(HttpServletResponse response) throws IOException {
        InputStream is = getInputStream(response);
        OutputStream os = response.getOutputStream();
        int len;
        while ((len = is.read()) != -1) {
            os.write(len);
        }
    }

    @GetMapping(value = "downloadFile3")
    public InputStreamResource downloadFile3(HttpServletResponse response) throws IOException {
        InputStream is = getInputStream(response);
        return new InputStreamResource(is);
    }

    private InputStream getInputStream(HttpServletResponse response) {
        String fileName = "aaa.txt";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        try {
            return new FileInputStream(new File("D:\\aaa.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
