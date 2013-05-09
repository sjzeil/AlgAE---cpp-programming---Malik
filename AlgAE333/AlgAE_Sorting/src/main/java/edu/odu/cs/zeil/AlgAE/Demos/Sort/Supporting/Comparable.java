package /*{*/edu.odu.cs.zeil.AlgAE.Demos.Sort./*}*/Supporting;
/*{*/import edu.odu.cs.zeil.AlgAE.Server.Visible;

/**
 * Protocol for Comparable objects.
 * @author Mark Allen Weiss
 */
public interface Comparable /*{*/extends Visible
{
    /**
     * Compare this object with rhs.
     * @param Rhs the second Comparable.
     * @return 0 if two objects are equal;
     *     less than zero if this object is smaller;
     *     greater than zero if this object is larger.
     */
    int     compares( Comparable rhs );

    /**
     * Compare this object with rhs.
     * @param Rhs the second Comparable.
     * @return true if this object is smaller;
     *     false otherwise.
     */
    boolean lessThan( Comparable rhs );
}
