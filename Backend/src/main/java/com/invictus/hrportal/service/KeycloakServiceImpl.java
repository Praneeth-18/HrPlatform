package com.invictus.hrportal.service;

import org.keycloak.adapters.spi.KeycloakAccount;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import com.invictus.hrportal.model.User;

import java.util.List;

import javax.ws.rs.core.Response;

public class KeycloakServiceImpl implements KeycloakService{


	    @Value("${keycloak.auth-server-url}")
	    private String keycloakServerUrl;

	    @Value("${keycloak.realm}")
	    private String realm;

	    @Value("${keycloak.resource}")
	    private String clientId;

	    @Value("${keycloak.admin.username}")
	    private String adminUsername;

	    @Value("${keycloak.admin.password}")
	    private String adminPassword;

	    @Override
	    public void registerUser(User u) {
	        try (Keycloak keycloak = Keycloak.getInstance(
	                keycloakServerUrl,
	                realm,
	                adminUsername,
	                adminPassword,
	                clientId)) {

	            UserRepresentation user = new UserRepresentation();
	            user.setUsername(u.getUsername());
	            user.setEmail(u.getEmail());
	            user.setEnabled(true);

	            Response response = keycloak.realm(realm).users().create(user);
	            if (response.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
	                throw new RuntimeException("Failed to register user: " + response.readEntity(String.class));
	            }

	            String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");

	            CredentialRepresentation credential = new CredentialRepresentation();
	            credential.setTemporary(false);
	            credential.setType(CredentialRepresentation.PASSWORD);
	            credential.setValue(u.getPassword());

	            keycloak.realm(realm).users().get(userId).resetPassword(credential);
	        }
	    }


	    // Method to authenticate a user and return JWT
	    @Override
	    public String loginUser(String username, String password) {
	        Keycloak keycloak = KeycloakBuilder.builder()
	                .serverUrl(keycloakServerUrl)
	                .realm(realm)
	                .clientId(clientId)
	                .clientSecret(clientSecret)
	                .grantType("password")
	                .username(username)
	                .password(password)
	                .build();

	        AccessTokenResponse response = keycloak.tokenManager().getAccessToken();
	        return response.getToken();
	    }

	    // Method to logout a user
	    @Override
	    public void logoutUser(String username) {
	        Keycloak clientkeycloak = KeycloakBuilder.builder()
	                .serverUrl(keycloakServerUrl)
	                .realm(realm)
	                .clientId(clientId)
	                .clientSecret(clientSecret)
	                .grantType("client_credentials")
	                .build();

	        // Get user by username
	        List<UserRepresentation> users = clientkeycloak.realm(realm).users().search(username);
	        if (!users.isEmpty()) {
	            String userId = users.get(0).getId();

	            // Logout user by ending all sessions
	            clientkeycloak.realm(realm).users().get(userId).logout();
	        }
	    }
}
