package api.utis.authentication;

import org.json.JSONObject;

public class AuthenticationRequest {
    private static String username;
    private static String password;
    public JSONObject requestBody;

    public AuthenticationRequest(final String username, final String password) {
        this.username = username;
        this.password = password;
        createJSONMainBody();
    }

    private void createJSONMainBody() {
        JSONObject data = new JSONObject();
        data.put("username", username);
        data.put("password", password);
        this.requestBody = data;
    }
}
