package pl.kk.quizmon.services;

import com.google.gson.Gson;
import pl.kk.quizmon.models.Pokemon;

import javafx.scene.image.Image;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class PokeApiService {
    private static final String urlName = "https://pokeapi.co/api/v2/pokemon/";
    private static final String urlSpriteName = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";
    private static final String urlIconName = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-viii/sword-shield/icons/";

    private static PokeApiService instance;

    private PokeApiService() {}

    private record PokemonApiResponse(int id, String name) { }

    public Pokemon getPokemonData(String name) throws URISyntaxException, IOException {
        if (name == null || name.isBlank()) {
            return Pokemon.getUnknown();
        }
        name = URLEncoder.encode(name.trim().toLowerCase(), StandardCharsets.UTF_8);
        String jsonData = downloadJsonData(name);
        Gson gson = new Gson();
        PokemonApiResponse apiResponse = gson.fromJson(jsonData, PokemonApiResponse.class);

        Pokemon pokemon = new Pokemon(apiResponse.id(), apiResponse.name());
        pokemon.setSprite(downloadSpriteFromId(pokemon.getId()));
        pokemon.setIcon(downloadIconFromId(pokemon.getId()));

        return pokemon;
    }

    public static synchronized PokeApiService getInstance() {
        if (instance == null)
            instance = new PokeApiService();

        return instance;
    }

    private String downloadJsonData(String name) throws URISyntaxException, IOException {
        URL url = new URI(urlName + name).toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            conn.disconnect();
        }
    }

    private Image downloadImageData(String url) {
        Image image = new Image(url, true);

        image.errorProperty().addListener((obs, oldVal, isError) -> {
            if (isError) {
                Logger.getGlobal().severe("Failed to download sprite!");
                if (image.getException() != null) {
                    Logger.getGlobal().severe(image.getException().getMessage());
                }
            }
        });

        return image;
    }

    public Image downloadSpriteFromId(int id) {
        return downloadImageData(urlSpriteName + id + ".png");
    }

    public Image downloadIconFromId(int id) {
        return downloadImageData(urlIconName + id + ".png");
    }
}
