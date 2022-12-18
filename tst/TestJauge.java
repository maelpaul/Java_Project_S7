package tec;

class TestJauge{
    public void testDansIntervalle() {
        Jauge jauge = new Jauge(67899,100);
        assert jauge.estVert();
        assert !jauge.estRouge();  
    }

    // L'incrémentation au delà du max ne met pas la jauge au rouge.

    public void testIncrementation() {
        try {
            Jauge jauge = new Jauge(67899,67898);
            assert jauge.estVert();
            jauge.incrementer();
            jauge.incrementer();
            assert jauge.estRouge();   
        } catch (AssertionError  e  ) 
        {
            e.printStackTrace();
            System.out.println("Test incrémentation n'a pas marché");
        }
    }

    public void testDecrementation() {
        Jauge jauge = new Jauge(67899,67900);
        assert jauge.estRouge();
        jauge.decrementer();
        jauge.decrementer();
        assert jauge.estVert();   
    }

    public void testDepart() {
        Jauge jauge = new Jauge(67899,67900);
        assert jauge.estRouge();  
    }

    public void testEgal() {
        Jauge jauge = new Jauge(67899,67899);
        assert jauge.estRouge();  
    }

    public void testZero() {
        Jauge jauge = new Jauge(67899,0);
        assert jauge.estVert();  
    }

    public void testNegatif() {
        Jauge jauge = new Jauge(67899,-5);
        assert !jauge.estRouge(); 
        assert !jauge.estVert(); 
    }

    protected void testCasLimite() {
        Jauge inverse = null;
    
        inverse = new Jauge(-42, 10);
      }
    
    public void testExceptionCasLimite(){
        try{
            new TestJauge().testCasLimite();
            assert false: "Exception non levee";
        }
        catch(IllegalArgumentException e){
            System.out.println("expection levée");
        }
        
    }

    public static void main (String[ ] args){

        boolean estMisAssertion = false;
        assert estMisAssertion = true;

        if (!estMisAssertion) {
            System.out.println("Execution impossible sans l'option -ea");
            return;
        }

        
        new TestJauge().testDansIntervalle();
        new TestJauge().testIncrementation();
        new TestJauge().testDecrementation();
        new TestJauge().testDepart();
        new TestJauge().testZero();
        new TestJauge().testNegatif();
        new TestJauge().testEgal();
        new TestJauge().testExceptionCasLimite();
        //UtilTest.lance(TestJauge.class);
    }
}
