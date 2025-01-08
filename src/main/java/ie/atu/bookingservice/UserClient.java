package ie.atu.bookingservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class UserClient {

    @Value("${user.service.url}")
    private String userServiceUrl;

    private final WebClient webClient;

    public UserClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public boolean checkUserExists(Long userId) {
        // GET /api/users/{id}
        String url = userServiceUrl + "/" + userId;
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .map(r -> true)
                .onErrorReturn(false)
                .block();
    }
}

