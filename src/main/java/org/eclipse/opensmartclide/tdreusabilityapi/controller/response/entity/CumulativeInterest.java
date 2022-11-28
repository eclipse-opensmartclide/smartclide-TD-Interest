/*******************************************************************************
 * Copyright (C) 2021-2022 University of Macedonia
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package org.eclipse.opensmartclide.tdreusabilityapi.controller.response.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @author George Digkas <digasgeo@gmail.com>
 *
 */
public class CumulativeInterest {
	
	private String sha;
	private Long revisionCount;
	private BigDecimal interestEu;
	private BigDecimal interestHours;

	public CumulativeInterest() { }
	
	public CumulativeInterest(String sha, Long revisionCount, BigDecimal interestEu, BigDecimal interestHours) {
		this.sha = sha;
		this.revisionCount = revisionCount;
		this.interestEu = interestEu;
		this.interestHours = interestHours;
	}

	public CumulativeInterest(String sha, Long revisionCount, Double interestEu, Double interestHours) {
		this.sha = sha;
		this.revisionCount = revisionCount;
		this.interestEu = new BigDecimal(interestEu);
		this.interestHours = new BigDecimal(interestHours);
	}

	public String getSha() {
		return sha;
	}

	public void setSha(String sha) {
		this.sha = sha;
	}

	public Long getRevisionCount() {
		return revisionCount;
	}

	public void setRevisionCount(Long revisionCount) {
		this.revisionCount = revisionCount;
	}

	public BigDecimal getInterestEu() {
		return interestEu.setScale(2, RoundingMode.HALF_UP);
	}

	public void setInterestEu(BigDecimal interestEu) {
		this.interestEu = interestEu;
	}

	public BigDecimal getInterestHours() {
		return interestHours.setScale(1, RoundingMode.HALF_UP);
	}

	public void setInterestHours(BigDecimal interestHours) {
		this.interestHours = interestHours;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CumulativeInterest that = (CumulativeInterest) o;
		return Objects.equals(sha, that.sha) && Objects.equals(revisionCount, that.revisionCount) && Objects.equals(interestEu, that.interestEu) && Objects.equals(interestHours, that.interestHours);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sha, revisionCount, interestEu, interestHours);
	}
}
