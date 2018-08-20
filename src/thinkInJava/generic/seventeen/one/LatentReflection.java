package thinkInJava.generic.seventeen.one;

/**
 * @author Will
 * @date 2018/8/20.
 */
public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Mime());
    }
}
