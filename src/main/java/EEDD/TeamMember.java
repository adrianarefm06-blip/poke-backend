package EEDD;

import jakarta.persistence.*;

@Entity
@Table(name = "team_member")
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int pokemonId;
    
    private String pokemonName;

    private String username;

    public TeamMember() {
    }

    public TeamMember(int pokemonId, String pokemonName, String username) {
        this.pokemonId = pokemonId;
        this.pokemonName = pokemonName;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
