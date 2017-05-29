package org.talend.daikon.properties;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Contains and process validation result for every property
 */
public class ValidationResults {

    private Map<String, ValidationResult> errors;
    private Map<String, ValidationResult> warnings;
    private ValidationResult generalValidationResult;

    public ValidationResults() {
        this.warnings = new LinkedHashMap<>();
        this.errors = new LinkedHashMap<>();
        generalValidationResult = calculateValidationResult();

    }

    /**
     * @return return list of all properties warnings (ValidationResult equals Result.Warning and message should be specified)
     */
    public List<ValidationResult> getWarningsList() {
        return new ArrayList<>(warnings.values());
    }

    /**
     * @return return list of all properties errors (ValidationResult equals Result.Error and error message should be specified)
     */
    public List<ValidationResult> getErrorsList() {
        return new ArrayList<>(errors.values());
    }


    public Map<String, ValidationResult> getErrors() {
        return Collections.unmodifiableMap(errors);
    }

    public Map<String, ValidationResult> getWarnings() {
        return Collections.unmodifiableMap(warnings);
    }

    /**
     * Add problem to appropriate Map if it was absent there and status is WARNING or ERROR
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

        if ((ValidationResult.Result.ERROR == vrStatus || ValidationResult.Result.WARNING == vrStatus)
                && StringUtils.isBlank(validationResult.getMessage())) {
            throw new IllegalArgumentException("ValidationResult message couldn't be null or empty when status is " + vrStatus);
        }


        if (warnings.containsKey(problemKey) || errors.containsKey(problemKey)) {
            updateProblem(problemKey, validationResult);
        }
        else {
            addProblem(problemKey, validationResult);
        }
        generalValidationResult = calculateValidationResult();
    }

    private void updateProblem(String problemKey, ValidationResult validationResult) {
        errors.remove(problemKey);
        warnings.remove(problemKey);

        addProblem(problemKey, validationResult);
    }

    private void addProblem(String problemKey, ValidationResult validationResult) {
        if (ValidationResult.Result.ERROR == validationResult.getStatus()) {
            errors.put(problemKey, validationResult);
        } else if (ValidationResult.Result.WARNING == validationResult.getStatus()) {
            warnings.put(problemKey, validationResult);
        } //No need to store VR.OK in this class yet, only errors and warnings
    }

    /**
     *
     * @return actual ValidationResult depending on content of errors and warnings maps
     */
    private ValidationResult calculateValidationResult() {
        ValidationResult.Result status = ValidationResult.Result.OK;
        if (!errors.isEmpty()) {
            status = ValidationResult.Result.ERROR;
        } else if (!warnings.isEmpty()) {
            status = ValidationResult.Result.WARNING;
        }
        return new ValidationResult(status, toString());
    }

    /**
     *
     * @return empty String when no problems in maps or full errors and warnings message
     */
    public String getGeneralProblemsMessage() {
        StringBuilder message = new StringBuilder();

        for (Object error: getErrorsList()) {
            message.append(error.toString()).append("\n");
        }
        for (Object warning: getWarningsList()) {
            message.append(warning.toString()).append("\n");
        }
        return  message.toString();
    }

    /**
     *
     * @return "OK" when there are no problems in maps or {@link #getGeneralProblemsMessage()} when they are present
     */
    @Override
    public String toString() {
        if (getGeneralProblemsMessage().isEmpty()) return "OK";
        else return getGeneralProblemsMessage();
    }

    public ValidationResult getGeneralValidationResult() {
        return generalValidationResult;
    }
}
