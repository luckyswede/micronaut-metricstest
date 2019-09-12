package metrics.test;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.reactivex.Single;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/insecure")
public class InsecureController {
    private final MyClient myClient;

    public InsecureController(MyClient myClient) {
        this.myClient = myClient;
    }

    @Get("/test/")
    public Single<String> test() {
        return myClient.notfound().switchIfEmpty(Single.just("fallback"));
    }

    @Get("/notfound/")
    public Single<String> notfound() {
        throw new HttpStatusException(HttpStatus.NOT_FOUND, "Not found");
    }
}
