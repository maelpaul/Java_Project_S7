package tec;

class TestPosition{
    public static void main(String[] args){
        boolean estMisAssertion = false;
        assert estMisAssertion = true;

        if (!estMisAssertion) {
            System.out.println("Execution impossible sans l'option -ea");
            return;
        }

        int doneTests = 0;

        System.out.println(".");
        new TestPosition().testDehors();
        ++doneTests;
        System.out.println(".");
        new TestPosition().testAssis();
        ++doneTests;
        System.out.println(".");
        new TestPosition().testDebout();
        ++doneTests;
        System.out.println("OK." + doneTests);
    }

    public void testDehors(){
        Position position = Position.recupererPositionDehors();

        assert !position.estAssis();
        assert !position.estDebout();
        assert position.estDehors();
        assert !position.estInterieur(); 

        System.out.println("testDehors() done");
    }

    public void testAssis(){
        Position position = Position.recupererPositionAssis();

        assert position.estAssis();
        assert !position.estDebout(); // PB
        assert !position.estDehors();
        assert position.estInterieur();

        System.out.println("testAssis() done");
    }

    public void testDebout(){
        Position position = Position.recupererPositionDebout();

        assert !position.estAssis();
        assert position.estDebout(); // PB
        assert !position.estDehors();
        assert position.estInterieur();

        System.out.println("testDebout() done");
    }
}