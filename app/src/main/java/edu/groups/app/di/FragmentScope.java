package edu.groups.app.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Kamil on 10/11/2017.
 */

@Scope
@Retention(RUNTIME)
public @interface FragmentScope {}