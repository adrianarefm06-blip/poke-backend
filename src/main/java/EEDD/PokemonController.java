package EEDD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "*")
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @GetMapping("/search")
    public List<Pokemon> searchPokemon(@RequestParam(required = false, defaultValue = "") String name) {
        if (name.isEmpty()) {
            return pokemonRepository.findAll();
        }
        return pokemonRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/all")
    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    @GetMapping("/team")
    public List<TeamMember> getTeam() {
        return teamMemberRepository.findAll();
    }

    @PostMapping("/team")
    public ResponseEntity<?> addToTeam(@RequestBody TeamMember member) {
        if (teamMemberRepository.count() >= 6) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"El equipo ya tiene 6 Pokémon. Elimina alguno antes de añadir otro.\"}");
        }
        TeamMember saved = teamMemberRepository.save(member);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/team/{id}")
    public ResponseEntity<?> removeFromTeam(@PathVariable int id) {
        teamMemberRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
