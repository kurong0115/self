package parse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.GZIPInputStream;

/**
 * @ClassName ParseInfo
 * @Description 爬
 * @Author Administrator
 * @Date 2019/11/28 9:25
 * @Version 1.0
 */
public class ParseInfo {

	public static void parseByUrl(String path){
		URL url = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			url = new URL(path);
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
//			urlConnection.addRequestProperty(":authority", "blog.csdn.net");
//			urlConnection.addRequestProperty(":path", "/weixin_44574121/article/details/103276642");
//			urlConnection.addRequestProperty(":scheme", "https");
			urlConnection.addRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
			urlConnection.addRequestProperty("accept-encoding", "gzip, deflate, br");
			urlConnection.addRequestProperty("accept-language", "zh-CN,zh;q=0.9");
			urlConnection.addRequestProperty("cache-control", "max-age=0");
			urlConnection.addRequestProperty("cookie", "TINGYUN_DATA=%7B%22id%22%3A%22-sf2Cni530g%23HL5wvli0FZI%22%2C%22n%22%3A%22WebAction%2FCI%2Farticle%252Fdetails%22%2C%22tid%22%3A%22126675884bf1c72%22%2C%22q%22%3A0%2C%22a%22%3A152%7D; uuid_tt_dd=10_20056491140-1569235521531-161714; dc_session_id=10_1569235521531.324017; __yadk_uid=BdUcFVEHzYE1YNUxSZ05uSyMYjvPVPN8; smidV2=2019092916382434463f4fc73edf6ec5c4bfc9cde3f37000a0cc3758d535c50; Hm_lvt_760b8e9d3c1f7691361ec306101d237c=1571121712; __gads=Test; UserName=weixin_44574121; UserInfo=8eb163c878f444dd81a897e9e306a288; UserToken=8eb163c878f444dd81a897e9e306a288; UserNick=Matrix_%E6%9E%AF%E8%8D%A3; AU=8B7; UN=weixin_44574121; BT=1571657512488; p_uid=U000000; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=6525*1*10_20056491140-1569235521531-161714!1788*1*PC_VC!5744*1*weixin_44574121; acw_tc=2760823715722614330676620e8ecd804844ad907f5b72f9b656e94efd464c; Hm_ct_e5ef47b9f471504959267fd614d579cd=6525*1*10_20056491140-1569235521531-161714!5744*1*weixin_44574121; Hm_lvt_eb5e3324020df43e5f9be265a8beb7fd=1572856265; Hm_ct_eb5e3324020df43e5f9be265a8beb7fd=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_ct_b771b9753a47e6a3f0cc5ebdb9e7eeaf=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_lvt_4a20bfe8e339184241f52b1b2c53e116=1573124406; Hm_ct_4a20bfe8e339184241f52b1b2c53e116=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_lvt_65c9e91fa3a639df46cc94cab0f3f53f=1574306203; Hm_ct_65c9e91fa3a639df46cc94cab0f3f53f=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_lvt_e5ef47b9f471504959267fd614d579cd=1572848303,1574315239,1574751174; UM_distinctid=16eaabe0c8b26-079a87fef7e6af-6b131a7b-15f900-16eaabe0c8d28b; Hm_lvt_feacd7cde2017fd3b499802fc6a6dbb4=1574843509; Hm_ct_feacd7cde2017fd3b499802fc6a6dbb4=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; firstDie=1; Hm_lvt_b771b9753a47e6a3f0cc5ebdb9e7eeaf=1573106511,1574822672,1574900114,1574902193; acw_sc__v2=5ddf224c1ecf76221d79c9cc1e5cfb007b0959d3; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1574900119,1574901887,1574901996,1574904438; announcement=%257B%2522isLogin%2522%253Atrue%252C%2522announcementUrl%2522%253A%2522https%253A%252F%252Fblogdev.blog.csdn.net%252Farticle%252Fdetails%252F103053996%2522%252C%2522announcementCount%2522%253A0%252C%2522announcementExpire%2522%253A3600000%257D; dc_tos=q1noty; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1574905463");
			urlConnection.addRequestProperty("referer", "https://blog.csdn.net/weixin_44574121/category_9547167.html");
			urlConnection.addRequestProperty("sec-fetch-mode", "navigate");
			urlConnection.addRequestProperty("sec-fetch-site", "none");
			urlConnection.addRequestProperty("sec-fetch-user", "?1");
			urlConnection.addRequestProperty("upgrade-insecure-requests", "1");
			urlConnection.addRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.87 Safari/537.36");
			urlConnection.connect();
			String responseMessage = urlConnection.getResponseMessage();
			if (responseMessage != null && "OK".equalsIgnoreCase(responseMessage)){
				is = urlConnection.getInputStream();
				isr = new InputStreamReader(is, "gb2312");
				br = new BufferedReader(isr);
				String line = null;
				while ((line = br.readLine()) != null){
					System.out.println(line);
				}
			}
			urlConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void parseByHttpClient(String path){
//		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//		HttpGet httpGet = new HttpGet("https://blog.csdn.net/weixin_44574121/article/details/103276642");
//		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.2)");
//		httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
//		httpGet.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
//		httpGet.setHeader("accept-encoding", "gzip");
//		httpGet.setHeader("cookie", "uid_tt_dd=10_20056491140-1569235521531-161714; dc_session_id=10_1569235521531.324017; __yadk_uid=BdUcFVEHzYE1YNUxSZ05uSyMYjvPVPN8; smidV2=2019092916382434463f4fc73edf6ec5c4bfc9cde3f37000a0cc3758d535c50; Hm_lvt_760b8e9d3c1f7691361ec306101d237c=1571121712; __gads=Test; UserName=weixin_44574121; UserInfo=8eb163c878f444dd81a897e9e306a288; UserToken=8eb163c878f444dd81a897e9e306a288; UserNick=Matrix_%E6%9E%AF%E8%8D%A3; AU=8B7; UN=weixin_44574121; BT=1571657512488; p_uid=U000000; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=6525*1*10_20056491140-1569235521531-161714!1788*1*PC_VC!5744*1*weixin_44574121; Hm_ct_e5ef47b9f471504959267fd614d579cd=6525*1*10_20056491140-1569235521531-161714!5744*1*weixin_44574121; Hm_lvt_eb5e3324020df43e5f9be265a8beb7fd=1572856265; Hm_ct_eb5e3324020df43e5f9be265a8beb7fd=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_ct_b771b9753a47e6a3f0cc5ebdb9e7eeaf=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_lvt_4a20bfe8e339184241f52b1b2c53e116=1573124406; Hm_ct_4a20bfe8e339184241f52b1b2c53e116=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_lvt_65c9e91fa3a639df46cc94cab0f3f53f=1574306203; Hm_ct_65c9e91fa3a639df46cc94cab0f3f53f=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_lvt_e5ef47b9f471504959267fd614d579cd=1572848303,1574315239,1574751174; UM_distinctid=16eaabe0c8b26-079a87fef7e6af-6b131a7b-15f900-16eaabe0c8d28b; Hm_lvt_feacd7cde2017fd3b499802fc6a6dbb4=1574843509; Hm_ct_feacd7cde2017fd3b499802fc6a6dbb4=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; firstDie=1; Hm_lvt_b771b9753a47e6a3f0cc5ebdb9e7eeaf=1573106511,1574822672,1574900114,1574902193; acw_tc=2760824015749421796285187e4885c0a373da3d38627704538d064a320904; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1574939789,1574942220,1574942972,1574986891; announcement=%257B%2522isLogin%2522%253Atrue%252C%2522announcementUrl%2522%253A%2522https%253A%252F%252Fblogdev.blog.csdn.net%252Farticle%252Fdetails%252F103053996%2522%252C%2522announcementCount%2522%253A0%252C%2522announcementExpire%2522%253A3600000%257D; acw_sc__v2=5de069736251f91017217c3e2ba2c5e4b4be324b; dc_tos=q1pgom; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1574988215");
//		HttpResponse response = null;
//
//		try {
//			response = httpClient.execute(httpGet);
//			HttpEntity entity = response.getEntity();
//			System.out.println(Jsoup.parse(EntityUtils.toString(entity)));
//			if ((entity.getContentEncoding() != null)
//					&& entity.getContentEncoding().getValue().contains("gzip")) {
//				GZIPInputStream gzip = new GZIPInputStream(
//						new ByteArrayInputStream(EntityUtils.toByteArray(entity)));
//				InputStreamReader isr = new InputStreamReader(gzip);
//				BufferedReader br = new BufferedReader(isr);
//				StringBuilder sb = new StringBuilder();
//				File file = new File("d:/images/info.html");
//				if(!file.exists()){
//					file.createNewFile();
//				}
//				FileWriter writer = new FileWriter(file);
//				BufferedWriter bw = new BufferedWriter(writer);
//				PrintWriter pw = new PrintWriter(bw);
//				String temp;
//				while((temp = br.readLine()) != null){
//					sb.append(temp);
//					sb.append("\r\n");
//					pw.println(temp);
//				}
//				isr.close();
//				gzip.close();
//				System.out.println(sb.toString());
//				pw.flush();
//				pw.close();
//				bw.close();
//				writer.close();
//			}
//		} catch (Exception e) { //发生异常换IP
//
//		}
	}

	public static void main(String[] args) {
		System.out.println('b' - 'a');
		System.out.println((char)127);
	}
}
