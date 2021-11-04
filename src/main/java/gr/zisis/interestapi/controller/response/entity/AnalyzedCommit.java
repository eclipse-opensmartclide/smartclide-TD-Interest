package gr.zisis.interestapi.controller.response.entity;

import java.util.Objects;

public class AnalyzedCommit implements Comparable<AnalyzedCommit> {
    private String sha;
    private Long revisionCount;

    public AnalyzedCommit() { }

    public AnalyzedCommit(String sha, Long revisionCount) {
        this.sha = sha;
        this.revisionCount = revisionCount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalyzedCommit that = (AnalyzedCommit) o;
        return Objects.equals(sha, that.sha) && Objects.equals(revisionCount, that.revisionCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sha, revisionCount);
    }

    @Override
    public int compareTo(AnalyzedCommit o) {
        if (this.revisionCount - o.revisionCount < 0)
            return -1;
        else if (this.revisionCount - o.revisionCount > 0)
            return 1;
        else
            return 0;
    }
}