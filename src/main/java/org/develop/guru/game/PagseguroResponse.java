package org.develop.guru.game;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Created by Luiz Eduardo on 07/06/2017.
 */

@XmlRootElement(name = "checkout")
@XmlAccessorType(XmlAccessType.FIELD)
public class PagseguroResponse {

    @XmlElement(name = "code")
    private String code;

    @XmlElement(name = "date")
    private String date;

    private String referenceCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }
}