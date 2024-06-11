package britt.desafio_publicando.service;

import britt.desafio_publicando.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

}
