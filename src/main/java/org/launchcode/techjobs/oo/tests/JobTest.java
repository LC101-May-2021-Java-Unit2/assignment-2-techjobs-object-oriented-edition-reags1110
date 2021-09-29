package org.launchcode.techjobs.oo.tests;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);
        assertEquals("Product tester", testJob.getName());

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob.getEmployer().getValue());

        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals("Desert", testJob.getLocation().getValue());

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob.getPositionType().getValue());

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job Job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(Job1.equals(Job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char chars[] = testJob.toString().toCharArray();

        assertEquals('\n', chars[0]);
        assertEquals('\n', chars[chars.length-1]);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String[] lines = testJob.toString().trim().split("\n");

        assertEquals(testJob.toString(), testJob.toString());
    }

    @Test
    public void testTestToStringHandlesEmptyFieldCallsAssertions() {
        Job testJob = new Job();

        String[] lines = testJob.toString().trim().split("\n");

        List<String> list = new ArrayList<String>(Arrays.asList(lines));

        lines = list.toArray(new String[0]);

        assertEquals(lines[1], "Name: Data not available");
        assertEquals(lines[2], "Employer: Data not available");
        assertEquals(lines[3], "Location: Data not available");
        assertEquals(lines[4], "Position Type: Data not available");
        assertEquals(lines[5], "Core Competency: Data not available");
    }
}