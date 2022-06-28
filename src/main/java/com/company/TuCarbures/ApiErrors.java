package com.company.TuCarbures;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.company.TuCarbures.ApiError.apiError;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrors {
    List<ApiError> errors = new ArrayList<>();

    public void addError(String code, String message) {
        this.errors.add(
                apiError().code(code).message(message).build()
        );
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}