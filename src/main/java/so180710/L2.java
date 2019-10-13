package so180710;

/*
interface MyInterface{}
class MyClass1 implements MyInterface{}
class MyClass2 implements MyInterface{}
class Test{
    MyInterface[] interfaceArray=new MyClass1[7];  //Valid reason
}
*/

interface MyInterface{
}
class MyClass1 implements MyInterface{
    public void a() {
        System.out.println("MyClass1");
    }
}
class MyClass2 implements MyInterface{
    public void a() {
        System.out.println("MyClass2");
    }
}
class Test{
    MyInterface[] interfaceArray=new MyInterface[7];  /*instantiating interface   here, How is it possible?*/
    {
        interfaceArray[0]=new MyInterface(){};
    }
}
public class L2 {
}
