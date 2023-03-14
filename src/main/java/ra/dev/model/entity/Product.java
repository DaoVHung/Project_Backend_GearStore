package ra.dev.model.entity;import lombok.AllArgsConstructor;import lombok.Getter;import lombok.NoArgsConstructor;import lombok.Setter;import javax.persistence.*;import java.util.ArrayList;import java.util.List;@Entity@Table(name = "Product")@Getter@Setter@NoArgsConstructor@AllArgsConstructorpublic class Product {    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)    @Column(name = "ProductID")    private int productID;    @ManyToOne    @JoinColumn(name = "CatalogID")    private Catalog catalog;    @Column(name = "ProductName")    private String productName;    @Column(name = "Price")    private int price;    @Column(name = "Description")    private String description;    @Column(name = "ProdcutStatus")    private boolean productStatus;    @Column(name = "ProductImg")    private String productImg;    @Column(name = "Discount")    private int discount;    @OneToMany(mappedBy = "product")    List<SubImage> listSub = new ArrayList<>();}