package org.develop.guru.service;

import org.develop.guru.entities.Life;
import org.develop.guru.repository.LifeRepository;
import org.develop.guru.security.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * Created by Luiz Eduardo on 27/03/2017.
 */

@Component
public class LifeService {

    @Autowired
    private LifeRepository lifeRepository;

    @Autowired
    private SystemUserRepository userRepository;


    void addLife(int user) {
        Life life = new Life();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiration = LocalDateTime.now().plusDays(30);

        life.setUser(userRepository.findOne(user));
        life.setDataCadastro(now);
        life.setDataExpiracao(expiration);
        lifeRepository.save(life);
    }


    public void useLife(int idLife) {
        lifeRepository.setDataConsumo(LocalDateTime.now(), idLife);
    }


    ArrayList<Life> getLifes(int user) {
        return lifeRepository.selectAvailableLives(userRepository.findOne(user));
    }
}
