package caozhilong.github.io.hotswap;

/**
 * �޸�class
 * @author admin
 *
 */
public class ClassModifier {

	/**
	 * Class�ļ��г����ص���ʼλ��
	 */
	private static final int CONSTANT_POOL_COUNT_INDEX = 8;
	
	/**
	 * CONSTANT_Utf8_info������tag��־
	 */
	private static final int CONSTANT_Utf8_info = 1;
	
	/**
	 * ��������11�ֱ�����ռ����,CONSTANT_Utf8_info���⣬CONSTANT_Utf8_info���Ƕ�����
	 */
	private static final int[] CONSTANT_ITEM_LENGTH = { -1, -1, 5, -1, 5, 9, 9, 3, 3, 5, 5, 5, 5};
	
	
	
	
	private static final int u1 = 1;
	
	private static final int u2 = 2;
	
	
	private byte[] classByte;
	
	
	public ClassModifier( byte[] classByte){
		this.classByte = classByte;
	}
	
	
	/**
	 * �޸ĳ�������CONSTANT_Utf8_info�е�����
	 * @param oldStr
	 * @param newStr
	 * @return �޸ĵĽ��
	 */
	public byte[] modifyUTF8Constant(String oldStr,String newStr){
		//1.��ȡ�����ĳ���
		int cpc = getConstantPoolCount();
		//2.���㵱ǰ���������ڴ��λ��
		int offset = CONSTANT_POOL_COUNT_INDEX + u2;
		//3.���㵱ǰ�ڴ��滻λ��
		for (int i = 0; i < cpc; i++) {
			int tag  = ByteUtils.bytes2Int(classByte, offset, u1);
			if(tag == CONSTANT_Utf8_info){
				int len = ByteUtils.bytes2Int(classByte, offset + u1, u2);
				offset += (u1 + u2);
				String str = ByteUtils.bytes2String(classByte, offset, len);
				if(str.equalsIgnoreCase(oldStr)){
					byte[] strBytes = ByteUtils.string2Bytes(newStr);
					byte[] strLen  = ByteUtils.int2Bytes(newStr.length(), u2);
					
					classByte = ByteUtils.bytesReplace(classByte, offset - u2, u2, strLen);
					classByte = ByteUtils.bytesReplace(classByte,offset,len,strBytes);
					return classByte;
				}
				else {
					offset += len;
				}
			}else {
				offset += CONSTANT_ITEM_LENGTH[tag];
			}
		}
		return classByte;
	}
	
	/**
	 * ��ȡ�������г���������
	 * @return ����������
	 */
	public int getConstantPoolCount(){
		return ByteUtils.bytes2Int(classByte,CONSTANT_POOL_COUNT_INDEX,u2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
