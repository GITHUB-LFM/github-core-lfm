package test;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lfm
 * @category 各种outofmemory程序
 * @date 2016-11-11
 **/
public class outofmemory {

	public static void main(String[] args) {

//		HeapOutOfMemory();
//		DirectMemoryOutOfMemory();
		StackOutOfMemoryStackOverFlow();
	}

	// 1、堆溢出
	public static void HeapOutOfMemory() {
		ArrayList<String> strs = new ArrayList<>(10000_0000);
		for (int i = 0; i <= 10000_0000; ++i) {
			strs.add(Integer.toString(i));
			if (i % 10000 == 0) {
				System.out.println(i);
			}
		}
	}
	// 2、堆外内存溢出
	public static void DirectMemoryOutOfMemory() {
		List<ByteBuffer> buffers = new ArrayList<>();  
        while(true){  
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 1024);  
            buffers.add(buffer);  
        }  
	}
	//3、栈溢出
	public static void  StackOutOfMemoryStackOverFlow() {
		 long time = System.currentTimeMillis();  
		 StackOutOfMemoryStackOverFlow();  
	}
	
}