
public class test {

	public static void main(String[] args) {
	person taro = new person();
	taro.name = "taro";
	taro.age = 18;
	System.out.println(taro.name);
	System.out.println(taro.age);

	person jiro = new person("jiro", 20);
	System.out.println(jiro.name);
	System.out.println(jiro.age);

	person saburo = new person("saburo");
	System.out.println(saburo.name);
	System.out.println(saburo.age);

	person nanashi = new person (25);
	System.out.println(nanashi.name);
	System.out.println(nanashi.age);

	person hanako = new person (17, "hanako");
	System.out.println(hanako.name);
	System.out.println(hanako.age);

	}

}
