
public class Test {

	public static void main(String[] args) {

		Person jiro = new Person();
		jiro.name="木村次郎";
		jiro.age=18;
		jiro.phoneNumber="080-7988-9932";
		jiro.address="811-2045";
		System.out.println("氏名 : " + jiro.name);
		System.out.println("年齢 : " + jiro.age + "歳");
		System.out.println("携帯電話番号 : " + jiro.phoneNumber);
		System.out.println("郵便番号 : 〒" + jiro.address);



		Person hanako = new Person();
		hanako.name="鈴木花子";
		hanako.age=16;
		hanako.phoneNumber="090-7988-9932";
		hanako.address="811-2145";
		System.out.println("氏名 : " + hanako.name);
		System.out.println("年齢 : " + hanako.age + "歳");
		System.out.println("携帯電話番号 : " + hanako.phoneNumber);
		System.out.println("郵便番号 : 〒" + hanako.address);

jiro.talk();
jiro.walk();
jiro.run();


Robot aibo = new Robot();
aibo.name="aibo";
aibo.talk();
aibo.walk();
aibo.run();


Robot asimo = new Robot();
asimo.name="asimo";
asimo.talk();
asimo.walk();
asimo.run();



Robot pepper = new Robot();
pepper.name="pepper";
pepper.talk();
pepper.walk();
pepper.run();



Robot draemon = new Robot();
draemon.name="doraemon";
draemon.talk();
draemon.walk();
draemon.run();






	}


}
