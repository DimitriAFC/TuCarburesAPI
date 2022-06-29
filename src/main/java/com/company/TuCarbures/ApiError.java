package com.company.TuCarbures;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class ApiError {

        private String code;

        private String message;

        public static ApiErrorBuilder apiError() {
            return ApiError.builder();
        }

    }
