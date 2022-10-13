package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    private Job jobEqualityOne;
    @Before
    public void before(){
         jobEqualityOne = new Job("kelechi", new Employer("launchCode"),new Location("kansas city"), new PositionType("front-end developer"),new CoreCompetency("ability to learn") );
    }

    @Test
    public  void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        Assert.assertNotEquals(job1,job2);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job constructorTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertTrue(constructorTest.getName() instanceof String);
      Assert.assertTrue(constructorTest.getEmployer() instanceof Employer);
      Assert.assertTrue(constructorTest.getLocation() instanceof Location);
        Assert.assertTrue(constructorTest.getPositionType() instanceof PositionType);
        Assert.assertTrue(constructorTest.getCoreCompetency() instanceof CoreCompetency);
        Assert.assertEquals("Product tester",constructorTest.getName());
        Assert.assertEquals(constructorTest.getEmployer().toString(), new Employer("ACME").getValue().toString());
        Assert.assertEquals(constructorTest.getLocation().toString(),new Location("Desert").getValue().toString());
        Assert.assertEquals(constructorTest.getPositionType().toString(), new PositionType("Quality control").getValue().toString());
        Assert.assertEquals(constructorTest.getCoreCompetency().toString(),new CoreCompetency("Persistence").getValue().toString() );


    }
    @Test
    public void testJobsForEquality(){
        jobEqualityOne = new Job("kelechi", new Employer("launchCode"),new Location("kansas city"), new PositionType("front-end developer"),new CoreCompetency("ability to learn") );
        Job jobEqualityTwo = new Job("kelechi", new Employer("launchCode"),new Location("kansas city"), new PositionType("front-end developer"),new CoreCompetency("ability to learn") );
        Assert.assertFalse(jobEqualityOne.equals(jobEqualityTwo));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        jobEqualityOne = new Job("kelechi", new Employer("launchCode"),new Location("kansas city"), new PositionType("front-end developer"),new CoreCompetency("ability to learn") );

        Assert.assertEquals('\n', jobEqualityOne.toString().charAt(0));
        Assert.assertEquals('\n', jobEqualityOne.toString().charAt(jobEqualityOne.toString().length() - 1));
        }

        @Test
    public void testToStringContainsCorrectLabelsAndData(){
            jobEqualityOne = new Job("kelechi", new Employer("launchCode"),new Location("kansas city"), new PositionType("front-end developer"),new CoreCompetency("ability to learn") );
            String newString = "\n"+ "ID: "+ jobEqualityOne.getId() + "\n" + "Name: " + "kelechi"+ "\n"+ "Employer: "+ "launchCode"+ "\n"+ "Location: "+ "kansas city" + "\n" + "Position Type: "+ "front-end developer" + "\n" + "Core Competency: " + "ability to learn" + "\n";
            Assert.assertEquals(newString,jobEqualityOne.toString());
        }

@Test
    public void testToStringHandlesEmptyField(){
    Job jobFour = new Job("obilor", new Employer("launchCode"),new Location("kansas city"), new PositionType("Quality Control"),new CoreCompetency("") );
    String newString = "\n"+ "ID: "+ jobFour.getId() + "\n" + "Name: " + "obilor"+ "\n"+ "Employer: "+ "launchCode"+ "\n"+ "Location: "+ "kansas city" + "\n" + "Position Type: "+ "Quality Control" + "\n" + "Core Competency: " + "Data not available" + "\n";
    Assert.assertEquals(newString, jobFour.toString());




}

}
