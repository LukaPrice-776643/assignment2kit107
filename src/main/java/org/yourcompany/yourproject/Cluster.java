package org.yourcompany.yourproject;

//nvm it started working again after adding packages

/**
 * Cluster.java
 *
 * KIT107 Assignment 2 -- Cluster Implementation
 *
 * @author Luka Price 776643
 * @version	23/09/26
 */
public class Cluster implements ClusterInterface {
    // instance variables, (fixed for arrray.)

		final protected int INITIAL_CAPACITY = 16;  // starting size of the ballots array

    protected String bundleName;        // candidate for whom this cluster of votes is for

    protected double weightedCount;     // weight of votes in this cluster

    protected int rawCount;             //  a raw count of votes in this cluster

    protected Ballot[] ballots;         // array holding the ballots in this cluster

    protected int numBallots;           // number of ballots currently stored in the array

    // raw count of votes in this cluster
    /**

          ***** Constructor

          *****
     *
     * @param candidate String -- the name of the candidate whose votes * this
     * bundle (cluster) is for
     *
     *

          ***** Precondition: The String is defined and unique

          ***** Postcondition: The new instance will have its instance variable(s)
     *
     * initialised to indicate an empty cluster.

          ***** Informally: Initialise the cluster of ballots.

          ****
     */
    public Cluster(String candidate) {//fixed.

        bundleName = candidate;
        weightedCount = 0;
        rawCount = 0;
        ballots = new Ballot[INITIAL_CAPACITY];
        numBallots = 0;


    }

    

    /**

          ***** isEmpty()

          ***** @return boolean -- whether the cluster is empty

          ***** Precondition: None

          ***** Postcondition: True is returned if the Cluster is empty; false is
     * returned otherwise.

          ***** Informally: Check whether the Cluster is empty.

          ****
     */
    public boolean isEmpty() {
        ///fixed

          return (numBallots == 0);
    }

    /**

          **** getFirstBallot()

          ****

          **** @return Ballot -- the first ballot paper in the cluster

          ****

          **** Precondition: None

          **** Postcondition: the first ballot in the cluster is returned if the
     *
     * cluster is non-empty; null is returned otherwise.

          **** Informally: Get the first ballot paper in the cluster.

          ***
     */
    public Ballot getFirstBallot() { //fixed

        Ballot result;  // the result of the method

        result = null;

        if (!isEmpty()) {

            result = ballots[0];

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
     * @return String, the name of the candidate that is the recipient of this
     * cluster of ballots
     *
     * Precondition: None Postcondition: the name of the bundle is returned.
     * Informally: Get the cluster's candidate name.
     */
    public String getBundleName() {//dont need to change, getter method already done
        return bundleName;
    }
    /**
     * grow()
     * 
     * Precondition: None
     * Postcondition: the capacity of the ballots array has been doubled,
     *                  preserving all existing entries.
     * Informally: Make room for more ballots once the array is full.
     */
    protected void grow() //added this for addBallotToCluster()
    {
        final int GROWTH_FACTOR = 2;  // how much bigger the new array should be
 
        Ballot []bigger;    // the enlarged array
 
        bigger = new Ballot[ballots.length * GROWTH_FACTOR];
        for (int i = 0; i < numBallots; i++)
        {
            bigger[i] = ballots[i];
        }
        ballots = bigger;
    }
 

    /**
     * addBallotToCluster()
     *
     * @param votes Ballot, the ballot paper to add to this cluster
     *
     * Precondition: The given Ballot parameter has been constructed.
     * Postcondition: The given Ballot has been added to the Cluster of ballot
     * papers ordered by descending preference. Informally: Add a ballot paper
     * to the Cluster.
     */
    public void addBallotToCluster(Ballot votes) { //fixed

        int i; //index variable, local.

        if (numBallots == ballots.length) {
            grow();
        }
        //shift each entry to allow placment of new entry.
        i = numBallots - 1;
        while ((i >= 0) && (ballots[i].getChoice() < votes.getChoice())) {
            ballots[i + 1] = ballots[i];

        }
        ballots[i + 1] = votes;
        numBallots++;

        rawCount++;
        weightedCount += votes.getWeight();

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
    public int votesFor(String candidate, int preference) { //fixed

        int count;

        Ballot ballot;
 
        count = 0;
        for (int i = 0; i < numBallots; i++) {
            ballot = ballots[i];
            if ((preference < ballot.getMaxVote()) && ballot.getVotes()[preference].equalsIgnoreCase(candidate)) {
                count++;
            }
        }

        return count;
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
     * Precondition: None. Postcondition: the first ballot in the cluster is
     * removed, the selection is updated to the next preference, the weight is
     * altered if the residual is not full weight, and then the ballot is
     * returned. null is returned if the cluster is empty. Informally: Prepare
     * the first ballot of the cluster to be moved to the cluster of its next
     * preference, and remove it from this cluster.
     */
    public Ballot transfer(double residual) { //finished
		final double FULL = -1; //keep ballots existinbg weight

		Ballot result;

		result = null;

		if (! isEmpty()){
			result = ballots[0];

			for (int i = 0; i < numBallots - 1; i++){
				ballots[i] = ballots [i + 1];
			}
			ballots[numBallots - 1] = null;
			numBallots--;

			rawCount--;
			weightedCount -= result.getWeight();

			result.update();


			if (residual != FULL){
				result.setWeight(residual);
			}

		}
		return result;
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
		String r; //results

		r = " ";
		if (isEmpty()){
			r += "Bundle:" + bundleName + "/n";

			for (int i = 0; i < numBallots; i++){
				r += ballots[i].toString() + "/n";
			}
		}
		return r;
    }
}
