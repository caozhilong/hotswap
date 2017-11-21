package caozhilong.github.io.hotswap.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import caozhilong.github.io.hotswap.JavaClassExecuter;

/**
 * 测试JAVA代码动态编译
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
		
		
		System.out.println("当前的执行结果为:  ");
		System.out.println(JavaClassExecuter.execute(b));//执行main方法
		
//		System.out.println(JavaClassExecuter.execute(b,"toString",new String[]{null}));//执行aaa
		
		System.out.println(JavaClassExecuter.getMethods(b));//执行main方法
		
		
	}
	
	
	
}
