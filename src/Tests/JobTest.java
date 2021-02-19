package Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job jobTest, nextTest, jobThree, nextJob, otherJob;

    @Before
    public void IdTest(){
    jobTest = new Job();
    nextTest = new Job();
    jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    nextJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    otherJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @Test
    public void testSettingJobId(){
    assertEquals(jobTest.getId()+1,nextTest.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(jobThree instanceof Job);
        assertEquals("Product tester", jobThree.getName());
        assertEquals("ACME",jobThree.getEmployer().getValue());
        assertEquals("Desert",jobThree.getLocation().getValue());
        assertEquals("Quality control",jobThree.getPositionType().getValue());
        assertEquals("Persistence",jobThree.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(nextJob.equals(otherJob));
    }

    @Test
    public void testToStringMethod(){
        System.out.println(nextJob.toString());
    }

    @Test
    public void testForEmptySpaces(){
        assertTrue(jobThree.toString().startsWith("\n"));
        assertTrue(jobThree.toString().endsWith("\n"));
    }

    @Test
    public void testForLabels(){
        assertTrue(jobThree.toString().contains("ID:3"));
        assertTrue(jobThree.toString().contains("Name:Product tester"));
        assertTrue(jobThree.toString().contains("Employer:ACME"));
        assertTrue(jobThree.toString().contains("Location:Desert"));
        assertTrue(jobThree.toString().contains("Position Type:Quality control"));
        assertTrue(jobThree.toString().contains("Core Competency:Persistence"));
    }

    @Test
    public void testIfFieldIsEmpty(){
        assertTrue(nextJob.toString().contains("Employer:Data not available"));
    }
}
