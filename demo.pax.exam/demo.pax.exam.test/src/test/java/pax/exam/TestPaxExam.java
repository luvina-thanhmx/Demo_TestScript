package pax.exam;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;
import static org.ops4j.pax.exam.CoreOptions.*;
import static org.junit.Assert.*;
import org.wiperdog.demo.bundle.test.pax.exam.service.Service;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class TestPaxExam {
	public TestPaxExam() {
	}

	@Inject
	private org.osgi.framework.BundleContext context;

	@Configuration
	public Option[] config() {
		return options(cleanCaches(true), frameworkStartLevel(6),
				// felix log level
				systemProperty("felix.log.level").value("4"),
				// setup properties for fileinstall bundle.
				systemProperty("felix.home").value(System.getProperty("user.dir")),
				// start bundle for test
				mavenBundle("org.wiperdog", "demo.bundle.test.pax.exam", "0.0.1-SNAPSHOT").startLevel(3), 
				junitBundles());
	}

	Service sv;
	String messageRun;
	String messageStop;
	
	@Before
	public void prepare() {
		sv =  (Service) context.getService(context.getServiceReference(Service.class.getName()));
		messageRun = "Run now";
		messageStop = "Stop here";
	}

	@After
	public void finish() {
	}

	@Test
	public void TestPaxExam01() {
		assertEquals("Run now", sv.run(messageRun));
	}
	
	@Test
	public void TestPaxExam02() {
		assertEquals("Stop here", sv.run(messageStop));
	}
}
