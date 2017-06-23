package org.develop.guru.repository;

import org.develop.guru.entities.Life;
import org.develop.guru.entities.PagamentoLog;
import org.develop.guru.security.SystemUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * Created by Luiz Eduardo on 27/03/2017.
 */

public interface PagamentoLogRepository extends CrudRepository<PagamentoLog, Integer> {

    ArrayList<PagamentoLog> findByUser(SystemUser user);

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    int getLastInsertId();

    @Modifying
    @Query("UPDATE PagamentoLog pagamento SET pagamento.codigoPagamento = ?2, pagamento.statusPagamento=?3, pagamento.ultimaMudancaStatus=?4 WHERE pagamento.id = ?1")
    void alteraStatus(int id, String notificationCode, String statusPagamento, LocalDateTime dataConsumo);
}