package com.martin.mysample.demo.model;

import lombok.Data;

import java.util.StringJoiner;

/**
 * Model
 *
 * @author Martin
 * @since 2023-10-13 10:58
 **/

@Data
public class Model {

    private Boolean success;

    private boolean failure;

    public String toString() {

        return new StringJoiner(", ", Model.class.getSimpleName() + "[", "]")

                .add("success=" + success)

                .add("failure=" + failure)

                .toString();
    }


}
