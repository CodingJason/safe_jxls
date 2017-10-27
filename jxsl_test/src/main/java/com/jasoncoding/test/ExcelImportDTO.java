package com.jasoncoding.test;


/**
 * @author jason
 * 从 excel 直接导出的 DTO
 */
public class ExcelImportDTO {
    /**
     * 患者姓名
     * 0
     * A
     */
    private String patientId;
    /**
     * 服务类型
     * 1
     * B
     */
    private String serviceType;
    /**
     * 主诊断
     * 2
     * C
     */
    private String mainDisease;
    /**
     * 医保类型
     * 3
     * D
     */
    private String insuranceType;
    /**
     * 医疗类别
     * 4
     * E
     */
    private String medicalType;
    /**
     * 所属科室
     * 5
     * F
     */
    private String depart;
    /**
     * 服务机构
     * 6
     * G
     */
    private String hospital;
    /**
     * 服务院区
     * 7
     * H
     */
    private String district;
    /**
     * 服务医生
     * 8
     * I
     */
    private String doctorName;
    /**
     * 入院诊断
     * 9
     * J
     */
    private String innerDisease;
    /**
     * 出院诊断
     * 10
     * K
     */
    private String outerDisease;
    /**
     * 麻醉类型
     * 11
     * L
     */
    private String anesthesia;
    /**
     * 服务名称
     * 12
     * M
     */
    private String serviceName;
    /**
     * 住院时间
     * 13
     * N
     */
    private String serviceDays;
    /**
     * 治疗费用
     * 14
     * O
     */
    private String hospitalPrice;
    /**
     * 支付方式
     * 15
     * P
     */
    private String payType;
    /**
     * 支付金额
     * 16
     * Q
     */
    private String payAmount;
    /**
     * 费用组成
     * 17
     * R
     */
    private String payAmountPart;
    /**
     * 费用组成
     * 18
     * S
     */
    private String payAmountPartPrice;
    /**
     * 高价值项目
     * 19
     * T
     */
    private String project;

    /**
     * 费用类别
     * 20
     * U
     */
    private String projectType;

    /**
     * 类型
     * 21
     * V
     */
    private String projectInsuranceType;
    /**
     * 单价
     * 22
     * W
     */
    private String projectPrice;

    /**
     * 数量
     * 23
     * X
     */
    private String projectCount;


    /**
     * 自费比例
     * 24
     * Y
     */
    private String patientPayRatio;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getMainDisease() {
        return mainDisease;
    }

    public void setMainDisease(String mainDisease) {
        this.mainDisease = mainDisease;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getMedicalType() {
        return medicalType;
    }

    public void setMedicalType(String medicalType) {
        this.medicalType = medicalType;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        depart = depart;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getInnerDisease() {
        return innerDisease;
    }

    public void setInnerDisease(String innerDisease) {
        this.innerDisease = innerDisease;
    }

    public String getOuterDisease() {
        return outerDisease;
    }

    public void setOuterDisease(String outerDisease) {
        this.outerDisease = outerDisease;
    }

    public String getAnesthesia() {
        return anesthesia;
    }

    public void setAnesthesia(String anesthesia) {
        this.anesthesia = anesthesia;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDays() {
        return serviceDays;
    }

    public void setServiceDays(String serviceDays) {
        this.serviceDays = serviceDays;
    }

    public String getHospitalPrice() {
        return hospitalPrice;
    }

    public void setHospitalPrice(String hospitalPrice) {
        this.hospitalPrice = hospitalPrice;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayAmountPart() {
        return payAmountPart;
    }

    public void setPayAmountPart(String payAmountPart) {
        payAmountPart = payAmountPart;
    }

    public String getPayAmountPartPrice() {
        return payAmountPartPrice;
    }

    public void setPayAmountPartPrice(String payAmountPartPrice) {
        payAmountPartPrice = payAmountPartPrice;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectInsuranceType() {
        return projectInsuranceType;
    }

    public void setProjectInsuranceType(String projectInsuranceType) {
        this.projectInsuranceType = projectInsuranceType;
    }

    public String getProjectPrice() {
        return projectPrice;
    }

    public void setProjectPrice(String projectPrice) {
        this.projectPrice = projectPrice;
    }

    public String getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(String projectCount) {
        this.projectCount = projectCount;
    }

    public String getPatientPayRatio() {
        return patientPayRatio;
    }

    public void setPatientPayRatio(String patientPayRatio) {
        this.patientPayRatio = patientPayRatio;
    }

    @Override
    public String toString() {
        return "ExcelImportDTO{" +
                "patientId='" + patientId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", mainDisease='" + mainDisease + '\'' +
                ", insuranceType='" + insuranceType + '\'' +
                ", medicalType='" + medicalType + '\'' +
                ", depart='" + depart + '\'' +
                ", hospital='" + hospital + '\'' +
                ", district='" + district + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", innerDisease='" + innerDisease + '\'' +
                ", outerDisease='" + outerDisease + '\'' +
                ", anesthesia='" + anesthesia + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDays=" + serviceDays +
                ", hospitalPrice=" + hospitalPrice +
                ", payType='" + payType + '\'' +
                ", payAmount='" + payAmount + '\'' +
                ", payAmountPart='" + payAmountPart + '\'' +
                ", payAmountPartPrice='" + payAmountPartPrice + '\'' +
                ", project='" + project + '\'' +
                ", projectType='" + projectType + '\'' +
                ", projectInsuranceType='" + projectInsuranceType + '\'' +
                ", projectPrice=" + projectPrice +
                ", projectCount=" + projectCount +
                ", patientPayRatio='" + patientPayRatio + '\'' +
                '}';
    }
}


