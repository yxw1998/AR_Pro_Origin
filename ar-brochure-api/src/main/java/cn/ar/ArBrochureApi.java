package cn.ar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author YangXw
 * @date 2021/11/18 0018 9:59
 * @description
 */

@SpringBootApplication
@EnableTransactionManagement
public class ArBrochureApi {
    public static void main(String[] args) {
        SpringApplication.run(ArBrochureApi.class,args);
    }
}
