package metrics.test;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;
import io.reactivex.Single;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/secured")
public class SecuredController {
    @Get("/test/")
    public Single<String> test(Authentication authentication) {
        return Single.just("hi there");
    }
}
