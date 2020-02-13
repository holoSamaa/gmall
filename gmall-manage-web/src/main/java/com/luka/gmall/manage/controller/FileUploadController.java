package com.luka.gmall.manage.controller;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author horo
 */
@RestController
@CrossOrigin
public class FileUploadController {
    @Value("${fileServer.url}")
    private String fileUrl;
    @Value("${fileServer.tracker.server}")
    private String trackerServer;
    @Value(("${fileServer.connect-timeout}"))
    private Integer connectTimeout;
    @Value("${fileServer.network-timeout}")
    private Integer netWorkTimeout;

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException, MyException {
        StringBuilder imgUrl = new StringBuilder(fileUrl);
        ClientGlobal.setG_connect_timeout(connectTimeout);
        ClientGlobal.setG_network_timeout(netWorkTimeout);
        ClientGlobal.initByTrackers(trackerServer);

        if(file != null) {
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getTrackerServer();
            StorageClient storageClient = new StorageClient(trackerServer);
            String fileName = file.getOriginalFilename();
            String extName = StringUtils.substringAfterLast(fileName, ".");
            String[] uploadFile = storageClient.upload_file(file.getBytes(), extName, null);
            for (String s : uploadFile) {
                imgUrl.append("/").append(s);
            }
        }
        return imgUrl.toString();
    }
}
