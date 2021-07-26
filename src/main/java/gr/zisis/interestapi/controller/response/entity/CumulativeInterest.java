package gr.zisis.interestapi.controller.response.entity;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author George Digkas <digasgeo@gmail.com>
 *
 */
public class CumulativeInterest {
	
	private String sha;
	private Integer revisionCount;
	private BigDecimal interestEu;
	
	public CumulativeInterest() { }
	
	public CumulativeInterest(String sha, Integer revisionCount, BigDecimal interestEu) {
		this.sha = sha;
		this.revisionCount = revisionCount;
		this.interestEu = interestEu;
	}

	public String getSha() {
		return sha;
	}

	public void setSha(String sha) {
		this.sha = sha;
	}

	public int getRevisionCount() {
		return revisionCount;
	}

	public void setRevisionCount(Integer revisionCount) {
		this.revisionCount = revisionCount;
	}

	public BigDecimal getInterestEu() {
		return interestEu;
	}

	public void setInterestEu(BigDecimal interestEu) {
		this.interestEu = interestEu;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CumulativeInterest that = (CumulativeInterest) o;
		return Objects.equals(sha, that.sha) && Objects.equals(revisionCount, that.revisionCount) && Objects.equals(interestEu, that.interestEu);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sha, revisionCount, interestEu);
	}
}
