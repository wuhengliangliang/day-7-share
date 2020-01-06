package liangliang.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Day7ShareApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day7ShareApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello 无痕";
    }
}
