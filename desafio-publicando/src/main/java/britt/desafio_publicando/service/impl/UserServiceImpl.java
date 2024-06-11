package britt.desafio_publicando.service.impl;

import britt.desafio_publicando.domain.model.User;
import britt.desafio_publicando.domain.repository.UserRepository;
import britt.desafio_publicando.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {     //caso elemento não exista já dispara uma exceção nativa do java
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        //if(userToCreate.getId()!= null &&  userRepository.existsById(userToCreate.getId())){
         if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
