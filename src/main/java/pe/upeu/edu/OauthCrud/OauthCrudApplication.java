package pe.upeu.edu.OauthCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class OauthCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthCrudApplication.class, args);
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		System.out.println(bc.encode("12345"));
	}

}
