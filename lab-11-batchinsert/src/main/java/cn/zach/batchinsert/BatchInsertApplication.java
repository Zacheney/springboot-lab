package cn.zach.batchinsert;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Zach
 * @date 2022/10/9 17:08
 */
@SpringBootApplication
@MapperScan("cn.zach.batchinsert.mapper")
public class BatchInsertApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatchInsertApplication.class, args);
    }
}
