package tp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tp3.client.IRun;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired(required = true)
	IRun irun;
	
	public void run(String... args)
	{
		irun.run();
	}
	
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(Application.class, args);
	}
}
