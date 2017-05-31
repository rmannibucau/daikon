package org.talend.daikon.properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmytro.sylaiev on 5/29/2017.
 */
public class ValidationResultsTest {

    ValidationResults validationResults;

    @Before public void setUp() {
        validationResults = new ValidationResults();
    }

    @Test public void testUpdateOneValidationResultSeveralTimes() {
        validationResults.addOrUpdateProblem("SomeProblem", new ValidationResult(ValidationResult.Result.ERROR, "Error message"));
        Assert.assertEquals(ValidationResult.Result.ERROR, validationResults.calculateValidationStatus());

        validationResults
                .addOrUpdateProblem("SomeProblem", new ValidationResult(ValidationResult.Result.WARNING, "Warning message"));
        Assert.assertEquals(ValidationResult.Result.WARNING, validationResults.calculateValidationStatus());

        validationResults.addOrUpdateProblem("SomeProblem", new ValidationResult(ValidationResult.Result.OK, null));
        Assert.assertEquals(ValidationResult.Result.OK, validationResults.calculateValidationStatus());
    }

    @Test(expected = IllegalArgumentException.class) public void testAddValidationResultErrorWithEmptyMessage() {
        validationResults.addOrUpdateProblem("SomeProblem", new ValidationResult(ValidationResult.Result.ERROR, ""));
    }

    @Test(expected = IllegalArgumentException.class) public void testAddValidationResultErrorWithNullMessage() {
        validationResults.addOrUpdateProblem("SomeProblem", new ValidationResult(ValidationResult.Result.ERROR, null));
    }

    @Test(expected = IllegalArgumentException.class) public void testAddValidationResultWarningWithEmptyMessage() {
        validationResults.addOrUpdateProblem("SomeProblem", new ValidationResult(ValidationResult.Result.WARNING, ""));
    }

    @Test(expected = IllegalArgumentException.class) public void testAddValidationResultWarningWithNullMessage() {
        validationResults.addOrUpdateProblem("SomeProblem", new ValidationResult(ValidationResult.Result.WARNING, null));
    }

    @Test public void testAddValidationResultOKWithEmptyMessage() {
        try {
            validationResults.addOrUpdateProblem("SomeProblem", new ValidationResult(ValidationResult.Result.OK, ""));
        } catch (IllegalArgumentException e) {
            Assert.fail();
        }
    }

    @Test public void testAddValidationResultOKWithNullMessage() {
        try {
            validationResults.addOrUpdateProblem("SomeProblem", new ValidationResult(ValidationResult.Result.OK, null));
        } catch (IllegalArgumentException e) {
            Assert.fail();
        }
    }

    @Test(expected = IllegalArgumentException.class) public void testAddProblemWithEmptyKey() {
        validationResults.addOrUpdateProblem("", new ValidationResult());
    }

    @Test(expected = IllegalArgumentException.class) public void testAddProblemWithNullKey() {
        validationResults.addOrUpdateProblem(null, new ValidationResult());
    }

    @Test public void testGetGeneralValidationResultWhenErrorsAndMessagesAreEmpty() {
        Assert.assertEquals(ValidationResult.Result.OK, validationResults.calculateValidationStatus());
        Assert.assertEquals("OK", validationResults.toString());
    }

    @Test public void testGetGeneralValidationResultWithOnlyErrors() {
        validationResults.addOrUpdateProblem("Test Error", new ValidationResult(ValidationResult.Result.ERROR, "Some error"));

        Assert.assertEquals(ValidationResult.Result.ERROR, validationResults.calculateValidationStatus());
        Assert.assertEquals("ERROR Some error", validationResults.toString());
    }

    @Test public void testGetGeneralValidationResultWithOnlyWarnings() {
        validationResults
                .addOrUpdateProblem("TestWarning", new ValidationResult(ValidationResult.Result.WARNING, "Some warning"));

        Assert.assertEquals(ValidationResult.Result.WARNING, validationResults.calculateValidationStatus());
        Assert.assertEquals("WARNING Some warning", validationResults.toString());
    }

    @Test public void testGetGeneralValidationResultWithBothErrorAndWarning() {
        validationResults.addOrUpdateProblem("Test Error", new ValidationResult(ValidationResult.Result.ERROR, "Some error"));
        validationResults
                .addOrUpdateProblem("Test Warning", new ValidationResult(ValidationResult.Result.WARNING, "Some warning"));

        Assert.assertEquals(ValidationResult.Result.ERROR, validationResults.calculateValidationStatus());
        Assert.assertEquals("ERROR Some error\nWARNING Some warning", validationResults.toString());
    }

    @Test public void testGetErrors() {
        ValidationResult vrErrorFirst = new ValidationResult(ValidationResult.Result.ERROR, "Some First error");
        ValidationResult vrErrorSecond = new ValidationResult(ValidationResult.Result.ERROR, "Some Second error");
        ValidationResult vrWarning = new ValidationResult(ValidationResult.Result.WARNING, "Some warning");
        List<ValidationResult> expectedList = new ArrayList<>();

        validationResults.addOrUpdateProblem("FirstError", vrErrorFirst);
        validationResults.addOrUpdateProblem("SecondError", vrErrorSecond);
        validationResults.addOrUpdateProblem("Warning", vrWarning);

        expectedList.add(vrErrorFirst);
        expectedList.add(vrErrorSecond);

        Assert.assertEquals(expectedList, validationResults.getErrors());
    }

    @Test public void testGetWarnings() {
        ValidationResult vrErrorFirst = new ValidationResult(ValidationResult.Result.ERROR, "Some First error");
        ValidationResult vrErrorSecond = new ValidationResult(ValidationResult.Result.ERROR, "Some Second error");
        ValidationResult vrWarning = new ValidationResult(ValidationResult.Result.WARNING, "Some warning");
        List<ValidationResult> expectedList = new ArrayList<>();

        validationResults.addOrUpdateProblem("FirstError", vrErrorFirst);
        validationResults.addOrUpdateProblem("SecondError", vrErrorSecond);
        validationResults.addOrUpdateProblem("Warning", vrWarning);

        expectedList.add(vrWarning);

        Assert.assertEquals(expectedList, validationResults.getWarnings());
    }

}
