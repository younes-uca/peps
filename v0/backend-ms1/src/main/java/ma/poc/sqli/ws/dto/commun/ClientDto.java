package  ma.poc.sqli.ws.dto.commun;

import ma.poc.sqli.zynerator.audit.Log;
import ma.poc.sqli.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto  extends AuditBaseDto {

    private String fullName  ;

    private ClientCategoryDto clientCategory ;



    public ClientDto(){
        super();
    }



    @Log
    public String getFullName(){
        return this.fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }


    public ClientCategoryDto getClientCategory(){
        return this.clientCategory;
    }

    public void setClientCategory(ClientCategoryDto clientCategory){
        this.clientCategory = clientCategory;
    }






}
