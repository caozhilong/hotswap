package caozhilong.github.io.hotswap;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


/**
 * 为JavaClass 劫持 java.lang.System
 * 除了out和err外，其余方法都转发给java.lang.System处理
 * @author czl
 *
 */
public class HackSystem {
	
	private final static InputStream in = System.in;
	
	
	private static ByteArrayOutputStream buffer  = new ByteArrayOutputStream();
	
	
	public final static PrintStream out = new PrintStream(buffer);
	
	public final static PrintStream err = out;
	
	
	public static String getBufferString(){
		return buffer.toString();
	}
	
	public static void clearBuffer(){
		buffer.reset();
	}
	
	
	public static void setSecurityManager(final SecurityManager s){
		System.setSecurityManager(s);
	}
	
	public static SecurityManager getSecurityManager(){
		return System.getSecurityManager();
	}
	
	public static long  currentTimeMillis(){
		return System.currentTimeMillis();
	}
	
	
    public static  void arraycopy(Object src,  int  srcPos,
            Object dest, int destPos,
            int length){
    	System.arraycopy(src, srcPos, dest, destPos, length);
    }
    
    
    public static void identityHashCode(Object x){
    	System.identityHashCode(x);
    }
    
    
	
	
}
