package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // <https://bit.ly/cs156-f24-teams>
        assertEquals("Nathan", Developer.getName());
    }

    @Test
    public void getName_returns_correct_githubId() {
        assertEquals("SexyJesusFreak", Developer.getGithubId());
    }

     @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f24-00", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Nathan"),"Team should contain Nathan");
        assertTrue(t.getMembers().contains("Neil"),"Team should contain Neil");
        assertTrue(t.getMembers().contains("Tom"),"Team should contain Tom");
        assertTrue(t.getMembers().contains("Hongtao"),"Team should contain Hongtao");
        assertTrue(t.getMembers().contains("Alec"),"Team should contain Alec");
        assertTrue(t.getMembers().contains("Elijah"),"Team should contain Elijah");
    }
    
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
