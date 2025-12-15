package snap.infrastructure.kakao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoClient {
    @Value("${kakao.url}")
    private String kakaoUrl;

    @Value("${kakao.apiurl}")
    private String kakaoApiUrl;

    @Value("${kakao.clientId}")
    private String clientId;

    public JSONObject getCoordinateFromAddress(String address) throws ParseException {
        String response = WebClient.builder()
                .baseUrl(kakaoApiUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .get()
                .uri(uriBuilder ->
                uriBuilder
                        .path("/local/search/address")
                        .queryParam("query", address)
                        .queryParam("page", 1)
                        .queryParam("size", 1)
                        .build()
                )
                .header("Authorization", "KakaoAK " + clientId)
                .retrieve().bodyToMono(String.class).block();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(response);
        JSONArray array = (JSONArray) jsonObject.get("documents");
        return (JSONObject) array.get(0);
    }
}
