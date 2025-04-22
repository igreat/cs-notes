package exam2012.problem3;

import java.util.ArrayList;
import java.util.HashMap;

public class VoteCounter {
    HashMap<String, Integer> voteCounts;

    public VoteCounter(ArrayList<String> options) {
        voteCounts = new HashMap<>();
        for (String option : options) {
            voteCounts.put(option, 0);
        }
    }

    public void voteFor(String option) throws VoteException {
        if (!voteCounts.containsKey(option)) {
            throw new VoteException("Voting option not valid");
        }
        voteCounts.put(option, getVoteCount(option) + 1);
    }

    public int getVoteCount(String option) throws VoteException {
        if (!voteCounts.containsKey(option)) {
            throw new VoteException("Voting option not valid");
        }
        return voteCounts.get(option);
    }
}