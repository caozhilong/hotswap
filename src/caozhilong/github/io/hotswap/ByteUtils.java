package caozhilong.github.io.hotswap;


/**
 * byte 数组处理工具
 * @author admin
 *
 */
public class ByteUtils {

	/**
	 * 字节码转成int
	 * @param classByte 字节码
	 * @param constantPoolCountIndex 常量的索引
	 * @param u2 常量的长度
	 * @return 转换后的值
	 */
	public static int bytes2Int(byte[] b, int start,
			int len) {
		int sum  = 0;
		int end = start + len;
		for (int i = start; i < end; i++) {
			int n = (b[i]) & 0xff;
			n <<= (--len) * 8;
			sum = n + sum;
		}
		
		return sum;
	}

	
	
	public static byte[] int2Bytes(int value,int len){
		byte[] b = new byte[len];
		for (int i = 0; i < len; i++) {
			b[len - i - 1] = (byte)((value >> 8 * i) & 0xff);
		}
		
		return b;
	}
	
	
	public static String bytes2String(byte[] b,int start,int len){
		return new String(b,start,len);
	}
	
	
	public static byte[] string2Bytes(String str){
		return str.getBytes();
	}
	
	
	public static byte[] bytesReplace(byte[] originalBytes,int offset ,int len, byte[] repalceBytes){
		
		byte[]  newBytes = new byte[originalBytes.length + (repalceBytes.length - len)];//x
		System.arraycopy(originalBytes, 0, newBytes, 0, offset);//x
		System.arraycopy(repalceBytes, 0, newBytes, offset, repalceBytes.length);//x
/*		
		System.out.println(originalBytes.length);
		System.out.println(offset + len);
		System.out.println(newBytes.length);
		System.out.println( offset + repalceBytes.length);
		System.out.println( repalceBytes.length - offset -len);*/
		System.arraycopy(originalBytes,offset + len, newBytes, offset + repalceBytes.length, originalBytes.length - offset -len);
		return newBytes;
	}
	
	
	
/*    public static byte[] bytesReplace(byte[] originalBytes, int offset, int len, byte[] replaceBytes) {
        byte[] newBytes = new byte[originalBytes.length + (replaceBytes.length - len)];
        System.arraycopy(originalBytes, 0, newBytes, 0, offset);
        System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
        System.arraycopy(originalBytes, offset + len, newBytes, offset + replaceBytes.length, originalBytes.length - offset - len);
        return newBytes;
    }*/
}
