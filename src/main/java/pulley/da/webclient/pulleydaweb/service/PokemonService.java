package pulley.da.webclient.pulleydaweb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pulley.da.webclient.pulleydaweb.models.Pokemon;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
public class PokemonService {

    private final static String pokemonUrl = "https://pokeapi.co/api/v2/pokemon";

    // Mono is a publisher that emits at most one item
    public Mono<Pokemon> retrievePokemonByName(final String name) {
        return getPokemon(name);
    }

    // Flux is a publisher that emits more than on item
    // Notice the order of elements are not synchronous with the list of names
    public Flux<Pokemon> retrieveManyPokemon(final List<String> names) {
        return Flux.fromIterable(names)
                .flatMap(this::getPokemon);
    }

    private Mono<Pokemon> getPokemon(final String name) {
        final WebClient webClient = WebClient.create(String.format("%s/%s", pokemonUrl, name));
        return webClient.get().retrieve().bodyToMono(Pokemon.class);
    }
}
