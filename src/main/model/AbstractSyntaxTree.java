package main.model;

/**
 * Model class to represent an AbstractSyntaxTree made out of Token-instances. Contains only the root.
 */
public class AbstractSyntaxTree {
    public Token root;

    /**
     * Default constructor.
     */
    public AbstractSyntaxTree() {
    }

    /**
     * Runs through the tree to build a string in the output format.
     *
     * @return A readable string showing the tree-nodes on their according levels.
     */
    public String getOutputFormat() {
        return root.getAsTree(0, new StringBuilder());
    }
}
