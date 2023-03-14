package ra.dev.model.entity;import com.fasterxml.jackson.annotation.JsonIgnore;import lombok.Data;import javax.persistence.*;import java.util.ArrayList;import java.util.HashSet;import java.util.List;import java.util.Set;@Entity@Table(name = "Users")@Datapublic class Users {    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)    @Column(name = "UserId")    private int userId;    @Column(name = "UserName", unique = true, nullable = false)    private String userName;    @Column(name = "fullName")    private String fullName;    @Column(name = "Password", nullable = false)    private String password;    @Column(name = "Email", nullable = false, unique = true)    private String email;    @Column(name = "PhoneNumber")    private String phoneNumber;    @Column(name = "UserStatus")    private boolean userStatus;    @Column(name = "Address")    private String address;    @ManyToMany(fetch = FetchType.LAZY)    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "UserID"),            inverseJoinColumns = @JoinColumn(name = "RoleId"))    private Set<Roles> listRoles = new HashSet<>();}