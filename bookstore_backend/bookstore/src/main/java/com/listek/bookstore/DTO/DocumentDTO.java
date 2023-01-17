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
            // #TODO generating invoice number;
            String invoiceNumber = "12345/2023";
            if (companyName.equals("") || NIP.equals("")){
                // Invoice for client
                return new Invoice(LocalDateTime.now(), invoiceNumber, order);
            } else {
                // Invoice for company
                return new CompanyInvoice(LocalDateTime.now(), invoiceNumber, NIP, companyName, order);
            }
        }

    }
}
