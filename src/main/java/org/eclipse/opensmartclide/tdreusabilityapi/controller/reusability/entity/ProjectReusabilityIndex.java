/*******************************************************************************
 * Copyright (C) 2021-2022 UoM - University of Macedonia
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package org.eclipse.opensmartclide.tdreusabilityapi.controller.reusability.entity;

import java.util.Objects;

public class ProjectReusabilityIndex implements Comparable<ProjectReusabilityIndex> {
    private String sha;
    private Long revisionCount;
    private Double index;

    public ProjectReusabilityIndex() { }

    public ProjectReusabilityIndex(String sha, Long revisionCount, Double index) {
        this.sha = sha;
        this.revisionCount = revisionCount;
        this.index = index;
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

    public Double getIndex() {
        return index;
    }

    public void setIndex(Double index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectReusabilityIndex that = (ProjectReusabilityIndex) o;
        return Objects.equals(sha, that.sha) && Objects.equals(revisionCount, that.revisionCount) && Objects.equals(index, that.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sha, revisionCount, index);
    }

    @Override
    public int compareTo(ProjectReusabilityIndex o) {
        if (this.revisionCount - o.revisionCount < 0)
            return -1;
        else if (this.revisionCount - o.revisionCount > 0)
            return 1;
        else
            return 0;
    }
}
