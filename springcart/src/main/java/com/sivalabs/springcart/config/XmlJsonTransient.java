/**
 * 
 */
package com.sivalabs.springcart.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Siva
 *
 */
@Target(value={ElementType.METHOD,ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
@Inherited
@XmlTransient
@JsonIgnore
public @interface XmlJsonTransient {

}
