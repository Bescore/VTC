package modèles;

public class test {
	
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "test [test=" + test + ", getTest()=" + getTest() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public test(String test) {
		this.test = test;
	}
	
	public test() {
		
	}
}
