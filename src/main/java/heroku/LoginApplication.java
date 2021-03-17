package heroku;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@SpringBootApplication
public class LoginApplication implements WebMvcConfigurer {

  @Autowired
  StoreService storeService;

  @RequestMapping("/store/{input}")
  @ResponseStatus(value = HttpStatus.ACCEPTED)
  public void store(@PathVariable String input) throws IOException {
    Path filePath = Paths.get("output.txt");
    byte[] fileContent = (input + "\r\n").getBytes();
    Files.write(filePath, fileContent, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    storeService.store(input);
  }

  @RequestMapping("/{file}")
  @ResponseBody
  public ResponseEntity<String> login(@PathVariable String file) {
    try {
      Path filePath = Paths.get("src/main/resources/" + file);
      String fileContent = new String(Files.readAllBytes(filePath));
      return ResponseEntity.ok().body(fileContent);
    } catch (IOException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @RequestMapping("/")
  @ResponseBody
  public ResponseEntity<String> root() {
    try {
      Path filePath = Paths.get("src/main/resources/login");
      String fileContent = new String(Files.readAllBytes(filePath));
      return ResponseEntity.ok().body(fileContent);
    } catch (IOException e) {
      return ResponseEntity.notFound().build();
    }
  }

  public static void main(final String[] args) throws Exception {
    SpringApplication.run(LoginApplication.class, args);
  }
}