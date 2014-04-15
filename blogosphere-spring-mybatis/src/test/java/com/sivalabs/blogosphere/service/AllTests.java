/**
 * 
 */
package com.sivalabs.blogosphere.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Siva
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserServiceTest.class,
        BlogServiceTest.class,
        PostServiceTest.class,
        CommentServiceTest.class,
        TagServiceTest.class
})
public class AllTests {

}
