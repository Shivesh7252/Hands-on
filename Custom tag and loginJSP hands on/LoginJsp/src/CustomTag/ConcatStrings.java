package CustomTag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
public class ConcatStrings extends SimpleTagSupport {

	private String first,last;

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
	public void doTag() throws IOException, JspException {
		final StringWriter sw = new StringWriter();
        getJspBody().invoke( sw );
 
        JspWriter out = getJspContext().getOut();
		out.println("The concatenation of "+first+" and "+last+" is: "+ (first+last));
		
	}
	
}
