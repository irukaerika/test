
public class Test {

	public static void main(String[] args) {
		Person jiro = new Person();
		jiro.name="木村次郎";
		jiro.age=18;
		System.out.println(jiro.name);
		System.out.println(jiro.age);

		Person hanako = new Person();
		hanako.name="鈴木花子";
		hanako.age=18;
		System.out.println(hanako.name);
		System.out.println(hanako.age);

		jiro.talk();
		jiro.walk();
		jiro.run();
	}

}
