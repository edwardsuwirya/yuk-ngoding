package com.enigmacamp.yukngoding.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "m_trainee", schema = "yukngoding")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainee_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "nick_name", nullable = false, length = 25)
    private String nickName;

    @Column(name = "address", nullable = false, length = 250)
    private String address;

    @Column(name = "id_card_no", nullable = false, length = 75)
    private String idCardNo;

    @Column(name = "telephone", nullable = false, length = 20)
    private String telephone;

    @Column(name = "education", length = 25)
    private String education;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private UserCredential userCredential;

//    @OneToMany(mappedBy = "trainee", cascade = CascadeType.ALL)
//    private Set<Enrollment> courseEnrollments = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public UserCredential getUserCredential() {
        return userCredential;
    }

    public void setUserCredential(UserCredential userCredential) {
        this.userCredential = userCredential;
    }

//    public Set<Enrollment> getCourseEnrollments() {
//        return courseEnrollments;
//    }
//
//    public void setCourseEnrollments(Set<Enrollment> courseEnrollments) {
//        this.courseEnrollments = courseEnrollments;
//    }
}