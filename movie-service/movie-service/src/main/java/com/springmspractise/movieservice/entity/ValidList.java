package com.springmspractise.movieservice.entity;

import lombok.Data;
import lombok.experimental.Delegate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * This is for validation of Movies which do not have valid params
 * As list could not be validated using @Valid, which worked perfectly for a bean
 * Consider using {@ValidList} instead of List for early validation check which works like @Valid but for this list of movies
 * Delegate of lombok creates/ delegates all methods of List<E> and @Data generates all boilerplate for getter setter and to string, use constructors needed explicitly
 *
 * @param <E>
 */
@Data
public class ValidList<E> implements List<E> {

    @Valid
    @Delegate
    private List<E> list = new ArrayList<>();
}
