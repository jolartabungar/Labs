
public class MethodSigExample {

	public int test(String s, int i, String n) {
		int x = i + s.length();
		return x;
	}

	public void callTest() {
		MethodSigExample eg = new MethodSigExample();
		int r = eg.test("hello", 10, "world");
	}

}
