package main.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class containing the keywords used in the operations.sql file as constants. Maybe this should be outsourced to a
 * config file. Also it would probably be better to distinct between the different things that are now just viewed as
 * "Parameters" (everything that is not listed here).
 */
public class Keywords {
    public static final String[] STATEMENTS = {"SELECT", "INSERT", "DELETE", "USE", "DELETE FROM"};
    public static final String[] CLAUSES = {"WHERE", "FROM", "INTO", "ORDER", "BY", "ORDER BY", "VALUES"};
    public static final String[] CONSTRAINTS = {"NOT", "NULL", "NOT NULL"};
    public static final String[] BINARY_OPERATORS = {"<", "IS"};
    public static final String[] COMPOSITE_KEYWORDS_FIRST_HALFS = {"ORDER", "NOT", "DELETE"};

    private static String[] allKeywords;

    /**
     * Puts all keywords together to one array to be quicker when checking whether one word is a keyword.
     *
     * @return A list of all the keywords.
     */
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
