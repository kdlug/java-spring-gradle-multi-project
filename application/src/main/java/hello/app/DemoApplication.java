package hello.app;

import hello.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Because DemoApplication is inside a different package (hello.app) than MyService (hello.service),
// @SpringBootApplication won’t detect it initially.
// There are different ways to allow `MyService to be picked up:
// Import it directly with @Import(MyService.class).
// Fetch everything from it’s package using @SpringBootApplication(scanBasePackageClasses={…​}).
// ​specifying the parent package by name, hello @SpringBootApplication(scanBasePackages = "hello")
@SpringBootApplication(scanBasePackages = "hello")
@RestController
public class DemoApplication {

    private final MyService myService;

    public DemoApplication(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public String home() {
        return myService.message();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}