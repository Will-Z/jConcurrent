package concuArt.c7;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Will
 * @date 2018/10/11.
 */
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicUserRef = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("conan", 15);
        atomicUserRef.set(user);
        User updateUser = new User("sufee", 16);
        atomicUserRef.compareAndSet(user, updateUser);
        System.out.println(atomicUserRef.get().getName() + "  " + atomicUserRef.get().getOld());
    }

    static class User {
        private String name;
        private int old;
        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }
        public String getName() {
            return name;
        }
        public int getOld() {
            return old;
        }
    }
}
