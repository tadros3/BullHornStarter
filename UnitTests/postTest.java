import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import customTools.DbPosts;

public class postTest {

	@Test
	public void test() {
		List<model.Bhpost> posts = DbPosts.bhPost();
		assertEquals(posts != null, true);
	}

}
