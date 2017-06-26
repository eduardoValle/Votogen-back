package org.develop.votogen.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * A última versão do JPA, que é a 2.1 saiu antes do Java 8, por isso não suporta o LocalDateTime com o @Temporal para o banco.
 * Essa Classe, que tem a função de definir o mapeamento do LocalDateTime para java.sql.Timestamp.
 * Created by Luiz Eduardo on 30/03/2017.
 */

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter <LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
        return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
    }
}