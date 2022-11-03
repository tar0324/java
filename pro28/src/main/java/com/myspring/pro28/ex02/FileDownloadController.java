package com.myspring.pro28.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileDownloadController {
	private static String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
	
	@RequestMapping("/download")
	protected void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String downFile = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		File file = new File(downFile);
		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0, lastIndex);
		String fileext = imageFileName.substring(lastIndex+1);
		System.out.println("fileext::::" + fileext);
		
		FileInputStream in = null;
		File thumbnail = new File(CURR_IMAGE_REPO_PATH + "\\" + "thumbnail" + "\\" + fileName + ".png");
		if (file.exists()) {
			if(fileext.equals("png") || fileext.equals("PNG")) {
				thumbnail.getParentFile().mkdir();
				Thumbnails.of(file).size(50, 50).outputFormat("png").toFile(thumbnail);
				
				in = new FileInputStream(thumbnail);
				byte[] buffer = new byte[1024 * 8];
				while(true) {
					int count = in.read(buffer);
					if(count == -1) {
						break;
					}
					out.write(buffer, 0 ,count);
				}
			} else { 
				response.setHeader("Cache-Control", "no-cache");
				response.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);
				in = new FileInputStream(file);
				byte[] buffer = new byte[1024 * 8];
				while (true) {
					int count = in.read(buffer);
					if (count == -1) {
						break;
					}
					out.write(buffer, 0, count);
				}
			}
			
		}

		in.close();
		out.close();
	}
}
