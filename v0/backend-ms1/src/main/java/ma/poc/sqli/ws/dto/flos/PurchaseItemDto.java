package  ma.poc.sqli.ws.dto.flos;

import ma.poc.sqli.zynerator.audit.Log;
import ma.poc.sqli.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.poc.sqli.ws.dto.commun.ProductDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseItemDto  extends AuditBaseDto {

    private BigDecimal price  ;
    private BigDecimal quantity  ;

    private ProductDto product ;
    private PurchaseDto purchase ;



    public PurchaseItemDto(){
        super();
    }



    @Log
    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }

    @Log
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }


    public ProductDto getProduct(){
        return this.product;
    }

    public void setProduct(ProductDto product){
        this.product = product;
    }
    public PurchaseDto getPurchase(){
        return this.purchase;
    }

    public void setPurchase(PurchaseDto purchase){
        this.purchase = purchase;
    }






}
