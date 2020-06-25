package com.billkang;


import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.billkang.utils.SleepUtils;

/**
 * @author kangbin
 * @date 2020/4/12.∂
 */
public class CsdnCraw {
    private static RestTemplate restTemplate = new RestTemplate();
    private static int count = 1;

    public static void main(String[] args) {


        String urlList = "https://blog.csdn.net/kangbin825/article/list/{pageNum}?t=1";

        List<Elements> list = new ArrayList();

        for (int i = 1; i <= 9; i++) {
            String url = urlList.replace("{pageNum}", i + "");
            HttpHeaders requestHeaders = buildHttpHeaders();
            HttpEntity<String> requestEntity = new HttpEntity(null, requestHeaders);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
            String htmlStr = response.getBody();

            Elements elements = Jsoup.parse(htmlStr).select("div[class=article-item-box csdn-tracking-statistics]");
            list.add(elements);
        }

        //        String urlList = "https://blog.csdn.net/kangbin825";


        if (!CollectionUtils.isEmpty(list)) {

            while (true) {
                for (Elements elements : list) {
                    for (Element e : elements) {

                        String detailUrl = e.select("a").get(0).attr("href");
                        viewDetail(detailUrl);


                    }
                }
            }
        }

    }

    private static void viewDetail(String detailUrl) {
        try {
            HttpHeaders requestHeaders = buildHttpHeaders();
            HttpEntity<String> requestEntity = new HttpEntity(null, requestHeaders);

            String id = detailUrl.split("details/")[1];
            String uvcUrl = "https://blog.csdn.net/kangbin825/article/uvc/" + id;

            ResponseEntity<String> response =
                    restTemplate.exchange(detailUrl, HttpMethod.GET, requestEntity, String.class);
            ResponseEntity<String> response2 =
                    restTemplate.exchange(uvcUrl, HttpMethod.GET, requestEntity, String.class);

            Long start = System.currentTimeMillis();
            SleepUtils.sleep(1500, 2000);
            System.out.println((count++) + ", " + (System.currentTimeMillis() - start) + ", success:" + detailUrl);
        } catch (Exception e) {
            e.printStackTrace();
            SleepUtils.sleep(3000, 30000);
        }
    }

    private static HttpHeaders buildHttpHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.add("authority", "blog.csdn.net");
        requestHeaders.add("method", "GET");
        requestHeaders.add("path", "/kangbin825");
        requestHeaders.add("scheme", "https");
        requestHeaders.add("accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,"
                        + "application/signed-exchange;v=b3;q=0.9");


