package AuthenticationFactory;

import java.util.HashSet;
import java.util.Set;

public class SocialMediaAuthenticator implements Authenticator {
    private final String token;

    public SocialMediaAuthenticator(String token) {
        this.token = token;
    }
    @Override
    public void authenticate(AuthenticationCallback callback) {
        if (isValidToken(token)) {
            callback.onSuccess();
        } else {
            callback.onFailure("Invalid token");
        }
    }
    private boolean isValidToken(String token) {
        return token != null && !token.isEmpty();
    }
}
