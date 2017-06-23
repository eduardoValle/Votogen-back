package org.develop.guru.service;

import org.develop.guru.entities.Historic;
import org.develop.guru.repository.HistoricRepository;
import org.develop.guru.security.SystemUser;
import org.develop.guru.security.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * Created by Luiz Eduardo on 27/03/2017.
 */

@Service
public class HistoricService {

    @Autowired
    private SystemUserRepository userRepository;

    @Autowired
    private HistoricRepository historicRepository;

    public void registerInHistoric(int id, String mensagem) {

        Historic historic;
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        String d = new SimpleDateFormat("dd/MM/yyyy").format(date);
        calendar.setTime(date);
        String hour = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);

        SystemUser user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        historic = new Historic(user, hour, mensagem, d);
        historicRepository.save(historic);
    }
}