package thinkInJava.classinfo.nine.inpk;

import thinkInJava.classinfo.nine.iv.A;

/**
 * @author Will
 * @date 2018/8/14.
 */
class C implements A {
    @Override public void f() {
        System.out.println("public C.f()");
    }

    public void g() {
        System.out.println("C.g()");
    }

    void u() {
        System.out.println("package C.u()");
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    /**
     * p.s. 事实证明 在反射面前 即便是 private
     * 也毫无隐私可言;   反射功能确实强大
     */
    private void w() {
        System.out.println("private C.w()");
    }
}
