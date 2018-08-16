package thinkInJava.generic.eight.one;

/**
 * Integer没有默认构造器 所以会失败
 *
 * 错误并非在编译器捕获 所以 sun不赞成这种方式
 *
 *
 * @author Will
 * @date 2018/8/16.
 */
public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");

        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}
