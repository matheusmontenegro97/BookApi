package ifpe.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookApiSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApiSecurityApplication.class, args);
	}

}
