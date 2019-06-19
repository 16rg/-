package manage.util;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




public class Util {

	
	public static String getTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return sdf.format(date.getTime());
	}

	// 上传文件/复制文件。
	public static void copyFile(File src, File dst) {
		try {
			int BUFFER_SIZE = 16 * 1024;
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE]; 
				for (int byteRead = 0; (byteRead = in.read(buffer)) > 0; ) 
				{ 
					out.write(buffer, 0, byteRead); 
				} 

			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 输出信息
	 * @param statusCode
	 * @param message
	 * @param navTabId
	 * @param rel
	 * @param forwardUrl
	 * @return
	 */
//	public static String outPutMsg(String statusCode,String message,String navTabId,String rel,String forwardUrl){
//		return "{"+MessageFormat.format("\"statusCode\":\"{0}\",\"message\":\"{1}\",\"navTabId\":\"{2}\",\"rel\":\"{3}\",\"callbackType\":\"closeCurrent\",\"forwardUrl\":\"{4}\"", statusCode,message,navTabId,rel,forwardUrl)+"}";
//	}
	
	
	/**
	 * 输出信息
	 * @param statusCode
	 * @param message
	 * @param navTabId
	 * @param rel
	 * @param forwardUrl
	 * @return
	 */
	public static String outPutMsg(String statusCode,String message,String navTabId,String rel,boolean isClose,String forwardUrl){
		String close = "";
		if(isClose){
			close = "closeCurrent";
		}
		return "{"+MessageFormat.format("\"statusCode\":\"{0}\",\"message\":\"{1}\",\"navTabId\":\"{2}\",\"rel\":\"{3}\",\"callbackType\":\"{4}\",\"forwardUrl\":\"{5}\"", statusCode,message,navTabId,rel,close,forwardUrl)+"}";
	}
}
