package exam2012.problem3;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<String> options = new ArrayList<>();
        options.add("A");
        options.add("B");
        options.add("C");
        VoteCounter vc = new VoteCounter(options);
        try {
            vc.voteFor("A");
            vc.voteFor("B");
            vc.voteFor("A");
            vc.voteFor("C");
            vc.voteFor("A");
            vc.voteFor("B");
            vc.voteFor("A");
            vc.voteFor("C");
            vc.voteFor("A");
            vc.voteFor("B");
            vc.voteFor("A");
            vc.voteFor("C");
            vc.voteFor("A");

            System.out.println(vc.getVoteCount("A"));
            System.out.println(vc.getVoteCount("B"));
            System.out.println(vc.getVoteCount("C"));
        } catch (VoteException e) {
            e.printStackTrace();
        }
    }
}
