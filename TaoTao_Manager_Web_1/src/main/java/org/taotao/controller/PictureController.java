package org.taotao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.taotao.common.pojo.PictureResult;
import org.taotao.common.utils.FastDFSClient;

/**
 * <p>Title: PictureController</p>
 * <p>Description: 图片上传</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月17日
 * @version 1.0
 */
@Controller
public class PictureController {
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
//1.0上传图片的方法
	@RequestMapping("/pic/upload")
	
	public  @ResponseBody  PictureResult upLoadFile(MultipartFile uploadFile){
//	1.1初始化一个参数
		PictureResult pictureResult=new  PictureResult();
//	1.2利用上传工具进行上传
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:fastdfs/client.conf");
//			1.2.1获取图片的扩展名
			String oldName=uploadFile.getOriginalFilename();
			String extName=oldName.substring(oldName.lastIndexOf(".")+1);
//			1.2.2进行上传图片,返回一个url路径也就是在图片服务其中的路径
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(),extName);
//			1.2.3拼接处服务访问服务器的url
			url=IMAGE_SERVER_URL+url;
			System.out.println(url);
//	1.3向PictureResult中设值
			pictureResult.setUrl(url);
			pictureResult.setError(0);
		} catch (Exception e) {
			e.printStackTrace();
			pictureResult.setError(1);
			pictureResult.setMessage("上传失败");
		}
		
		return pictureResult;
	
	}
	
	
	
}
