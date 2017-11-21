package caozhilong.github.io.hotswap;

import java.lang.reflect.Method;



/**
 * ִ��JavaClass
 * @author admin
 *
 */
public class JavaClassExecuter {

	
	/**
	 * ִ���ⲿ�����һ������Java���byte����<br/>
	 * ����������byte������� java.lang.System��CONSTANT_Utf8_info�����޸�Ϊ�ٳֵ�HackSystem��
	 * ʹ��Ŀ�����main����ִ��,������ʹ�ø������������������
	 * 
	 * 
	 * @param classBytes ����һ��Java���Byte����
	 * @return ִ�н��
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
