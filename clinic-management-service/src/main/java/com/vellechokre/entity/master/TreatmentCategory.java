// package com.vellechokre.entity.master;
//
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
//
// import com.vellechokre.entity.EntityContant;
//
/// **
// * Project clinic-management-service
// *
// * @author nishant.bhardwaz
// * @version 1.0
// * @date Sep 2, 2019
// */
// @Entity(name = EntityContant.TREATMENT_CATEGORY)
// public class TreatmentCategory {
//
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Integer treatmentCategoryId;
//
// private String description;
//
// private Integer charge;
//
// @ManyToOne
// @JoinColumn(name = "treatmentTypeId")
// private TreatmentType treatmentType;
//
// /**
// * @return the treatmentCategoryId
// */
// public Integer getTreatmentCategoryId() {
//
// return treatmentCategoryId;
// }
//
// /**
// * @param treatmentCategoryId the treatmentCategoryId to set
// */
// public void setTreatmentCategoryId(final Integer treatmentCategoryId) {
//
// this.treatmentCategoryId = treatmentCategoryId;
// }
//
// /**
// * @return the description
// */
// public String getDescription() {
//
// return description;
// }
//
// /**
// * @param description the description to set
// */
// public void setDescription(final String description) {
//
// this.description = description;
// }
//
// /**
// * @return the charge
// */
// public Integer getCharge() {
//
// return charge;
// }
//
// /**
// * @param charge the charge to set
// */
// public void setCharge(final Integer charge) {
//
// this.charge = charge;
// }
//
// /**
// * @return the treatmentType
// */
// public TreatmentType getTreatmentType() {
//
// return treatmentType;
// }
//
// /**
// * @param treatmentType the treatmentType to set
// */
// public void setTreatmentType(final TreatmentType treatmentType) {
//
// this.treatmentType = treatmentType;
// }
// }
