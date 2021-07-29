package gr.zisis.interestapi.controller.response.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class HighInterestFile {
    private String sha;
    private Long revisionCount;
    private String filePath;
    private BigDecimal interestEu;
    private BigDecimal interestHours;
    private BigDecimal interestPercentageOfProject;

    public HighInterestFile() { }

    public HighInterestFile(String sha, Long revisionCount, String filePath, BigDecimal interestEu, BigDecimal interestHours, BigDecimal interestPercentageOfProject) {
        this.sha = sha;
        this.revisionCount = revisionCount;
        this.filePath = filePath;
        this.interestEu = interestEu;
        this.interestHours = interestHours;
        this.interestPercentageOfProject = interestPercentageOfProject;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public BigDecimal getInterestEu() {
        return interestEu;
    }

    public void setInterestEu(BigDecimal interestEu) {
        this.interestEu = interestEu;
    }

    public BigDecimal getInterestPercentageOfProject() {
        return interestPercentageOfProject;
    }

    public void setInterestPercentageOfProject(BigDecimal interestPercentageOfProject) {
        this.interestPercentageOfProject = interestPercentageOfProject;
    }

    public BigDecimal getInterestHours() {
        return interestHours;
    }

    public void setInterestHours(BigDecimal interestHours) {
        this.interestHours = interestHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HighInterestFile that = (HighInterestFile) o;
        return Objects.equals(sha, that.sha) && Objects.equals(revisionCount, that.revisionCount) && Objects.equals(filePath, that.filePath) && Objects.equals(interestEu, that.interestEu) && Objects.equals(interestHours, that.interestHours) && Objects.equals(interestPercentageOfProject, that.interestPercentageOfProject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sha, revisionCount, filePath, interestEu, interestHours, interestPercentageOfProject);
    }
}
