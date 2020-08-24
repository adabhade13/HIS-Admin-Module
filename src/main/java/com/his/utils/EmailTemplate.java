package com.his.utils;

import com.his.entity.AccountEntity;

public class EmailTemplate {
	
	
	public static String getTemplate(AccountEntity entity) {
		
	return	"<html>"
		+"<body>"
		+"<h3>Hi "+entity.getFname()+",<br>"
		
		+ " &nbsp;&nbsp;&nbsp; &nbsp; welcome to the health Insurance System..!</h3>"

		+"<div> Your email address is ::"+entity.getEmail()+"<br>"
		+ "your temporary password is ::"+entity.getPazzword()+"<br>"
		+ "</div>"
		+" Click here to Un-lock Account::"
		+"<a href=http://localhost:8182/unlockAcc?email="+entity.getEmail()+"> Un-lock Account </a><br><br>"
		
		+"Thanks &  Regards <br>"
		 +"HIS-Services Pvt ltd, New Jersy USA"
		+"</body>"

		+"</html>";
	}

}
