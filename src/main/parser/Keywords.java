package main.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keywords {
    public static final String[] STATEMENTS = {"SELECT", "INSERT", "DELETE", "USE"};
    public static final String[] CLAUSES = {"WHERE", "FROM", "INTO", "IS", "ORDER", "BY"};
    public static final String[] CONSTRAINTS = {"NOT", "NULL"};
    public static final String[] OPERATORS = {"<"};

    public static String[] allKeywords;

    public static String[] getAllKeywords() {
        if (allKeywords == null) {
            final List<String> tmpAllKeywords = new ArrayList<>();
            for (final String[] arr : new String[][]{STATEMENTS, CONSTRAINTS, CLAUSES, OPERATORS}) {
                tmpAllKeywords.addAll(Arrays.asList(arr));
            }
            allKeywords = (String[]) tmpAllKeywords.toArray();
        }
        return allKeywords;
    }


}
