package AuthenticationFactory;

public interface AuthenticationCallback {
    void onSuccess();
    void onFailure(String errorMessage);
}
