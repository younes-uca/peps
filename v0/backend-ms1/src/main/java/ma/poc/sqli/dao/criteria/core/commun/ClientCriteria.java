package  ma.poc.sqli.dao.criteria.core.commun;



import ma.poc.sqli.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ClientCriteria extends  BaseCriteria  {

    private String fullName;
    private String fullNameLike;

    private ClientCategoryCriteria clientCategory ;
    private List<ClientCategoryCriteria> clientCategorys ;


    public ClientCriteria(){}

    public String getFullName(){
        return this.fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getFullNameLike(){
        return this.fullNameLike;
    }
    public void setFullNameLike(String fullNameLike){
        this.fullNameLike = fullNameLike;
    }


    public ClientCategoryCriteria getClientCategory(){
        return this.clientCategory;
    }

    public void setClientCategory(ClientCategoryCriteria clientCategory){
        this.clientCategory = clientCategory;
    }
    public List<ClientCategoryCriteria> getClientCategorys(){
        return this.clientCategorys;
    }

    public void setClientCategorys(List<ClientCategoryCriteria> clientCategorys){
        this.clientCategorys = clientCategorys;
    }
}
