/*
package com.oneler.util;

import com.alibaba.fastjson.JSONObject;
import com.aukey.wishcrawler.util.CommonUtil;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;

import static com.aukey.wishcrawler.util.CommonUtil.getKeyValue;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class LoginTest {

    public static final MediaType MEDIA_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

    @Value("${app.account.name}")
    private String account = "423340676@qq.com";

    @Value("${app.account.password}")
    private String passwd = "8711400731";

    String index = "https://www.wish.com";
    String loginUrl = "https://www.wish.com/api/email-login";
    String apiUrl = "https://www.wish.com/api/merchant";


    OkHttpClient client = new OkHttpClient.Builder()
            .cookieJar(new CookieJar() {
                private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

                @Override
                public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                    List<Cookie> existCookies = loadForRequest(url);
                    Iterator<Cookie> newIterator = existCookies.iterator();
                    Iterator<Cookie> existIterator = cookies.stream().collect(toList()).iterator();
                    while (newIterator.hasNext()) {
                        Cookie newCookie = newIterator.next();
                        while (existIterator.hasNext()) {
                            if (Objects.equals(newCookie.name(), existIterator.next().name())) {
                                existIterator.remove();
                                break;
                            }
                        }
                    }
                    existCookies.addAll(cookies);
                    cookieStore.put(url.host(), existCookies);
                }

                @Override
                public List<Cookie> loadForRequest(HttpUrl url) {
                    List<Cookie> cookies = cookieStore.get(url.host());
                    return cookies != null ? cookies : new ArrayList<>();
                }
            }).build();

    @Test
    public void testLogin() {
        try {

            */
/*index*//*

            Request.Builder indexBuilder = new Request.Builder();
            indexBuilder.url(index);

            Response indexResponse = client.newCall(indexBuilder.build()).execute();

            String tokeName = "X-XSRFToken";
            String cookie = indexResponse.headers("Set-Cookie").stream().collect(joining(";"));
            String token = getKeyValue(cookie, "=", "_xsrf");

            */
/*login*//*

            String params = CommonUtil.getParamString("email", account, "password", passwd);
            Request.Builder loginBuilder = new Request.Builder();
            RequestBody loginBody = RequestBody.create(MEDIA_TYPE, params);
            loginBuilder.url(loginUrl);
            loginBuilder.post(loginBody);
            loginBuilder.addHeader(tokeName, token);

            Response loginResponse = client.newCall(loginBuilder.build()).execute();
            String content = loginResponse.body().string();
            System.out.println(content);

            */
/*api*//*

            Request.Builder apiBuilder = new Request.Builder();
            FormBody.Builder formBuilder = new FormBody.Builder();
            formBuilder.add("start", 0 + "");
            formBuilder.add("query", "gl");
            apiBuilder.post(formBuilder.build());
            apiBuilder.url(apiUrl);
            apiBuilder.addHeader(tokeName, token);
            Response apiResponse = client.newCall(apiBuilder.build()).execute();
            String jsons = apiResponse.body().string();
            JSONObject object = JSONObject.parseObject(jsons);
            System.out.println(object.getJSONObject("data").getJSONArray("results").size());
            System.out.println(jsons);

            */
/*index*//*

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
*/
