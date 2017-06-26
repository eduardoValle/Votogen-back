package org.develop.votogen.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * A última versão do JPA, que é a 2.1 saiu antes do Java 8, por isso não suporta o LocalDate com o @Temporal para o banco.
 * Essa Classe, que tem a função de definir o mapeamento do LocalDate para java.sql.Date.
 * Created by Luiz Eduardo on 30/03/2017.
 */

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
        return (locDate == null ? null : Date.valueOf(locDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
}