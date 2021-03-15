import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@SpringBootApplication
public class LoginApplication implements WebMvcConfigurer {

  @RequestMapping("/store")
  @ResponseStatus(value = HttpStatus.OK)
  public void store(@RequestParam final String input) throws IOException {
    Files.write(Paths.get("output.txt"), (input + "\r\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
  }

  @RequestMapping("/login")
  @ResponseBody
  public String login() throws IOException {
    return new String(Files.readAllBytes(Paths.get("src/main/resources/login.html")));
  }

  public static void main(final String[] args) throws Exception {
      SpringApplication.run(LoginApplication.class, args);
    }
}