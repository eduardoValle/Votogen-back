package org.develop.guru.service;

import org.develop.guru.entities.Life;
import org.develop.guru.game.Cards;
import org.develop.guru.game.CardsRequest;
import org.develop.guru.repository.UserPlanRepository;
import org.develop.guru.security.SystemUser;
import org.develop.guru.security.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Luiz Eduardo on 10/04/2017.
 */
@Component
public class GameService {

    @Autowired
    private LifeService lifeService;

    @Autowired
    private HistoricService historicService;

    @Autowired
    private SystemUserRepository userRepository;

    @Transactional
    public List<String> play(int id, CardsRequest cards) {

        Cards cardsList = new Cards();
        List<String> msgList = cardsList.selectCards(cards);
        ArrayList<Life> lifes = lifeService.getLifes(id);

        if(lifes.size() > 0){
            //Consome uma vida e salva a mensagem no histórico.
            lifeService.useLife(lifes.get(0).getId());
            historicService.registerInHistoric(id, cardsList.completeMessage(msgList));
        } else {

            SystemUser u = userRepository.findById(id).orElseThrow(NotFoundException::new);
            if (u.getEmail().equals("teste@teste")){
                historicService.registerInHistoric(id, cardsList.completeMessage(msgList));
            }else {
                // Retorna apenas 4 frases.
                msgList = getNoLifeMsgList(msgList);
            }
        }
        return msgList;
    }

    public List<String> getNoLifeMsgList (List<String> msgList) {

        List<String> reducedMessage = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            reducedMessage.add(msgList.get(i));
        }
        return reducedMessage;
    }
}
