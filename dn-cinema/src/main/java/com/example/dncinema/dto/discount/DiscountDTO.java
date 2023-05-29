package com.example.dncinema.dto.discount;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class DiscountDTO implements Validator {
    private Integer idDiscount;
    @NotBlank(message = "Tên khuyến mãi không được để trống")
    @Length(max = 255,message = "Tên khuyến mãi không dài quá 255 từ")
    private String nameDiscount;
    @NotNull(message = "Ngày bắt đầu không được để trống")
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private String dateStart;
    @NotNull(message = "Ngày kết thúc không được để trống")
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private String dateEnd;
    @NotNull(message = "Hình ảnh không được để trống")
    private String img;
    @NotBlank(message = "Chi tiết khuyến mãi không được để trống")
    private String describeDiscount;
    @NotNull(message = "Phần trăm giảm giá không được để trống")
    @Max(value = 100,message = "Phần trăm giảm giá không được quá 100")
    @DecimalMin(value = "0.0", inclusive = false,message = "Phần trăm giảm giá phải lớn hơn 0")
    private Double percentDiscount;

    public DiscountDTO() {
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

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
