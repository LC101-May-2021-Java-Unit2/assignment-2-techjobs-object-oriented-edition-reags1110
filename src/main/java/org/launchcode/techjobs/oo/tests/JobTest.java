package org.launchcode.techjobs.oo.tests;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class JobTest{


    private static final Job jobOne = new Job();
    private static final Job jobTwo = new Job();
    private static final Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    private static final Job jobFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    private static final Job jobFive = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
    private static final Job jobSix = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));


    @Test
    public void testSettingJobIdExists() {
        assertEquals(1, jobOne.getId());
        assertEquals(2, jobTwo.getId());
        assertFalse(jobOne.getId() == jobTwo.getId());
        assertTrue((jobOne.getId() + 1) == jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFieldsCallsAsserts() {
        assertEquals(3, jobThree.getId());
        assertEquals("Product tester", jobThree.getName());
        assertEquals("ACME", jobThree.getEmployer().toString());
        assertEquals("Desert", jobThree.getLocation().toString());
        assertEquals("Quality control", jobThree.getPositionType().toString());
        assertEquals("Persistence", jobThree.getCoreCompetency().toString());

    }

    @Test
    public void testJobsForEqualityExists() {
       assertEquals(false, jobThree == jobFour);
    }

    @Test
    public void testToStringContainsBlankLines() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', job.toString().charAt(0));
        assertEquals('\n', job.toString().charAt(job.toString().length() - 1));
    }

    @Test
    public void testToStringHasLabelsForEachField() {
        String toString = jobThree.toString();
        assertTrue(toString.contains("ID: "));
        assertTrue(toString.contains("Name: "));
        assertTrue(toString.contains("Employer: "));
        assertTrue(toString.contains("Location: "));
        assertTrue(toString.contains("Position Type: "));
        assertTrue(toString.contains("Core Competency: "));
    }

    @Test
    public void testToStringHandlesEmptyFieldCallsAssertions() {
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

    @Test
    public void testToStringDataNotAvailable() {
        assertTrue(jobFive.toString().contains("Data not available"));
    }

    @Test
    public void testForOops() {
        assertTrue(jobSix.toString().contains("OOPS! This job does not seem to exist."));
    }
}