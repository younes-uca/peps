package  ma.poc.sqli.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.poc.sqli.bean.core.commun.Client;
import ma.poc.sqli.dao.criteria.core.commun.ClientCriteria;
import ma.poc.sqli.service.facade.admin.commun.ClientAdminService;
import ma.poc.sqli.ws.converter.commun.ClientConverter;
import ma.poc.sqli.ws.dto.commun.ClientDto;
import ma.poc.sqli.zynerator.controller.AbstractController;
import ma.poc.sqli.zynerator.dto.AuditEntityDto;
import ma.poc.sqli.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.poc.sqli.zynerator.process.Result;

import org.springframework.http.HttpEntity;

import org.springframework.web.multipart.MultipartFile;
import ma.poc.sqli.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/client/")
public class ClientRestAdmin  extends AbstractController<Client, ClientDto, ClientCriteria, ClientAdminService, ClientConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<Client>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ClientDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one client")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple clients")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all clients")
    @GetMapping("")
    public ResponseEntity<List<ClientDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all clients")
    @GetMapping("optimized")
    public ResponseEntity<List<ClientDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a client by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @Operation(summary = "Saves the specified  client")
    @PostMapping("")
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  client")
    @PutMapping("")
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of client")
    @PostMapping("multiple")
    public ResponseEntity<List<ClientDto>> delete(@RequestBody List<ClientDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified client")
    @DeleteMapping("")
    public ResponseEntity<ClientDto> delete(@RequestBody ClientDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified client")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple clients by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by clientCategory id")
    @GetMapping("clientCategory/id/{id}")
    public List<ClientDto> findByClientCategoryId(@PathVariable Long id){
        return findDtos(service.findByClientCategoryId(id));
    }
    @Operation(summary = "delete by clientCategory id")
    @DeleteMapping("clientCategory/id/{id}")
    public int deleteByClientCategoryId(@PathVariable Long id){
        return service.deleteByClientCategoryId(id);
    }
    @Operation(summary = "Finds clients by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ClientDto>> findByCriteria(@RequestBody ClientCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated clients by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ClientCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports clients by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ClientCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets client data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ClientCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ClientRestAdmin (ClientAdminService service, ClientConverter converter) {
        super(service, converter);
    }




}
