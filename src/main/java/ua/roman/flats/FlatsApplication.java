package ua.roman.flats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.roman.flats.collector.DataWorkflow;

@SpringBootApplication
public class FlatsApplication implements CommandLineRunner {

	@Autowired
	private DataWorkflow engine;

	public static void main(String[] args) {
		SpringApplication.run(FlatsApplication.class, args);
	}

	@Override
	public void run(String... args) {
		engine.run();
	}
}
