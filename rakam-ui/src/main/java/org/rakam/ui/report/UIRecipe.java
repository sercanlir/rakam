package org.rakam.ui.report;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.rakam.collection.FieldType;
import org.rakam.collection.SchemaField;
import org.rakam.plugin.MaterializedView;
import org.rakam.ui.DashboardService;
import org.rakam.ui.customreport.CustomReport;
import org.rakam.ui.page.CustomPageDatabase.Page;
import org.rakam.ui.report.Report;

import javax.inject.Inject;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UIRecipe {
    private final List<Report> reports;
    private final List<CustomReport> customReports;
    private final List<Page> customPages;
    private final List<DashboardBuilder> dashboards;

    @JsonCreator
    public UIRecipe(@JsonProperty("custom_reports") List<CustomReport> customReports,
                    @JsonProperty("custom_pages") List<Page> customPages,
                    @JsonProperty("dashboards") List<DashboardBuilder> dashboards,
                    @JsonProperty("reports") List<Report> reports) {
        this.customReports = customReports == null ? ImmutableList.of() : customReports;
        this.customPages = customPages == null ? ImmutableList.of() : customPages;
        this.reports = reports == null ? ImmutableList.of() : ImmutableList.copyOf(reports);
        this.dashboards = dashboards == null ? ImmutableList.of() : ImmutableList.copyOf(dashboards);
    }

    @JsonProperty("custom_pages")
    public List<Page> getCustomPages() {
        return customPages;
    }

    @JsonProperty("custom_reports")
    public List<CustomReport> getCustomReports() {
        return customReports;
    }

    @JsonProperty("dashboards")
    public List<DashboardBuilder> getDashboards() {
        return dashboards;
    }

    @JsonProperty("reports")
    public List<Report> getReports() {
        return reports;
    }

    public static class DashboardBuilder {
        public final String name;
        public final List<DashboardService.DashboardItem> items;

        @JsonCreator
        public DashboardBuilder(
                @JsonProperty("name") String name,
                @JsonProperty("items") List<DashboardService.DashboardItem> items) {
            this.name = name;
            this.items = items;
        }
    }
}
