package org.training.user.service.service.implementation;

import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;
import org.training.user.service.config.KeyCloakManager;
import org.training.user.service.service.KeycloakService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements KeycloakService {

    private final KeyCloakManager keyCloakManager;

    @Override
    public Integer createUser(UserRepresentation userRepresentation) {

        return keyCloakManager.getKeyCloakInstanceWithRealm().users().create(userRepresentation).getStatus();
    }

    @Override
    public List<UserRepresentation> readUserByEmail(String emailId) {

        return keyCloakManager.getKeyCloakInstanceWithRealm().users().search(emailId);
    }


}