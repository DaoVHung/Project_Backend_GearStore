package ra.dev.controller;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.ResponseEntity;import org.springframework.security.access.prepost.PreAuthorize;import org.springframework.web.bind.annotation.*;import ra.dev.model.dto.request.catalog.CatalogDTO;import ra.dev.model.dto.request.catalog.CatalogShowProduct;import ra.dev.model.dto.request.catalog.ProductDTO;import ra.dev.model.dto.request.product.ProductGet;import ra.dev.model.dto.request.product.ViewByCatalog;import ra.dev.model.entity.Catalog;import ra.dev.model.entity.Product;import ra.dev.model.service.CatalogService;import javax.annotation.security.PermitAll;import java.util.ArrayList;import java.util.List;@CrossOrigin(origins = "*")@RestController@RequestMapping("api/v1/catalog")public class CatalogController {    //************************************************ Admin ********************************************************    @Autowired    private CatalogService catalogService;    @GetMapping//    @PermitAll//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")    public List<CatalogDTO> getCatalog() {        List<Catalog> catalogList = catalogService.findAll();        List<CatalogDTO> catalogDTOList = new ArrayList<>();        for (Catalog cata : catalogList) {            CatalogDTO catalogDTO1 = new CatalogDTO(cata.getCatalogID(), cata.getCatalogName(), cata.isCatalogStatus());            catalogDTOList.add(catalogDTO1);        }        return catalogDTOList;    }    @GetMapping("/getListActive")//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")    public List<CatalogDTO> getCatalogActive() {        List<Catalog> catalogList = catalogService.getAllActive();        List<CatalogDTO> catalogDTOList = new ArrayList<>();        for (Catalog cata : catalogList) {            CatalogDTO catalogDTO1 = new CatalogDTO(cata.getCatalogID(), cata.getCatalogName(), cata.isCatalogStatus());            catalogDTOList.add(catalogDTO1);        }        return catalogDTOList;    }    @PostMapping//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")    public Catalog createCatalog(@RequestBody Catalog catalog) {        Catalog catalog1 = catalog;        catalog1.setCatalogStatus(true);        return catalogService.saveOrUpdate(catalog1);    }    @PutMapping("/{catalogID}")//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")    public Catalog update(@PathVariable("catalogID") int catalogID, @RequestBody Catalog catalog) {        Catalog catalogUpdate = catalogService.findByID(catalogID);        catalogUpdate.setCatalogName(catalog.getCatalogName());        catalogUpdate.setCatalogStatus(true);        return catalogService.saveOrUpdate(catalogUpdate);    }    @PutMapping("/delete/{catalogID}")//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")    public Catalog delete(@PathVariable("catalogID") int catalogID) {        Catalog catalogDelete = catalogService.findByID(catalogID);        catalogDelete.setCatalogStatus(false);        return catalogService.saveOrUpdate(catalogDelete);    }    @GetMapping("/{catalogID}")//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")    public Catalog getByID(@PathVariable("catalogID") int catalogID) {        return catalogService.findByID(catalogID);    }    @GetMapping("/showListProduct")//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")    public List<CatalogShowProduct> showProduct() {        List<Catalog> catalogList = catalogService.findAll();        List<CatalogShowProduct> catalogShowProductList = new ArrayList<>();        for (Catalog cata : catalogList) {            List<ProductDTO> productDTOS = new ArrayList<>();            for (Product product : cata.getProductList()) {                ProductDTO productDTO = new ProductDTO(product.getProductName(), product.isProductStatus());                productDTOS.add(productDTO);            }            CatalogShowProduct catalogDTO1 = new CatalogShowProduct(cata.getCatalogName(), cata.isCatalogStatus(), productDTOS);            catalogShowProductList.add(catalogDTO1);        }        return catalogShowProductList;    }    //************************************************ User ******************************************************    @GetMapping("/product/{catalogID}")    public List<ProductGet> searchCatalog(@PathVariable("catalogID") int catalogID) {        Catalog catalogList = catalogService.findByID(catalogID);        List<ProductGet> listProductGet = new ArrayList<>();        for (Product pro : catalogList.getProductList()) {            if (pro.isProductStatus() == true) {                ProductGet productGet = new ProductGet(                        pro.getProductID(),                        pro.getCatalog().getCatalogName(),                        pro.getProductName(),                        pro.getDiscount(),                        pro.getPrice(),                        pro.isProductStatus(),                        pro.getProductImg(),                        pro.getDescription(),                        pro.getListSub());                listProductGet.add(productGet);            } else {                continue;            }        }//        ViewByCatalog viewByCatalog = new ViewByCatalog(catalogList.getCatalogName(), listProductGet);//        viewByCatalogList.add(viewByCatalog);        return listProductGet;    }    @GetMapping("/search/{catalogName}")    public List<ViewByCatalog> getProductbyCatalog(@PathVariable("catalogName") String catalogName) {        List<Catalog> catalogList = catalogService.searchByName(catalogName);        List<ViewByCatalog> viewByCatalogList = new ArrayList<>();        for (Catalog catalog : catalogList) {            List<ProductGet> listProductGet = new ArrayList<>();            for (Product pro : catalog.getProductList()) {                ProductGet productGet = new ProductGet(                        pro.getProductID(),                        pro.getCatalog().getCatalogName(),                        pro.getProductName(),                        pro.getDiscount(),                        pro.getPrice(),                        pro.isProductStatus(),                        pro.getProductImg(),                        pro.getDescription(),                        pro.getListSub());                listProductGet.add(productGet);            }            ViewByCatalog viewByCatalog = new ViewByCatalog(catalog.getCatalogName(), listProductGet);            viewByCatalogList.add(viewByCatalog);        }        return viewByCatalogList;    }    @GetMapping("/searchByName/{catalogName}")    public List<Catalog> searchByName(@PathVariable("catalogName") String catalogName) {        List<Catalog> catalogList = catalogService.searchName(catalogName);        return catalogList;    }}