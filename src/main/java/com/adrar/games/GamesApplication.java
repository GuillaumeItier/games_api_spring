package com.adrar.games;

import com.adrar.games.model.Console;
import com.adrar.games.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamesApplication implements CommandLineRunner {

	private ConsoleRepository consoleRepository;

	public GamesApplication(ConsoleRepository consoleRepository)
	{
		this.consoleRepository = consoleRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(GamesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
