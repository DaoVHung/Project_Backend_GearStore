package ra.dev.model.dto.request.catalog;import lombok.Getter;import lombok.NoArgsConstructor;import lombok.Setter;import java.util.ArrayList;import java.util.List;@Getter@Setter@NoArgsConstructorpublic class CatalogShowProduct {    private String catalogName;    private Boolean catalogStatus;    private List<ProductDTO> productList = new ArrayList<>();    public CatalogShowProduct(String catalogName, Boolean catalogStatus, List<ProductDTO> productList) {        this.catalogName = catalogName;        this.catalogStatus = catalogStatus;        this.productList = productList;    }}