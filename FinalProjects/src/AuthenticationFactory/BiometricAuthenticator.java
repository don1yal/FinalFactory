package AuthenticationFactory;

public class BiometricAuthenticator implements Authenticator{

    private double isBiometricVerified;

    public BiometricAuthenticator(double isBiometricVerified) {
        this.isBiometricVerified = isBiometricVerified;
    }
    @Override
    public void authenticate(AuthenticationCallback callback) {
        if (verifyBiometric()) {
            callback.onSuccess();
        } else {
            callback.onFailure("Biometric verification failed");
        }
    }

    public boolean verifyBiometric() {
        return isBiometricVerified < 0.8;
    }
}
