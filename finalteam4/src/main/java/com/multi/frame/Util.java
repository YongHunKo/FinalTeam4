package com.multi.frame;

import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static void saveFile(MultipartFile mf, String imgdir) {
		byte[] data;
		String imgname = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			FileOutputStream fo = new FileOutputStream(imgdir + imgname);
			fo.write(data);
			fo.close();
		} catch (Exception e) {

		}
		System.out.println("imgname = " + imgname);
	}
}
