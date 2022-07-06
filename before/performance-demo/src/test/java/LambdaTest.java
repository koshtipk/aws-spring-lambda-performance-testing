
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.performance.example.base.BaseLambda;

public class LambdaTest {

	public LambdaTest() {

	}

	static TestContext ctx = null;

	@BeforeClass
	public static void createInput() {
		ctx = createContext();
	}

	private static TestContext createContext() {
		TestContext ctx = new TestContext();
		ctx.setFunctionName("GreetHandler");
		return ctx;
	}

	@Test
	public void initializedFlowTest() {

		Map<String, Object> mapRequest = new HashMap<>();

		mapRequest.put("username", "user1");

		BaseLambda baseLambda = new BaseLambda();
		ResponseEntity<String> response = baseLambda.handleRequest(mapRequest, createContext());
		System.out.println(response);
	}

}