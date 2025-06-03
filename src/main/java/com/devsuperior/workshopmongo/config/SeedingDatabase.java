package com.devsuperior.workshopmongo.config;

import com.devsuperior.workshopmongo.entities.Post;
import com.devsuperior.workshopmongo.entities.User;
import com.devsuperior.workshopmongo.repositories.PostRepository;
import com.devsuperior.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class SeedingDatabase implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) {

		Mono<Void> seeding = userRepository.deleteAll()
				.then(postRepository.deleteAll())
				.thenMany(
						userRepository.saveAll(Arrays.asList(
								new User(null, "Maria Brown", "maria@gmail.com"),
								new User(null, "Alex Green", "alex@gmail.com"),
								new User(null, "Bob Grey", "bob@gmail.com")
						))
				)
				.collectList()
				.flatMapMany(users -> {
					User maria = users.stream().filter(u -> u.getEmail().equals("maria@gmail.com")).findFirst().orElseThrow();
					User alex = users.stream().filter(u -> u.getEmail().equals("alex@gmail.com")).findFirst().orElseThrow();
					User bob = users.stream().filter(u -> u.getEmail().equals("bob@gmail.com")).findFirst().orElseThrow();

					Post post1 = new Post(null, Instant.parse("2022-11-21T18:35:24.00Z"), "Partiu viagem",
							"Vou viajar para São Paulo. Abraços!", maria.getId(), maria.getName());
					Post post2 = new Post(null, Instant.parse("2022-11-23T17:30:24.00Z"), "Bom dia",
							"Acordei feliz hoje!", maria.getId(), maria.getName());

					post1.addComment("Boa viagem mano!", Instant.parse("2022-11-21T18:52:24.00Z"), alex.getId(), alex.getName());
					post1.addComment("Aproveite!", Instant.parse("2022-11-22T11:35:24.00Z"), bob.getId(), bob.getName());

					post2.addComment("Tenha um ótimo dia!", Instant.parse("2022-11-23T18:35:24.00Z"), alex.getId(), alex.getName());

					post1.setUser(maria);
					post2.setUser(maria);

					return postRepository.saveAll(Arrays.asList(post1, post2));
				})
				.then();

		seeding.subscribe(); // Dispara toda a cadeia
	}
}
