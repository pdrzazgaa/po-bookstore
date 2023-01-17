package com.listek.bookstore.DTO;

import com.listek.bookstore.models.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.StringBufferInputStream;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DocumentDTO {

    private static final String INVOICE = "invoice";
    private static final String RECEIPT = "receipt";
    private String document;

    public DocumentDTO(String document) {
        this.document = document;
    }

    public Document fromDocumentDTOtoDocument(Order order, String NIP, String companyName){
        if (document.equals(RECEIPT))
            return new Receipt(LocalDateTime.now(), order);
        else {
            if (companyName.equals("") || NIP.equals("")){
                // Invoice for client
                return new Invoice(LocalDateTime.now(), order);
            } else {
                // Invoice for company
                return new CompanyInvoice(LocalDateTime.now(), NIP, companyName, order);
            }
        }

    }
}
