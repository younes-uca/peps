package  ma.poc.sqli.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.poc.sqli.bean.core.commun.ClientCategory;
import ma.poc.sqli.dao.criteria.core.commun.ClientCategoryCriteria;
import ma.poc.sqli.service.facade.admin.commun.ClientCategoryAdminService;
import ma.poc.sqli.ws.converter.commun.ClientCategoryConverter;
import ma.poc.sqli.ws.dto.commun.ClientCategoryDto;
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
@RequestMapping("/api/admin/clientCategory/")
public class ClientCategoryRestAdmin  extends AbstractController<ClientCategory, ClientCategoryDto, ClientCategoryCriteria, ClientCategoryAdminService, ClientCategoryConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<ClientCategory>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ClientCategoryDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one clientCategory")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple clientCategorys")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all clientCategorys")
    @GetMapping("")
    public ResponseEntity<List<ClientCategoryDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all clientCategorys")
    @GetMapping("optimized")
    public ResponseEntity<List<ClientCategoryDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a clientCategory by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ClientCategoryDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @Operation(summary = "Saves the specified  clientCategory")
    @PostMapping("")
    public ResponseEntity<ClientCategoryDto> save(@RequestBody ClientCategoryDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  clientCategory")
    @PutMapping("")
    public ResponseEntity<ClientCategoryDto> update(@RequestBody ClientCategoryDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of clientCategory")
    @PostMapping("multiple")
    public ResponseEntity<List<ClientCategoryDto>> delete(@RequestBody List<ClientCategoryDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified clientCategory")
    @DeleteMapping("")
    public ResponseEntity<ClientCategoryDto> delete(@RequestBody ClientCategoryDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified clientCategory")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple clientCategorys by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds clientCategorys by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ClientCategoryDto>> findByCriteria(@RequestBody ClientCategoryCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated clientCategorys by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ClientCategoryCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports clientCategorys by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ClientCategoryCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets clientCategory data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ClientCategoryCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ClientCategoryRestAdmin (ClientCategoryAdminService service, ClientCategoryConverter converter) {
        super(service, converter);
    }




}
