package AuthenticationFactory;

public interface Factory {
    Authenticator getAuthenticator(String type, String str1, String str2, double percentage);
}
