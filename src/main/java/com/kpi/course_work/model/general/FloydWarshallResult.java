package com.kpi.course_work.model.general;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FloydWarshallResult {

    private double durationParallel;
    private double durationSequential;
    private int[][] adjacencyMatrix;
    private Response parallelResponse;
    private Response sequentialResponse;

    public double getDurationParallel() {
        return durationParallel;
    }

    public void setDurationParallel(double durationParallel) {
        this.durationParallel = durationParallel;
    }

    public FloydWarshallResult durationParallel(double durationParallel) {
        this.durationParallel = durationParallel;
        return this;
    }

    public double getDurationSequential() {
        return durationSequential;
    }

    public void setDurationSequential(double durationSequential) {
        this.durationSequential = durationSequential;
    }

    public FloydWarshallResult durationSequential(double durationSequential) {
        this.durationSequential = durationSequential;
        return this;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public FloydWarshallResult adjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        return this;
    }

    public Response getParallelResponse() {
        return parallelResponse;
    }

    public void setParallelResponse(Response parallelResponse) {
        this.parallelResponse = parallelResponse;
    }

    public FloydWarshallResult parallelResponse(Response parallelResponse) {
        this.parallelResponse = parallelResponse;
        return this;
    }

    public Response getSequentialResponse() {
        return sequentialResponse;
    }

    public void setSequentialResponse(Response sequentialResponse) {
        this.sequentialResponse = sequentialResponse;
    }

    public FloydWarshallResult sequentialResponse(Response sequentialResponse) {
        this.sequentialResponse = sequentialResponse;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("durationParallel", durationParallel)
                .append("durationSequential", durationSequential)
                .append("adjacencyMatrix", adjacencyMatrix)
                .append("parallelResponse", parallelResponse)
                .append("sequentialResponse", sequentialResponse)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        FloydWarshallResult rhs = (FloydWarshallResult) obj;
        return new EqualsBuilder()
                .append(this.durationParallel, rhs.durationParallel)
                .append(this.durationSequential, rhs.durationSequential)
                .append(this.adjacencyMatrix, rhs.adjacencyMatrix)
                .append(this.parallelResponse, rhs.parallelResponse)
                .append(this.sequentialResponse, rhs.sequentialResponse)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(durationParallel)
                .append(durationSequential)
                .append(adjacencyMatrix)
                .append(parallelResponse)
                .append(sequentialResponse)
                .toHashCode();
    }
}
