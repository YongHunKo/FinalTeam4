package com.multi.frame;

import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static void saveFile(MultipartFile mf, String adminstore, String custstore) {
		byte [] data;
		String storeimg = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			FileOutputStream fo = 
					new FileOutputStream(adminstore+storeimg);
			fo.write(data);
			fo.close();
			FileOutputStream fo2 = 
					new FileOutputStream(custstore+storeimg);
			fo2.write(data);
			fo2.close();
		}catch(Exception e) {
			
		}
		
	}
	
}




