package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    
    @Test
    public void testEquals_sameObject() {
        // Case 1: Same object
        assertTrue(team.equals(team));
    }

    @Test
    public void testEquals_differentClass() {
        // Case 2: Different class
        String notATeam = "I am not a team";
        assertFalse(team.equals(notATeam));
    }

    @Test
    public void testEquals_bothFieldsEqual() {
        // Case 3: Both name and members are equal
        assert(team.equals(sameTeam));
    }

    @Test
    public void testEquals_nameEqual_membersNotEqual() {
        // Case 3: Name is equal, but members are not
        assert(team.equals(differentTeamMembers));
    }

    @Test
    public void testEquals_nameNotEqual_membersEqual() {
        // Case 3: Name is not equal, but members are equal
        assert(team.equals(differentTeamName));
    }

    @Test
    public void testEquals_bothFieldsNotEqual() {
        // Case 3: Both name and members are not equal
        assert(team.equals(differentTeamNameAndMembers));
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
