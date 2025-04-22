package exam2022.problem4;

import java.util.ArrayList;
import java.util.HashMap;

public class VoteCounter {
    private HashMap<String, Integer> voteCounts;

    public VoteCounter(ArrayList<String> names) {
        this.voteCounts = new HashMap<>();
        for (String name : names) {
            this.voteCounts.put(name, 0);
        }
    }

    public void voteFor(String option) throws VoteException {
        if (!voteCounts.containsKey(option)) {
            throw new VoteException();
        }
        voteCounts.put(option, voteCounts.get(option) + 1);
    }

    public int getVoteCount(String option) throws VoteException {
        if (!voteCounts.containsKey(option)) {
            throw new VoteException();
        }
        return voteCounts.get(option);
    }
}
