package EEDD;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PokemonDataLoader {

    @Autowired
    private PokemonRepository pokemonRepository;

    @PostConstruct
    public void loadData() {
        if (pokemonRepository.count() == 0) {
            System.out.println("⏳ Obteniendo Pokémon de la PokeAPI...");
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://pokeapi.co/api/v2/pokemon?limit=2000";
            
            try {
                Map<String, Object> response = restTemplate.getForObject(url, Map.class);
                if (response != null && response.containsKey("results")) {
                    List<Map<String, String>> results = (List<Map<String, String>>) response.get("results");
                    List<Pokemon> pokemonsToSave = new ArrayList<>();
                    
                    for (Map<String, String> result : results) {
                        String name = result.get("name");
                        String urlPokemon = result.get("url");
                        
                        String[] parts = urlPokemon.split("/");
                        int id = Integer.parseInt(parts[parts.length - 1]);
                        
                        pokemonsToSave.add(new Pokemon(id, name));
                    }
                    pokemonRepository.saveAll(pokemonsToSave);
                    System.out.println("✅ ¡Base de datos poblada con " + pokemonsToSave.size() + " Pokémon!");
                }
            } catch (Exception e) {
                System.err.println("❌ Error al cargar los Pokémon desde la API: " + e.getMessage());
            }
        } else {
            System.out.println("✅ La base de datos ya contiene Pokémon.");
        }
    }
}
