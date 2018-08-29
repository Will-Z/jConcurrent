package jvm.classload;

import java.io.IOException;
import java.io.InputStream;

/**
 * 每个类加载器都拥有独立的命名空间; 比较两个类是否"相等", 只有在这两个类是由同一个类加载器加载的前提下才有意义;
 *
 *
 *
 * @author Will
 * @date 2018/8/28.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("jvm.classload.ClassLoaderTest").getDeclaredConstructor().newInstance();
        System.out.println(obj.getClass());

        /*
         * 结果为 false
         *
         * 因为虚拟机中存在了两个ClassLoaderTest类, 一个是由系统应用程序类加载器加载,
         * 另一个由我们自定义的类加载器加载, 虽然都来自于同一个Class文件, 但依然是两个独立的类,  所以做对象所属类型检查时结果为false;
         *
         */
        System.out.println(obj instanceof jvm.classload.ClassLoaderTest);
    }
}
