package AuthenticationFactory;

public class AuthenticatorFactory implements Factory {
    @Override
    public Authenticator getAuthenticator(String type, String str1, String str2, double percentage) {
        switch (type.toUpperCase()) {
            case "EMAIL":
                return new EmailPasswordAuthenticator(str1, str2);
            case "SOCIAL":
                return new SocialMediaAuthenticator(str1);
            case "BIOMETRIC":
                return new BiometricAuthenticator(percentage);
            default:
                throw new IllegalArgumentException("Invalid authentication type: " + type);
        }
    }
}
