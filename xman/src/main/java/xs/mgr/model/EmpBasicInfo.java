package xs.mgr.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EmpBasicInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "emp_basicinfo", catalog = "xman")
public class EmpBasicInfo implements java.io.Serializable {

    // Fields

    private String empCode;
    private String empName;
    private String empNameKata;
    private String empNameRoma;
    private String empGender;
    private Date empBirthdate;
    private String empPhone;
    private String empMail;
    private String empPost;
    private String empAddress;
    private String empPassport;
    private String empMynumber;
    private String empPhoto;
    private Timestamp empCreatedate;
    private String empCreateuser;
    private Timestamp empUpdatedate;
    private String empUpdateuser;

    // Constructors

    /** default constructor */
    public EmpBasicInfo() {
    }

    /** minimal constructor */
    public EmpBasicInfo(String empCode, String empName) {
        this.empCode = empCode;
        this.empName = empName;
    }

    /** full constructor */
    public EmpBasicInfo(String empCode, String empName, String empNameKata, String empNameRome, String empGender,
            Date empBirthdate, String empPhone, String empMail, String empPost, String empAddress, String empPassport,
            String empMynumber, String empPhoto, Timestamp empCreatedate, String empCreateuser,
            Timestamp empUpdatedate, String empUpdateuser) {
        this.empCode = empCode;
        this.empName = empName;
        this.empNameKata = empNameKata;
        this.empNameRoma = empNameRome;
        this.empGender = empGender;
        this.empBirthdate = empBirthdate;
        this.empPhone = empPhone;
        this.empMail = empMail;
        this.empPost = empPost;
        this.empAddress = empAddress;
        this.empPassport = empPassport;
        this.empMynumber = empMynumber;
        this.empPhoto = empPhoto;
        this.empCreatedate = empCreatedate;
        this.empCreateuser = empCreateuser;
        this.empUpdatedate = empUpdatedate;
        this.empUpdateuser = empUpdateuser;
    }

    // Property accessors
    @Id
    @Column(name = "emp_code", unique = true, nullable = false, length = 32)
    public String getEmpCode() {
        return this.empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    @Column(name = "emp_name", nullable = false, length = 50)
    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Column(name = "emp_name_kata", length = 50)
    public String getEmpNameKata() {
        return this.empNameKata;
    }

    public void setEmpNameKata(String empNameKata) {
        this.empNameKata = empNameKata;
    }

    @Column(name = "emp_name_roma", length = 50)
    public String getEmpNameRoma() {
        return this.empNameRoma;
    }

    public void setEmpNameRoma(String empNameRome) {
        this.empNameRoma = empNameRome;
    }

    @Column(name = "emp_gender", length = 10)
    public String getEmpGender() {
        return this.empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "emp_birthdate", length = 10)
    public Date getEmpBirthdate() {
        return this.empBirthdate;
    }

    public void setEmpBirthdate(Date empBirthdate) {
        this.empBirthdate = empBirthdate;
    }

    @Column(name = "emp_phone", length = 20)
    public String getEmpPhone() {
        return this.empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    @Column(name = "emp_mail", length = 50)
    public String getEmpMail() {
        return this.empMail;
    }

    public void setEmpMail(String empMail) {
        this.empMail = empMail;
    }

    @Column(name = "emp_post", length = 20)
    public String getEmpPost() {
        return this.empPost;
    }

    public void setEmpPost(String empPost) {
        this.empPost = empPost;
    }

    @Column(name = "emp_address", length = 200)
    public String getEmpAddress() {
        return this.empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    @Column(name = "emp_passport", length = 20)
    public String getEmpPassport() {
        return this.empPassport;
    }

    public void setEmpPassport(String empPassport) {
        this.empPassport = empPassport;
    }

    @Column(name = "emp_mynumber", length = 20)
    public String getEmpMynumber() {
        return this.empMynumber;
    }

    public void setEmpMynumber(String empMynumber) {
        this.empMynumber = empMynumber;
    }

    @Column(name = "emp_photo", length = 50)
    public String getEmpPhoto() {
        return this.empPhoto;
    }

    public void setEmpPhoto(String empPhoto) {
        this.empPhoto = empPhoto;
    }

    @Column(name = "emp_createdate", length = 19)
    public Timestamp getEmpCreatedate() {
        return this.empCreatedate;
    }

    public void setEmpCreatedate(Timestamp empCreatedate) {
        this.empCreatedate = empCreatedate;
    }

    @Column(name = "emp_createuser", length = 45)
    public String getEmpCreateuser() {
        return this.empCreateuser;
    }

    public void setEmpCreateuser(String empCreateuser) {
        this.empCreateuser = empCreateuser;
    }

    @Column(name = "emp_updatedate", length = 19)
    public Timestamp getEmpUpdatedate() {
        return this.empUpdatedate;
    }

    public void setEmpUpdatedate(Timestamp empUpdatedate) {
        this.empUpdatedate = empUpdatedate;
    }

    @Column(name = "emp_updateuser", length = 45)
    public String getEmpUpdateuser() {
        return this.empUpdateuser;
    }

    public void setEmpUpdateuser(String empUpdateuser) {
        this.empUpdateuser = empUpdateuser;
    }

}