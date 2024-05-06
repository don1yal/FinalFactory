package AuthenticationFactory;

import java.util.regex.Pattern;

public class EmailPasswordAuthenticator implements Authenticator {
    private final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private final Pattern emailPattern = Pattern.compile(emailRegex);

    private String email;
    private String password;
    public EmailPasswordAuthenticator(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void authenticate(AuthenticationCallback callback) {
        if (!isValidEmail(email)) {
            callback.onFailure("Invalid email Format");
            return;
        }

        if (!isValidPassword(password)) {
            callback.onFailure("Invalid password");
            return;
        }

        if ("user@example.com".equals(email) && "password123".equals(password)) {
            callback.onSuccess();
        } else {
            callback.onFailure("Invalid credentials");
        }
    }
    public boolean isValidEmail(String email) {
        return email != null && emailPattern.matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }
}
