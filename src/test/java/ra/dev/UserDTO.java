public class UserDTO {    private Integer userId;    private String address;    private String confirmPass;    private String email;    private String fullName;    private String passWords;    private Boolean permission;    private String phoneNumber;    private String userName;    private Boolean userStatus;    public Integer getUserId() {        return this.userId;    }    public void setUserId(Integer userId) {        this.userId = userId;    }    public String getAddress() {        return this.address;    }    public void setAddress(String address) {        this.address = address;    }    public String getConfirmPass() {        return this.confirmPass;    }    public void setConfirmPass(String confirmPass) {        this.confirmPass = confirmPass;    }    public String getEmail() {        return this.email;    }    public void setEmail(String email) {        this.email = email;    }    public String getFullName() {        return this.fullName;    }    public void setFullName(String fullName) {        this.fullName = fullName;    }    public String getPassWords() {        return this.passWords;    }    public void setPassWords(String passWords) {        this.passWords = passWords;    }    public Boolean getPermission() {        return this.permission;    }    public void setPermission(Boolean permission) {        this.permission = permission;    }    public String getPhoneNumber() {        return this.phoneNumber;    }    public void setPhoneNumber(String phoneNumber) {        this.phoneNumber = phoneNumber;    }    public String getUserName() {        return this.userName;    }    public void setUserName(String userName) {        this.userName = userName;    }    public Boolean getUserStatus() {        return this.userStatus;    }    public void setUserStatus(Boolean userStatus) {        this.userStatus = userStatus;    }}