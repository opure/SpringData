package com.oneler.domain;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by opure on 2017/4/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewTest {

    @Test
    public void test() {
        DataSource dataSource = new DataSource();
        dataSource.setUsername("reader");
        dataSource.setUrl("jdbc:mysql://10.1.1.200:3306/fba_stock?useUnicode=true&characterEncoding=utf8&useSSL=true&allowMultiQueries=true");
        dataSource.setPassword("read@2016");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Map<String, Integer> map = new HashMap<>();

        String countSQL = "SELECT\n" +
                "\tCOUNT(*)\n" +
                "FROM\n" +
                "\t`fba_stock`.`customer_shipment_sales`\n" +
                "WHERE\n" +
                "\t`area` = '%s'\n" +
                "AND account_name = '%s'\n" +
                "AND shipment_date > '2017-03-01 00:00:00'\n" +
                "AND shipment_date < '2017-04-01 23:59:59'";

        BufferedReader br = null;
        int counts = 0;
        try {
            br = new BufferedReader(new FileReader("F:\\SpringData\\var\\doc\\newfba.txt"));
            String temp = null;
            temp = br.readLine();
            while (temp != null) {
                counts++;
                Integer count = jdbcTemplate.queryForObject(String.format(countSQL, temp.split("\\t")[1], temp.split("\\t")[0]), Integer.class, new Object[]{});
                if (!count.equals(0))
                    map.put(temp.split("\\t")[2], count);
                temp = br.readLine();
            }
        } catch (Exception e) {
        }
        System.out.println("start"+map.size());
        Map<String,Integer> mapss = new HashMap<>();
        map.forEach((k, v) -> {
            try {
                String path = "C:\\Users\\opure\\Desktop\\新建文件夹 (2)\\"+k.toUpperCase();
                List<String> str = new ArrayList<>();
                File file = new File(path);
                if(file.exists()) {
                    BufferedReader brs = new BufferedReader(new FileReader(path));
                    String temp = null;
                    int count = 0;
                    try {
                        temp = brs.readLine();
                        while (temp != null) {
                            count ++;
                            temp = brs.readLine();
                        }
                        if(count<v) {
                            mapss.put(k,count);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        System.out.println("end"+mapss.size());
        mapss.forEach((k,v)->{
            System.out.println(k+""+v);
        });
    }

    public void test2() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\opure\\Desktop\\新建文件夹 (2)\\"));
        int longest = br.lines().
                mapToInt(String::length).
                max().
                getAsInt();
        br.close();
        System.out.println(longest);
    }

    @Test
    public void getFileName() {
        String path = "C:\\Users\\opure\\Desktop\\新建文件夹 (2)"; // 路径
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }
        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [目录]");
            } else {
                System.out.println(fs.getName());
                File file = new File("C:\\Users\\opure\\Desktop\\新建文件夹 (2)\\"+fs.getName());
                file.renameTo(new File("C:\\Users\\opure\\Desktop\\新建文件夹 (2)\\" + fs.getName().substring(0, fs.getName().length() - 7).toUpperCase()));
            }
        }
    }
}
