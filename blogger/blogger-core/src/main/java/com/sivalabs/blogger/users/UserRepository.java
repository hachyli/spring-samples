/**
 * 
 */
package com.sivalabs.blogger.users;

import com.sivalabs.blogger.domain.User;

/**
 * @author Siva
 *
 */
public interface UserRepository {

	User login(String userName, String password);
}
