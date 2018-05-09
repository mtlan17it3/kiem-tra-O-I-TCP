package giuaky;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.OutputStream;

	public class bai3{
		 public static void main(String[] args) {
			 FileInputStream fis = null;
		     FileOutputStream fos = null;
		    	try {
		    		
			        File d1 = new File("D:\\thuchanh.txt");
			        fis = new FileInputStream(d1);
			        File d2 = new File("D:\\t.txt");
			        fos = new FileOutputStream(d2);
			        int data;
			        data=fis.read();
			            while (data != -1) {
			            	fos.write(data);
			            	data = fis.read(); 
			            }
		    	} catch (Exception e) {

		    	}
		    	finally {
					try {
						fis.close();
						fos.close();
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
		 }
	}
