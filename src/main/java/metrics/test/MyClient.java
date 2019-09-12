package metrics.test;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Maybe;

@Client("http://localhost:8080/insecure")
public interface MyClient {
    @Get("/notfound/")
    Maybe<String> notfound();
}
