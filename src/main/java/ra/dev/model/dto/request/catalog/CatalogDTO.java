package ra.dev.model.dto.request.catalog;import lombok.AllArgsConstructor;import lombok.Getter;import lombok.NoArgsConstructor;import lombok.Setter;import java.util.ArrayList;import java.util.List;@Getter@Setter@NoArgsConstructor@AllArgsConstructorpublic class CatalogDTO {    private int catalogID;    private String catalogName;    private Boolean catalogStatus;}