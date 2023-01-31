package pulley.da.webclient.pulleydaweb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pulley.da.webclient.pulleydaweb.models.Pokemon;
import pulley.da.webclient.pulleydaweb.service.PokemonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    private final static List<String> names = List.of("ditto", "abra", "pikachu", "charizard");

    @GetMapping("/{name}")
    public Mono<Pokemon> getPokemonByName(@PathVariable(name = "name") final String name) {
        log.info("Retrieving Pokemon by Name: {}", name);

        return pokemonService.retrievePokemonByName(name);
    }

    @GetMapping
    public Flux<Pokemon> getManyPokemon() {
        return pokemonService.retrieveManyPokemon(names);
    }
}
