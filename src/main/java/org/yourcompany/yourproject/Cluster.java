
/**
 * Cluster.java
 *
 * KIT107 Assignment 2 -- Cluster Implementation
 *
 * @author <<your name and student ID number>>
 * @version	<<date of completion>>
 */
public class Cluster implements ClusterInterface {
    // instance variables

    protected String bundleName;        // candidate for whom this cluster of votes is for

    protected double weightedCount;     // weight of votes in this cluster

    protected int rawCount;             //  a raw count of votes in this cluster

    protected Node first;               // the head of the linked list of ballots

    protected Node last;                // tail of the linked list of ballots (for O(1) append) //finished (possibly, this is all i could think of needding at the time)

    // raw count of votes in this cluster
    /**

          *** Constructor

          ***
     *
     * @param candidate String -- the name of the candidate whose votes * this
     * bundle (cluster) is for
     *
     *

          *** Precondition: The String is defined and unique

          *** Postcondition: The new instance will have its instance variable(s)
     *
     * initialised to indicate an empty cluster.

          *** Informally: Initialise the cluster of ballots.

          **
     */
    public Cluster(String candidate) {//finished

        bundleName = candidate;
        weightedCount = 0;
        rawCount = 0;
        first = null;
        last = null;

    }

    /**

          *** isEmpty()

          *** @return boolean -- whether the cluster is empty

          *** Precondition: None

          *** Postcondition: True is returned if the Cluster is empty; false is
     * returned otherwise.

          *** Informally: Check whether the Cluster is empty.

          **
     */
    public boolean isEmpty() { ///finished

        return (first == null);

    }

    /**

          ** getFirstBallot()

          **

          ** @return Ballot -- the first ballot paper in the cluster

          **

          ** Precondition: None

          ** Postcondition: the first ballot in the cluster is returned if the
     *
     * cluster is non-empty; null is returned otherwise.

          ** Informally: Get the first ballot paper in the cluster.

          **/
    public Ballot getFirstBallot() { //finishedd

        Ballot result;  // the result of the method

        result = null;

        if (!isEmpty()) {

            result = (Ballot) first.getData();

        }

        return result;

    }

    /**
     * getRawCount()
     *
     * @return int -- the raw count of ballot papers in the cluster
     *
     * Precondition: None Postcondition: the raw count of ballots in the cluster
     * is returned. Informally: Get the count of ballots in the cluster.
     */
    public int getRawCount() { //dont need to change, getter method already done
        return rawCount;
    }

    /**
     * getWeightedCount()
     *
     * @return double -- the weighted count of ballot papers in the cluster
     *
     * Precondition: None Postcondition: the weighted count of ballots in the
     * cluster is returned. Informally: Get the weighted count of ballots in the
     * cluster.
     */
    public double getWeightedCount() { //dont need to change, getter method already done
        return weightedCount;
    }

    /**
     * getBundleName()
     *
     * @return String -- the name of the candidate that is the recipient of this
     * cluster of ballots
     *
     * Precondition: None Postcondition: the name of the bundle is returned.
     * Informally: Get the cluster's candidate name.
     */
    public String getBundleName() {//dont need to change, getter method already done
        return bundleName;
    }

    /**
     * addBallotToCluster()
     *
     * @param votes Ballot -- the ballot paper to add to this cluster
     *
     * Precondition: The given Ballot parameter has been constructed.
     * Postcondition: The given Ballot has been added to the Cluster of ballot
     * papers ordered by descending preference. Informally: Add a ballot paper
     * to the Cluster.
     */
    public void addBallotToCluster(Ballot votes) { //next up

    }

    /**
     * votesFor()
     *
     * @param candidate String -- the candidate to count the votes of
     * @param preference int -- the preference to count the votes for
     *
     * @return int -- the count of votes for the given candidate of the given
     * preference
     *
     * Precondition: None Postcondition: the first ballot in the cluster is
     * returned if the cluster is non-empty; null is returned otherwise.
     * Informally: Get the first ballot paper in the cluster.
     */
    public int votesFor(String candidate, int preference) {
//COMPLETE ME!!!
        return -1;  // change me -- this is just to allow the program to compile
    }

    /**
     * transfer()
     *
     * @param residiual double -- the residual weight to be allocated to the
     * ballot being transferred
     *
     * @return Ballot -- the ballot removed from the current cluster which is to
     * be moved to another cluster with the given weight
     *
     * Precondition: None Postcondition: the first ballot in the cluster is
     * removed, the selection is updated to the next preference, the weight is
     * altered if the residual is not full weight, and then the ballot is
     * returned. null is returned if the cluster is empty. Informally: Prepare
     * the first ballot of the cluster to be moved to the cluster of its next
     * preference, and remove it from this cluster.
     */
    public Ballot transfer(double residual) {
//COMPLETE ME!!!
        return null;  // change me -- this is just to allow the program to compile
    }

    /**
     * toString()
     *
     * @return String -- printable form of the Cluster of ballots
     *
     * Precondition: None Postcondition: A printable (String) form of the ballot
     * data is returned. If there are no ballot papers then "" is returned.
     * Informally: Convert the Cluster of ballot data to a multi-line String.
     */
    public String toString() {
//COMPLETE ME!!!
        return "UNFINISHED";  // change me -- this is just to allow the program to compile
    }
}
