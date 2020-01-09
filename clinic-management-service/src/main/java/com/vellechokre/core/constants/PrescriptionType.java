package com.vellechokre.core.constants;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 7, 2020
 */
public enum PrescriptionType {
    ORIGINAL("(Original for Recipient)"), DUPLICATE("(Duplicate)");

    private final String value;

    /**
     * @param value
     */
    private PrescriptionType(final String value) {

        this.value = value;
    }

    public static PrescriptionType get(final String type) {

        for (final PrescriptionType invoiceType : values()) {
            if (invoiceType.getValue().equals(type)) {
                return invoiceType;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + type + "]");
    }

    /**
     * @return the value
     */
    public String getValue() {

        return value;
    }
}
