package cl.felipe.pokemonapp_ev1.modelo;

public class Pokemon {
    public String id;
    public String name;
    public String imageUrl;

    public String supertype;
    public String set;

    public Pokemon(){

    }

    public Pokemon(String id, String name, String imageUrl, String supertype, String set) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;

        this.supertype = supertype;
        this.set = set;
    }
}
