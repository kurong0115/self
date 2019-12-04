package test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreTest
 * @Description 信号量测试
 * @Author Administrator
 * @Date 2019/11/25 15:46
 * @Version 1.0
 */
public class SemaphoreTest {

	static Semaphore semaphore = new Semaphore(5, true);

	static final int MAX = 8;

	public static void main(String[] args) {
		for (int i = 0; i < MAX; i++){
			new Thread(()->{
				System.out.println(Thread.currentThread().getName() + "正在使用机器");
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + "使用完机器");
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}

	}
}
