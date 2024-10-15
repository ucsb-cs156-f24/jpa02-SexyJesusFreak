package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    
    // Test case 1: Same object
    @Test
    public void equals_sameObject_returnsTrue() {
        assertTrue(team.equals(team));
    }

    // Test case 2: Different class
    @Test
    public void equals_differentClass_returnsFalse() {
        assertFalse(team.equals("not a team"));
    }

    // Test case 3.1: Different name, same members
    @Test
    public void equals_differentName_returnsFalse() {
        Team other = new Team("different-name");
        other.setMembers(new ArrayList<>());
        assertFalse(team.equals(other));
    }

    // Test case 3.2: Same name, different members
    @Test
    public void equals_differentMembers_returnsFalse() {
        Team other = new Team("test-team");
        ArrayList<String> differentMembers = new ArrayList<>();
        differentMembers.add("member1");
        other.setMembers(differentMembers);
        assertFalse(team.equals(other));
    }

    // Test case 3.3: Different name, different members
    @Test
    public void equals_differentNameAndMembers_returnsFalse() {
        Team other = new Team("different-name");
        ArrayList<String> differentMembers = new ArrayList<>();
        differentMembers.add("member1");
        other.setMembers(differentMembers);
        assertFalse(team.equals(other));
    }

    // Test case 3.4: Same name, same members
    @Test
    public void equals_sameNameAndMembers_returnsTrue() {
        Team other = new Team("test-team");
        other.setMembers(new ArrayList<>());
        assertTrue(team.equals(other));
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
