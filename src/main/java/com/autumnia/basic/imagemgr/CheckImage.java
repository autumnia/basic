package com.autumnia.basic.imagemgr;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CheckImage {
	// 운영	
	private static String SOURCE_FILE_NAME = "/svc/webapps/ng_api/WEB-INF/classes/data/source_data.log";
	private static String RESULT_FILE_NAME = "/svc/webapps/ng_api/WEB-INF/classes/logs/" ;

	// 개발 
	//private static String SOURCE_FILE_NAME = "./src/work/moveimages/logs/source_data.log";
	//private static String RESULT_FILE_NAME = "./src/work/moveimages/logs/" ;
	
	
	protected static String getDate(String dateFormat) throws Exception
	{
		Calendar calendar = Calendar.getInstance( Locale.KOREAN );
		TimeZone timezone = calendar.getTimeZone();
		timezone = TimeZone.getTimeZone("Asia/Seoul");
		calendar = Calendar.getInstance(timezone);
	
		java.util.Date date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat( dateFormat, Locale.KOREAN );
		sdf.setTimeZone( timezone );
	
		return sdf.format(date);
	}		
	
	protected static void writeLog(String path, String msg)
	{
		if ( null == msg ) return ;

		RandomAccessFile raf = null;
		FileOutputStream fos = null;
		try
		{
			String today 	= getDate("yyyy-MM-dd"); 
			String curtime 	= getDate("HH:mm:ss"); 
	
			//raf = new RandomAccessFile(path, "rw");
			raf = new RandomAccessFile(path + today + ".log", "rw");
			raf.seek(raf.length());
	
			fos = new FileOutputStream(raf.getFD());
	
			String line = msg + "\r\n";
			//String line = "[" + curtime + "] " + msg + "\r\n";
	
			fos.write( line.getBytes() );
		}
		catch (Exception e) {
			System.out.println( "writeLog Error: " + e.getMessage() );
		}
		finally {
			try { if ( fos != null ) fos.close(); } catch (Exception e ) {	System.out.println( e.getMessage() ); }
			try { if ( raf != null ) raf.close(); } catch (Exception e ) {	System.out.println( e.getMessage() ); }
		}
	}	
	
	public static void readFile(String path) throws Exception
	{
       	BufferedReader in = new BufferedReader(new FileReader(path));
		String line = "";
		String targetFileName = "";
		while(true) {					
			line = in.readLine().trim();
			if(line != null) {
				//System.out.println("line: " +  line );
				//System.out.println("line: " +  line.substring( line.lastIndexOf("/")+1, line.length() )  );
				//targetFileName = line.substring( line.lastIndexOf("/")+1, line.length() );
				//moveFile( line, TARGET_PATH + targetFileName ) ;
				
				//System.out.println( line ) ;
				deleteFile( line ) ;
				
				targetFileName = "";
			} 
			else {
				break;
			}
		}
		in.close();
	}	
	
	public static void deleteFile(String filename ) 
	{
		File file= null;
		try {
			file = new File( filename );
	
			if( file.exists() ) {
				//file.delete();
				writeLog( RESULT_FILE_NAME + "success_", filename );
			}
			else {
				writeLog( RESULT_FILE_NAME + "notfound_", filename );
			} 
		}
		catch (Exception e ) {
			System.out.println( e.getMessage() );
			//writeLog( RESULT_FILE_NAME + "error_" +  filename );
		}
		finally {
			file = null;
		}
	}
	
	
	public static void moveFile(String sourcePath, String targetPath) 
	{
		File fileToMove = null;
		File targetFile = null;
		try {
	    	fileToMove = new File(sourcePath);
	    	targetFile = new File(targetPath) ;

	    	if ( fileToMove.exists() ) {
    			writeLog( RESULT_FILE_NAME, sourcePath  );
	    	}    		

	    	//if ( targetFile.exists() ) {
	   		//	fileToMove.renameTo(new File(targetPath));
    		//	writeLog( ERROR_FILE_NAME, sourcePath  );
	    	//}
    		
    		//System.out.println( ERROR_FILE_NAME );
	        //System.out.println( sourcePath );
	    } 
	    catch (Exception e) {
	        //System.out.println( sourcePath );
	        //System.out.println( targetPath );
	        writeLog( RESULT_FILE_NAME, sourcePath  );
	    }
	    finally {
	    	fileToMove = null;
	    	targetFile = null;
	    }
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try {
			System.out.println( "작업시작" ) ;
			
			readFile(  SOURCE_FILE_NAME ) ;
		}
		catch (Exception e ) {
			System.out.println( e.getMessage() ) ;
		}
		finally {
			System.out.println( "작업완료" ) ;
		}
		
	}
}
