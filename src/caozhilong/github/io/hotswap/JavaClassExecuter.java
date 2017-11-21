package caozhilong.github.io.hotswap;

import java.lang.reflect.Method;



/**
 * 执行JavaClass
 * @author admin
 *
 */
public class JavaClassExecuter {

	
	/**
	 * 执行外部传入的一个代表Java类的byte数组<br/>
	 * 将输入的类的byte数组代表 java.lang.System的CONSTANT_Utf8_info常量修改为劫持的HackSystem类
	 * 使用目标类的main方法执行,输出结果使用该类的输出输入流来输出
	 * 
	 * 
	 * @param classBytes 代表一个Java类的Byte数组
	 * @return 执行结果
	 */
	public static String execute(byte[] classBytes){
		HackSystem.clearBuffer();
		ClassModifier cm = new ClassModifier(classBytes);
		
		byte[] modifyClassBytes = cm.modifyUTF8Constant("java/lang/System", "caozhilong/github/io/hotswap/HackSystem");
		
		HotSwapClassLoader classLoader = new HotSwapClassLoader();
		
		Class clazz = classLoader.loadByte(modifyClassBytes);
		
		try {
			Method method = clazz.getMethod("main", new Class[] { String[].class});
			method.invoke(null, new String[]{null});
		} catch (Throwable e) {
			e.printStackTrace(HackSystem.out);
		} 
		return HackSystem.getBufferString();
	}
	
	
	public static Method[] getMethods(byte[] classBytes){
		HackSystem.clearBuffer();
		ClassModifier cm = new ClassModifier(classBytes);
		
		byte[] modifyClassBytes = cm.modifyUTF8Constant("java/lang/System", "caozhilong/github/io/hotswap/HackSystem");
		
		HotSwapClassLoader classLoader = new HotSwapClassLoader();
		
		Class clazz = classLoader.loadByte(modifyClassBytes);
		Method[] methods  =  null;
		try {
			methods = clazz.getMethods();
			System.out.println(methods.length);
			for (Method m : methods) {
				System.out.println(m.getName());
				System.out.println(m.getParameterTypes());
			}
			return methods;
		} catch (Throwable e) {
			e.printStackTrace(HackSystem.out);
		}
		return null;
			
	}
}
