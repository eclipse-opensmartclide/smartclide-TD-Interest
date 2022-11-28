package org.eclipse.opensmartclide.tdreusabilityapi.service.principal.analysis.parser.infrastructure.entities;

import java.util.Objects;

public final class CodeRange {

    private final Integer startLine;
    private final Integer endLine;

    public CodeRange (Integer startLine, Integer endLine) {
        this.startLine = startLine;
        this.endLine = endLine;
    }

    public Integer getStartLine() {
        return startLine;
    }

    public Integer getEndLine() {
        return endLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeRange codeRange = (CodeRange) o;
        return Objects.equals(Math.abs(startLine - endLine), Math.abs(codeRange.startLine - codeRange.endLine));
    }

    @Override
    public int hashCode() {
        return Objects.hash(startLine, endLine);
    }

    @Override
    public String toString() {
        return "[" + this.getStartLine() + "," + this.getEndLine() + "]";
    }
}
