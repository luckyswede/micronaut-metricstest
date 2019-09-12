package metrics.test;

import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.token.validator.TokenValidator;
import io.reactivex.Flowable;
import javax.inject.Singleton;
import org.reactivestreams.Publisher;

@Singleton
public class MyTokenValidator implements TokenValidator {
    @Override
    public Publisher<Authentication> validateToken(String token) {
        return Flowable.empty();
    }
}
