package caozhilong.github.io.hotswap.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import caozhilong.github.io.hotswap.JavaClassExecuter;

/**
 * ����JAVA���붯̬����
 * @author admin
 *
 */
public class TestJavaClassExecuter {

	public static void main(String[] args) throws IOException {
//		 InputStream is  = new FileInputStream("D:/test/Test.class");
		//C:\Users\admin\Workspaces\MyEclipse 8.5\HotSwp\test
		InputStream is  = new FileInputStream("C:/Users/admin/Workspaces/MyEclipse 8.5/HotSwp/test/Test.class");
		byte[] b = new byte[is.available()];
		 
		is.read(b);
		is.close();
		
		
		System.out.println("��ǰ��ִ�н��Ϊ:  ");
		System.out.println(JavaClassExecuter.execute(b));//ִ��main����
		
//		System.out.println(JavaClassExecuter.execute(b,"toString",new String[]{null}));//ִ��aaa
		
		System.out.println(JavaClassExecuter.getMethods(b));//ִ��main����
		
		
	}
	
	
	
}
