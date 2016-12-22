package com.enjoysoft.fastdfs;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test for simple FastDfs.
 */
public class FastDfsTest extends TestCase{
	 static String   conf = null;
	 static String 	file = null;
	 static {
	    	 conf = System.getProperty("user.dir")+File.separator+"resource"+File.separator+"fdfs_client.conf";
	    	 file = System.getProperty("user.dir")+File.separator+"resource"+File.separator+"file.jpg";
	 }
	 
	@Test
	public void testGetFileMate(){ 
        try { 
            ClientGlobal.init(conf);
 
            TrackerClient tracker = new TrackerClient(); 
            TrackerServer trackerServer = tracker.getConnection(); 
            StorageServer storageServer = null;
 
            StorageClient storageClient = new StorageClient(trackerServer, 
                    storageServer); 
            NameValuePair nvps [] = storageClient.get_metadata("group1", "M00/00/00/wKiJg1hZNomAQ-NRABbGSTfmliM510.jpg"); 
            for(NameValuePair nvp : nvps){ 
                System.out.println(nvp.getName() + ":" + nvp.getValue()); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
    
	@Test
    public  void testDelete(){ 
        try { 
            ClientGlobal.init(conf);
 
            TrackerClient tracker = new TrackerClient(); 
            TrackerServer trackerServer = tracker.getConnection(); 
            StorageServer storageServer = null;
 
            StorageClient storageClient = new StorageClient(trackerServer, 
                    storageServer); 
            int i = storageClient.delete_file("group1", "M00/00/00/wKiJg1hZNomAQ-NRABbGSTfmliM510.jpg"); 
            System.out.println( i==0 ? "删除成功" : "删除失败:"+i); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
	@Test
    public  void testGetFileInfo(){
    	try { 
            ClientGlobal.init(conf);
 
            TrackerClient tracker = new TrackerClient(); 
            TrackerServer trackerServer = tracker.getConnection(); 
            StorageServer storageServer = null;
 
            StorageClient storageClient = new StorageClient(trackerServer, storageServer); 
            FileInfo fi = storageClient.get_file_info("group1", "M00/00/00/wKiJg1hZNomAQ-NRABbGSTfmliM510.jpg"); 
            System.out.println(fi.getSourceIpAddr()); 
            System.out.println(fi.getFileSize()); 
            System.out.println(fi.getCreateTimestamp()); 
            System.out.println(fi.getCrc32()); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
    /**
     * 下载
     */
	@Test
    public  void testDownload(){
    	try {
    		 
            ClientGlobal.init(conf);
 
            TrackerClient tracker = new TrackerClient(); 
            TrackerServer trackerServer = tracker.getConnection(); 
            StorageServer storageServer = null;
 
            StorageClient storageClient = new StorageClient(trackerServer, storageServer); 
            byte[] b = storageClient.download_file("group1", "M00/00/00/wKiJg1hZNomAQ-NRABbGSTfmliM510.jpg"); 
            System.out.println(b); 
            IOUtils.write(b, new FileOutputStream("D:/"+UUID.randomUUID().toString()+".jpg"));
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
   
    /**
     * 下载 
     */
	@Test
    public   void getUpload(){
    	try{
    		ClientGlobal.init(conf);
    		TrackerClient tracker = new TrackerClient(); 
    		TrackerServer trackerServer = tracker.getConnection(); 
    		
    		StorageServer storageServer = null;
    		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
    		
    		NameValuePair nvp [] = new NameValuePair[]{ 
                      new NameValuePair("age", "18"), 
                      new NameValuePair("sex", "male") 
              }; 
    		 String fileIds[] = storageClient.upload_file(file, "jpg", nvp);
    		 System.out.println(fileIds.length); 
             System.out.println("组名：" + fileIds[0]); 
             System.out.println("路径: " + fileIds[1]);
    	}catch(Exception e){
    		e.printStackTrace();
    		
    	}
    }
    
}
