package org.develop.guru.service;

import org.develop.guru.entities.PagamentoLog;
import org.develop.guru.entities.Products;
import org.develop.guru.game.NotificationResponse;
import org.develop.guru.game.Pagseguro;
import org.develop.guru.game.PagseguroResponse;
import org.develop.guru.repository.PagamentoLogRepository;
import org.develop.guru.repository.ProductsRepository;
import org.develop.guru.security.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by Luiz Eduardo on 08/06/2017.
 */

@Component
public class PagseguroService {

    @Autowired
    private PagamentoLogRepository pagamentoLogRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private SystemUserRepository userRepository;

    @Autowired
    private LifeService lifeService;


    public PagseguroResponse addPagamentoLog(int user, int idProduct) {
        Products products = productsRepository.findById(idProduct);
        PagamentoLog pagamentoLog = new PagamentoLog();
        pagamentoLog.setUser(userRepository.findOne(user));
        pagamentoLog.setStatusPagamento("Aguardando pagamento");
        pagamentoLog.setProduto(products);
        pagamentoLog.setDataCadastro(LocalDateTime.now());
        pagamentoLogRepository.save(pagamentoLog);
        return Pagseguro.comparVida(products.getNumberOfLives(), products.getValueOfLives(), pagamentoLogRepository.getLastInsertId());
    }


    @Transactional
    public void anteraStatusPagamento(String notificationCode){
        NotificationResponse notificationResponse = Pagseguro.pegaStatusPagamento(notificationCode);
        pagamentoLogRepository.alteraStatus(Integer.parseInt(notificationResponse.getReferenceCode()), notificationResponse.getNotificationCode(),
                transactionStatusByIndex(Integer.parseInt(notificationResponse.getStatusTransaction())), LocalDateTime.now());
        //ADICIONANDO AS VIDAS PARA OS USUÁRIOS
        adicionaVidas(Integer.parseInt(notificationResponse.getReferenceCode()));
    }


    private String transactionStatusByIndex(int notificationCode){
        Map<Integer, String> transactionStatus = new HashMap<>();
        transactionStatus.put(1, "Aguardando pagamento");
        transactionStatus.put(2, "Em análise");
        transactionStatus.put(3, "Paga");
        transactionStatus.put(4, "Disponível");
        transactionStatus.put(5, "Em disputa:");
        transactionStatus.put(6, "Devolvida");
        transactionStatus.put(7, "Cancelada");
        transactionStatus.put(8, "Debitado");
        transactionStatus.put(9, "Retenção temporária");
        return transactionStatus.get(notificationCode);
    }


    @Transactional
    private void adicionaVidas(int referenceCode){
        PagamentoLog pagamentoLog = pagamentoLogRepository.findOne(referenceCode);
        Products products = productsRepository.findOne(pagamentoLog.getProduto().getId());
        for(int i = 0; i < products.getNumberOfLives(); i++){
            lifeService.addLife(pagamentoLog.getUser().getId());
        }
    }
}
