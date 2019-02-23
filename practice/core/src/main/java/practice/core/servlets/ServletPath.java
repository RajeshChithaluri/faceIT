package practice.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class,
property = {
	Constants.SERVICE_DESCRIPTION + "= servlet using with the path",
	"sling.servlet.methods = "+ HttpConstants.METHOD_GET,
	"sling.servlet.paths ="+ "/bin/servletPath",
}
		)
public class ServletPath extends SlingSafeMethodsServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
	        resp.setContentType("text/plain");
	        resp.getWriter().write("Hello Servlet Path");
	}

}
