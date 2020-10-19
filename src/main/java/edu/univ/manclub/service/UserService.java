package edu.univ.manclub.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.univ.manclub.persistence.StudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.univ.manclub.domain.Students;

@Service("UserService")
public class UserService implements UserDetailsService {
	@Autowired
	protected StudentsMapper studentsMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Getting a student object.... wait for it");
		return loadStudentById(username);
	}
	
	@Transactional
	public UserDetails loadStudentById(String id) throws UsernameNotFoundException {
		System.out.println("Getting a student obect through StudentMapper");
		Students student = studentsMapper.getStudentByStudentID(id);
		
		System.out.println("Done with db work");
		if(student == null){
			throw new UsernameNotFoundException("No such student : " + id);
		}
		else {
			System.out.println("Got that student");
		}
		
		/* For more information
		 * see http://stackoverflow.com/questions/14268451/spring-security-userdetailsservice-implementation-login-fails
		 * http://howtodoinjava.com/2013/04/16/custom-userdetailsservice-example-for-spring-3-security/
		 */

		boolean accountNotExpired = true;
		boolean credentialsNotExpired = true;
		boolean accountNonLocked = true;
		
		return new User(
				student.getStudentID(),
				student.getPassword(),
				true,
				accountNotExpired,
				credentialsNotExpired,
				accountNonLocked,
				getAuthorities(student)
				);
	}
	
	public Collection<GrantedAuthority> getAuthorities(Students student){
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
		if(student.getLevel() == 0){
			authList.add(new SimpleGrantedAuthority("ROLE_NEWMEMBER"));
		}
		else {
			if(student.getAssociation() == 0){
				authList.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
			}
			else {
				authList.add(new SimpleGrantedAuthority("ROLE_ASSOCIATION"));
			}
		}
		return authList;
	}
}

