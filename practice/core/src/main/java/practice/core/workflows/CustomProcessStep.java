package practice.core.workflows;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class,
property = {
		Constants.SERVICE_DESCRIPTION+"= Creating Node.",
		Constants.SERVICE_VENDOR+"= Adobe",
		"process.label"+"= Create Node"
})
public class CustomProcessStep implements WorkflowProcess {

	@Override
	public void execute(WorkItem arg0, WorkflowSession arg1, MetaDataMap arg2) throws WorkflowException {
		
		 ResourceResolver resourceResolver = arg1.adaptTo(ResourceResolver.class);
		 Resource resource = resourceResolver.getResource(arg0.getContentPath()+"/jcr:content");
		 Node node = resource.adaptTo(Node.class);
		 try {
			node.setProperty("Rajesh", "rajesh");
		}  catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
