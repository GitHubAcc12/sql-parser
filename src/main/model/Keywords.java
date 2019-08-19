package main.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keywords {
    public static final String[] STATEMENTS = {"SELECT", "INSERT", "DELETE", "USE", "INSERT INTO", "DELETE FROM"};
    public static final String[] CLAUSES = {"WHERE", "FROM", "INTO", "IS", "ORDER", "BY", "ORDER BY"};
    public static final String[] CONSTRAINTS = {"NOT", "NULL", "NOT NULL"};
    public static final String[] BINARY_OPERATORS = {"<"};
    public static final String[] COMPOSITE_KEYWORDS_FIRST_HALFS = {"ORDER", "NOT", "INSERT", "DELETE"};

    private static String[] allKeywords;

    public static String[] getAllKeywords() {
        if (allKeywords == null) {
            final List<String> tmpAllKeywords = new ArrayList<>();
            for (final String[] arr : new String[][]{STATEMENTS, CONSTRAINTS, CLAUSES, BINARY_OPERATORS}) {
                tmpAllKeywords.addAll(Arrays.asList(arr));
            }
            allKeywords = (String[]) tmpAllKeywords.toArray();
        }
        return allKeywords;
    }


}
