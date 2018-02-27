package monprojet.framework.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
/*		Login login = loginDao.findByName(username);
		System.out.println("************************222***************************");
		System.out.println("************************222*****************************");
		System.out.println("********************************************************");
		if (login != null)
			System.out.println(login.toString());
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		UserDetails userDetails = (UserDetails) new User(login.getLogin(), login.getpasswrd(), grantList);
		return userDetails;*/
		return null;
	}
}