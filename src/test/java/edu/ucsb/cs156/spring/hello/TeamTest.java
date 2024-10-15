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
public void testEquals_SameObjectAndDifferentClass() {
    // Case 1: Test that equals returns true when comparing the same object
    Team team = new Team("test-team");
    assertEquals(team.equals(team), true); // Same object

    // Case 2: Test that equals returns false when comparing to an object of a different class
    assertEquals(team.equals("wrong"), false); // Different class
}

@Test
public void testEquals_BothNameAndMembersEqual() {
    // Case 3: Test when both the name and members are the same (should return true)
    Team team1 = new Team("correct");
    Team team2 = new Team("correct");
    team1.addMember("correct");
    team2.addMember("correct");
    assertEquals(team1.equals(team2), true); // Both name and members are equal
}

@Test
public void testEquals_NameEqualButMembersNotEqual() {
    // Case 3: Test when the name is the same, but members are different (should return false)
    Team team1 = new Team("correct");
    Team team2 = new Team("correct");
    team1.addMember("correct");
    team2.addMember("wrong");
    assertEquals(team1.equals(team2), false); // Name is equal, but members are different
}

@Test
public void testEquals_NameNotEqualButMembersEqual() {
    // Case 3: Test when the name is different, but members are the same (should return false)
    Team team1 = new Team("correct");
    Team team2 = new Team("wrong");
    team1.addMember("correct");
    team2.addMember("correct");
    assertEquals(team1.equals(team2), false); // Name is different, but members are equal
}

@Test
public void testEquals_BothNameAndMembersNotEqual() {
    // Case 3: Test when both the name and members are different (should return false)
    Team team1 = new Team("correct");
    Team team2 = new Team("wrong");
    team1.addMember("correct");
    team2.addMember("wrong");
    assertEquals(team1.equals(team2), false); // Both name and members are different
}

@Test
public void testHashCode_SameContent() {
    // Test that two teams with the same name and members have the same hash code
    Team team1 = new Team("jun");
    team1.addMember("yoon");
    Team team2 = new Team("jun");
    team2.addMember("yoon");
    assertEquals(team1.hashCode(), team2.hashCode()); // Same content should produce the same hash code
}

@Test
public void testHashCode_DefaultTeam() {
    // Test the hash code of a default team (without name and members)
    Team team = new Team();
    int actualHashCode = team.hashCode();
    int expectedHashCode = 1; // Assuming the default hash code is 1 as per implementation
    assertEquals(expectedHashCode, actualHashCode); // Verify the hash code for the default team
}

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
