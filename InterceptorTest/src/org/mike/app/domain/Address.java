// Copyright (c) 1998-2013 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2013-XX-XX, Mike.Mai, creation
// ============================================================================

package org.mike.app.domain;

/**
 * @author Mike.Mai
 *
 */
public class Address {
    private Integer addressId;
    private String addressDetail;
    /**
     * @return the addressId
     */
    public Integer getAddressId() {
        return addressId;
    }
    /**
     * @param addressId the addressId to set
     */
    public void setAddressId(final Integer addressId) {
        this.addressId = addressId;
    }
    /**
     * @return the addressDetail
     */
    public String getAddressDetail() {
        return addressDetail;
    }
    /**
     * @param addressDetail the addressDetail to set
     */
    public void setAddressDetail(final String addressDetail) {
        this.addressDetail = addressDetail;
    }


}