        requestHeaders.add("accept-language", "en,zh-CN;q=0.9,zh;q=0.8");
        requestHeaders.add("referer", "https://www.csdn.net/");
        requestHeaders.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987"
                        + ".163 Safari/537.36");
        requestHeaders.add("Cookie",
                "uuid_tt_dd=10_37293762740-1544778441811-813451; UN=kangbin825; "
                        + "smidV2=20181215111016d7af19f7c56514fe7e0fea546d736a6e006b5e48581572710; "
                        + "Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=5744*1*kangbin825!1788*1*PC_VC!6525*1"
                        + "*10_37293762740-1544778441811-813451; dc_session_id=10_1561779283742.404625; "
                        + "Hm_lvt_4a20bfe8e339184241f52b1b2c53e116=1569662342; "
                        + "Hm_ct_4a20bfe8e339184241f52b1b2c53e116=6525*1*10_37293762740-1544778441811-813451; "
                        + "Hm_ct_e5ef47b9f471504959267fd614d579cd=6525*1*10_37293762740-1544778441811-813451!5744*1"
                        + "*kangbin825; cache_cart_num=0; Hm_lvt_b295236c27378576a28657637636c01a=1577340162; "
                        + "Hm_ct_b295236c27378576a28657637636c01a=6525*1*10_37293762740-1544778441811-813451; "
                        + "__yadk_uid=H3VIP10lDozOjwdz9iY46PwEjebaH64N; "
                        + "Hm_ct_68822ecd314ca264253e255a3262d149=5744*1*kangbin825!6525*1*10_37293762740"
                        + "-1544778441811-813451; UserName=kangbin825; UserInfo=37637721dc8e4f64b729dcf8e1b4e2c3; "
                        + "UserToken=37637721dc8e4f64b729dcf8e1b4e2c3; UserNick=kangbin825; AU=354; BT=1585387794122;"
                        + " p_uid=U000000; UM_distinctid=17120cefa47f3-0264f78a49cabd-f313f6d-100200-17120cefa48283; "
                        + "Hm_ct_146e5663e755281a5bbe1f3f1c477685=6525*1*10_37293762740-1544778441811-813451!5744*1"
                        + "*kangbin825; Hm_ct_244847735f7f8703ad1bce2e52d1f032=5744*1*kangbin825!6525*1"
                        + "*10_37293762740-1544778441811-813451; "
                        + "Hm_ct_f77cd53694362ac491d92c9dd0458d88=5744*1*kangbin825!6525*1*10_37293762740"
                        + "-1544778441811-813451; Hm_lvt_f77cd53694362ac491d92c9dd0458d88=1586216965,1586217593,"
                        + "1586271986; Hm_lvt_244847735f7f8703ad1bce2e52d1f032=1586351360,1586442446,1586594146,"
                        + "1586594213; Hm_lvt_146e5663e755281a5bbe1f3f1c477685=1586505155,1586574220,1586593163,"
                        + "1586594740; Hm_ct_5c2049f0420b71ee20ff0f2896670ca2=5744*1*kangbin825!6525*1*10_37293762740"
                        + "-1544778441811-813451; Hm_lvt_68822ecd314ca264253e255a3262d149=1586591413,1586591491,"
                        + "1586594655,1586598401; Hm_lvt_5c2049f0420b71ee20ff0f2896670ca2=1586595198,1586607140; "
                        + "Hm_lvt_62052699443da77047734994abbaed1b=1586617958; "
                        + "Hm_ct_62052699443da77047734994abbaed1b=5744*1*kangbin825!6525*1*10_37293762740"
                        + "-1544778441811-813451; dc_sid=2a10a4ca5aeee7e67db9226bba996cc7; "
                        + "TY_SESSION_ID=973f5184-c18b-4d76-a620-a10293a75d80; "
                        + "searchHistoryArray=%255B%2522%25E5%258A%25A8%25E6%2580%2581%25E8%25A7%2584%25E5%2588%2592"
                        + "%2522%252C%2522csdn%25E5%258D%259A%25E5%25AE%25A2%25E4%25B8%2593%25E5%25AE%25B6%2522%252C"
                        + "%2522%25E6%25AD%25BB%25E4%25B8%258D%25E4%25BA%2586%25E5%25B0%25B1%25E8%25BF%2598%25E5%25A5"
                        + "%25BD%25E3%2580%2581%2522%255D; "
                        + "announcement=%257B%2522isLogin%2522%253Atrue%252C%2522announcementUrl%2522%253A%2522https"
                        + "%253A%252F%252Fblog.csdn.net%252Fblogdevteam%252Farticle%252Fdetails%252F105203745%2522"
                        + "%252C%2522announcementCount%2522%253A0%252C%2522announcementExpire%2522%253A3600000%257D; "
                        + "c_adb=1; utm_source=distribute.pc_feed.none-task-blog-alirecmd-1; c_ref=https%3A//www"
                        + ".baidu.com/link%3Furl%3DUJlSs92OrFHHFYmOiGE"
                        + "-4zk4cjQZuTzcmB0mhl15xFI_spFWZmq4k6TiuwwJbt6Ntfvwo980RwJmsmeP7vtI_K%26wd%3D%26eqid"
                        + "%3De39f3d0d00001417000000035e92d2b4; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1586661962,"
                        + "1586663665,1586664093,1586680490; Hm_lvt_e5ef47b9f471504959267fd614d579cd=1586680546; "
                        + "Hm_lpvt_e5ef47b9f471504959267fd614d579cd=1586680546; dc_tos=q8o2li; "
                        + "Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1586680616");
        return requestHeaders;
    }
}