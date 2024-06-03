package com.microservice.UserService;

import com.microservice.UserService.models.User;
import com.microservice.UserService.repos.JpaRegisteredClientRepository;
import com.microservice.UserService.repos.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

import java.util.UUID;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	JpaRegisteredClientRepository registeredClientRepository;

	@Autowired
	UserRepo userRepo;

	@Test
	void contextLoads() {
	}

    @Test
    public void addSampleRegisteredClient() {
        RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("scaler")
                .clientSecret("$2a$12$KrCnD7lCbkdgY2kYSDgC3O848Z.i/OGbi1PXYFQAhZBES5K7P.RMq")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .redirectUri("https://oauth.pstmn.io/v1/callback")
                .postLogoutRedirectUri("https://oauth.pstmn.io/v1/callback")
                .scope("ADMIN")
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
                .build();

        registeredClientRepository.save(oidcClient);
    }

	@Test
	public void addSampleUserInDb() {

		User user = new User();
		user.setName("user");
		user.setHashedPassword("$2a$12$uRSohbe18JcvObrvXNypuumfc7RQLFc5yWZtn9HAiM2SzE4PL.KvK");

		userRepo.save(user);


	}

}
