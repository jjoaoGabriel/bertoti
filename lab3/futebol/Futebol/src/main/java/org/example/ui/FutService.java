package org.example.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Fut;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class FutService {

    private static final String API_URL =
            "http://localhost:8080/players";

    private final ObjectMapper mapper =
            new ObjectMapper();

    // Busca os jogadores
    public List<Fut> getPlayers() {

        try {

            HttpURLConnection conn =
                    (HttpURLConnection)
                            new URL(API_URL).openConnection();

            conn.setRequestMethod("GET");

            InputStream response =
                    conn.getInputStream();

            Fut[] players =
                    mapper.readValue(response, Fut[].class);

            return Arrays.asList(players);

        } catch (Exception e) {

            e.printStackTrace();

            return List.of();
        }
    }

    // Adiciona jogador
    public void addPlayer(Fut player) {
        sendWithBody("POST", API_URL, player);
    }

    // Atualiza jogador
    public void updatePlayer(Long id, Fut player) {
        sendWithBody("PUT", API_URL + "/" + id, player);
    }

    // Deleta jogador
    public void deletePlayer(Long id) {

        try {

            HttpURLConnection conn =
                    (HttpURLConnection)
                            new URL(API_URL + "/" + id)
                                    .openConnection();

            conn.setRequestMethod("DELETE");

            conn.getInputStream();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendWithBody(
            String method,
            String urlStr,
            Fut player
    ) {

        try {

            HttpURLConnection conn =
                    (HttpURLConnection)
                            new URL(urlStr)
                                    .openConnection();

            conn.setRequestMethod(method);

            conn.setRequestProperty(
                    "Content-Type",
                    "application/json"
            );

            conn.setDoOutput(true);

            String json =
                    mapper.writeValueAsString(player);

            OutputStream os =
                    conn.getOutputStream();

            os.write(json.getBytes());

            os.flush();

            conn.getInputStream();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}