package com.example.dncinema.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_discount")
    private Integer idDiscount;
    @Column(name = "name_discount", columnDefinition = "varchar(255)")
    private String nameDiscount;
    @Column(name = "date_start", columnDefinition = "date")
    private LocalDate dateStart;
    @Column(name = "date_end", columnDefinition = "date")
    private LocalDate dateEnd;
    @Column(name = "describe_discount", columnDefinition = "varchar(255)")
    private String describeDiscount;
    @Column(name = "percent_discount")
    private Double percentDiscount;



    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    public Discount() {
    }

    public Discount(Integer idDiscount, String nameDiscount, LocalDate dateStart, LocalDate dateEnd, String describeDiscount, Double percentDiscount) {
        this.idDiscount = idDiscount;
        this.nameDiscount = nameDiscount;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.describeDiscount = describeDiscount;
        this.percentDiscount = percentDiscount;
    }

    public Integer getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(Integer idDiscount) {
        this.idDiscount = idDiscount;
    }

    public String getNameDiscount() {
        return nameDiscount;
    }

    public void setNameDiscount(String nameDiscount) {
        this.nameDiscount = nameDiscount;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescribeDiscount() {
        return describeDiscount;
    }

    public void setDescribeDiscount(String describeDiscount) {
        this.describeDiscount = describeDiscount;
    }

    public Double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(Double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
