package demo.portlet.example.portlet;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import demo.portlet.example.constants.DemoPortletExamplePortletKeys;
import example.entity.model.Employee;
import example.entity.service.EmployeeLocalService;

/**
 * @author lenovo
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DemoPortletExample", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DemoPortletExamplePortletKeys.DEMOPORTLETEXAMPLE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DemoPortletExamplePortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(DemoPortletExamplePortlet.class);

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private EmployeeLocalService employeeLocalService;

	public void addEmployee(ActionRequest request, ActionResponse response) throws PortalException {

		// ServiceContext serviceContext =
		// ServiceContextFactory.getInstance(simpleentity.class.getName(), request);
		long id = counterLocalService.increment();
		Employee smp = null;
		smp = employeeLocalService.createEmployee(id);
		smp.setName(ParamUtil.getString(request, "name"));
		smp.setNumber(ParamUtil.getInteger(request, "number"));
		employeeLocalService.addEmployee(smp);
		System.out.println("addedd successfully" + smp);
	}

	public void deleteEmployee(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long Eid = ParamUtil.getLong(actionRequest, "id");
		System.out.println("------" + Eid);
		Employee empl = employeeLocalService.deleteEmployee(Eid);
		if (empl != null) {

			log.info("Student have been deleted successfylly");
		} else {

			log.error("There is an Erron in delete Student");
		}

		// empl=employeeLocalService.deleteEmployee(empl);

		System.out.println("deleted successfully");
	}

	public void updateEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException, PortalException {
		long empId = ParamUtil.getLong(actionRequest, "id");

		Employee empl = employeeLocalService.getEmployee(empId);
//		//empl.setName(name);
//		
//		String field1 = ParamUtil.getString(actionRequest, "name");
//		int field2 = ParamUtil.getInteger(actionRequest, "number");
//
//	
//		if (fooId <= 0) {
//			Employee foo = employeeLocalService.createEmployee(fooId);
////
//			foo.setName(field1);
//			foo.setNumber(field2);
//			foo.setId(fooId);
//
//			employeeLocalService.addEmployee(foo);
//		} else {
//			Employee foo = employeeLocalService.createEmployee(fooId);
//
//			foo.setName(field1);
//			foo.setNumber(field2);
//			foo.setId(fooId);
////
//			employeeLocalService.addEmployee(foo);
//}

		empl.setName(ParamUtil.getString(actionRequest, "name"));

		empl.setNumber(ParamUtil.getInteger(actionRequest, "number"));

		employeeLocalService.updateEmployee(empl);
		System.out.println("updated successfully" + empl);
	}

}