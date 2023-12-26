package com.admin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.admin.qa.base.TestBase;
import com.admin.qa.domain.CourseDetails;
import com.admin.qa.pages.AddCoursePage;
import com.admin.qa.pages.CoursesListPage;
import com.admin.qa.pages.DashboardPage;
import com.admin.qa.pages.LoginPage;

public class CoursesListTest extends TestBase {
	CoursesListPage coursesListPage;

	@BeforeClass
	public void coursesListMenu() {
		initialization();
		DashboardPage dashboardpage = new LoginPage().login(prop.getProperty("username"), prop.getProperty("password"));
		coursesListPage = dashboardpage.clickOnCoursesMenu();
	}

	@Test
	public void verifyCoursesListPageTitle() {
		boolean isPageLoaded = coursesListPage.verifyCoursesListTilte();
		Assert.assertTrue(isPageLoaded, "Course List Page Not Loaded");
	}

	@Test
	public void addCourse() {
		AddCoursePage addCoursePage = coursesListPage.clickOnAddCourseBtn();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setPhoto("C:\\Users\\SWHIZZ TECHNOLOGIES\\eclipse-workspace1\\InstitutionalAdminPortal\\src\\main\\resources\\images\\Java.png");
		courseDetails.setCategory("DevOps");
		courseDetails.setName("Java");
		courseDetails.setUrl("https://www.java.com/");
		courseDetails.setContent(
				"Java is a widely-used programming language for coding web applications. It has been a popular choice among developers for over two decades, with millions of Java applications in use today. Java is a multi-platform, object-oriented, and network-centric language that can be used as a platform in itself. It is a fast, secure, reliable programming language for coding everything from mobile apps and enterprise software to big data applications and server-side technologies.");
		courseDetails.setIsPopular("Yes");
		addCoursePage.addCourse(courseDetails);
	}
	@AfterClass
	public void tearDown() {
	driver.close();	
	}

}
