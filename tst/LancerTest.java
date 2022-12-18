package tec;

import java.lang.reflect.*;

public class LancerTest {
    public static void verifie(boolean condition, String message){
        if (condition)
            System.out.println("\u001B[32mCONFORME: " + message + "\u001B[0m");
        else {
            StackTraceElement caller = Thread.currentThread().getStackTrace()[2];

            System.out.println("\u001B[32mNON CONFORME " + message + " dans "
                + caller.getClassName() + ":" + caller.getMethodName() + "("
                + caller.getFileName() + ":" + caller.getLineNumber() + ")" + "\u001B[0m");
        }
    }

    public static void lancer(Class c) throws Exception{
        System.out.println("Autotest : " + c.getName());
        java.lang.reflect.Method[] mesMethodes = c.getMethods();

        int nbTest = 0;
        for (int i = 0; i < mesMethodes.length; ++i){
            java.lang.reflect.Method m = mesMethodes[i];
            
            if (m.getName().startsWith("test")){
                try {
                    m.invoke(c.newInstance());
                    ++nbTest;
                } catch (ReflectiveOperationException e){
                    throw new IllegalStateException(e);
                }
            }

        }

        System.out.println(nbTest + " test(s): " + c.getName());
    }

    static public void main(String[] args) throws Exception{
        boolean estMisAssertion = false;
        assert estMisAssertion = true;
    
        if (!estMisAssertion) {
            System.out.println("Execution impossible sans l'option -ea");
            return;
        }

        for(int i=0; i < args.length; i++){
            new LancerTest().lancer(Class.forName(args[i]));
        }
    }
}
