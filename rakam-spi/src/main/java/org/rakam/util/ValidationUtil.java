package org.rakam.util;

import static com.google.common.base.Preconditions.checkNotNull;


public class ValidationUtil {
    public static void checkProject(String project) {
        checkNotNull(project, "project is null");
        if(!project.matches("^[0-9A-Za-z]+$")) {
            throw new IllegalArgumentException("Project id is not valid.");
        }
    }
    public static void checkCollection(String collection) {
        checkNotNull(collection, "collection is null");
        if(!collection.matches("^[a-zA-Z_][a-zA-Z0-9_]*$")) {
            throw new IllegalArgumentException("Collection is not valid.");
        }
    }

    public static String checkTableColumn(String column, String type) {
        checkNotNull(type, type+" is null");
        if(!column.matches("^[a-zA-Z_][a-zA-Z0-9_]*$")) {
            throw new IllegalArgumentException(type+" is not valid.");
        }
        return column;
    }
}
