package org.develop.guru.game;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Modelo  de Notificação recebida ao solicitar dados de uma trnsação pagseguro.
 * Created by Luiz Eduardo on 07/06/2017.
 */

@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotificationResponse {

    @XmlElement(name = "code")
    private String notificationCode;

    @XmlElement(name = "reference")
    private String referenceCode;

    @XmlElement(name = "status")
    private String statusTransaction;

    @XmlElement(name = "date")
    private String date;

    public String getNotificationCode() {
        return notificationCode;
    }

    public void setNotificationCode(String notificationCode) {
        this.notificationCode = notificationCode;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getStatusTransaction() {
        return statusTransaction;
    }

    public void setStatusTransaction(String statusTransaction) {
        this.statusTransaction = statusTransaction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}