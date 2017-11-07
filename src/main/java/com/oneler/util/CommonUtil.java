/*
package com.oneler.util;

import okhttp3.FormBody;
import okhttp3.Request;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

*/
/**
 * Created by guanyuan on 2017/4/12 16:32.
 * aukey_wish_crawler.
 *//*

public final class CommonUtil {

    */
/**
     * 将返回精度为 天
     *
     * @param date 时间
     * @return date
     *//*

    public static Date getDate(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTime();
    }

    */
/**
     * 计算日期差
     *
     * @param from 开始
     * @param to   结束
     * @return to - from
     *//*

    public static int dateDiff(Calendar from, Calendar to) {
        return (int) ((to.getTimeInMillis() - from.getTimeInMillis()) / 86400000);
    }

    */
/**
     * 计算日期差
     *
     * @param from 开始
     * @param to   结束
     * @return to - from
     *//*

    public static int dateDiff(Date from, Date to) {
        return (int) ((to.getTime() - from.getTime()) / 86400000);
    }

    */
/**
     * 计算日期差
     *
     * @param from 开始
     * @param to   结束
     * @return to - from
     *//*

    public static float dateDiffByHour(Date from, Date to) {
        return (to.getTime() - from.getTime()) / 3600000;
    }

    public static Date increaseDate(Date date, int day) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.DATE, day);
        return instance.getTime();
    }

    public static Map<String, String> parseKVFromUrl(String params) {
        String[] pairs = params.split("&");
        Map<String, String> map = new HashMap<>();
        Stream.of(pairs).forEach(pair -> {
            String key = "", value = "";
            String[] kv = pair.split("=");
            if (kv.length > 0)
                key = kv[0];
            if (kv.length > 1)
                value = kv[1];
            map.put(key, value);
        });
        return map;
    }

    public static String buildParamsString(Map<String, String> map) {
        return map.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&"));
    }

    public static String parseValueFromUrl(String params, String key) {
        return parseKVFromUrl(params).get(key);
    }

    */
/**
     * 分隔数组
     *
     * @param list
     * @param limit
     * @param <T>
     * @return
     *//*

    public static <T> List<List<T>> splitList(List<T> list, int limit) {
        int size = list.size();
        int from = 0;
        int to;
        List<List<T>> lists = new ArrayList<>();
        do {
            to = from + limit > size ? size : from + limit;
            lists.add(list.subList(from, to));
            from += limit;
        } while (to < size);
        return lists;
    }

    */
/**
     * @param args k1,v1,k2,v3
     * @return
     *//*

    public static String getParamString(String... args) {
        Iterator<String> iterator = Arrays.asList(args).iterator();
        List<String> pairs = new ArrayList<>();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = iterator.next();
            pairs.add(key + "=" + value);
        }
        return pairs.stream().collect(Collectors.joining("&"));
    }

    public static String getKeyValue(String from, String separator, String key) {
        String reg = key + separator + "([0-9a-zA-Z_.|]*)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(from);
        if (matcher.find())
            return matcher.group(1);
        else return null;
    }

    public static String getRequestParamValue(Request request, String key) {
        FormBody formBody = (FormBody) (request.body());
        String value = null;
        for (int j = 0; j < formBody.size(); j++) {
            if (formBody.name(j).equals(key)) {
                value = formBody.value(j);
                break;
            }
        }
        return value;
    }

    public static String getRequestParamValue(Request request, String... keys) {
        String value = null;
        for (String key : keys) {
            value = getRequestParamValue(request, key);
            if (value != null)
                break;
        }
        return value;
    }

    public static void main(String[] args) {
        String from = "count=25&offset=0&request_id=tag_54ac6e18f8a0b3724c6c473f";
    }

    public static boolean containsEmpty(String... args) {
        for (String s : args) {
            if (s == null || s.trim().length() == 0)
                return true;
        }
        return false;
    }

    public static String readResourceFile(String fileName) {
        try {
            String path = CommonUtil.class.getClassLoader().getResource(fileName).getFile();
            return readFileContent(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readFileContent(String fileName) throws IOException {
        File file = new File(fileName);

        BufferedReader bf = new BufferedReader(new FileReader(file));

        String content = "";
        StringBuilder sb = new StringBuilder();

        while (content != null) {
            content = bf.readLine();

            if (content == null) {
                break;
            }

            sb.append(content.trim() + "\n");
        }

        bf.close();
        return sb.toString();
    }

    public static String removeSpecialChar(String str) {
        try {
            return str.replaceAll("[_#~@]", "");
        } catch (NullPointerException e) {
            return null;
        }
    }

}
*/
