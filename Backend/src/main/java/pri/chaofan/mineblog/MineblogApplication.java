package pri.chaofan.mineblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("pri.chaofan.mineblog.dao")
public class MineblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MineblogApplication.class, args);
	}

}
