package com.kpi.course_work.model.general;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Response {

    private int[][] costs;
    private int[][] paths;

    public static Response of(int[][] costs, int[][] paths) {
        Response response = new Response();

        response.setCosts(costs);
        response.setPaths(paths);

        return response;
    }

    public int[][] getCosts() {
        return costs;
    }

    public void setCosts(int[][] costs) {
        this.costs = costs;
    }

    public int[][] getPaths() {
        return paths;
    }

    public void setPaths(int[][] paths) {
        this.paths = paths;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("costs", costs)
                .append("paths", paths)
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
        Response rhs = (Response) obj;
        return new EqualsBuilder()
                .append(this.costs, rhs.costs)
                .append(this.paths, rhs.paths)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(costs)
                .append(paths)
                .toHashCode();
    }
}
