package com.listek.bookstore.DTO;

import com.listek.bookstore.models.Complaint;
import com.listek.bookstore.models.ComplaintItem;
import com.listek.bookstore.models.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductComplaintDTO {
    private long productId;
    private int amount;
    private String reason;

    public ComplaintItem fromProductComplaintDTOtoComplaintItem(Product product, Complaint complaint){
        ComplaintItem complaintItem = new ComplaintItem();
        complaintItem.setComplaintReason(reason);
        complaintItem.setQuantity(amount);
        complaintItem.setProduct(product);
        complaintItem.setComplaint(complaint);

        return complaintItem;
    }
}
