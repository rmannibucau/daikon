package org.talend.daikon.properties;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Contains and process validation result for every property
 */
public class ValidationResults {

    private Map<String, ValidationResult> validationResults;

    public ValidationResults() {
        this.validationResults = new LinkedHashMap<>();
    }

    /**
     * @return list of all properties warnings (ValidationResult equals Result.Warning and message should be specified)
     */
    public List<ValidationResult> getWarnings() {
        List<ValidationResult> warnings = new ArrayList<>();
        for (ValidationResult vr: validationResults.values()) {
            if (ValidationResult.Result.WARNING == vr.getStatus()) {
                warnings.add(vr);
            }
        }
        return warnings;
    }

    /**
     * @return list of all properties errors (ValidationResult equals Result.Error and error message should be specified)
     */
    public List<ValidationResult> getErrors() {
        List<ValidationResult> errors = new ArrayList<>();
        for (ValidationResult vr: validationResults.values()) {
            if (ValidationResult.Result.ERROR == vr.getStatus()) {
                errors.add(vr);
            }
        }
        return errors;
    }

    /**
     * @return unmodifiable Map where keys are problemKeys and values are all ValidationResults
     */
    public Map<String, ValidationResult> getAllValidationResults() {
        return Collections.unmodifiableMap(validationResults);
    }

    /**
     * Add problem to validationResults Map if it was absent there and status is WARNING or ERROR
     * Update problem status and message if warning or error was present in Map
     * Remove warning or error from map if new ValidationResult.status is OK
     *
     * @param problemKey not empty and not null
     * @param validationResult result of any property checking
     * @throws IllegalArgumentException if key is empty or null, validationResult is null
     * or VR.message is empty or null when VR.status is WARNING or ERROR
     */
    public void addOrUpdateProblem(String problemKey, ValidationResult validationResult) {

        if (StringUtils.isBlank(problemKey))  {
            throw new IllegalArgumentException("Problem Key couldn't be null or empty");
        }

        if (null == validationResult) {
            throw new IllegalArgumentException("Property Validation Result couldn't be null");
        }

        ValidationResult.Result vrStatus = validationResult.getStatus();

        if (vrStatus == ValidationResult.Result.OK) {
            handleOk(problemKey);
        } else {
            handleProblem(problemKey, validationResult);
        }

    }

    private void handleProblem(String problemKey, ValidationResult validationResult) {
        if (StringUtils.isBlank(validationResult.getMessage())) {
            throw new IllegalArgumentException("ValidationResult message couldn't be null or empty for problem");
        }

        addProblem(problemKey, validationResult);
    }

    private void handleOk(String problemKey) {
        if (validationResults.containsKey(problemKey)) {
            validationResults.remove(problemKey);
        }
    }

    private void addProblem(String problemKey, ValidationResult validationResult) {
        if (ValidationResult.Result.ERROR == validationResult.getStatus() || ValidationResult.Result.WARNING == validationResult.getStatus()) {
            validationResults.put(problemKey, validationResult);
        }
        //No need to store VR.OK in this class yet, only errors and warnings
    }

    /**
     * @return actual ValidationResult.Result depending on available errors and warning
     */
    public ValidationResult.Result calculateValidationStatus() {
        ValidationResult.Result status = ValidationResult.Result.OK;
        if (!getErrors().isEmpty()) {
            status = ValidationResult.Result.ERROR;
        } else if (!getWarnings().isEmpty()) {
            status = ValidationResult.Result.WARNING;
        }
        return status;
    }

    /**
     *
     * @return empty String when no problems in maps or full errors and warnings message
     */
    private String getGeneralProblemsMessage() {
        StringBuilder message = new StringBuilder();

        for (Object error: getErrors()) {
            message.append(error.toString()).append("\n");
        }
        for (Object warning: getWarnings()) {
            message.append(warning.toString()).append("\n");
        }
        return  message.substring(0, message.length() - 1);
    }

    /**
     * @return "OK" when there are no problems in maps or {@link #getGeneralProblemsMessage()} when they are present
     */
    @Override
    public String toString() {
        if (validationResults.isEmpty()) return "OK";
        else return getGeneralProblemsMessage();
    }
}
